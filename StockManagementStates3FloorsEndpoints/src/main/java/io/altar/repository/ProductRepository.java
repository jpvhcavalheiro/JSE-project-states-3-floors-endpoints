package io.altar.repository;
import io.altar.models.Product;

public class ProductRepository extends EntityRepository<Product> {
	@Override
	protected Class<Product> getEntityClass() {
		return Product.class;
	}
	

}
