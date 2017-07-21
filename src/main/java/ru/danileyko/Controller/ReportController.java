package ru.danileyko.Controller;

import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.danileyko.JDBC.ResultDao;
import ru.danileyko.model.ResultCountOfFreeIp;

import java.util.List;

/**
 * Created by danil on 21.07.2017.
 */
@Controller
@RequestMapping(value = "/",method = {RequestMethod.GET,RequestMethod.POST})
public class ReportController {
    @Autowired
    private ResultDao resultDao;

    @RequestMapping(value = "/free-ip")
    public @ResponseBody
    String getReportOfFreeIp(){
        List<ResultCountOfFreeIp> freeIps = resultDao.getFreeIpCount();

        Gson objGson = new Gson();
        String json = objGson.toJson(freeIps);
        System.out.println("JSON: "+ json);
        return json;
    }
}


