package com.projet.projetojava;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.projet.projetojava.service.AirlineService;
import com.projet.projetojava.entity.Airplane;

@SpringBootApplication
public class Main {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(Main.class, args);

        AirlineService airlineServiceRed = context.getBean(AirlineService.class);
        airlineServiceRed.setAirlineName("Red");

        AirlineService airlineServiceBlue = context.getBean(AirlineService.class);
        airlineServiceBlue.setAirlineName("Blue");

        AirlineService airlineServiceGreen = context.getBean(AirlineService.class);
        airlineServiceGreen.setAirlineName("Green");

        // Adicionando aviões à companhia aérea Red
        Airplane airplane1 = new Airplane();
        airplane1.setModel("Boeing 747");
        airlineServiceRed.addAirplane(airplane1);

        Airplane airplane2 = new Airplane();
        airplane2.setModel("Boeing 747");
        airlineServiceRed.addAirplane(airplane2);

        // Imprimindo o nome da companhia aérea e os aviões
        System.out.println(airlineServiceRed.getAirlineName());
        System.out.println(airlineServiceRed.getAirplanes());

        // Adicionando aviões à companhia aérea Blue
        Airplane airplane3 = new Airplane();
        airplane3.setModel("Airbus A320");
        airlineServiceBlue.addAirplane(airplane3);

        Airplane airplane4 = new Airplane();
        airplane4.setModel("Airbus A320");
        airlineServiceBlue.addAirplane(airplane4);

        // Imprimindo o nome da companhia aérea e os aviões
        System.out.println(airlineServiceBlue.getAirlineName());
        System.out.println(airlineServiceBlue.getAirplanes());

        // Adicionando aviões à companhia aérea Green
        Airplane airplane5 = new Airplane();
        airplane5.setModel("Boeing 737");
        airlineServiceGreen.addAirplane(airplane5);

        Airplane airplane6 = new Airplane();
        airplane6.setModel("Boeing 737");
        airlineServiceGreen.addAirplane(airplane6);

        // Imprimindo o nome da companhia aérea e os aviões
        System.out.println(airlineServiceGreen.getAirlineName());
        System.out.println(airlineServiceGreen.getAirplanes());
    }
}

