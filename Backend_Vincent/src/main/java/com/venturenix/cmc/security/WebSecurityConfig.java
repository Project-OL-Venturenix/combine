package com.venturenix.cmc.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
// import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import com.venturenix.cmc.security.jwt.AuthEntryPointJwt;
import com.venturenix.cmc.security.jwt.AuthTokenFilter;
import com.venturenix.cmc.security.services.UserDetailsServiceImpl;
import jakarta.servlet.DispatcherType;
import org.springframework.security.oauth2.jwt.JwtDecoders;

@Configuration
@EnableMethodSecurity
// (securedEnabled = true,
// jsr250Enabled = true,
// prePostEnabled = true) // by default
public class WebSecurityConfig { // extends WebSecurityConfigurerAdapter {
  @Autowired
  UserDetailsServiceImpl userDetailsService;

  @Autowired
  private AuthEntryPointJwt unauthorizedHandler;

  @Bean
  public AuthTokenFilter authenticationJwtTokenFilter() {
    return new AuthTokenFilter();
  }

  // @Override
  // public void configure(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
  // authenticationManagerBuilder.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
  // }

  @Bean
  public DaoAuthenticationProvider authenticationProvider() {
    DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();

    authProvider.setUserDetailsService(userDetailsService);
    authProvider.setPasswordEncoder(passwordEncoder());

    return authProvider;
  }

  // @Bean
  // @Override
  // public AuthenticationManager authenticationManagerBean() throws Exception {
  // return super.authenticationManagerBean();
  // }

  @Bean
  public AuthenticationManager authenticationManager(
      AuthenticationConfiguration authConfig) throws Exception {
    return authConfig.getAuthenticationManager();
  }

  @Bean
  public PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }

  // @Override
  // protected void configure(HttpSecurity http) throws Exception {
  // http.cors().and().csrf().disable()
  // .exceptionHandling().authenticationEntryPoint(unauthorizedHandler).and()
  // .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
  // .authorizeRequests().antMatchers("/api/auth/**").permitAll()
  // .antMatchers("/api/test/**").permitAll()
  // .anyRequest().authenticated();
  //
  // http.addFilterBefore(authenticationJwtTokenFilter(), UsernamePasswordAuthenticationFilter.class);
  // }

  // @Bean
  // public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
  // http.csrf(csrf -> csrf.disable()).exceptionHandling(
  // exception -> exception.authenticationEntryPoint(unauthorizedHandler))
  // .sessionManagement(session -> session
  // .sessionCreationPolicy(SessionCreationPolicy.STATELESS))
  // .authorizeHttpRequests(auth -> auth// .requestMatchers("/api/**").permitAll()//
  // .requestMatchers("/api/auth/**").permitAll()
  // .requestMatchers("/api/test/**").permitAll()
  // .requestMatchers("/api/event/**").permitAll()
  // .requestMatchers("/api/eventgroup/**").permitAll()
  // .requestMatchers("/api/eventquestion/**").permitAll()
  // .requestMatchers("/api/eventuser/**").permitAll()
  // .requestMatchers("/api/group/**").permitAll()
  // .requestMatchers("/api/groupquestionsubmit/**").permitAll()
  // .requestMatchers("/api/groupscore/**").permitAll()
  // .requestMatchers("/api/grouptestcase/**").permitAll()
  // .requestMatchers("/api/grouptuser/**").permitAll()
  // .requestMatchers("/api/question/**").permitAll()
  // .requestMatchers("/api/testcase/**").permitAll()
  // .requestMatchers("/api/user/**").permitAll()
  // .requestMatchers("/api/userquestionsubmit/**").permitAll()
  // .requestMatchers("/api/userscore/**").permitAll()
  // .requestMatchers("/api/usertestcase/**").permitAll().anyRequest()
  // .authenticated());

  // http.authenticationProvider(authenticationProvider());

  // http.addFilterBefore(authenticationJwtTokenFilter(),
  // UsernamePasswordAuthenticationFilter.class);

  // return http.build();
  // }


  @Bean
  public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
    http.authorizeHttpRequests(auth -> auth//
        // 小心import 錯：import org.springframework.boot.web.servlet.DispatcherType;
        // import jakarta.servlet.DispatcherType; 先啱
        .dispatcherTypeMatchers(DispatcherType.ERROR).permitAll()//
        // .requestMatchers("/api/**")//
        .requestMatchers("/api/auth/**", //
            "/api/test/**", "/api/event/**", //
            "/api/eventgroup/**", //
            "/api/eventquestion/**", //
            "/api/eventuser/**", //
            "/api/group/**", //
            "/api/groupquestionsubmit/**", //
            "/api/groupscore/**", //
            "/api/grouptestcase/**", //
            "/api/grouptuser/**", //
            "/api/question/**", //
            "/api/testcase/**", //
            "/api/user/**", //
            "/api/userquestionsubmit/**", //
            "/api/userscore/**", //
            "/api/usertestcase/**")//
        .permitAll()//
        .anyRequest()//
        .authenticated()) // 用緊anyRequest，所有request都會受保護->question: 如何不受保護
        .csrf(csrf -> csrf.disable())//
        .cors(Customizer.withDefaults());
    // http.oauth2ResourceServer(oauth2ResourceServer -> oauth2ResourceServer
    // .jwt(jwt -> jwt.decoder(JwtDecoders.fromIssuerLocation(issuer)))//
    // );
    return http.build();
  }
}
