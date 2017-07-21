package ru.danileyko.JDBC;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import ru.danileyko.model.Hostels;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by danil on 19.07.2017.
 */
public class HostelsJDBCTemplate implements HostelDao {
    private JdbcTemplate jdbcTemplate;

    public HostelsJDBCTemplate(DataSource dataSource){
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public List<Hostels> getAllHostels() {
        String sql = "SELECT * FROM RUNNET.MY_SUB_TYPE_V";
        List<Hostels> hostelsList = jdbcTemplate.query(sql, new RowMapper<Hostels>() {
            @Override
            public Hostels mapRow(ResultSet resultSet, int i) throws SQLException {
                Hostels hostels = new Hostels();
                hostels.setId(resultSet.getInt(1));
                hostels.setName(resultSet.getString(2));
                hostels.setOrderId(resultSet.getInt(3));
                hostels.setNumHostelId(resultSet.getInt(4));
                hostels.setkHostelId(resultSet.getInt(5));
                hostels.setAddress(resultSet.getString(6));
                return hostels;
            }
        });
        return hostelsList;
    }
}
