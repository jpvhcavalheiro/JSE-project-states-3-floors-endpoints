package io.altar.DTOs;

import io.altar.models.Product;

public class ShelfDTO {
	private static final long serialVersionUID=1L;
	private String capacity;
	private Product productInShelf;
	private double rentPrice;
	public ShelfDTO(){}
	public ShelfDTO(String capacity, Product productInShelf, double rentPrice) {
		super();
		this.capacity = capacity;
		this.productInShelf = productInShelf;
		this.rentPrice = rentPrice;
	}
}
