package sg.edu.nus.iss.app.workshop17.service;

import java.io.IOException;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import sg.edu.nus.iss.app.workshop17.model.Weather;

// This annotation serves as a specialization of @Component, allowing for implementation classes
// to be autodetected through classpath scanning.
@Service
public class WeatherService {

    // OpenWeatherMap API endpoint
    private static final String OPEN_WEATHER_URL = "https://api.openweathermap.org/data/2.5/weather";

        // Method to fetch weather data from OpenWeatherMap API
        public Optional<Weather> getWeather(String city, String unitMeasurement) throws IOException {
        // Get API key from environment variable    
        String apiKey = System.getenv("OPEN_WEATHER_MAP_API_KEY");
        System.out.println(city);
        // Build the API endpoint URL with query parameters
        String weatherUrl = UriComponentsBuilder
                                    .fromUriString(OPEN_WEATHER_URL)
                                    .queryParam("q", 
                                        city.replaceAll(" ", "+"))
                                    .queryParam("units", unitMeasurement)
                                    .queryParam("appId", apiKey)
                                    .toUriString();
        System.out.println(weatherUrl);
        RestTemplate template = new RestTemplate();
        // Fetch data from API
        ResponseEntity<String> resp = null;
        resp = template.getForEntity(weatherUrl,String.class);
        System.out.println(resp);
        // Create weather object from json
        Weather w = Weather.create(resp.getBody());
        System.out.println(w);
        // return the weather object wrapped in Optional
        if(w != null)
            return Optional.of(w);                        
        return Optional.empty();
    }
}
