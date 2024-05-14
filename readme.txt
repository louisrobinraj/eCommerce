Used tech stack 
	Java 17 
	Spring boot 3.2.5
	Database MySQL
	 

1. Internal user Store Product Data 

URL -> http://localhost:9090/api/ecom/internal/store-products
Method -> POST
Sample Request Body -> 
{
  
    "products": [
        {
          
            "category": "Laptop",
            "brand": "Apple"
        },
        {
          
            "category": "Mobile",
            "brand": "Apple"
        },
        {
          
            "category": "IPad",
            "brand": "Apple"
        },
        {
          
            "category": "Mobile",
            "brand": "Samsung"
        },
        {
          
            "category": "Laptop",
            "brand": "Dell"
        },
        {
          
            "category": "Mobile",
            "brand": "OnePlus"
        },
    ]
}

2. External user retrive Product Datas

URL -> http://localhost:9090/api/ecom/external/retrive-products?shopperID=4HMKU&category=Mobile&brand=Apple&limit=10
Method -> Get

