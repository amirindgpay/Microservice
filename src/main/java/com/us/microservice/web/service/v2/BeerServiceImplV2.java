package com.us.microservice.web.service.v2;

import java.util.UUID;

import com.us.microservice.web.model.v2.BeerDtoV2;

import org.springframework.stereotype.Service;

@Service
public class BeerServiceImplV2 implements BeerServiceV2{
	@Override
	public BeerDtoV2 getById(UUID beerId) {
		return null;
	}

	@Override
	public BeerDtoV2 saveNewBeer(BeerDtoV2 beerDtoV2) {
		return null;
	}

	@Override
	public BeerDtoV2 update(UUID uuid, BeerDtoV2 beerDtoV2) {
		return null;
	}

	@Override
	public void delete(UUID uuid) {

	}
}
