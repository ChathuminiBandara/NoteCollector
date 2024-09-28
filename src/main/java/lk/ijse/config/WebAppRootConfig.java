package lk.ijse.config;

import jakarta.persistence.EntityManagerFactory;
import lombok.val;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@Configuration
@ComponentScan(basePackages = "lk.ijse")
@EnableJpaRepositories(basePackages = "lk.ijse.dao")
@EnableTransactionManagement
public class WebAppRootConfig {  // this is to simplify the dao layer

    @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }

    //data source eka defined - bean data source
    @Bean
    public DataSource dataSource() {
        //new data source : add
        var dmds = new DriverManagerDataSource();
        dmds.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dmds.setUrl("jdbc:mysql://localhost:3306/springNote?createDatabaseIfNotExist=true&useSSL=false");
        dmds.setUsername("root");
        dmds.setPassword("1234");
        return dmds;
    }

    //hibernate JPA Implementation - 2nd bean to configure the orm tool  - without any property files
    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {  // entity managers in JPA  - this has bootstrapped from this

        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        vendorAdapter.setGenerateDdl(true);

        LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
        factory.setJpaVendorAdapter(vendorAdapter);    // connecting the required vendor
        factory.setPackagesToScan("lk.ijse.entity");  //entity hadala thina thana pennanna
        factory.setDataSource(dataSource());
        return factory;
    }

    //to manage the transactions
    @Bean
    public PlatformTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) {

        JpaTransactionManager txManager = new JpaTransactionManager();
        txManager.setEntityManagerFactory(entityManagerFactory);
        return txManager;
    }
}