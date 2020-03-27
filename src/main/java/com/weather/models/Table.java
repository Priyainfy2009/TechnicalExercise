package com.weather.models;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Table")
@XmlAccessorType(XmlAccessType.FIELD)
public class Table {

    @XmlElement(name = "Country")
    private String Country;
    @XmlElement(name = "City")
    private String City;

    public String getCountry() {
        return Country;
    }

    public void setCountry(String country) {
    	Country = country;
    }

    public String getCity() {
        return City;
    }

    public void setCity(String city) {
    	City = city;
    }
}
