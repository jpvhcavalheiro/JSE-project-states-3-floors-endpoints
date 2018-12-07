package io.altar.business;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import io.altar.models.*;
import io.altar.repository.*;

public class ProductBusiness {
	public static ProductRepository productRepository1 = ProductRepository.getInstance();
	public static ShelfRepository shelfRepository1 = ShelfRepository.getInstance();

	public static Product addNewProductToProductRepository(Product productToAdd) {
		productRepository1.createEntity(productToAdd);
		if (productToAdd.getShelvesIdList().size() > 0) {
			ArrayList <Long> newShelvesIdList=productToAdd.getShelvesIdList();
			ArrayList<Long> oldShelvesIdList=(ArrayList<Long>)newShelvesIdList.clone();
			for (long item : oldShelvesIdList) {
				if (shelfRepository1.fetchEntityById(item).getProductIdInShelf() == -1) {
					shelfRepository1.fetchEntityById(item).setProductIdInShelf(productToAdd.getId());
				} else {
					productRepository1.fetchEntityById(productToAdd.getId()).getShelvesIdList().remove(item);
				}
			}
		}

		return productRepository1.fetchEntityById(productToAdd.getId());
	}

	public static void removeProductFromProductId(long productId) {
		Product oldProduct = productRepository1.fetchEntityById(productId);
		if (oldProduct.getShelvesIdList().size() > 0) {
			for (long item : oldProduct.getShelvesIdList()) {
				shelfRepository1.fetchEntityById(item).setProductIdInShelf(-1);
			}
		}
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

	public static Collection<Product> getAllProducts() {
		return productRepository1.showAll();
	}

	public static boolean isThereThisProduct(long productIdToTest) {
		if (productRepository1.fetchEntityById(productIdToTest) == null) {
			return false;
		} else {
			return true;
		}
	}

	public static Product getAProduct(long productIdToSee) {
		return productRepository1.fetchEntityById(productIdToSee);
	}

	public static Product changeProduct(Product productToChange) {
		for (long item : productRepository1.fetchEntityById(productToChange.getId()).getShelvesIdList()) {
			shelfRepository1.fetchEntityById(item).setProductIdInShelf(-1);
		}
		for (long item : productToChange.getShelvesIdList()) {
			shelfRepository1.fetchEntityById(item).setProductIdInShelf(productToChange.getId());
		}
		productRepository1.changeEntityById(productToChange);
		return productRepository1.fetchEntityById(productToChange.getId());
	}
}
