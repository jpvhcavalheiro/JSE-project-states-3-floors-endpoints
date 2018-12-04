package io.altar.business;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import io.altar.models.*;
import io.altar.repository.*;

public class Business {
	public static ProductRepository productRepository1 = ProductRepository.getInstance();
	public static ShelfRepository shelfRepository1 = ShelfRepository.getInstance();

	public static Product addNewProductToProductRepository(Product productToAdd) {
		if (productToAdd.getShelvesIdList().size() > 0) {
			for (long item : productToAdd.getShelvesIdList()) {
				shelfRepository1.fetchEntityById(item).setProductIdInShelf(productToAdd.getId());
			}
		}
		productRepository1.createEntity(productToAdd);
		return productToAdd;
	}
	public static void removeProductFromProductId(long productId){
		productRepository1.deleteEntityById(productId);
	}

	public static void updateShelfRepositoryAccordingToShelvesList(ArrayList<Long> shelvesList, long productId) {
		productRepository1.fetchEntityById(productId).setShelvesIdList(shelvesList);
	}

	public static boolean isThereThisShelf(long shelfIdToTest) {
		if (shelfRepository1.fetchEntityById(shelfIdToTest) == null) {
			return false;
		} else {
			return true;
		}
	}
	public static  Collection<Product> getAllProducts(){
		return productRepository1.showAll();
	}

	public static boolean isThereThisProduct(long productIdToTest) {
		if (productRepository1.fetchEntityById(productIdToTest) == null) {
			return false;
		} else {
			return true;
		}
	}
}
