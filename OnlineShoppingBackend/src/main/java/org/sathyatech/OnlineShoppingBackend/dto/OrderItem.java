package org.sathyatech.OnlineShoppingBackend.dto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="order_item")
public class OrderItem implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2807784793215159858L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@OneToOne
	private Product product;
	@ManyToOne
	@JoinColumn(name="order_id")
	private OrderDetail detail;
	@Column(name="buying_price")
	private double buyingPrice;
	@Column(name="product_count")
	private int productCount;
	private double total;
	
	public OrderItem() {
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public OrderDetail getDetail() {
		return detail;
	}
	public void setDetail(OrderDetail detail) {
		this.detail = detail;
	}
	public double getBuyingPrice() {
		return buyingPrice;
	}
	public void setBuyingPrice(double buyingPrice) {
		this.buyingPrice = buyingPrice;
	}
	public int getProductCount() {
		return productCount;
	}
	public void setProductCount(int productCount) {
		this.productCount = productCount;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}

	@Override
	public String toString() {
		return "OrderItem [id=" + id + ", product=" + product + ", detail=" + detail + ", buyingPrice=" + buyingPrice
				+ ", productCount=" + productCount + ", total=" + total + "]";
	}
	
}
