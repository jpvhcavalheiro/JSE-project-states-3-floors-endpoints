package io.altar.business;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import io.altar.DTOs.ProductDTO;
import io.altar.models.Product;
import io.altar.repository.ProductRepository;
import io.altar.repository.ShelfRepository;


public class ProductBusiness {
	@Inject
	ProductRepository productRepository1;
	@Inject
	ShelfRepository shelfRepository1;

	@Transactional
	public void provisoryAddNewProduct(Product productToAdd){
		productRepository1.createEntity(productToAdd);
		
	}
	@Transactional
	public void provisoryChangeProduct(Product productToChange){
		productRepository1.changeEntity(productToChange);
	}
	
	@Transactional
	public void provisoryRemoveProductFromProductId(Product productToDelete){
		productRepository1.deleteEntity(productToDelete);
	}
	
	public ProductDTO provisorySeeAProduct(long productIdToSee){
		return ProductDTO.turnProductToProductDTO(productRepository1.findById(productIdToSee));

	}
	
	/*
	public static ProductDTO addNewProductToProductRepository(Product productToAdd) {
		productRepository1.createEntity(productToAdd);
		if (productToAdd.getShelvesList().size() > 0) {
			List <Shelf> newShelvesList=productToAdd.getShelvesList();
			List<Shelf> oldShelvesList=new ArrayList<Shelf>();
			for(Shelf item:newShelvesList){
				oldShelvesList.add(item);
			}
			for (Shelf item : oldShelvesList) {
				if (shelfRepository1.fetchEntityById(item.getId()).getProductInShelf() == null) {
					shelfRepository1.fetchEntityById(item.getId()).setProductInShelf(productToAdd);
				} else {
					productRepository1.fetchEntityById(productToAdd.getId()).getShelvesList().remove(item);
				}
			}
		}
		return ProductDTO.turnProductToProductDTO(productRepository1.fetchEntityById(productToAdd.getId()));
	}

	public static void removeProductFromProductId(long productId) {
		Product oldProduct = productRepository1.fetchEntityById(productId);
		if (oldProduct.getShelvesList().size() > 0) {
			for (Shelf item : oldProduct.getShelvesList()) {
				shelfRepository1.fetchEntityById(item.getId()).setProductInShelf(null);
			}
		}
		productRepository1.deleteEntityById(productId);
	}
	public static boolean isThereThisShelf(long shelfIdToTest) {
		if (shelfRepository1.fetchEntityById(shelfIdToTest) == null) {
			return false;
		} else {
			return true;
		}
	}

	public static ArrayList<ProductDTO> getAllProducts() {
		ArrayList <ProductDTO> productRepository1DTO=new ArrayList<ProductDTO>();
		for(Product item:productRepository1.showAll()){
			productRepository1DTO.add(ProductDTO.turnProductToProductDTO(item));
		}
		return productRepository1DTO;
	}

	public static boolean isThereThisProduct(long productIdToTest) {
		if (productRepository1.fetchEntityById(productIdToTest) == null) {
			return false;
		} else {
			return true;
		}
	}

	public static ProductDTO getAProduct(long productIdToSee) {
		return ProductDTO.turnProductToProductDTO(productRepository1.fetchEntityById(productIdToSee));
	}

	public static ProductDTO changeProduct(Product productToChange) {
		if(!productRepository1.fetchEntityById(productToChange.getId()).getShelvesList().isEmpty()){
			for (Shelf item : productRepository1.fetchEntityById(productToChange.getId()).getShelvesList()) {
				shelfRepository1.fetchEntityById(item.getId()).setProductInShelf(null);
			}
		}
		if(!productToChange.getShelvesList().isEmpty()){
			for (Shelf item : productToChange.getShelvesList()) {
				shelfRepository1.fetchEntityById(item.getId()).setProductInShelf(productToChange);
			}
		}
		productRepository1.changeEntityById(productToChange);
		return ProductDTO.turnProductToProductDTO(productRepository1.fetchEntityById(productToChange.getId()));
	}*/
}
