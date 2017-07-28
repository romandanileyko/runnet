package ru.danileyko.JDBC;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import ru.danileyko.model.LogReport;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by danil on 28.07.2017.
 */
public class DhcpLogReportJDBCTemplate implements DhcpLogReportDAO {
    private JdbcTemplate jdbcTemplate;

    public DhcpLogReportJDBCTemplate(DataSource dataSource){
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public List<LogReport> getDhcpLogByLogin(String login) {
        String sql = "SELECT dhcpl.PUSER,dhcpl.MAC,dhcpl.LOG_DATE,dhcpl.LOG_TYPE,dhcpl.IP FROM RUNNET.DHCP_LOG_V dhcpl\n" +
                "WHERE dhcpl.PUSER LIKE '%" + login + "%' \n" +
                "AND ROWNUM <100 \n"+
                "ORDER BY dhcpl.LOG_DATE DESC";

        List<LogReport> logReportList = jdbcTemplate.query(sql, new RowMapper<LogReport>() {
            @Override
            public LogReport mapRow(ResultSet resultSet, int i) throws SQLException {
                LogReport logReport = new LogReport();
                logReport.setLogin(resultSet.getString(1));
                logReport.setMac(resultSet.getString(2));
                logReport.setLogDate(resultSet.getDate(3));
                logReport.setLogType(resultSet.getString(4));
                logReport.setIp(resultSet.getString(5));
                return logReport;
            }
        });
        return logReportList;
    }
}
