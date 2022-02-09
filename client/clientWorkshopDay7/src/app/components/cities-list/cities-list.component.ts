import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-cities-list',
  templateUrl: './cities-list.component.html',
  styleUrls: ['./cities-list.component.css']
})
export class CitiesListComponent implements OnInit {

  citiesList: string[] = ["Singapore", "Tokyo", "Bangkok", "Jakarta", "Sydney", "Berlin", "Amsterdam"]

  constructor() { }

  ngOnInit(): void {
  }

  addCity(cityName: any) {
    this.citiesList.push(cityName);
  }

}
