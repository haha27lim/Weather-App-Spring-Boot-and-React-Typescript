package sg.edu.nus.iss.app.workshop17.controller;

import java.io.IOException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import sg.edu.nus.iss.app.workshop17.model.Weather;
import sg.edu.nus.iss.app.workshop17.service.WeatherService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(path="/weather")
public class WeatherController {
    
    // Auto wire the weather service
    @Autowired
    private WeatherService weatherSvc;

    // Map get request to this method
    @GetMapping
    public Weather getWeather (@RequestParam(required=true) String city,
        @RequestParam(required=false) String units) throws IOException {
        System.out.println("units > " + units);
        // If units not set, set to metric
        if (units == null)
            units = "metric";
        // Get the weather data
        Optional<Weather> w= weatherSvc.getWeather(city, units);
        // Return the weather data
        return w.orElseThrow(() -> new RuntimeException("Weather data not found"));
    }
}
