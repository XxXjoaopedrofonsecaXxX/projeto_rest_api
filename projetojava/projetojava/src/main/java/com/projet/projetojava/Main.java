package com.projet.projetojava;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import com.projet.projetojava.entity.Airline;
import com.projet.projetojava.entity.Airplane;

@SpringBootApplication
public class Main {
    
	public static void main(String[] args) {

		ConfigurableApplicationContext context = SpringApplication.run(Main.class, args);

		Airline redLine = 	Airline.createAirLine("Red");

		Airline greenLine = context.getBean(Airline.class);
		greenLine.setId(1L);

		Airline blueLine = context.getBean(Airline.class);
		blueLine.setName("Blue");

		// Adicionando aviões à companhia aérea Red
		Airplane airplane1 = new Airplane();
		airplane1.setModel("Boeing 747");
		airplane1.setMaxCapacity(366); // Adicionando capacidade máxima
		airplane1.setAirline(redLine); // Defina a companhia aérea para o avião
		redLine.addAirplane(airplane1);

		Airplane airplane2 = new Airplane();
		airplane2.setModel("Boeing 747");
		airplane2.setMaxCapacity(366); // Adicionando capacidade máxima
		airplane2.setAirline(redLine); // Defina a companhia aérea para o avião
		redLine.addAirplane(airplane2);

        // Imprimindo o nome da companhia aérea e os aviões
        System.out.println(redLine.getName());
        for (Airplane airplane : redLine.getAirplanes()) {
            System.out.println("Modelo: " + airplane.getModel() + ", Capacidade Máxima: " + airplane.getMaxCapacity());
        }

        // Adicionando aviões à companhia aérea Blue
        Airplane airplane3 = new Airplane();
        airplane3.setModel("Airbus A320");
        airplane3.setMaxCapacity(180); // Adicionando capacidade máxima
        airplane3.setAirline(blueLine); // Defina a companhia aérea para o avião
        blueLine.addAirplane(airplane3);

        Airplane airplane4 = new Airplane();
        airplane4.setModel("Airbus A320");
        airplane4.setMaxCapacity(180); // Adicionando capacidade máxima
        airplane4.setAirline(blueLine); // Defina a companhia aérea para o avião
        blueLine.addAirplane(airplane4);

         // Imprimindo o nome da companhia aérea e os aviões
        System.out.println(blueLine.getName());
        for (Airplane airplane : blueLine.getAirplanes()) {
            System.out.println("Modelo: " + airplane.getModel() + ", Capacidade Máxima: " + airplane.getMaxCapacity());
        }

        // Adicionando aviões à companhia aérea Green
        Airplane airplane5 = new Airplane();
        airplane5.setModel("Boeing 737");
        airplane5.setMaxCapacity(85); // Adicionando capacidade máxima
        airplane5.setAirline(greenLine); // Defina a companhia aérea para o avião
        greenLine.addAirplane(airplane5);

        Airplane airplane6 = new Airplane();
        airplane6.setModel("Boeing 737");
        airplane6.setMaxCapacity(85); // Adicionando capacidade máxima
        airplane6.setAirline(greenLine); // Defina a companhia aérea para o avião
        greenLine.addAirplane(airplane6);

        // Imprimindo o nome da companhia aérea e os aviões
        System.out.println(greenLine.getName());
        for (Airplane airplane : greenLine.getAirplanes()) {
            System.out.println("Modelo: " + airplane.getModel() + ", Capacidade Máxima: " + airplane.getMaxCapacity());
        }
   } 
}
