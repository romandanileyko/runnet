package ru.danileyko.JDBC;

import ru.danileyko.model.IpDetail;
import ru.danileyko.model.IpRange;

import java.util.List;

/**
 * Created by danil on 19.07.2017.
 */
public interface IpDetailDao {
    public List<IpDetail> getAllIp();
}
