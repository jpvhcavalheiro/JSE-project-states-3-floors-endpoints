package io.altar.services.stateMachine;

import java.util.ArrayList;
import java.util.Collection;

import javax.inject.Inject;
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

import io.altar.DTOs.ShelfDTO;
import io.altar.business.*;
import io.altar.models.Product;
import io.altar.models.Shelf;

import javax.ws.rs.Path;

@Path("/shelves")
public class ShelfServices {
	@Inject
	ShelfBusiness shelfBusiness;
	@Context
	private UriInfo context;

	@GET
	@Path("/eureka")
	@Produces(MediaType.TEXT_PLAIN)
	public String seeHealth() {
		return "Eureka! FUNCIONA!";
	}

	@POST
	@Path("/provisory")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public void provisoryCreateShelf(Shelf shelf) {
		shelfBusiness.provisoryAddNewShelf(shelf);
	}
	
	@PUT
	@Path("/provisory")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public void provisoryChangeShelf(Shelf shelfToChange){
		shelfBusiness.provisoryChangeShelf(shelfToChange);
	}
	
	@DELETE
	@Path("/provisory")
	@Consumes(MediaType.APPLICATION_JSON)
	public void removeShelf(Shelf shelfToRemove) {
		shelfBusiness.provisoryRemoveShelf(shelfToRemove);
	}
	
	@POST
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public ShelfDTO createShelf(Shelf shelf) {
		return shelfBusiness.addNewShelfToShelfRepository(shelf);
	}

	@GET
	@Path("/seeall")
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<ShelfDTO> seeAllShelves() {
		return shelfBusiness.getAllShelves();
	}

	@GET
	@Path("/seeshelfid/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public ShelfDTO seeASingleShelf(@PathParam("id") long id) {
		return shelfBusiness.getAShelf(id);
	}
	@PUT
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public ShelfDTO changeShelf(Shelf shelfToChange){
		return ShelfBusiness.changeShelf(shelfToChange);
	}

	@DELETE
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public void removeShelf(@PathParam("id") long id) {
		shelfBusiness.removeShelf(id);
	}
}
