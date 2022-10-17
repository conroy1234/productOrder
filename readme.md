there are six products id inserted into the product table which can be found in schema.sql
the productIds are as follows (DF10, DF11, DF12, DF13, DF14, DF15). this can be found also in data.sql

the api url are as follows
order can be created using any of the above product id above. example

http://localhost:8081/fictional/organisation/order/DF14
once the order is placed we can see the now new created order in the in memory h2 database using the following link.

http://localhost:8081/h2
to log in you will need to pass the following.

Driver Class: org.h2.Driver
JDBC URL: jdbc:h2:mem:productdb
User Name: sa
Password: 