# Shopping Cart demo for Test purpose 

## Stack of technologies
	## Back End
		-Spring Boot
		-Maven 	
		-Java
	##UI Layer
		-Express JS
		-Angular JS
		-Node JS
	DB - NoSQL
		-Mongo DB (Cloud Mongo DB is connected - it canbe changed in property file.)

## Local Setup steps

## UI Layer

Make sure you have [Node.js](http://nodejs.org/) installed.


$ git clone or download
$ cd santhosh-shoppingcar-demo
$ npm install
$ npm start


Shooping cart should be running on port 4000

## Back End

$ cd spring-boot-backend
$ mvn clean
$ mvn package
$ java -jar target/ShoppingCart-0.0.1-SNAPSHOT.jar

or

$ mvn spring-boot:run

Make sure Back end is started first.

