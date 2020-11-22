package com.prova.concesionarios.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.prova.concesionarios.dto.ChainBenefitsDTO;
import com.prova.concesionarios.services.ChainService;

@RestController
@RequestMapping("/chain")
public class ChainAPI {
	
	private final ChainService chainService;
	
	public ChainAPI(ChainService chainService) {
		this.chainService = chainService;
	}
	
	@GetMapping("/benefits")
	public ResponseEntity<ChainBenefitsDTO> getBenefits() {
		return ResponseEntity.ok(chainService.getChainBenefits());
	}
}
