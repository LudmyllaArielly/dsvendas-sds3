package com.ludmylla.dsvendas.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ludmylla.dsvendas.dto.SaleDto;
import com.ludmylla.dsvendas.dto.SaleSumDto;
import com.ludmylla.dsvendas.dto.SaleSusscessDto;
import com.ludmylla.dsvendas.entities.Sale;
import com.ludmylla.dsvendas.repository.SaleRepository;
import com.ludmylla.dsvendas.repository.SellerRepository;

@Service
public class SaleService {
	
	@Autowired
	private SaleRepository saleRepository;
	
	@Autowired
	private SellerRepository sellerRepository;
	
	@Transactional(readOnly = true)
	public Page<SaleDto> findAll(Pageable pageable){
		sellerRepository.findAll();
		Page<Sale> sale = saleRepository.findAll(pageable);
		return sale.map(x -> new SaleDto(x));
	}
	
	@Transactional(readOnly = true)
	public List<SaleSumDto> amountGroupedBySeller(){
		return saleRepository.amountGroupedBySeller();
	}
	
	@Transactional(readOnly = true)
	public List<SaleSusscessDto> successGroupedBySeller(){
		return saleRepository.successGroupedBySeller();
	}
	
}
