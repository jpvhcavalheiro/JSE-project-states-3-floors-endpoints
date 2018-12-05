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
		shelfRepository1.deleteEntityById(shelfIdToRemove);
	}

	public static Collection<Shelf> getAllShelves() {
		return shelfRepository1.showAll();
	}

}
