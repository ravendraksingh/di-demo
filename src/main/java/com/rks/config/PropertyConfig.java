package com.rks.config;

import com.rks.examplebeans.FakeDataSource;
import com.rks.examplebeans.FakeJmsBroker;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


//@PropertySource({"classpath:datasource.properties", "classpath:jms.properties"})
//@PropertySources({
//        @PropertySource("classpath:datasource.properties"),
//        @PropertySource("classpath:jms.properties")
//})
@Configuration
public class PropertyConfig {

    @Value("${myapp.username}")
    String user;

    @Value("${myapp.password}")
    String password;

    @Value("${myapp.dburl}")
    String dburl;

    @Value("${myapp.jms.username}")
    String jmsUsername;

    @Value("${myapp.jms.password}")
    String jmsPassword;

    @Value("${myapp.jms.dburl}")
    String jmsDburl;


    @Bean
    public FakeDataSource fakeDataSource() {
        FakeDataSource fakeDataSource = new FakeDataSource();
        fakeDataSource.setUserName(user);
        fakeDataSource.setPassword(password);
        fakeDataSource.setDburl(dburl);
        return fakeDataSource;
    }

    @Bean
    public FakeJmsBroker fakeJmsBroker() {
        FakeJmsBroker fakeJmsBroker = new FakeJmsBroker();
        fakeJmsBroker.setUserName(jmsUsername);
        fakeJmsBroker.setPassword(jmsPassword);
        fakeJmsBroker.setDburl(jmsDburl);
        return fakeJmsBroker;
    }

    /*
    @Bean
    public static PropertySourcesPlaceholderConfigurer properties() {
        PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer = new PropertySourcesPlaceholderConfigurer();
        return propertySourcesPlaceholderConfigurer;
    }
    */
}
