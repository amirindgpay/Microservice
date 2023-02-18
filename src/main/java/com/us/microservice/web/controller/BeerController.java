package com.us.microservice.web.controller;

import java.util.UUID;

import com.us.microservice.web.model.BeerDto;
import com.us.microservice.web.service.BeerService;
import lombok.AllArgsConstructor;
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
@RequestMapping("/api/v1/beer")
@Deprecated
public class BeerController {

	private final BeerService beerService;

	@GetMapping("/{beerId}")
	public ResponseEntity<BeerDto> getBeer(@PathVariable("beerId") UUID beerId){
		return new ResponseEntity<>(beerService.getById(beerId), HttpStatus.OK);
	}


	@PostMapping
	public ResponseEntity<BeerDto> saveBeer(@RequestBody BeerDto beerDto){
		BeerDto saveDto = beerService.saveNewBeer(beerDto);

		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.add("Location" , "/api/v1/beer/" +"   "+  saveDto.getBeerName());

		return new ResponseEntity<>( saveDto ,httpHeaders , HttpStatus.CREATED);
	}


	@PutMapping("/{beerId}")
	public ResponseEntity<BeerDto> update(@PathVariable("beerId") UUID uuid , @RequestBody BeerDto beerDto){
		BeerDto beerDto1=beerService.update(uuid , beerDto);
		return new ResponseEntity<>(beerDto1,HttpStatus.NO_CONTENT);
	}

	@DeleteMapping("/{beerId}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable("beerId") UUID uuid){
		beerService.delete(uuid);
	}


}
