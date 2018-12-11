package io.altar.repository;
import io.altar.models.Product;

public class ProductRepository extends EntityRepository<Product> {
	private final static ProductRepository INSTANCE = new ProductRepository();

	public static ProductRepository getInstance() {
		return INSTANCE;
	}

	public ProductRepository() {
	}
}
