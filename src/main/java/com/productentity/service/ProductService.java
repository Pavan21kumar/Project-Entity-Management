package com.productentity.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.productentity.dto.ProductRequast;
import com.productentity.entity.Product;
import com.productentity.util.ResponseStructure;

public interface ProductService {

	ResponseEntity<ResponseStructure<Product>> saveProduct(ProductRequast product);

	ResponseEntity<ResponseStructure<String>> deleteProduct(int productId);

	ResponseEntity<ResponseStructure<Product>> getById(int productId);

	ResponseEntity<ResponseStructure<Product>> updateProductLamda(int productId, ProductRequast product);

	ResponseEntity<ResponseStructure<List<Product>>> getAllProductsLamda();

	

}
     