package com.Controller;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class MasilaController {
	//Covid data provided class
    @Autowired
    coraViruseController covidDatas;

    //This method is used to get the world data
    @GetMapping("/world")
    public String getWorldData() {
        Map<String,Object> worldDatas=covidDatas.getCovidWorld();
        return "indexHome";
    }

}
