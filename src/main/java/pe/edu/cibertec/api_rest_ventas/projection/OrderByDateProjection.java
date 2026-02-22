package pe.edu.cibertec.api_rest_ventas.projection;

import java.time.LocalDateTime;

public interface OrderByDateProjection {	
	Long getOrderID();
	String getCustomerID();
	Long getEmployeID();
	LocalDateTime getOrderDate();
	Long getProductID();
	Double getUnitPrice();
	Integer getQuantity();
	Double getDiscount();
	Double getTotalLinea();
}
