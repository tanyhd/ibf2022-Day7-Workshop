package day7workshop.day7.services;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import day7workshop.day7.models.Weather;
import jakarta.json.Json;
import jakarta.json.JsonArray;
import jakarta.json.JsonObject;
import jakarta.json.JsonReader;

@Service
public class WeatherService {

    private static final String WEATHER_API = System.getenv("weatherAPI");
    private static final String WEATHER_URL = "https://api.openweathermap.org/data/2.5/weather";

    public Weather getWeather(String city) {
        Weather weather = new Weather();

        String url = UriComponentsBuilder
                    .fromUriString(WEATHER_URL)
                    .queryParam("q", city)
                    .queryParam("appid", WEATHER_API)
                    .queryParam("units", "metric")
                    .toUriString();
        RequestEntity<Void> req = RequestEntity.get(url).build();
        RestTemplate template = new RestTemplate();
        ResponseEntity<String> resp = template.exchange(req, String.class);
        String body = resp.getBody();
  
        try(InputStream is = new ByteArrayInputStream(body.getBytes())) {

            JsonReader reader = Json.createReader(is);
            JsonObject result = reader.readObject();
            JsonArray resultWeatherArray = result.getJsonArray("weather");

            float temp = (float) result.getJsonObject("main").getJsonNumber("temp").doubleValue();
            float pressure = (float) result.getJsonObject("main").getJsonNumber("pressure").doubleValue();
            float humidity = (float) result.getJsonObject("main").getJsonNumber("humidity").doubleValue();
            String name = result.getString("name");

            weather.setHumidity(humidity);
            weather.setTemp(temp);
            weather.setPressure(pressure);
            weather.setName(name);

            weather.setMain(resultWeatherArray.getJsonObject(0).getString("main"));
            weather.setDescription(resultWeatherArray.getJsonObject(0).getString("description"));
        } catch (Exception e) {}
        
        return weather;
    }

    public String getWeatherJson(String city) {
        Weather weather = new Weather();
        weather = getWeather(city);
        return weather.toJson().toString();
    }
}

