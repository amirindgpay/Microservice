package com.us.microservice.web.service;

import java.util.UUID;

import com.us.microservice.web.model.BeerDto;

public interface BeerService {
	BeerDto getById(UUID beerId);

	BeerDto saveNewBeer(BeerDto beerDto);

	BeerDto update(UUID uuid, BeerDto beerDto);

	void delete(UUID uuid);
}
