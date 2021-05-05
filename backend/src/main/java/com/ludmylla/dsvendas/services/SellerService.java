package com.ludmylla.dsvendas.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ludmylla.dsvendas.dto.SellerDto;
import com.ludmylla.dsvendas.entities.Seller;
import com.ludmylla.dsvendas.repository.SellerRepository;

@Service
public class SellerService {
	
	@Autowired
	private SellerRepository sellerRepository;
	
	public List<SellerDto> findAll(){
		List<Seller> seller = sellerRepository.findAll();
		// Converte lista de Seller para uma nova lista de SellerDto
		return seller.stream().map(x -> new SellerDto(x)).collect(Collectors.toList());
	}
	
}
