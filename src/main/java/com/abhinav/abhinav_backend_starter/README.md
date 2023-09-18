# Sample API
```
GET
http://localhost:8080/products

GET
http://localhost:8080/products/12

POST
http://localhost:8080/products
{
    "title": "test product",
        "price": 13.5,
        "description": "lorem ipsum set",
        "image": "https://i.pravatar.cc",
        "category": "electronic"
}

POST/DELETE
{
    "id": 1,
        "title": "Fjallraven - Foldsack No. 1 Backpack, Fits 15 Laptops",
        "description": "Your perfect pack for everyday use and walks in the forest. Stash your laptop (up to 15 inches) in the padded sleeve, your everyday",
        "image": "https://fakestoreapi.com/img/81fPKd-2AYL._AC_SL1500_.jpg",
        "category": "men's clothing",
        "price": 109.95
}
