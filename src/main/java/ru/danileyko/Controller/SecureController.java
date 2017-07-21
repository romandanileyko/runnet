package ru.danileyko.Controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.danileyko.JDBC.HostelDao;
import ru.danileyko.JDBC.IpDetailDao;
import ru.danileyko.JDBC.IpRangeDao;
import ru.danileyko.JDBC.ResultDao;
import ru.danileyko.model.Hostels;
import ru.danileyko.model.IpDetail;
import ru.danileyko.model.IpRange;
import ru.danileyko.model.ResultCountOfFreeIp;


import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by danil on 17.07.2017.
 */
@Controller
@RequestMapping(value = "/",method = {RequestMethod.GET,RequestMethod.POST})
public class SecureController {
    List<String> list = new ArrayList<>();
    @Autowired
    AuthenticationManager authenticationManager;
    @Autowired
    private IpRangeDao ipRangeDao;
    @Autowired
    private IpDetailDao ipDetailDao;
    @Autowired
    private HostelDao hostelDao;
    @Autowired
    private ResultDao resultDao;

    @RequestMapping(value = "/test")
    public @ResponseBody
    List<String> list(){
        list.add("Test.");
        String loggedUser = getPrincipal();
        System.out.println("loggedUser is: "+loggedUser);
        List<IpRange> listRanges = ipRangeDao.getAllRanges();
        listRanges.stream().forEach(p->System.out.println(p));
        return list;
    }
    @RequestMapping(value = "/free-ip")
    public @ResponseBody String getReportOfFreeIp(){
        List<ResultCountOfFreeIp> freeIps = resultDao.getFreeIpCount();

        Gson objGson = new Gson();
        String json = objGson.toJson(freeIps);
        System.out.println("JSON: "+ json);
        return json;
    }
    @RequestMapping(value = {"/admin","/logout","/home"})
    public String redirectToIndex(){
        return "forward:/index.html";
    }

    private String getPrincipal(){
        String userName = null;
        Object prncipal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if(prncipal instanceof UserDetails){
            userName = ((UserDetails)prncipal).getUsername();
        } else {
            userName = prncipal.toString();
        }
        return userName;
    }
}
