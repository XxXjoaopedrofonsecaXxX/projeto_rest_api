package com.projet.projetojava;

import java.util.Map;

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

        AirlineService airlineServiceGreen = context.getBean(AirlineService.class);
        airlineServiceGreen.setAirlineName("Green");

        AirlineService airlineServiceBlue = context.getBean(AirlineService.class);
        airlineServiceBlue.setAirlineName("Blue");

        // Adicionando aviões à companhia aérea Red
        Airplane airplane1 = new Airplane();
        airplane1.setModel("Boeing 747");
        airplane1.setMaxCapacity(366); // Adicionando capacidade máxima
        airplane1.setAirline(airlineServiceRed.getAirlineName()); // Defina a companhia aérea para o avião
        airlineServiceRed.addAirplane(airplane1);

        Airplane airplane2 = new Airplane();
        airplane2.setModel("Boeing 747");
        airplane2.setMaxCapacity(366); // Adicionando capacidade máxima
        airplane2.setAirline(airlineServiceRed.getAirlineName()); // Defina a companhia aérea para o avião
        airlineServiceRed.addAirplane(airplane2);

        // Imprimindo o nome da companhia aérea e os aviões
        System.out.println(airlineServiceRed.getAirlineName());
        for (Map.Entry<Long, Airplane> entry : airlineServiceRed.getAirplanes().entrySet()) {
            Airplane airplane = entry.getValue();
            System.out.println("Modelo: " + airplane.getModel() + ", Capacidade Máxima: " + airplane.getMaxCapacity());
        }

        // Adicionando aviões à companhia aérea Blue
        Airplane airplane3 = new Airplane();
        airplane3.setModel("Airbus A320");
        airplane3.setMaxCapacity(180); // Adicionando capacidade máxima
        airplane3.setAirline(airlineServiceBlue.getAirlineName()); // Defina a companhia aérea para o avião
        airlineServiceBlue.addAirplane(airplane3);

        Airplane airplane4 = new Airplane();
        airplane4.setModel("Airbus A320");
        airplane4.setMaxCapacity(180); // Adicionando capacidade máxima
        airplane4.setAirline(airlineServiceBlue.getAirlineName()); // Defina a companhia aérea para o avião
        airlineServiceBlue.addAirplane(airplane4);

         // Imprimindo o nome da companhia aérea e os aviões
         System.out.println(airlineServiceBlue.getAirlineName());
         for (Map.Entry<Long, Airplane> entry : airlineServiceBlue.getAirplanes().entrySet()) {
             Airplane airplane = entry.getValue();
             System.out.println("Modelo: " + airplane.getModel() + ", Capacidade Máxima: " + airplane.getMaxCapacity());
         }

         // Adicionando aviões à companhia aérea Green
         Airplane airplane5 = new Airplane();
         airplane5.setModel("Boeing 737");
         airplane5.setMaxCapacity(85); // Adicionando capacidade máxima
         airplane5.setAirline(airlineServiceGreen.getAirlineName()); // Defina a companhia aérea para o avião
         airlineServiceGreen.addAirplane(airplane5);

         Airplane airplane6 = new Airplane();
         airplane6.setModel("Boeing 737");
         airplane6.setMaxCapacity(85); // Adicionando capacidade máxima
         airplane6.setAirline(airlineServiceGreen.getAirlineName()); // Defina a companhia aérea para o avião
         airlineServiceGreen.addAirplane(airplane6);

          // Imprimindo o nome da companhia aérea e os aviões
          System.out.println(airlineServiceGreen.getAirlineName());
          for (Map.Entry<Long, Airplane> entry : airlineServiceGreen.getAirplanes().entrySet()) {
              Airplane airplane = entry.getValue();
              System.out.println("Modelo: " + airplane.getModel() + ", Capacidade Máxima: " + airplane.getMaxCapacity());
          }
    }
}

