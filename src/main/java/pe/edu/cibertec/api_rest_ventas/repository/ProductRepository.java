package pe.edu.cibertec.api_rest_ventas.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import jakarta.transaction.Transactional;
import pe.edu.cibertec.api_rest_ventas.model.Product;
import pe.edu.cibertec.api_rest_ventas.projection.ProductContactProjection;

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
	
	
	@Query(value = """
			select productname, unitsinstock, unitprice,
			c.categoryname, s.contactname
			from products p 
			INNER JOIN categories c 
			ON p.CategoryID = c.CategoryID
			INNER JOIN suppliers s 
			ON p.SupplierID = s.SupplierID
			WHERE p.unitsinstock < :stock
			AND p.discontinued = :discontinued
			""", nativeQuery = true)
	List<ProductContactProjection> getProductsByStockDiscontinued(
			@Param("stock") Integer stock, 
			@Param("discontinued") Boolean discontinued);
	
	@Transactional
	@Modifying
	@Query(value = """
			update products set unitsinstock=:stock 
			where productid=:productid
			""", nativeQuery = true)
	void updateStockProductsById(@Param("stock") Integer stock,
			@Param("productid") Integer productid);
	
	
	
	
	
	

}
