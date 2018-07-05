package customerform.config;

import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.TransactionManagementConfigurer;

import javax.inject.Inject;
import javax.sql.DataSource;
import java.io.IOException;
import java.util.Properties;

@Configuration
@EnableTransactionManagement
@ComponentScan
public class HibernateConfig implements TransactionManagementConfigurer {

    @Inject
    SessionFactory sessionFactory;

//    @Bean
//    public DataSource dataSource() {
//        EmbeddedDatabaseBuilder edb = new EmbeddedDatabaseBuilder();
//        edb.setType(EmbeddedDatabaseType.H2);
//        edb.addScript("classpath:schema.sql");
//        EmbeddedDatabase embeddedDatabase = edb.build();
//        return embeddedDatabase;
//    }

    public PlatformTransactionManager annotationDrivenTransactionManager() {
        System.out.println(sessionFactory);
        HibernateTransactionManager transactionManager = new HibernateTransactionManager();
        transactionManager.setSessionFactory(sessionFactory);
        return transactionManager;
    }

    @Bean
    public SessionFactory sessionFactoryBean(DataSource dataSource) {
        try {
            LocalSessionFactoryBean lsfb = new LocalSessionFactoryBean();
            lsfb.setDataSource(dataSource);
            lsfb.setPackagesToScan("customerform.domain");
            Properties props = new Properties();
            props.setProperty("dialect", "org.hibernate.dialect.H2Dialect");
            lsfb.setHibernateProperties(props);
            lsfb.afterPropertiesSet();
            SessionFactory object = lsfb.getObject();
            return object;
        } catch (IOException e) {
            return null;
        }
    }
}
