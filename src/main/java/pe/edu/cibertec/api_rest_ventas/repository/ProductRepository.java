package pe.edu.cibertec.api_rest_ventas.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pe.edu.cibertec.api_rest_ventas.model.Product;

public interface ProductRepository extends
	JpaRepository<Product, Integer>{

}
