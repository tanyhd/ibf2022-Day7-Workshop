import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { CitiesListComponent } from './components/cities-list/cities-list.component';
import { WeatherComponent } from './components/weather/weather.component';
import { RouterModule, Routes } from '@angular/router'
import { HttpClientModule } from '@angular/common/http'
import { WeatherService } from './weather.service';

const appRoute: Routes = [
  { path: '', component: CitiesListComponent},
  { path: 'weather/:city', component: WeatherComponent}
]

@NgModule({
  declarations: [
    AppComponent,
    CitiesListComponent,
    WeatherComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    RouterModule.forRoot(appRoute),
    HttpClientModule
  ],
  providers: [WeatherService],
  bootstrap: [AppComponent]
})
export class AppModule { }
