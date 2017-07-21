package ru.danileyko.JDBC;

import ru.danileyko.model.Hostels;
import ru.danileyko.model.IpDetail;

import java.util.List;

/**
 * Created by danil on 19.07.2017.
 */
public interface HostelDao {
    public List<Hostels> getAllHostels();
}
