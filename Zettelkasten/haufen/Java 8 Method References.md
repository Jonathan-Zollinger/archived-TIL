Method References
- Lambda expressions help in making your code more concise (fewer keystrokes). 
- Method references, can, in certain situations, help in making your lambda expressions even more concise. 
- If all your lambda expression does is call one method, then that is an opportunity to use a method reference. 
- If a lambda parameter is simply passed to another method, then the redundancy of specifying the variable twice can be removed.

```java
List<String> names = Arrays.asList ("Sean", "Mary", " John");
names.forEach(name -> System.out.println(name)); // lambda
names.forEach(System.out::println); // method reference
```

4 Types of references: 
-  Bound – instance known at compile-time
-  Unbound – instance provided at runtime
-  Static
-  Constructor