package com.Controller;
import java.util.Map;
import org.springframework.ui.Model;
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
    public String getWorldData(Model m) {
        Map<String,Object> worldDatas=covidDatas.getCovidWorld();
        m.addAttribute("worldDatas","Hi it is working");
        return "indexHome";
    }

}
