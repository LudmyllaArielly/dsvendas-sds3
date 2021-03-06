package com.ludmylla.dsvendas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ludmylla.dsvendas.dto.SaleDto;
import com.ludmylla.dsvendas.dto.SaleSumDto;
import com.ludmylla.dsvendas.dto.SaleSusscessDto;
import com.ludmylla.dsvendas.services.SaleService;

@RestController
@RequestMapping(value = "/sales")
public class SaleController {
	
	@Autowired
	private SaleService saleService;
	
	@GetMapping
	public ResponseEntity<Page<SaleDto>> findAll(Pageable pageable){
		Page<SaleDto> list = saleService.findAll(pageable);
		return ResponseEntity.ok(list);
	}
	
	@GetMapping(value = "/amount-by-seller")
	public ResponseEntity<List<SaleSumDto>> amountGroupedBySeller(){
		List<SaleSumDto> list = saleService.amountGroupedBySeller();
		return ResponseEntity.ok(list);
	}
	
	@GetMapping(value = "/susscess-by-seller")
	public ResponseEntity<List<SaleSusscessDto>> successGroupedBySeller(){
		List<SaleSusscessDto> list = saleService.successGroupedBySeller();
		return ResponseEntity.ok(list);
	}
	
}
