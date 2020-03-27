/*Controller to expose REST APIs /getCities and /getWeather
 */
package com.weather.controller;

import com.weather.models.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import net.webservicex.GlobalWeather;
import net.webservicex.GlobalWeatherSoap;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.StringReader;
import java.net.MalformedURLException;
import java.net.URL;


@Controller
public class WeatherController {


   // private final static String URL="file:/D:/WSDL/global-weather.wsdl";
    private final static String URL="http://www.webservicex.net/globalweather.asmx?WSDL";

    Logger logger = LoggerFactory.getLogger(WeatherController.class);

    @GetMapping(value = "/")
    public String showHomePage(){
        return "index";
    }

    @PostMapping(value = "/getCities")
    public String getCitiesByCountry(@RequestParam String country, Model model) throws JAXBException {

        String response=null;
       GlobalWeatherSoap gws=SoapMethod();
       logger.info("URL post initialization in getCities : "+gws);

       if(gws!=null){
           response=gws.getCitiesByCountry(country);
            if(response==null || response.compareTo("")==0){
            	 //returns the error page
                return "error";
            }
            
            response=response.replaceAll("string","");

            JAXBContext jaxbContext = JAXBContext.newInstance(NewDataSet.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();

            logger.info("Response from entity "+response);
            StringReader reader = new StringReader(response);
            NewDataSet cities = (NewDataSet) unmarshaller.unmarshal(reader);

            for(Table table:cities.getTableList()){
                logger.info("City : "+table.getCity());
            }

            model.addAttribute("cities",cities.getTableList());
            model.addAttribute("country",country);
            logger.info("Post addition to model ");

        }else{
        	  //returns the error page
            return "error";
        }
        //returns the search result
        return "result";

    }
    @PostMapping(value = "/getWeather")
    public String getWeather(@RequestParam  String city, String country, Model model) throws JAXBException {

        String response=null;
        GlobalWeatherSoap gws=SoapMethod();
        logger.info("URL post initialization in getWeather: "+gws);
       
        if(gws!=null){
            response=gws.getWeather(city,country);
        //response="<NewDataSet><Location>Melbourne</Location></NewDataSet>";
            if(response==null || response.compareTo("")==0){
            	 //returns the error page
                return "error";
            }
            response=response.replaceAll("string","");

            JAXBContext jaxbContext = JAXBContext.newInstance(NewWeatherDataSet.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();

            logger.info("Response from entity "+response);
            StringReader reader = new StringReader(response);
            NewWeatherDataSet weather = (NewWeatherDataSet) unmarshaller.unmarshal(reader);
                
            model.addAttribute("Location",weather.getLocation());
            model.addAttribute("Time",weather.getTime());
            model.addAttribute("Wind",weather.getWind());
            model.addAttribute("Visibility",weather.getVisibility());
            model.addAttribute("SkyConditions",weather.getSkyConditions());
            model.addAttribute("Temperature",weather.getTemperature());
            model.addAttribute("DewPoint",weather.getDewPoint());
            model.addAttribute("RelativeHumidity",weather.getRelativeHumidity());
            model.addAttribute("Status",weather.getStatus());
            
            logger.info("Post addition to model "+model);

        }else{
        	  //returns the error page	
           return "error";
        }
        //returns the search result
        return "result";

    }

    private GlobalWeatherSoap SoapMethod(){
        GlobalWeatherSoap port=null;
        try {
            URL url=new URL(URL);
            GlobalWeather globalWeather=new GlobalWeather(url);
            port=globalWeather.getGlobalWeatherSoap();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        return port;

    }

}
