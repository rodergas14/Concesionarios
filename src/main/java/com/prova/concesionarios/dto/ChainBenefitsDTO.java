package com.prova.concesionarios.dto;

import java.util.List;

public class ChainBenefitsDTO {
	public class DealershipBenefits{
		String dealershipName;
		Double dealershipBenefits;
		
		public DealershipBenefits(String dealershipName,Double dealershipBenefits ) {
			this.dealershipName = dealershipName;
			this.dealershipBenefits = dealershipBenefits;
		}
	}
	
	private Double chainBenefits;
	private List<DealershipBenefits> dealershipBenefits;
	
	
}
