package com.us.microservice.web.controller;

import java.util.UUID;

import com.us.microservice.web.model.BeerDto;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/beer/")
public class BeerController  {

	@GetMapping("{beerId}")
	public ResponseEntity<BeerDto> getBeerById (@PathVariable("beerId")UUID uuid){

		return new ResponseEntity<>(HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity saveNewBeer(@RequestBody BeerDto beerDto){

		return new ResponseEntity(HttpStatus.CREATED);
	}

	@PutMapping("/{beerId}")
	public ResponseEntity updateBeerById(@PathVariable("beerId") UUID uuid , @RequestBody BeerDto beerDto){

		return new ResponseEntity(HttpStatus.NO_CONTENT);
	}

}
