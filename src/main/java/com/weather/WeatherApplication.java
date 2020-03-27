/*Springboot application to bring up rest api which in turn will point to soap based stubs
 * to expose rest api to retrieve data for cities as per country and weather data as per city
 * Oauth  to be done for actual production deployment is not handled in this
 * Only SSL authentication is handled
 * Author- Priyadharshini
 */
package com.weather;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class WeatherApplication {

	public static void main(String[] args) {
		SpringApplication.run(WeatherApplication.class, args);
	}

}
