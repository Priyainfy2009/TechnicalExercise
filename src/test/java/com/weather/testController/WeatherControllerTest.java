/*Controller to test rest api exposed
*/

package com.weather.testController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.http.HttpMethod;
import com.weather.controller.WeatherController;

import net.webservicex.GlobalWeather;
import net.webservicex.GlobalWeatherSoap;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;

import org.junit.Test;
import org.junit.runner.RunWith;

import  org.springframework.test.web.servlet.MockMvcResultMatchersDsl;

@RunWith(SpringJUnit4ClassRunner.class)
@WebMvcTest(WeatherController.class)
public class WeatherControllerTest{
	
	@MockBean
	GlobalWeatherSoap soapObj = SoapMethod();
	@Autowired
	private MockMvc mockMvc ;
    private final static String URL="http://www.webservicex.net/globalweather.asmx?WSDL";

    @Test
    public void getCitiesbyCount() throws Exception{
      // String response="<NewDataSet><Table><City>Melbourne</City><Country>Australia</Country></Table></NewDataSet>";

    	URL url = new URL("/getCities?country=austarlia");
    	MvcResult result=(MvcResult) this.mockMvc.perform(post(url));
    	System.out.println("MVCREsult"+result);
    	}
	
	 private RequestBuilder post(URL url2) {
		 RequestBuilder builder = MockMvcRequestBuilders.request(HttpMethod.POST, url2.getPath());
		 return builder;
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