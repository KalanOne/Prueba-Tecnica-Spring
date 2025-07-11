package com.prueba.tecnica.security;

import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserService;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.DefaultOAuth2User;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.prueba.tecnica.model.Usuario;
import com.prueba.tecnica.service.UsuarioService;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private JwtTokenProvider tokenProvider;

    @Autowired
    private CustomAuthenticationEntryPoint customAuthenticationEntryPoint;

    @Bean
    public JwtAuthenticationFilter jwtAuthenticationFilter() {
        return new JwtAuthenticationFilter();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(usuarioService).passwordEncoder(passwordEncoder());
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Bean
    public OAuth2UserService<OAuth2UserRequest, OAuth2User> oauth2UserService() {
        DefaultOAuth2UserService delegate = new DefaultOAuth2UserService();
        return request -> {
            OAuth2User oAuth2User = delegate.loadUser(request);

            // Registrar usuario en BD
            Map<String, Object> attributes = oAuth2User.getAttributes();
            String email = (String) attributes.get("email");
            String name = (String) attributes.get("name");
            if (email == null || email.isEmpty()) {
                throw new OAuth2AuthenticationException("Email no proporcionado por el proveedor OAuth2");
            }

            Usuario usuario = usuarioService.findByEmail(email)
                    .orElseGet(() -> {
                        Usuario newUser = new Usuario();
                        newUser.setEmail(email);
                        newUser.setUsername(email);
                        newUser.setNombre(name);
                        newUser.setPassword(UUID.randomUUID().toString());
                        newUser.setEnabled(true);
                        return usuarioService.registrarUsuario(newUser, "ROLE_USER");
                    });

            return new DefaultOAuth2User(
                    usuario.getAuthorities(),
                    attributes,
                    "email");
        };
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .cors().and().csrf().disable()
                .exceptionHandling()
                .authenticationEntryPoint(customAuthenticationEntryPoint)
                .and()
                .authorizeRequests()
                .antMatchers("/api/auth/**", "/oauth2/**").permitAll()
                .antMatchers("/h2-console/**").permitAll()
                .anyRequest().authenticated()
                .and()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .oauth2Login(oauth2 -> oauth2
                        .userInfoEndpoint(userInfo -> userInfo
                                .userService(oauth2UserService()))
                        .successHandler((request, response, authentication) -> {
                            String jwt = tokenProvider.generateToken(authentication);
                            response.setContentType("application/json");
                            response.getWriter().write(
                                    "{\"token\":\"" + jwt + "\"}");
                        }));

        http.headers().frameOptions().disable();

        http.addFilterBefore(jwtAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class);
    }
}