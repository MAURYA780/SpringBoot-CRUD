package com.bootproject.jesm34.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bootproject.jesm34.dao.BuyerDao;
import com.bootproject.jesm34.dto.BuyerDto;
@Component
public class BuyerService {
	@Autowired
	BuyerDao buyerDao;

	public String createAccount(BuyerDto buyerDto) {
		
		return buyerDao.createaccount(buyerDto);
	}

	public String removeAccount(int id) {
		Optional<BuyerDto> obs=buyerDao.removeAccount(id);
		if(obs.isPresent()) {
			BuyerDto dto=obs.get();
			buyerDao.removeById(dto.getId());
			return "account is deleted";
		}
		else
		return "no data found";
	}

	public BuyerDto findById(int id) {
		Optional<BuyerDto> odo=buyerDao.findById(id);
		if(odo.isPresent()) {
			BuyerDto buyerDto=odo.get();
			return buyerDto;
		}
		else
		return null;
	}

	public List<BuyerDto> findAll() {
		List<BuyerDto> dtos=buyerDao.findAll();
		if(dtos.isEmpty()) {
			return null;
		}
		else
		return dtos;
	}

	public String deleteAll() {
		List<BuyerDto> dtos=buyerDao.findAll();
		if(dtos.isEmpty()) {
		return "data not found";
		}
		else {		
			buyerDao.deleteAll();
			return"data deleted";
		}
	}

	public String update(BuyerDto buyerDto) {
		return buyerDao.update(buyerDto);
	}
}
