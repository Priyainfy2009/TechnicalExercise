package com.weather.models;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "NewDataSet")
@XmlAccessorType(XmlAccessType.FIELD)
public class NewWeatherDataSet {

	
	
	  	@XmlElement(name = "Location")
	    private String Location;
	  	
	    @XmlElement(name = "Time")
	    private String Time;
	    
	    @XmlElement(name = "Wind")
	    private String Wind;
	    
	    @XmlElement(name = "Visibility")
	    private String Visibility;
	    
	    @XmlElement(name = "SkyConditions")
	    private String SkyConditions;
	    
	    @XmlElement(name = "Temperature")
	    private String Temperature;

	    @XmlElement(name = "DewPoint")
	    private String DewPoint;
	    
	    @XmlElement(name = "RelativeHumidity")
	    private String RelativeHumidity;
	    
	    @XmlElement(name = "Status")
	    private String Status;
	    
	    public String getLocation() {
	        return Location;
	    }

	    public void setLocation(String location) {
	    	Location = location;
	    }

	    public String getTime() {
	        return Time;
	    }

	    public void setTime(String time) {
	    	Time = time;
	    }
	    
	    public String getWind () {
	        return Wind;
	    }

	    public void setWind (String wind) {
	    	Wind = wind;
	    }
	    
	    public String getVisibility () {
	        return Visibility ;
	    }

	    public void setVisibility (String visibility) {
	    	Visibility = visibility;
	    }
	    
	    public String getSkyConditions () {
	        return SkyConditions;
	    }

	    public void setSkyConditions (String skyConditions) {
	    	SkyConditions = skyConditions;
	    }
	    
	    public String getTemperature () {
	        return Temperature ;
	    }

	    public void setTemperature (String temperature) {
	    	Temperature = temperature;
	    }
	    
	    public String getDewPoint () {
	        return DewPoint;
	    }

	    public void set (String dewPoint) {
	    	DewPoint = dewPoint;
	    }
	    
	    public String getRelativeHumidity () {
	        return RelativeHumidity;
	    }

	    public void setRelativeHumidity (String relativeHumidity) {
	    	RelativeHumidity = relativeHumidity;
	    }
	    
	    public String getStatus () {
	        return Status;
	    }

	    public void setStatus (String status) {
	    	Status = status;
	    }
}
