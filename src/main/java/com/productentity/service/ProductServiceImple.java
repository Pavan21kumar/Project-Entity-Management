package com.productentity.service;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.productentity.dto.ProductRequast;
import com.productentity.entity.Product;
import com.productentity.repository.ProductRepository;
import com.productentity.util.ResponseStructure;

@Service
public class ProductServiceImple implements ProductService {

	private ProductRepository repo;

	private ResponseStructure<Product> structure;
	private ResponseStructure<String> structureString;

	private ResponseStructure<List<Product>> structureList;

	public ProductServiceImple(ProductRepository repo, ResponseStructure<Product> structure,
			ResponseStructure<String> structureString, ResponseStructure<List<Product>> structureList) {

		this.repo = repo;
		this.structure = structure;
		this.structureString = structureString;
		this.structureList = structureList;
	}

	public Product mappedToProductdtotoproduct(Product product, ProductRequast productDto) {
		product.setProductName(productDto.getProductName());
		product.setProductPrice(productDto.getProductPrice());
		product.setQuantity(productDto.getQuantity());
		return product;

	}

	public ResponseEntity<ResponseStructure<Product>> saveProduct(ProductRequast productDto) {

		Product product = mappedToProductdtotoproduct(new Product(), productDto);

		Product product2 = repo.save(product);
		return ResponseEntity
				.ok(structure.setStatuscode(HttpStatus.OK.value()).setMessage("product is strored").setData(product2));
	}

	public ResponseEntity<ResponseStructure<String>> deleteProduct(int productId) {

		Product product = repo.findById(productId).get();
		if (product != null) {
			String res = "data is deleted successfully";
			return ResponseEntity.ok(structureString.setStatuscode(HttpStatus.OK.value())
					.setMessage("product is deleted...").setData(res));

		}
		throw new RuntimeException("product is not present");
	}

	public ResponseEntity<ResponseStructure<Product>> getById(int productId) {

		return repo.findById(productId).map(p -> {

			return ResponseEntity
					.ok(structure.setStatuscode(HttpStatus.OK.value()).setMessage("product is found...").setData(p));
		}).orElseThrow(() -> new RuntimeException("product is not found...."));

	}

	public ResponseEntity<ResponseStructure<Product>> updateProductLamda(int productId, ProductRequast product) {

		
		return repo.findById(productId).map(productex -> {
			productex= mappedToProductdtotoproduct(productex, product);
//			productex.setProductName(product.getProductName());
//			productex.setProductPrice(product.getProductPrice());
//			productex.setQuantity(product.getQuantity());
//			productex = repo.save(productex);

			return ResponseEntity.ok(
					structure.setStatuscode(HttpStatus.OK.value()).setMessage("object is updated").setData(productex));
		}).orElseThrow(() -> new RuntimeException("product is not found..."));

	}

	public ResponseEntity<ResponseStructure<List<Product>>> getAllProductsLamda() {

		List<Product> list = repo.findAll();

		if (list != null) {
			return ResponseEntity.ok(structureList.setStatuscode(HttpStatus.OK.value())
					.setMessage("products data is found").setData(list));
		}
		throw new RuntimeException("products are not found.....");
	}

}
