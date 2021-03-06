package io.altar.DTOs;

import io.altar.models.BaseEntity;
import io.altar.models.Product;
import io.altar.models.Shelf;

public class ShelfDTO extends BaseEntity {
	private static final long serialVersionUID=1L;
	private String capacity;
	private ProductDTO productDTOInShelf;
	private double rentPrice;
	private long id;
	public ShelfDTO(){}
	public ShelfDTO(String capacity, ProductDTO productDTOInShelf, double rentPrice, long id) {
		super();
		this.capacity = capacity;
		this.productDTOInShelf = productDTOInShelf;
		this.rentPrice = rentPrice;
		this.id=id;
	}
	public ShelfDTO(String capacity, double rentPrice, long id) {
		super();
		this.capacity = capacity;
		this.rentPrice = rentPrice;
		this.id=id;
	}
	public static ShelfDTO turnShelfToShelfDTO(Shelf shelfToPresent){
		ShelfDTO shelfDTOToPresent;
		if(shelfToPresent.getProductInShelf()!=null){
			shelfDTOToPresent=new ShelfDTO(shelfToPresent.getCapacity(),ProductDTO.turnProductToProductDTO(shelfToPresent.getProductInShelf()),shelfToPresent.getRentPrice(),shelfToPresent.getId());
		} else 
			shelfDTOToPresent=new ShelfDTO(shelfToPresent.getCapacity(),shelfToPresent.getRentPrice(),shelfToPresent.getId());
		return shelfDTOToPresent;
		
	}
	public String getCapacity() {
		return capacity;
	}
	public void setCapacity(String capacity) {
		this.capacity = capacity;
	}
	public ProductDTO getProductDTOInShelf() {
		return productDTOInShelf;
	}
	public void setProductDTOInShelf(ProductDTO productDTOInShelf) {
		this.productDTOInShelf = productDTOInShelf;
	}
	public double getRentPrice() {
		return rentPrice;
	}
	public void setRentPrice(double rentPrice) {
		this.rentPrice = rentPrice;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	
	
	
	
	
}


