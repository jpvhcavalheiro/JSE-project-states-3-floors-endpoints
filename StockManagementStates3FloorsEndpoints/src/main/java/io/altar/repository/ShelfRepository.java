package io.altar.repository;
import java.util.List;

import javax.persistence.TypedQuery;

import io.altar.models.Shelf;

public class ShelfRepository extends EntityRepository<Shelf> {
	
	@Override
	protected Class<Shelf> getEntityClass() {
		return Shelf.class;
	}
	
	@Override
	protected String getAllEntityQueryName() {
		return Shelf.GET_ALL_SHELVES_QUERY_NAME;
	}

	
	
}
