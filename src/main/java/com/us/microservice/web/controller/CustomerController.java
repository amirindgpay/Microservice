package com.us.microservice.web.controller;

import java.util.UUID;

import com.us.microservice.web.model.BeerDto;
import com.us.microservice.web.model.CustomerDto;
import com.us.microservice.web.service.CustomerService;
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

@RequestMapping("/api/v1/customer")
@RequiredArgsConstructor
@RestController
public class CustomerController {

	private final CustomerService customerService;

	@GetMapping("/{customerId}")
	public ResponseEntity<CustomerDto> getCustomer(@PathVariable("customerId") UUID customerId){
		return new ResponseEntity<>(customerService.getById(customerId), HttpStatus.OK);
	}


	@PostMapping
	public ResponseEntity<CustomerDto> saveCustomer(@RequestBody CustomerDto customerDto){
		CustomerDto customerDto1 = customerService.saveNewCustomer(customerDto);

		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.add("Location" , "/api/v1/customer/" +"   "+  customerDto.getName());

		return new ResponseEntity<>( customerDto1 ,httpHeaders , HttpStatus.CREATED);
	}


	@PutMapping("/{customerId}")
	public ResponseEntity<CustomerDto> update(@PathVariable("customerId") UUID uuid , @RequestBody CustomerDto customerDto){
		CustomerDto customerDto1=customerService.update(uuid , customerDto);
		return new ResponseEntity<>(customerDto1,HttpStatus.NO_CONTENT);
	}

	@DeleteMapping("/{customerId}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable("customerId") UUID uuid){
		customerService.delete(uuid);
	}



}
