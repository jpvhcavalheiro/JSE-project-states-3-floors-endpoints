package io.altar.models;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

@Entity
public class Product extends BaseEntity{
	private static final long serialVersionUID=1L;
	
	@OneToMany(fetch=FetchType.LAZY,mappedBy="productInShelf")
	private List <Shelf> shelvesList=new ArrayList();
	private int discount;
	private int iva;
	private double pvp;
	public Product(){}
	public Product(ArrayList<Long> shelvesIdList, int discount, int iva, double pvp) {
		super();
		this.shelvesList = shelvesList;
		this.discount = discount;
		this.iva = iva;
		this.pvp = pvp;
	}
	/**
	 * addNewShelfToShelvesList receives an id of a shelf where the product will be inserted and insert it
	 * to the list of shelves which contain this product
	 * @param newShelfId the id of a new shelf which will contain this product
	 */
	//esta funcao esta errada
	//em nenhuma parte do codigo se inicializa o shelfidlist como estando vazio
	public void addNewShelfToShelvesList(Shelf newShelf) {
		shelvesList.add(newShelf);
	}
	
	public List<Shelf> getShelvesList() {
		return shelvesList;
	}
	
	public void setShelvesList(ArrayList<Shelf> shelvesList) {
		this.shelvesList = shelvesList;
	}
	public int getDiscount() {
		return discount;
	}
	public void setDiscount(int discount) {
		this.discount = discount;
	}
	public int getIva() {
		return iva;
	}
	public void setIva(int iva) {
		this.iva = iva;
	}
	public double getPvp() {
		return pvp;
	}
	public void setPvp(double pvp) {
		this.pvp = pvp;
	}
	@Override
	public String toString() {
		return "Product"+getId()+" [shelvesList=" + shelvesList + ", discount=" + discount + ", iva=" + iva + ", pvp=" + pvp + "]";
	}
	public void removeShelfFromList(Shelf shelfToRemove){
		this.shelvesList.remove(shelfToRemove);
	}
}
