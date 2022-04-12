# Parsing JSON with GSON

Using GSON to Parson JSON Returned from a Web API

## Information

This is a rewrite of the program [Concepts of Accessing and Parsing Web API Data](https://github.com/profjmc3/Concepts-of-Accessing-and-Parsing-Web-API-Data) that uses a new version of the Glitch end-point that returns JSON and parses that data with Google's GSON.

This program includes two copies of the Assignment class. The one version stores the date in Unix Epoch Time as a long. The other version stores the date as a GregorianCalendar instance (Assignment_GCDate.java).

When using GSON to parse a class that uses all primitive data we don't have to do a lot of work. You can see that the data maps with no additional work in the default example shown in the Driver.java file.

When we use GSON to parse JSON to create classes with more complex data types we need to write a custom deserializer. In most cases I would suggest modifying your class to better represent the data returned by the JSON. I would suggest that you avoid writing custom deserializer classes at this point. You can see this code by renaming the Assignment_GCDate.java file to Assignment.java and commenting/uncommenting code as indicated in the driver.

This project includes the GSON library.
