**Hookah-Internet-Shop** 
=====================

***1. Project goal***
-----------------------------------
The goal of the project is to create a template for an online store, to recreate its main functionality using springboot framework
 
***2. Project structure:***
-----------------------------------
* all sources are in the "com.kpi.internetshop" package
* all controllers are responsible for handling requests are in the package "controller"
* the "repository" package contains the classes responsible for the implementation of interaction with the database and interfaces that describe their work
* the "annotation" package contains custom annotations and classes for implementation the logic of validation
* the "entity" package is responsible for recreating and describing entities whose data is stored in the database
* the "security" package contains authentication implementation and started data injection
* the "service" package contains the main business logic of the application including classes with implementation of the main methods and interfaces that describe classes' work
* the "resources" folder contains static (for storing images) and templates (for representation user-friendly interface in the form of html pages) folders and file for configuring database connection named "application.properties"
* the "config" folder contains authorization and authentication setup

***3. Implementation details:***
-----------------------------------
The project implements:
* authorization
* authentication,
* hashing passwords using,
* dividing user roles into buyers and administrators 
* corresponding functionality for each role
* As a database was used MySQL
* Driver to connect to database - com.mysql.cj.jdbc.Driver 
* The protocol for transferring data between the client and the server are http
* The code was organized in such a way as to comply with the SOLID principles
* For the implementation of Dependency Inversion, I used SpringBoot framework
* For convenient display of information on the client side, I use html pages and template engine thymeleaf were used 
 to display dynamic data in it.

***4. Launch guide:***
-----------------------------------
* Clone this project 
* Install and configure MySQL(or another rdbms) 
* Fix the information about connection to database in "application.properties" file
* After running the project you can try admin functions. Use login: "admin@gmail.com" and password: "1" and user functions. Use login: "ann@gmail.com" and password: "1". 

***5. Functionality:***
-----------------------------------
general capabilities:
* registration ("/registration")
* watching all products' plethora("/")
* logout from the system ("/logout")
* login ("/login")

user capabilities:
* watching the list of his selected products ("/cart/show") 
* adding product to the shopping cart ("/cart/add/{id}")
* deleting selected product from the cart ("/cart/delete/{id}")
* update amount of product in cart ("/cart/update/{id}" and to save data ""/cart/save)
* clean the cart ("/cart/clean")
* complete an order ("/order/complete")
* watching the list of user's own list of orders ("/orders/show")
* watching details of user`s order ("/user/orders/details/{id}")

admin capabilities:
* watching all products("/products")
* watching all users list ("/users")
* adding new product to the product-list ("/products/add" and to save data "/save")
* update product position ("/products/update/{id}" and to save data "/save")
* delete product position totally ("/products/delete/{id}")
* deleting users ("/users/delete/{id}")
* watching the list of all users' orders ("/orders")
* deleting orders from the previous list ("/orders/delete/{id}")
* watching details of order ("/orders/details/{id}")

***6. Author:***
-----------------------------------
[Maryna Voloshyna](https://github.com/voloshynamaryna11)