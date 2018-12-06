package io.altar.business;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import io.altar.models.*;
import io.altar.repository.*;
import io.altar.business.ShelfBusiness;

public class ShelfBusiness {
	public static ProductRepository productRepository1 = ProductRepository.getInstance();
	public static ShelfRepository shelfRepository1 = ShelfRepository.getInstance();

	public static Shelf addNewShelfToShelfRepository(Shelf shelfToAdd) {
		shelfRepository1.createEntity(shelfToAdd);
		if (shelfRepository1.fetchEntityById(shelfToAdd.getId()).getProductIdInShelf() != -1) {
			productRepository1
					.fetchEntityById(shelfRepository1.fetchEntityById(shelfToAdd.getId()).getProductIdInShelf())
					.getShelvesIdList().add(shelfToAdd.getId());
		}
		return shelfRepository1.fetchEntityById(shelfToAdd.getId());
	}

	public static Shelf getAShelf(long shelfIdToSearch) {
		return shelfRepository1.fetchEntityById(shelfIdToSearch);
	}

	public static void removeShelfFromProductId(long shelfIdToRemove) {
		if (shelfRepository1.fetchEntityById(shelfIdToRemove).getProductIdInShelf() != -1) {
			Product oldProduct=productRepository1.fetchEntityById(shelfRepository1.fetchEntityById(shelfIdToRemove).getProductIdInShelf());
			oldProduct.getShelvesIdList().remove(shelfIdToRemove);
			productRepository1.changeEntityById(oldProduct);
		}
		shelfRepository1.deleteEntityById(shelfIdToRemove);
	}

	public static Collection<Shelf> getAllShelves() {
		return shelfRepository1.showAll();
	}

	public static Shelf changeShelf(Shelf shelfToEdit) {
		Shelf oldShelf=shelfRepository1.fetchEntityById(shelfToEdit.getId());
		if(oldShelf.getProductIdInShelf()!=-1){
			Product oldProduct=productRepository1.fetchEntityById(oldShelf.getProductIdInShelf());
			oldProduct.getShelvesIdList().remove(oldShelf.getProductIdInShelf());
			productRepository1.changeEntityById(oldProduct);
		}
		if(shelfToEdit.getProductIdInShelf()!=-1){
			Product newProduct=productRepository1.fetchEntityById(shelfToEdit.getProductIdInShelf());
			newProduct.getShelvesIdList().add(shelfToEdit.getId());
			productRepository1.changeEntityById(newProduct);
		}
		shelfRepository1.changeEntityById(shelfToEdit);
		return shelfRepository1.fetchEntityById(shelfToEdit.getId());
	}

}
