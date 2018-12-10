package io.altar.DTOs;

import java.util.ArrayList;
import java.util.List;

import io.altar.models.Product;
import io.altar.models.Shelf;

public class ProductDTO {
	private static final long serialVersionUID=1L;
	private int discount;
	private int iva;
	private double pvp;
	public ProductDTO(){}
	public ProductDTO(int discount, int iva, double pvp, long id) {
		//super();
		this.discount = discount;
		this.iva = iva;
		this.pvp = pvp;
	}
	public static ProductDTO turnProductToProductDTO(Product productToPresent){
		ProductDTO productDTOToPresent=new ProductDTO(productToPresent.getDiscount(),productToPresent.getIva(),productToPresent.getPvp(),productToPresent.getId());
		return productDTOToPresent;
		
	}
}
