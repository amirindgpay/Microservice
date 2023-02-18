package com.us.microservice.web.controller.v2;

import java.util.UUID;

import com.us.microservice.web.model.BeerDto;
import com.us.microservice.web.model.v2.BeerDtoV2;
import com.us.microservice.web.service.v2.BeerServiceV2;
import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v2/beer")
public class BeerControllerV2 {

	private final BeerServiceV2 beerServiceV2;

	@GetMapping("/{beerId}")
	public ResponseEntity<BeerDtoV2> getBeer(@PathVariable("beerId") UUID beerId){
		return new ResponseEntity<>(beerServiceV2.getById(beerId), HttpStatus.OK);
	}


	@PostMapping
	public ResponseEntity<BeerDtoV2> saveBeer(@RequestBody BeerDtoV2 beerDtoV2){
		BeerDtoV2 saveDto = beerServiceV2.saveNewBeer(beerDtoV2);

		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.add("Location" , "/api/v2/beer/" +"   "+  saveDto.getBeerName());

		return new ResponseEntity<>( saveDto ,httpHeaders , HttpStatus.CREATED);
	}


	@PutMapping("/{beerId}")
	public ResponseEntity<BeerDtoV2> update(@PathVariable("beerId") UUID uuid , @RequestBody BeerDtoV2 beerDtoV2){
		BeerDtoV2 update= beerServiceV2.update(uuid , beerDtoV2);
		return new ResponseEntity<>(update,HttpStatus.NO_CONTENT);
	}

	@DeleteMapping("/{beerId}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable("beerId") UUID uuid){
		beerServiceV2.delete(uuid);
	}


}
