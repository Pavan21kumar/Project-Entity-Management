package com.productentity.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductRequast {

	@NotNull(message = "product name should be not null")
	private String productName;
	@NotNull(message = "product price should be not null")
	private int productPrice;
	@NotNull(message = "product quantity should be not null")
	private int quantity;

}
