package com.prova.concesionarios;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.prova.concesionarios.repositories.DealershipCarRepository;




@SpringBootApplication
public class ConcesionariosApplication {
	
	
	public static void main(String[] args) {
		ApplicationContext ctx  = SpringApplication.run(ConcesionariosApplication.class, args);
		DealershipCarRepository repo = ctx.getBean(DealershipCarRepository.class);
		repo.findAll().forEach(deal ->{
			System.out.println(deal.getName() + " " + deal.getBenefits() );
				}
				
				);
	}

}
