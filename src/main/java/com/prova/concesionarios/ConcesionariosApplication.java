package com.prova.concesionarios;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.prova.concesionarios.repositories.DealershipCarJPARepository;




@SpringBootApplication
public class ConcesionariosApplication {
	
	
	public static void main(String[] args) {
		ApplicationContext ctx  = SpringApplication.run(ConcesionariosApplication.class, args);
		DealershipCarJPARepository repo = ctx.getBean(DealershipCarJPARepository.class);
		repo.findAll().forEach(deal ->{
			System.out.println(deal.getName() + " " + deal.getBenefits() );
				}
				
				);
	}

}
