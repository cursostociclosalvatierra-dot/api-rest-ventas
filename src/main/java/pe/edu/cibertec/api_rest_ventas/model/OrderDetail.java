package pe.edu.cibertec.api_rest_ventas.model;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "ordersdetails")
public class OrderDetail {
	@EmbeddedId
	private ProductOrderId id;
	private Double unitprice;
	private Integer quantity;
	public ProductOrderId getId() {
		return id;
	}
	public void setId(ProductOrderId id) {
		this.id = id;
	}
	public Double getUnitprice() {
		return unitprice;
	}
	public void setUnitprice(Double unitprice) {
		this.unitprice = unitprice;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	

}
