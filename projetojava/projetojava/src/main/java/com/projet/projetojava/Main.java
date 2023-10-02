package com.projet.projetojava;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.projet.projetojava.entity.Airline;
import com.projet.projetojava.entity.Airplane;
import com.projet.projetojava.repository.AirlineRepository;
import com.projet.projetojava.repository.AirplaneRepository;

@SpringBootApplication
public class Main implements CommandLineRunner {

    @Autowired
    private AirlineRepository airlineRepository;

    @Autowired
    private AirplaneRepository airplaneRepository;

	public static void main(String[] args) {
		SpringApplication.run(Main.class, args);
	}

    @Override
    public void run(String... args) throws Exception {
        Airline redLine = 	new Airline("Red");
        airlineRepository.save(redLine);

        // similar for greenLine and blueLine

        // Adicionando aviões à companhia aérea Red
        addAirplanesToAirline(redLine, "Boeing 747", 366, 2);

        // similar for other airlines
    }

   private void addAirplanesToAirline(Airline airline, String model, int maxCapacity, int quantity) {
       for (int i = 0; i < quantity; i++) {
           Airplane airplane = new Airplane(model, maxCapacity, airline);
           airplaneRepository.save(airplane);
       }
   }
}
