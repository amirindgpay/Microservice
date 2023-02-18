package com.us.microservice.web.service.v2;

import java.util.UUID;

import com.us.microservice.web.model.BeerDto;
import com.us.microservice.web.model.v2.BeerDtoV2;

public interface BeerServiceV2 {
	BeerDtoV2 getById(UUID beerId);

	BeerDtoV2 saveNewBeer(BeerDtoV2 beerDtoV2);

	BeerDtoV2 update(UUID uuid, BeerDtoV2 beerDtoV2);


	void delete(UUID uuid);
}
