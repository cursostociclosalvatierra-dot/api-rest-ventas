package pe.edu.cibertec.api_rest_ventas.model;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "orders")
public class Order {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer orderid;
	private LocalDateTime orderdate;
	private LocalDateTime requireddate;
	private LocalDateTime shippeddate;
	private Integer shipvia;
	private Double freight;
	private String shipname;
	private String shipaddress;
	private String shipcity;
	private String shipregion;
	private String shippostalcode;
	private String shipcountry;	
	@ManyToOne
	@JoinColumn(name="customerid")
	private Customer customer;
	@ManyToOne
	@JoinColumn(name="employeeid")
	private Employee employee;
	
}
