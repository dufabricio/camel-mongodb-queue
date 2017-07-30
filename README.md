**Using Camel MongoDB Component**

https://github.com/apache/camel/blob/master/components/camel-mongodb3/src/main/docs/mongodb3-component.adoc

https://blog.serverdensity.com/replacing-rabbitmq-with-mongodb/

**Requirements**

Step 1 - Start a mongod on localhost:27017 

````
mondod
````


Step 2 - Create a capped collection for events:

````
db.createCollection("messages", { capped : true, size : 5242880, max : 5000 } )
````


**Sender**

Running : on ./sender folder execute:

````
mvn spring-boot:run
````

You can send messages to localhost:38080/sender with body json e.g. {"message":"Text messae for Event"}

It will saved to mongodb messages collection.

**Receiver**

Running : on ./receiver folder execute:

````
mvn spring-boot:run
````

On startup camel will create a taiable cursor for collection message consuming all pending messages and record ir on H2

http://localhost:38081/h2console

````
SELECT * FROM MESSAGE_RECEIVED 
````
