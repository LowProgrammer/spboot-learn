package com.demo.config;

import com.demo.handle.LoginSuccessHandler;
import com.demo.service.CustomUserDetailsService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

/**
 * @Classname SecurityConfiguration
 * @Description TODO
 * @Date 2019/7/25 19:00
 * @Created by ChenS
 */
@Configuration
@Order(SecurityProperties.IGNORED_ORDER)
@EnableConfigurationProperties(SecuritySettings.class)
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    protected Log log = LogFactory.getLog(getClass());
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private SecuritySettings settings;
    @Autowired
    private CustomUserDetailsService customUserDetailsService;
    @Autowired
    //@Qualifier("dataSource")
    private DataSource dataSource;
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        auth.userDetailsService(customUserDetailsService).passwordEncoder(passwordEncoder());
        //remember me
        auth.eraseCredentials(false);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.formLogin().loginPage("/login").permitAll().successHandler(loginSuccessHandler())
                .and().authorizeRequests()
                .antMatchers("/images/**","/checkcoe","/scripts/**","/styles/**").permitAll()
                .antMatchers(settings.getPermitall().split(",")).permitAll()
                .anyRequest().authenticated()
                .and().csrf().requireCsrfProtectionMatcher(csrfSecurityRequestMatcher())
                .and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.NEVER)
                .and().logout().logoutSuccessUrl(settings.getLogoutsuccssurl())
                .and().exceptionHandling().accessDeniedPage(settings.getDeniedpage())
                .and().rememberMe().tokenValiditySeconds(1209600).tokenRepository(tokenRepository());
        //super.configure(http);
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public JdbcTokenRepositoryImpl tokenRepository(){
        JdbcTokenRepositoryImpl jtr = new JdbcTokenRepositoryImpl();
        jtr.setDataSource(dataSource);
        return jtr;
    }

    @Override
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception{
        return super.authenticationManagerBean();
    }

    @Bean
    public LoginSuccessHandler loginSuccessHandler(){
        return new LoginSuccessHandler();
    }

    @Bean
    public CustomFilterSecurityInterceptor customFilter() throws Exception{
        CustomFilterSecurityInterceptor customFilter = new CustomFilterSecurityInterceptor();
        customFilter.setSecurityMetadataSource(securityMetadataSource());
        customFilter.setAccessDecisionManager(accessDecisionManager());
        customFilter.setAuthenticationManager(authenticationManager);
        return customFilter;
    }

    @Bean
    public CustomAccessDecisionManager accessDecisionManager() {
        return new CustomAccessDecisionManager();
    }

    @Bean
    public CustomSecurityMetadataSource securityMetadataSource() {
        return new CustomSecurityMetadataSource(settings.getUrlroles());
    }


    private CsrfSecurityRequestMatcher csrfSecurityRequestMatcher(){
        CsrfSecurityRequestMatcher csrfSecurityRequestMatcher = new CsrfSecurityRequestMatcher();
        List<String> list = new ArrayList<String>();
        list.add("/rest/");
        csrfSecurityRequestMatcher.setExecludeUrls(list);
        return csrfSecurityRequestMatcher;
    }
}
