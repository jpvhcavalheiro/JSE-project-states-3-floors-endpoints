package io.altar.services.stateMachine;

import java.util.Collection;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

import io.altar.business.*;
import io.altar.models.Product;
@Path("/products")
public class ProductServices {

	@Context
	private UriInfo context;
	
	@GET
	@Path("/eureka")
	@Produces(MediaType.TEXT_PLAIN)
	public String seeHealth(){
		return "Eureka!ola  FUNCIONA!";
	}
	
	
	@POST
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Product createProduct(Product product){
	return ProductBusiness.addNewProductToProductRepository(product);
	}
	@GET
	@Path("/seeall")
	@Produces(MediaType.APPLICATION_JSON)
	public  Collection<Product> seeAllProducts(){
		return ProductBusiness.getAllProducts();
	}
	
	@GET
	@Path("/seeproductid/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Product seeASingleProduct(@PathParam("id") long id){
		return ProductBusiness.getAProduct(id);
	}
	
	@GET
	@Path("/joao")
	@Produces(MediaType.TEXT_PLAIN)
	public String joao(){
		return "Joao campeone";
	}
	
	
	
	@DELETE
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public void removeProduct(@PathParam("id") long id){
		ProductBusiness.removeProductFromProductId(id);
	}
	@PUT
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON)
	public Product changeProduct(Product productToChange){
		return ProductBusiness.changeProduct(productToChange);
	}

}
