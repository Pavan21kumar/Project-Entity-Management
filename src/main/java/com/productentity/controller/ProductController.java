package com.productentity.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.productentity.dto.ProductRequast;
import com.productentity.entity.Product;
import com.productentity.service.ProductService;
import com.productentity.util.ErrorStructure;
import com.productentity.util.ResponseStructure;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.Valid;

@RestController
public class ProductController {

	private ProductService service;

	public ProductController(ProductService service) {

		this.service = service;
	}

	@Operation(description = "the End point is used to save the Product data", responses = {
			@ApiResponse(responseCode = "200", description = "product is saved"),
			@ApiResponse(responseCode = "400", description = "invaild inputs",
			content = @Content(schema = @Schema(implementation = ErrorStructure.class))) })
	@PostMapping("/products")
	public ResponseEntity<ResponseStructure<Product>> saveProduct(@RequestBody @Valid ProductRequast product) {

		return service.saveProduct(product);
	}

	@Operation(description = "the End point is used to delete the Product data", responses = {
			@ApiResponse(responseCode = "200", description = "product is deleted"),
			@ApiResponse(responseCode = "404", description = "Product Not Found By givenId",
			content = @Content(schema = @Schema(implementation = ErrorStructure.class))) })
	@DeleteMapping("/products/{productId}")
	public ResponseEntity<ResponseStructure<String>> deleteProductById(@PathVariable int productId) {
		return service.deleteProduct(productId);
	}

	@Operation(description = "the end point is used to get the Product based on the productId", responses = {
			@ApiResponse(responseCode = "200", description = "product is found"),
			@ApiResponse(responseCode = "404", description = "Product Not Found By givenId",
			content = @Content(schema = @Schema(implementation = ErrorStructure.class))
			) })
	@GetMapping("/products/{productId}")
	public ResponseEntity<ResponseStructure<Product>> getByIdLamda(@PathVariable int productId) {
		return service.getById(productId);
	}

	@Operation(description = "the End point is used to Update the Product data", responses = {
			@ApiResponse(responseCode = "200", description = "product is Updated"),
			@ApiResponse(responseCode = "404", description = "Product Not Found By givenId",
			content = @Content(schema = @Schema(implementation = ErrorStructure.class))),
			@ApiResponse(responseCode = "400", description = "Invalid Inputs",
			content = @Content(schema = @Schema(implementation = ErrorStructure.class))) })
	@PutMapping("/products/{productId}")
	public ResponseEntity<ResponseStructure<Product>> updateProductLamda(@PathVariable int productId,
			@RequestBody ProductRequast product) {
		return service.updateProductLamda(productId, product);
	}

	@Operation(description = "the End point is used to Update the Product data", responses = {
			@ApiResponse(responseCode = "200", description = "products is Found"),
			@ApiResponse(responseCode = "404", description = "Product Not Found ",
			content = @Content(schema = @Schema(implementation = ErrorStructure.class))) })
	@GetMapping("/products")
	public ResponseEntity<ResponseStructure<List<Product>>> getAllProductLamda() {
		return service.getAllProductsLamda();

	}

}
