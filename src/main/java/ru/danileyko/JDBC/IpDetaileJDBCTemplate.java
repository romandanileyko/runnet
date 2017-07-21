package ru.danileyko.JDBC;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import ru.danileyko.model.IpDetail;
import ru.danileyko.model.IpRange;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by danil on 19.07.2017.
 */
public class IpDetaileJDBCTemplate implements IpDetailDao {
    private JdbcTemplate jdbcTemplate;

    public IpDetaileJDBCTemplate(DataSource dataSource){
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public List<IpDetail> getAllIp() {
        String sql = "SELECT * FROM RUNNET.IPDETAIL_V";
        List<IpDetail> IpDetailes = jdbcTemplate.query(sql, new RowMapper<IpDetail>() {
            @Override
            public IpDetail mapRow(ResultSet resultSet, int i) throws SQLException {
                IpDetail ipDetail = new IpDetail();
                ipDetail.setId(resultSet.getInt(1));
                ipDetail.setIp(resultSet.getString(2));
                ipDetail.setMask(resultSet.getString(3));
                ipDetail.setIp_range_id(resultSet.getInt(4));
                ipDetail.setStatus(resultSet.getByte(5));
                ipDetail.setModifiedBy(resultSet.getString(6));
                ipDetail.setDateModified(resultSet.getDate(7));
                return ipDetail;
            }
        });
        return IpDetailes;
    }
}
