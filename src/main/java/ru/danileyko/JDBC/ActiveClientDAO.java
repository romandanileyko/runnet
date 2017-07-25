package ru.danileyko.JDBC;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import ru.danileyko.model.ActiveClient;

import javax.sql.DataSource;
import java.util.List;

/**
 * Created by danil on 25.07.2017.
 */
public class ActiveClientDAO {
    private JdbcTemplate jdbcTemplate;

    public ActiveClientDAO(DataSource dataSource){
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public int getActiveClientCount(){
       int count = jdbcTemplate.queryForObject("SELECT count(*) FROM RUNNET.CUSTOMER cust WHERE cust.CUR_STATUS = 'C'",new Object[]{},Integer.class);
       return count;
    }
}
