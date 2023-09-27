package com.projet.projetojava;

import com.projet.projetojava.service.AirlineService;

public class Main {
    public static void main(String[] args) {
       
        AirlineService airlineServiceRed = new AirlineService("Red");
        AirlineService airlineServiceBlue = new AirlineService("Blue");
        AirlineService airlineServiceGreen = new AirlineService("Green");

       
        System.out.println(airlineServiceRed.getAirlineName());
        System.out.println(airlineServiceBlue.getAirlineName());
        System.out.println(airlineServiceGreen.getAirlineName());
    }
}