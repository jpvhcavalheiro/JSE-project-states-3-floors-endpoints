package io.altar.services.stateMachine;

import java.util.Collection;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

import io.altar.business.Business;
import io.altar.models.Product;
@Path("/products")
public class ProductServices {

	@Context
	private UriInfo context;
	
	@GET
	@Path("/eureka")
	@Produces(MediaType.TEXT_PLAIN)
	public String seeHealth(){
		return "Eureka! FUNCIONA!";
	}
	
	
	@POST
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Product createProduct(Product product){
	return Business.addNewProductToProductRepository(product);
	}
	@GET
	@Path("/seeall")
	@Produces(MediaType.APPLICATION_JSON)
	public  Collection<Product> seeAllProducts(){
		return Business.getAllProducts();
	}
	
	
	
	@DELETE
	@Path("/")
	@Consumes(MediaType.TEXT_PLAIN)
	public void removeProduct(long productId){
		Business.removeProductFromProductId(productId);
	}

}
