package at.bals.taskservice.vo;

import javax.xml.bind.annotation.XmlRootElement;

//Die Vorlage einer Item für die Arraylist
@XmlRootElement
public class Item {
	private int id;
	private String name;
	private int quantity;
	

	public Item() {

	}

	public Item(int id, String name, int quantity) {
		super();
		this.id = id;
		this.name = name;
		this.quantity = quantity;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
}
