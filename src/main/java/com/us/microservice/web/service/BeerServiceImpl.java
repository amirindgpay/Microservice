package com.us.microservice.web.service;

import java.util.UUID;

import com.us.microservice.web.model.BeerDto;

import org.springframework.stereotype.Service;

@Service
public class BeerServiceImpl implements BeerService{
	@Override
	public BeerDto getById(UUID beerId) {
		return BeerDto.builder()
				.id(UUID.randomUUID())
				.beerName("A")
				.beerStyle("B")
				.build();
	}

	@Override
	public BeerDto saveNewBeer(BeerDto beerDto) {
		return BeerDto.builder()
				.id(UUID.randomUUID())
				.beerName("Dog")
				.build();
	}

	@Override
	public BeerDto update(UUID uuid, BeerDto beerDto) {
		return null;
	}

	@Override
	public void delete(UUID uuid) {

	}
}
