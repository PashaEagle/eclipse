package main;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "sales")
public class Sale
{
	@Id
	private ObjectId id;
	private String price;
	private String isOnSale;

	public Sale()
	{
	}

	public Sale(String price, String isOnSale)
	{
		this.price = price;
		this.isOnSale = isOnSale;
	}

	public void setId(ObjectId id)
	{
		this.id = id;
	}

	public String getId()
	{
		return id.toHexString();
	}

	public void setPrice(String price)
	{
		this.price = price;
	}

	public String getPrice()
	{
		return price;
	}

	public void setIsOnSale(String bb)
	{
		this.isOnSale = bb;
	}

	public String getIsOnSale()
	{
		return isOnSale;
	}

}
