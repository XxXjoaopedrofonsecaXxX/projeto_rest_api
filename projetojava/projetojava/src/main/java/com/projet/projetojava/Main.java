package com.projet.projetojava;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.projet.projetojava.entity.Airline;
import com.projet.projetojava.entity.Airplane;

@SpringBootApplication
public class Main {
    
	public static void main(String[] args) {

		SpringApplication.run(Main.class, args);

		Airline redLine = 	Airline.createAirLine("Red");
		Airline greenLine = new Airline();
		Airline blueLine = new Airline();
		blueLine.setName("Blue");

		// Adicionando aviões à companhia aérea Red
		addAirplanesToAirline(redLine, "Boeing 747", 366, 2);

        // Imprimindo o nome da companhia aérea e os aviões
        printAirlineAndAirplanes(redLine);

        // Adicionando aviões à companhia aérea Blue
        addAirplanesToAirline(blueLine, "Airbus A320", 180, 2);

         // Imprimindo o nome da companhia aérea e os aviões
        printAirlineAndAirplanes(blueLine);

        // Adicionando aviões à companhia aérea Green
        addAirplanesToAirline(greenLine, "Boeing 737", 85, 2);

        // Imprimindo o nome da companhia aérea e os aviões
        printAirlineAndAirplanes(greenLine);
   } 

   private static void addAirplanesToAirline(Airline airline, String model, int maxCapacity, int quantity) {
       for (int i = 0; i < quantity; i++) {
           Airplane airplane = new Airplane();
           airplane.setModel(model);
           airplane.setMaxCapacity(maxCapacity); // Adicionando capacidade máxima
           airplane.setAirline(airline); // Defina a companhia aérea para o avião
           airline.addAirplane(airplane);
       }
   }

   private static void printAirlineAndAirplanes(Airline airline) {
       System.out.println(airline.getName());
       for (Airplane airplane : airline.getAirplanes()) {
           System.out.println("Modelo: " + airplane.getModel() + ", Capacidade Máxima: " + airplane.getMaxCapacity());
       }
   }
}
