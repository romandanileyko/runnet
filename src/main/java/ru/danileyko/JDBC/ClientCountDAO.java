package ru.danileyko.JDBC;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import ru.danileyko.model.CountClientInEachHostel;

import javax.sql.DataSource;
import javax.validation.OverridesAttribute;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by danil on 24.07.2017.
 */
public class ClientCountDAO {
    private JdbcTemplate jdbcTemplate;

    public ClientCountDAO(DataSource dataSource){
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public List<CountClientInEachHostel> countClientInEachHostels(){
        String sql = "SELECT msv.NAME,COUNT(cust.PUSER) FROM RUNNET.CUSTOMER cust,RUNNET.MY_SUB_TYPE_V msv\n" +
                "WHERE cust.SUBTYPE = msv.ID\n" +
                "AND cust.CUR_STATUS = 'C'\n" +
                "GROUP BY msv.NAME\n" +
                "ORDER BY 2 DESC";

        List<CountClientInEachHostel> clientInEachHostels = jdbcTemplate.query(sql, new RowMapper<CountClientInEachHostel>() {
            @Override
            public CountClientInEachHostel mapRow(ResultSet resultSet, int i) throws SQLException {
                CountClientInEachHostel countClientInEachHostel = new CountClientInEachHostel();
                countClientInEachHostel.setNameOfHostel(resultSet.getString(1));
                countClientInEachHostel.setCountClient(resultSet.getInt(2));
                return countClientInEachHostel;
            }
        });
        return clientInEachHostels;
    }
}
