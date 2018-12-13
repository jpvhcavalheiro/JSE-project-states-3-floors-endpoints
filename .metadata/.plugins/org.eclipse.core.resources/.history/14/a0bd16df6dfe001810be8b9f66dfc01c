package io.altar.models;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class Shelf extends BaseEntity {
	private static final long serialVersionUID=1L;
	private String capacity;
	
	@ManyToOne(cascade=CascadeType.ALL)
	private Product productInShelf;
	private double rentPrice;
	public Shelf(){}
	public Shelf(String capacity, Product productInShelf, double rentPrice) {
		super();
		this.capacity = capacity;
		this.productInShelf = productInShelf;
		this.rentPrice = rentPrice;
	}
	/*public Shelf(String capacity, double rentPrice) {
		super();
		this.capacity = capacity;
		this.rentPrice = rentPrice;
	}*/
	public String getCapacity() {
		return capacity;
	}
	public void setCapacity(String capacity) {
		this.capacity = capacity;
	}

	public Product getProductInShelf() {
		return productInShelf;
	}
	public void setProductInShelf(Product productInShelf) {
		this.productInShelf = productInShelf;
	}
	public double getRentPrice() {
		return rentPrice;
	}
	public void setRentPrice(double rentPrice) {
		this.rentPrice = rentPrice;
	}

	public String shelfToString() {
		return "Shelf"+getId()+" [capacity=" + capacity + ", productIdInShelf=" + productInShelf + ", rentPrice=" + rentPrice + "]";
	}
}
