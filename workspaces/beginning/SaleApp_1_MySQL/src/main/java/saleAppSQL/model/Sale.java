package saleAppSQL.model;

import javax.persistence.Entity;

//import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
//import org.springframework.data.mongodb.core.mapping.Document;

//@Document(collection = "sales")
@Entity
public class Sale
{
	@Id
	private String Id;
	private String name;
	private String price;

	public Sale()
	{
	}

	public Sale(String name, String price)
	{
		this.name = name;
		this.price = price;
	}

	public void setId(String id)
	{
		Id = new String(id);
	}

	public String getId()
	{
		return Id;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getName()
	{
		return name;
	}

	public void setPrice(String price)
	{
		this.price = price;
	}

	public String getPrice()
	{
		return price;
	}
}
