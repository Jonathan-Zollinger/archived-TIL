#### Testing
- [custom place pojo in httpclient](https://github.com/aruld/maps-app/blob/db4f958c454984a2bd67e7cbfa37b15f969b3411/maps-service/src/main/java/maps/service/GeoClient.java#L8) <-- has some tests, may not apply
- [test containers with h2 db](https://guides.micronaut.io/latest/replace-h2-with-real-database-for-testing-maven-java.html)
- [spock tests example](https://guides.micronaut.io/latest/micronaut-mqtt-maven-groovy.html#add-test)
	- [my spock notes](Spock.md)
- [maven java guide](https://guides.micronaut.io/latest/micronaut-http-client-maven-java.html)
- [default supported test containers](https://micronaut-projects.github.io/micronaut-test-resources/snapshot/guide/#modules-databases): 

| Database                                                     | JDBC | R2DBC | Database identifier | Default image                                              |
| ------------------------------------------------------------ | ---- | ----- | ------------------- | ---------------------------------------------------------- |
| [MariaDB](https://mariadb.org/)                              | Yes  | Yes   | mariadb             | mariadb                                                    |
| [MySQL](https://www.mysql.com/)                              | Yes  | Yes   | mysql               | mysql                                                      |
| [Oracle Database](https://www.oracle.com/database/)          | Yes  | Yes   | oracle              | gvenzl/oracle-xe:slim-faststart                            |
| [PostgreSQL](https://www.postgresql.org/)                    | Yes  | Yes   | postgres            | postgres                                                   |
| [Microsoft SQL Server](https://www.microsoft.com/sql-server) | Yes  | Yes   | mssql               | mcr.microsoft.com/mssql/server:2019-CU16-GDR1-ubuntu-20.04 |

- [test-resources](https://micronaut-projects.github.io/micronaut-gradle-plugin/latest/#test-resources) plugin will automatically spin up a db container based on the datasources property

- Calling `@MicronautTest` configures [Micronaut to use the test environment](https://docs.micronaut.io/latest/guide/index.html#environments) ||| *[clarifying blog post](https://blog.wick.technology/micronaut-test-configuration/#:~:text=To%20do%20this%20in%20Micronaut%2C%20use%20environment-specific%20property,for%20your%20test%2C%20not%20the%20entire%20main%20config.)* |||

#### HttpClient
[Query Parameters](https://docs.micronaut.io/latest/guide/#binding)

#### Micronaut Data
- [Testing micronaut data repo and controller](https://youtu.be/FbrsGfBx_XM?si=JkYOnHzHuR2WDsMa&t=855)
- [Micronaut guide: Read Values with Object Mapper](https://micronaut-projects.github.io/micronaut-serialization/snapshot/guide/#jacksonQuick)
- [Adding seed data w/ sql (from Micronaut guide)](https://guides.micronaut.io/latest/replace-h2-with-real-database-for-testing-maven-java.html#seed-data)
- [Graem's overview (youtube clip from `goto` summit 2023)](https://youtu.be/JWIUPMMq9Fc?si=M1b0ysHAZ4ywkJIh&t=1105)
- [Micronaut guide on using TestContainers](https://guides.micronaut.io/latest/replace-h2-with-real-database-for-testing-maven-java.html#testing-using-testcontainers)
- [Micronaut Docs on additive queries](https://micronaut-projects.github.io/micronaut-data/1.0.x/guide/#dataUpdates)
- [Micronaut guide micronaut data w/ java records](https://guides.micronaut.io/latest/micronaut-java-records-maven-java.html)
###### Example Repos
- [kokuwaio](https://github.com/kokuwaio/micronaut-openapi-codegen/blob/c2fa118155b085a62ff86216717fc3632eba52bf/gen/main/java/testmodel/micronaut_pojo/PropertyTypeOne.java#L4)
- [oracle](https://github.com/oracle-samples/oracle-db-examples/blob/3f77208c0d53da22f8c60418a623c53e19cce2b1/java/micronaut-jsonview-demo-app/src/main/java/com/example/micronaut/dto/CreateStudentDto.java#L10)
##### Varying Flavors:
[4 different flavors:](https://micronaut-projects.github.io/micronaut-data/latest/guide/#sql)
    JPA (Hibernate) and Hibernate Reactive
    SQL (JDBC, R2DBC)
    MongoDB
    Azure Cosmos
[Shared concepts between flavors:](https://micronaut-projects.github.io/micronaut-data/latest/guide/#shared)
	- [Repositories](https://micronaut-projects.github.io/micronaut-data/latest/guide/#repositories) - use existing or create a custom repository
	- [Querying](https://micronaut-projects.github.io/micronaut-data/latest/guide/#querying) - define a repository method to access your data
	- [Data access](https://micronaut-projects.github.io/micronaut-data/latest/guide/#dataUpdates) - data access operations
	- [Transactions](https://micronaut-projects.github.io/micronaut-data/latest/guide/#transactions) - transactional access support
	

#### Properties Interpolation
[See section "Demo: Api Alternatives"](https://app.pluralsight.com/channels/player?courseId=6e7310de-1337-4a76-aa3b-1618d9a133d7&moduleId=f8c0fe29-eb6e-41b4-a242-c770a020c9e9&channelId=a1ace3d2-81cb-44bc-96f2-a99658eea442)

##### Resource Loader:
- [load resources example repo](https://github.com/ghillert/resource-readable-demo)
- [sister blog post](https://hillert.com/blog/from-resource-to-readable/)
- [source stack overflow discussion](https://stackoverflow.com/questions/53370135/is-there-an-equivalent-for-springs-resource-in-micronaut)
> Note: path is different from `src` path - calling `Files.isReadable(path)` will differ from ResourceLoader.getResourceasStream(path)'s success. 
	for example, `String path="src/test/groovy/resources/example/response/pdp_client.json"` doesn't fail with `Files.isReadable(path)`, fails to work with the resource loader. changing path to `"example/response/pdp_client.json"` lets resource loader work and Files.isReadable() check to fail.

Resource Resolver:
	[mn guide](https://docs.micronaut.io/latest/guide/#resources)
	

Logging: 
	Set logging with properties
```yml
---
logger:
	levels:
		foo.bar: TRACE
```
	or Set custom logging config file
```yaml
logger
	config: /foo/log4j2.xml
```
	where an example config file could look like:

```xml
<?xml version="1.0" encoding="UTF-8"?>  
<Configuration status="TRACE">  
    <Appenders>  
        <Console name="LogToConsole" target="SYSTEM_OUT">  
            <PatternLayout pattern="%d{HH:mm:ss.SSS} [%t] %-5level %logger{36} - %msg%n"/>  
        </Console>  
    </Appenders>  
    <Loggers>  
        <logger name="io.micronaut.http.client" level="TRACE"/>  
        <Logger name="com.github.graqr.threshr" level="debug" additivity="false">  
            <AppenderRef ref="LogToConsole"/>  
        </Logger>  
        <Root level="error">  
            <AppenderRef ref="LogToConsole"/>  
        </Root>  
    </Loggers>  
</Configuration>
```


Questions:
- Do I need to employ the @MappedEntity Annotation with Micronaut data?
	No, it's just one option to map data. https://youtu.be/FbrsGfBx_XM?si=iviO24wPPK5LaG3K&t=1552

properties:
	good resource: https://blog.mrhaki.com/2018/08/micronaut-mastery-using-specific.html
	https://wangler.io/dealing-with-configuration-list-in-micronaut/
	