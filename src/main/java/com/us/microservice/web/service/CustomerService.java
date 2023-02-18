package com.us.microservice.web.service;

import java.util.UUID;

import com.us.microservice.web.model.CustomerDto;

public interface CustomerService {

	CustomerDto getById(UUID customerId);

	void delete(UUID uuid);

	CustomerDto update(UUID uuid, CustomerDto customerDto);


	CustomerDto saveNewCustomer(CustomerDto customerDto);
}
