**Using Camel MongoDB Component**

https://github.com/apache/camel/blob/master/components/camel-mongodb3/src/main/docs/mongodb3-component.adoc


Step 1 - Start a mongod on localhost:27017 

````
mondod
````


Step 2 - Create a capped collection for events:

````
db.createCollection("messages", { capped : true, size : 5242880, max : 5000 } )
````