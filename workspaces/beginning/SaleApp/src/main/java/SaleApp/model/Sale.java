package SaleApp.model;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "sales")
public class Sale
{
	@Id
	private ObjectId id;
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
		this.id = new ObjectId(id);
	}

	public String getId()
	{
		return id.toHexString();
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
