## Workshop 17

OpenWeather API key (Macos)
```
export OPEN_WEATHER_MAP_API_KEY=<your api key>
```

OpenWeather API key (Windows)
```
set OPEN_WEATHER_MAP_API_KEY=<your api key>
```
```
https://api.openweathermap.org/data/2.5/weather?q=singapore&units=metric&appid=<API KEY>)
```

```
{
  "coord": {
    "lon": 103.8501,
    "lat": 1.2897
  },
  "weather": [
    {
      "id": 803,
      "main": "Clouds",
      "description": "broken clouds",
      "icon": "04d"
    }
  ],
  "base": "stations",
  "main": {
    "temp": 26.27,
    "feels_like": 26.27,
    "temp_min": 25.61,
    "temp_max": 26.97,
    "pressure": 1012,
    "humidity": 80
  },
  "visibility": 10000,
  "wind": {
    "speed": 2.57,
    "deg": 330
  },
  "clouds": {
    "all": 75
  },
  "dt": 1674090297,
  "sys": {
    "type": 1,
    "id": 9470,
    "country": "SG",
    "sunrise": 1674083597,
    "sunset": 1674126992
  },
  "timezone": 28800,
  "id": 1880252,
  "name": "Singapore",
  "cod": 200
}
```