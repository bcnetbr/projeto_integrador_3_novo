package com.github.braully.dws;

import com.sun.faces.config.ConfigureListener;
import java.util.Map;
import javax.faces.webapp.FacesServlet;
import javax.servlet.ServletContext;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.CustomScopeConfigurer;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.web.context.ServletContextAware;

/**
 *
 * @author braully
 */
@EnableWebSecurity
@SpringBootApplication
public class AplicacaoWeb extends WebSecurityConfigurerAdapter implements ServletContextAware {

    public static void main(String... args) {
        SpringApplication.run(AplicacaoWeb.class, args);
    }

    @Bean
    public ServletRegistrationBean servletRegistrationBean() {
        FacesServlet servlet = new FacesServlet();
        return new ServletRegistrationBean(servlet, "*.xhtml");
//        ServletRegistrationBean reg = new ServletRegistrationBean(servlet, "*.senac");
//        return reg;
    }

    @Bean
    public ServletListenerRegistrationBean<ConfigureListener> jsfConfigureListener() {
        return new ServletListenerRegistrationBean<ConfigureListener>(
                new ConfigureListener());
    }

    @Override
    public void setServletContext(ServletContext servletContext) {
        servletContext.setInitParameter("com.sun.faces.forceLoadConfiguration", Boolean.TRUE.toString());
        //servletContext.setInitParameter("javax.faces.DEFAULT_SUFFIX", ".html");
    }
    @Bean
    public static CustomScopeConfigurer viewScope() {
        CustomScopeConfigurer configurer = new CustomScopeConfigurer();
        configurer.setScopes(
                Map.of("view", new ViewScope()));
        return configurer;
    }
     @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        UserDetails user = User.withUsername("Felipe")
                .password(passwordEncoder().encode("123456"))
                .roles("COMUM").build();

        UserDetails admin = User.withUsername("22222222222")
                .password(passwordEncoder().encode("654321"))
                .roles("EMPREENDEDOR").build();
        return new InMemoryUserDetailsManager(user, admin);
    }
    //@Autowired
   // public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception {
       // auth.jdbcAuthentication().dataSource(datasource())
                //.usersByUsernameQuery(
                //        "select nome,senha, enabled from usuarios where nome=?")
                //.authoritiesByUsernameQuery(
                //        "select nome, tipo from usuarios where nome=?");
   // }
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .authorizeRequests()
                .antMatchers("/").permitAll()
                .antMatchers("/Login*", "/Principal.xhtml").permitAll()
                .antMatchers("**/*.css", "/*.css", "/*.png").permitAll()
                //.antMatchers("/todas-solicitacoes").hasRole("ADMIN")
                .antMatchers("/Sobre.xhtml").permitAll()
                .antMatchers("/Votacoes.xhtml").hasRole("COMUM")
                .antMatchers("/Resultados.xhtml").hasRole("EMPREENDEDOR")
                .antMatchers("/cadastroNecessidade.xhtml").permitAll()
                .antMatchers("/.xhtml").permitAll()
                
                .anyRequest().authenticated().and()
                .formLogin().loginPage("/Login.xhtml").loginProcessingUrl("/senha")
                .successForwardUrl("/Principal.xhtml")
                .permitAll().and()
                .logout().permitAll();
    }
    
        @Bean
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource datasource() {
        return DataSourceBuilder.create().build();
    }
}
