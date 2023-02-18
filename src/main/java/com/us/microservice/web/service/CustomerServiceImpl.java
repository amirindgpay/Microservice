package com.us.microservice.web.service;

import java.util.UUID;

import com.us.microservice.web.model.CustomerDto;

import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService{
	@Override
	public CustomerDto getById(UUID customerId) {
		return CustomerDto.builder()
				.id(UUID.randomUUID())
				.name("Sara")
				.build();
	}

	@Override
	public void delete(UUID uuid) {

	}

	@Override
	public CustomerDto update(UUID uuid, CustomerDto customerDto) {
		return null;
	}

	@Override
	public CustomerDto saveNewCustomer(CustomerDto customerDto) {
		return null;
	}
}
