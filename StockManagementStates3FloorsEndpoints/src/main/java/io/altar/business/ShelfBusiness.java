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
		if (shelfRepository1.fetchEntityById(shelfToAdd.getId()).getProductInShelf() != null) {
			productRepository1
					.fetchEntityById(shelfToAdd.getProductInShelf().getId())
					.getShelvesList().add(shelfToAdd);
		}
		return shelfRepository1.fetchEntityById(shelfToAdd.getId());
	}

	public static Shelf getAShelf(long shelfIdToSearch) {
		return shelfRepository1.fetchEntityById(shelfIdToSearch);
	}

	public static void removeShelf(long shelfIdToRemove) {
		if (shelfRepository1.fetchEntityById(shelfIdToRemove).getProductInShelf() != null) {
			Product oldProduct=shelfRepository1.fetchEntityById(shelfIdToRemove).getProductInShelf();
			oldProduct.getShelvesList().remove(shelfIdToRemove);
			productRepository1.changeEntityById(oldProduct);
		}
		shelfRepository1.deleteEntityById(shelfIdToRemove);
	}

	public static Collection<Shelf> getAllShelves() {
		return shelfRepository1.showAll();
	}

	public static Shelf changeShelf(Shelf shelfToEdit) {
		Shelf oldShelf=shelfRepository1.fetchEntityById(shelfToEdit.getId());
		if(oldShelf.getProductInShelf()!=null){
			Product oldProduct=productRepository1.fetchEntityById(oldShelf.getProductInShelf().getId());
			oldProduct.getShelvesList().remove(oldShelf);
			productRepository1.changeEntityById(oldProduct);
		}
		if(shelfToEdit.getProductInShelf()!=null){
			Product newProduct=productRepository1.fetchEntityById(shelfToEdit.getProductInShelf().getId());
			newProduct.getShelvesList().add(shelfToEdit);
			productRepository1.changeEntityById(newProduct);
		}
		shelfRepository1.changeEntityById(shelfToEdit);
		return shelfRepository1.fetchEntityById(shelfToEdit.getId());
	}

}
