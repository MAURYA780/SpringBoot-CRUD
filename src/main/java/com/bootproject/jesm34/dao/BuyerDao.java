package com.bootproject.jesm34.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bootproject.jesm34.dto.BuyerDto;
import com.bootproject.jesm34.repository.BuyerRepository;
@Component
public class BuyerDao {
	
	@Autowired
	BuyerRepository buyerRepository;
	
	public String createaccount(BuyerDto d1) {
		buyerRepository.save(d1);
		return "Account created";		
	}

	public Optional<BuyerDto> removeAccount(int id) {
	
		Optional<BuyerDto> obo=buyerRepository.findById(id);
		return obo;
	}

	public void removeById(int id) {
		buyerRepository.deleteById(id);		
		
	}
	public Optional<BuyerDto> findById(int id) {
		Optional<BuyerDto> odo=buyerRepository.findById(id);
		return odo;
	}
	

	public List<BuyerDto> findAll() {
		List<BuyerDto> buyerdtos=buyerRepository.findAll();			
		return buyerdtos;
	}	
	public void deleteAll() {
		buyerRepository.deleteAll();
	}

	public String update(BuyerDto buyerDto) {
		buyerRepository.save(buyerDto);	
		return "data updated";
	}

}
