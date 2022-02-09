package day7workshop.day7.models;

import jakarta.json.Json;
import jakarta.json.JsonObject;

public class Weather {

    private String main = "";
    private String description = ""; 
    private String icon;
    private float temp = 0;
    private float pressure;
    private float humidity;
    private String name = "";

    
    public String name() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public float getTemp() {
        return temp;
    }
    public void setTemp(float temp) {
        this.temp = temp;
    }
    public float getPressure() {
        return pressure;
    }
    public void setPressure(float pressure) {
        this.pressure = pressure;
    }
    public float getHumidity() {
        return humidity;
    }
    public void setHumidity(float humidity) {
        this.humidity = humidity;
    }
    public String getMain() {
        return main;
    }
    public void setMain(String main) {
        this.main = main;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public String getIcon() {
        return icon;
    }
    public void setIcon(String icon) {
        this.icon = icon;
    }

    public JsonObject toJson() {
        return Json.createObjectBuilder()
            .add("main", main)
            .add("description", description)
            .add("temp", temp)
            .add("pressure", pressure)
            .add("humidity", humidity)
            .add("name", name)
            .build();
    }
    
}

