### Vanilla JPA vs Vanilla JDBC
The JDBC is a barebones connection to a database. JPA is an abstraction of JDBC. JPA is one flavor of an [ORM](https://en.wikipedia.org/wiki/List_of_object%E2%80%93relational_mapping_software#Java), where [OOP and data access mix idealogy](https://www.baeldung.com/jpa-vs-jdbc). JDBC requires the developer to be more involved in writing sql scripts. 
##### JPA one to many example
 ```Java
@Entity
@Table(name = "employee")
public class Employee implements Serializable {
    @OneToMany(mappedBy = "employee", fetch = FetchType.EAGER)
    @OrderBy("firstName asc")
    private Set communications;
}
```

#### JDBC vanilla example
```java
import java.sql.*;

public class FirstExample {
   static final String DB_URL = "jdbc:mysql://localhost/TUTORIALSPOINT";
   static final String USER = "guest";
   static final String PASS = "guest123";
   static final String QUERY = "SELECT id, first, last, age FROM Employees";

   public static void main(String[] args) {
      // Open a connection
      try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
         Statement stmt = conn.createStatement();
         ResultSet rs = stmt.executeQuery(QUERY);) {
         // Extract data from result set
         while (rs.next()) {
            // Retrieve by column name
            System.out.print("ID: " + rs.getInt("id"));
            System.out.print(", Age: " + rs.getInt("age"));
            System.out.print(", First: " + rs.getString("first"));
            System.out.println(", Last: " + rs.getString("last"));
         }
      } catch (SQLException e) {
         e.printStackTrace();
      } 
   }
}
```

#### Performance
> The difference between JPA and JDBC is essentially who does the coding: the JPA framework or a local developer. Either way, we’ll have to deal with the [object-relation impedance mismatch](https://en.wikipedia.org/wiki/Object%E2%80%93relational_impedance_mismatch).<br><br>To be fair, when we write SQL queries incorrectly, JDBC performance can be abysmally sluggish. When deciding between the two technologies, performance shouldn’t be a point of dispute. Professional developers are more than capable of producing Java applications that run equally well regardless of the technology utilized.


###### Reference: 
- [Guide using JDBC](https://guides.micronaut.io/latest/micronaut-data-jdbc-repository-maven-java.html)
- [Guide using JPA](https://guides.micronaut.io/latest/micronaut-jpa-hibernate-maven-java.html) <-- cool example of configuring db access w/ variables
