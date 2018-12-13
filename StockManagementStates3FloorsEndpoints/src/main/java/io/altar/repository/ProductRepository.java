package io.altar.repository;
import io.altar.models.Product;

public class ProductRepository extends EntityRepository<Product> {
	@Override
	protected Class<Product> getEntityClass() {
		return Product.class;
	}
	
	@Override
	protected String getAllEntityQueryName() {
		return Product.GET_ALL_PRODUCTS_QUERY_NAME;
	}
	

}
