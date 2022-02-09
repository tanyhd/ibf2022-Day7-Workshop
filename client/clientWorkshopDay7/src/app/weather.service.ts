import { HttpClient, HttpParams } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { lastValueFrom } from "rxjs";
import { Weather } from "./models";

@Injectable()
export class WeatherService {

  constructor(private http: HttpClient) { }

  getWeather(city: string): Promise<any> {
    return(lastValueFrom(
      this.http.get<Weather>(`/api/weather/${city}`)
    ));
  }
}
