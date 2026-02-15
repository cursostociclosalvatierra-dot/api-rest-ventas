package pe.edu.cibertec.api_rest_ventas.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import pe.edu.cibertec.api_rest_ventas.model.Product;

public interface ProductRepository extends
	JpaRepository<Product, Integer>{
	//select * from products where discontinued = ? 
	//Funciones JPA (uso solo para consultas básicas)
	List<Product> findByDiscontinued(Boolean discontinued);
	
	//JPQL != SQL (uso para consultas intermedias)
	@Query(value = "select p from Product p where p.discontinued=:discontinued")
	List<Product> getProductsNonDiscontinued(
			@Param("discontinued")Boolean discontinued);
	
	//SQL Nativo
	@Query(value = "select * from products where discontinued=:discontinued",
			nativeQuery = true)
	List<Product> getProductsNonDiscontinuedSQL(
			@Param("discontinued")Boolean discontinued);
	
	

}
