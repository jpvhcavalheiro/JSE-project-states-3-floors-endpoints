package io.altar.services.stateMachine;

import java.util.Collection;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

import io.altar.business.*;
import io.altar.models.Product;
import io.altar.models.Shelf;

import javax.ws.rs.Path;

@Path("/shelves")
public class ShelfServices {
	@Context
	private UriInfo context;

	@GET
	@Path("/eureka")
	@Produces(MediaType.TEXT_PLAIN)
	public String seeHealth() {
		return "Eureka! FUNCIONA!";
	}

	@POST
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Shelf createShelf(Shelf shelf) {
		return ShelfBusiness.addNewShelfToShelfRepository(shelf);
	}

	@GET
	@Path("/seeall")
	@Produces(MediaType.APPLICATION_JSON)
	public Collection<Shelf> seeAllShelves() {
		return ShelfBusiness.getAllShelves();
	}

	@GET
	@Path("/seeshelfid/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Shelf seeASingleShelf(@PathParam("id") long id) {
		return ShelfBusiness.getAShelf(id);
	}

	@DELETE
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public void removeShelf(@PathParam("id") long id) {
		ShelfBusiness.removeShelfFromProductId(id);
	}
}
