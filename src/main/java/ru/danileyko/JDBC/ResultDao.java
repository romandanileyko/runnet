package ru.danileyko.JDBC;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import ru.danileyko.model.Hostels;
import ru.danileyko.model.IpDetail;
import ru.danileyko.model.IpRange;
import ru.danileyko.model.ResultCountOfFreeIp;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by danil on 20.07.2017.
 */
public class ResultDao {
    private JdbcTemplate jdbcTemplate;

    public ResultDao(DataSource dataSource){
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public List<ResultCountOfFreeIp> getFreeIpCount(){
        String sql = "SELECT msv.NAME,ipr.IP_RANGE,COUNT(ipd.IP) FROM RUNNET.IPRANGE ipr,RUNNET.IPDETAIL ipd,RUNNET.MY_SUB_TYPE_V msv\n" +
                "WHERE msv.ID = ipr.NUM_HOSTEL_ID\n" +
                "AND ipr.ID = ipd.IPRANGEID\n" +
                "AND msv.ID != 11 --X2\n" +
                "AND msv.ID != 12 --X3\n" +
                "AND msv.ID != 2 --Karpova1\n" +
                "AND ipd.STATUS = 0\n" +
                "GROUP BY  msv.NAME,ipr.IP_RANGE\n" +
                "ORDER BY NAME";

        List<ResultCountOfFreeIp> freeIps = jdbcTemplate.query(sql, new RowMapper<ResultCountOfFreeIp>() {
                    @Override
                    public ResultCountOfFreeIp mapRow(ResultSet resultSet, int i) throws SQLException {
                        ResultCountOfFreeIp resultCountOfFreeIp = new ResultCountOfFreeIp();
                        resultCountOfFreeIp.setName(resultSet.getString(1));
                        resultCountOfFreeIp.setIpange(resultSet.getString(2));
                        resultCountOfFreeIp.setCount(resultSet.getInt(3));
                        return resultCountOfFreeIp;
                    }
                }
        );
        return freeIps;
    }
}
