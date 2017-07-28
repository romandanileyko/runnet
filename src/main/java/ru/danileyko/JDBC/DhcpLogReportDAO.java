package ru.danileyko.JDBC;

import ru.danileyko.model.LogReport;

import java.util.List;

/**
 * Created by danil on 28.07.2017.
 */
public interface DhcpLogReportDAO {
    public List<LogReport> getDhcpLogByLogin(String login);
}

