package ru.danileyko.JDBC;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import ru.danileyko.model.IpRange;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by danil on 19.07.2017.
 */
public class IpRangesJDBCTemplate implements IpRangeDao {

    private JdbcTemplate jdbcTemplate;

    public IpRangesJDBCTemplate(DataSource dataSource){
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public List<IpRange> getAllRanges() {
       String sql = "SELECT * FROM RUNNET.IPRANGE_V";
       List<IpRange> ipRanges = jdbcTemplate.query(sql, new RowMapper<IpRange>() {
            @Override
            public IpRange mapRow(ResultSet resultSet, int i) throws SQLException {
                IpRange ipRange = new IpRange();
                ipRange.setId(resultSet.getInt(1));
                ipRange.setNum_hostel_id(resultSet.getInt(2));
                ipRange.setIp_range(resultSet.getString(3));
                return ipRange;
            }
        });
        return ipRanges;
    }
}

