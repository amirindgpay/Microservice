package com.us.microservice.web.model.v2;

import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
//@RequiredArgsConstructor
@Builder
public class BeerDtoV2 {

	private UUID id;
	private String beerName;
	private BeerStyleEnum beerStyle;
	private Long upc;

}
