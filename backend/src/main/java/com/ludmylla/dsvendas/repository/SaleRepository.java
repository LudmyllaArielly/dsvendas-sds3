package com.ludmylla.dsvendas.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ludmylla.dsvendas.dto.SaleSumDto;
import com.ludmylla.dsvendas.dto.SaleSusscessDto;
import com.ludmylla.dsvendas.entities.Sale;

@Repository
public interface SaleRepository extends JpaRepository<Sale, Long>{
	
	@Query("select new com.ludmylla.dsvendas.dto.SaleSumDto(obj.seller, sum(obj.amount)) "
			+ "from Sale as obj group by obj.seller")
	List<SaleSumDto> amountGroupedBySeller();
	
	@Query("select new com.ludmylla.dsvendas.dto.SaleSusscessDto(obj.seller, sum(obj.visited), sum(obj.deals)) "
			+ "from Sale as obj group by obj.seller")
	List<SaleSusscessDto> successGroupedBySeller();
}
