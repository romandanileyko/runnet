package ru.danileyko.JDBC;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

/**
 * Created by danil on 21.07.2017.
 */
@Configuration
public class JDBCConfig {
    @Autowired
    private Environment environment;

    @Bean
    public DataSource getDataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("oracle.jdbc.driver.OracleDriver");
        dataSource.setUrl(environment.getProperty("spring.datasource.url"));
        dataSource.setUsername(environment.getProperty("spring.datasource.username"));
        dataSource.setPassword(environment.getProperty("spring.datasource.password"));
        return dataSource;
    }

    @Bean
    public IpRangeDao getIpRangesDao(){
        return new IpRangesJDBCTemplate(getDataSource());
    }

    @Bean
    public IpDetailDao getIpDetailesDao(){
        return new IpDetaileJDBCTemplate(getDataSource());
    }
    @Bean
    public HostelDao getHostelsDao() {
        return new HostelsJDBCTemplate(getDataSource());
    }

    @Bean
    public ResultDao getResult(){
        return new ResultDao(getDataSource());
    }
    @Bean
    public ClientCountDAO getClientCount(){
        return new ClientCountDAO(getDataSource());
    }
    @Bean
    public LastRegisteredDAO getLastRegistered(){
        return new LastRegisteredDAO(getDataSource());
    }
    @Bean
    public ActiveClientDAO getActiveClientDAO(){
        return new ActiveClientDAO(getDataSource());
    }
    @Bean
    public DhcpLogReportDAO getDhcpLog(){ return new DhcpLogReportJDBCTemplate(getDataSource());}
}
