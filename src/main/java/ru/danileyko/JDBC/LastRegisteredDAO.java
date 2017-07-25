package ru.danileyko.JDBC;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import ru.danileyko.model.LastRegistered;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by danil on 24.07.2017.
 */
public class LastRegisteredDAO {
    private JdbcTemplate jdbcTemplate;

    public LastRegisteredDAO(DataSource dataSource){
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public List<LastRegistered> lastRegistered(int hostelNum, int dayCount){
        String sql = "SELECT cust.PUSER,msv.NAME,mcv.MAC,mcv.DATE_MODIFIED,ipd.IP\n" +
                "  FROM RUNNET.CUSTOMER cust,RUNNET.MAC_CUSTOMER_V mcv,RUNNET.IPDETAIL_V ipd,RUNNET.MY_SUB_TYPE_V msv\n" +
                "WHERE cust.PUSER = mcv.PUSER\n" +
                "AND mcv.IP_DETAIL_ID = ipd.ID\n" +
                "AND cust.SUBTYPE = msv.ID\n" +
                "AND mcv.DATE_CREATED > sysdate - " + dayCount+"\n" +
                "AND msv.NUM_HOSTEL ="+hostelNum;

        List<LastRegistered> lastRegistered = jdbcTemplate.query(sql, new RowMapper<LastRegistered>() {
            @Override
            public LastRegistered mapRow(ResultSet resultSet, int i) throws SQLException {
                LastRegistered lastRegisteredObj = new LastRegistered();
                lastRegisteredObj.setPuser(resultSet.getString(1));
                lastRegisteredObj.setHostelName(resultSet.getString(2));
                lastRegisteredObj.setMac(resultSet.getString(3));
                lastRegisteredObj.setDate(resultSet.getDate(4));
                lastRegisteredObj.setIp(resultSet.getString(5));
                return lastRegisteredObj;
            }
        });
        return lastRegistered;
    }
}
