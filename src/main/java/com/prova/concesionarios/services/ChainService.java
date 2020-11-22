package com.prova.concesionarios.services;

import org.springframework.stereotype.Service;

import com.prova.concesionarios.dto.ChainBenefitsDTO;
import com.prova.concesionarios.dto.ChainBenefitsDTO.DealershipBenefits;
import com.prova.concesionarios.repositories.DealershipCarRepository;

@Service
public class ChainService {
	
	private final DealershipCarRepository dealershipCarRepository;
	
	public ChainService(DealershipCarRepository dealershipCarRepository) {
		this.dealershipCarRepository = dealershipCarRepository;
	}
	
	public ChainBenefitsDTO getChainBenefits() {
		ChainBenefitsDTO chainBenefitsDTO = new ChainBenefitsDTO();
		
		dealershipCarRepository.findAll().forEach(dealership -> {
						Double dealershipBenefits = dealership.getBenefits();
						chainBenefitsDTO.addDealershipBenefits(dealership.getName(), dealershipBenefits);
						chainBenefitsDTO.setChainBenefits(chainBenefitsDTO.getChainBenefits() + dealershipBenefits );
					}	
				);
		
		return chainBenefitsDTO;
	}
}
