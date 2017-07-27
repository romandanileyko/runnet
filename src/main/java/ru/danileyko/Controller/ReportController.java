package ru.danileyko.Controller;

import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.danileyko.JDBC.ActiveClientDAO;
import ru.danileyko.JDBC.ClientCountDAO;
import ru.danileyko.JDBC.LastRegisteredDAO;
import ru.danileyko.JDBC.ResultDao;
import ru.danileyko.model.CountClientInEachHostel;
import ru.danileyko.model.LastRegistered;
import ru.danileyko.model.ResultCountOfFreeIp;
import ru.danileyko.pdf.FreeIPPdfReport;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.List;

/**
 * Created by danil on 21.07.2017.
 */
@Controller
@RequestMapping(value = "/",method = {RequestMethod.GET,RequestMethod.POST})
public class ReportController {
    @Autowired
    private ResultDao resultDao;
    @Autowired
    private ClientCountDAO clientCountDAO;
    @Autowired
    private LastRegisteredDAO lastRegisteredDAO;
    @Autowired
    private ActiveClientDAO activeClientDAO;

    @RequestMapping(value = "/free-ip")
    public @ResponseBody
    String getReportOfFreeIp(){
        List<ResultCountOfFreeIp> freeIps = resultDao.getFreeIpCount();

        Gson objGson = new Gson();
        String json = objGson.toJson(freeIps);
        System.out.println("JSON: "+ json);
        return json;
    }

    @RequestMapping(value = "/count-client")
    public @ResponseBody String getRepoortCountClient(){
        List<CountClientInEachHostel> countClientInEachHostels = clientCountDAO.countClientInEachHostels();
        Gson objGson = new Gson();
        String json = objGson.toJson(countClientInEachHostels);
        System.out.println("COUNT OF CLIENT: "+ json);
        return json;
    }

    @RequestMapping(value = "/last-registered")
    public @ResponseBody String getRepoortLastRegistered(
            @RequestParam(value = "hostelNum") int hostelNum,
            @RequestParam(value = "dayCount") int dayCount){
        List<LastRegistered> lastRegistered = lastRegisteredDAO.lastRegistered(hostelNum,dayCount);
        Gson objGson = new Gson();
        String json = objGson.toJson(lastRegistered);
        System.out.println("REPORT: "+ json);
        return json;
    }

    @RequestMapping(value = "/active-client-count")
    public @ResponseBody int getActiveClientCount(){
                Integer count = activeClientDAO.getActiveClientCount();
        return count;
    }

    @RequestMapping(value = "/free-ip-pdf",produces = MediaType.APPLICATION_PDF_VALUE)
    public ResponseEntity<InputStreamResource> freeIpPdfreport() throws IOException{
        List<ResultCountOfFreeIp> freeIps = resultDao.getFreeIpCount();
        ByteArrayInputStream byteArrayInputStream = FreeIPPdfReport.freeIpReport(freeIps);

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Content-Disposition", "inline; filename=free-ip-report.pdf");

        return ResponseEntity.ok()
                .headers(httpHeaders)
                .contentType(MediaType.APPLICATION_PDF)
                .body(new InputStreamResource(byteArrayInputStream));
    }
}


