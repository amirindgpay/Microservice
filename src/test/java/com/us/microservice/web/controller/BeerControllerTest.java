package com.us.microservice.web.controller;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.us.microservice.web.model.BeerDto;
import com.us.microservice.web.service.BeerService;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;

import static org.hamcrest.core.Is.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@ExtendWith(SpringExtension.class)
@WebMvcTest(BeerController.class)
public class BeerControllerTest {

	@MockBean
	BeerService beerService;

	@Autowired
	MockMvc mockMvc;

	@Autowired
	ObjectMapper objectMapper;

	BeerDto validBeer;

	@Before
	public void setUp() {
		validBeer = BeerDto.builder().id(UUID.randomUUID())
				.beerName("Beer1")
				.beerStyle("PALE_ALE")
				.upc(123456789012L)
				.build();
	}



	@Test
	void handle_1() throws Exception {

		validBeer = BeerDto.builder().id(UUID.randomUUID())
				.beerName("Beer1")
				.beerStyle("PALE_ALE")
				.upc(123456789012L)
				.build();

		given(beerService.getById(any(UUID.class))).willReturn(validBeer);

		mockMvc.perform(get("/api/v1/beer"+"/"+validBeer.getId().toString()).accept(MediaType.APPLICATION_JSON_UTF8))
				.andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
				.andExpect(jsonPath("$.id", is(validBeer.getId().toString())))
				.andExpect(jsonPath("$.beerName", is("Beer1")));
	}

	@Test
	void handle_2() throws Exception {

		BeerDto beerDto = BeerDto.builder().id(UUID.randomUUID())
				.beerName("Beer1")
				.beerStyle("PALE_ALE")
				.upc(123456789012L)
				.build();

		String beerDtoJson = objectMapper.writeValueAsString(beerDto);


		given(beerService.saveNewBeer(any())).willReturn(beerDto);

//		mockMvc.perform(post("/api/v1/beer").accept(MediaType.APPLICATION_JSON_UTF8))
//				.andExpect(status().isCreated())
//				.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8));

		mockMvc.perform(post("/api/v1/beer")
						.contentType(MediaType.APPLICATION_JSON_UTF8)
						.content(beerDtoJson))
				.andExpect(status().isCreated());


	}


	@Test
	public void handleUpdate() throws Exception {
		//given
		BeerDto beerDto = BeerDto.builder().id(UUID.randomUUID())
				.beerName("Beer1")
				.beerStyle("PALE_ALE")
				.upc(123456789012L)
				.build();

		String beerDtoJson = objectMapper.writeValueAsString(beerDto);


		given(beerService.update(any(),any())).willReturn(beerDto);

		mockMvc.perform(put("/api/v1/beer/" + validBeer.getId())
						.contentType(MediaType.APPLICATION_JSON)
						.content(beerDtoJson))
				.andExpect(status().isNoContent());

//		then(beerService).should().update(any(), any());

	}


}
