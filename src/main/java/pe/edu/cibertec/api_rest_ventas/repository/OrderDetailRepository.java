package pe.edu.cibertec.api_rest_ventas.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import pe.edu.cibertec.api_rest_ventas.model.OrderDetail;
import pe.edu.cibertec.api_rest_ventas.model.ProductOrderId;
import pe.edu.cibertec.api_rest_ventas.projection.OrderByDateProjection;

public interface OrderDetailRepository
 extends JpaRepository<OrderDetail, ProductOrderId>{
	
	
	@Query(value = """
		CALL ObtenerOrdenesPorFecha(:fechaInicio, :fechaFin)
			""", nativeQuery = true)
	List<OrderByDateProjection> getOrderByDate(
			@Param("fechaInicio") LocalDate fechaInicio,
			@Param("fechaFin") LocalDate fechaFin);
	
	

}

