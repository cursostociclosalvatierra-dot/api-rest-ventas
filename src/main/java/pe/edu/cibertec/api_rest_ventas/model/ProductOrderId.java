package pe.edu.cibertec.api_rest_ventas.model;

import java.io.Serializable;

import jakarta.persistence.Embeddable;

@Embeddable
public class ProductOrderId implements Serializable {
	
	private Integer orderid;	
	private Integer productid;
	public Integer getOrderid() {
		return orderid;
	}
	public void setOrderid(Integer orderid) {
		this.orderid = orderid;
	}
	public Integer getProductid() {
		return productid;
	}
	public void setProductid(Integer productid) {
		this.productid = productid;
	}
	
	
}
