package com.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
@Controller
public class MasilaController {
	//Covid data provided class
    @Autowired
    coraViruseController covidDatas;

    //This method is used to get the world data
    public void getWorldData() {
        covidDatas.getCovidWorld();
    }
    
}
