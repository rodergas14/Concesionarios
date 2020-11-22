package com.prova.concesionarios.dto;

import java.io.Serializable;
import java.util.ArrayList;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ChainBenefitsDTO {
	private Double chainBenefits;
	private ArrayList<DealershipBenefits> dealershipBenefitsList;
	
	public ChainBenefitsDTO() {
		chainBenefits = 0.0;
		dealershipBenefitsList = new ArrayList<>();
	}

	@Getter
	@Setter
	public class DealershipBenefits implements Serializable {
		private String dealershipName;
		private Double dealershipBenefits;
		
		public DealershipBenefits(String dealershipName,Double dealershipBenefits ) {
			this.dealershipName = dealershipName;
			this.dealershipBenefits = dealershipBenefits;
		}
		
		
	}
	
	public void addDealershipBenefits(String dealershipName,Double dealershipBenefits) {
		dealershipBenefitsList.add(new DealershipBenefits(dealershipName,dealershipBenefits));
	}
	
	
	

	
	
}
