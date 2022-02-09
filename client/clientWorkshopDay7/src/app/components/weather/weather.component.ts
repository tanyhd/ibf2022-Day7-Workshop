import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Weather } from 'src/app/models';
import { WeatherService } from 'src/app/weather.service';

@Component({
  selector: 'app-weather',
  templateUrl: './weather.component.html',
  styleUrls: ['./weather.component.css']
})
export class WeatherComponent implements OnInit {

  weather!: Weather;

  constructor(private weatherSvc: WeatherService, private activatedRoute: ActivatedRoute) { }

  ngOnInit(): void {
    const city = this.activatedRoute.snapshot.params['city']
    this.weatherSvc.getWeather(city)
      .then(w => this.weather = w)
  }

}
