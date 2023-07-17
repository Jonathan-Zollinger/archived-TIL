<i> Created: 2023-05-17 14:53 </i>

### Examples

##### Problematic Code
```java
BufferedReader reader;
try {
	reader = new BufferedReader(new FileReader(myFileToRead));
} catch (FileNotFoundException e) {
    // Exception handling
}

try {
	while ((line = reader.readLine()) != null) {
	    System.out.println(line);
	}
} catch (IOException e) {
    // Exception handling
}
```

The above code has potential to leave the file open and is less readable than the proper code, below.

##### Proper Code
```Java
try (BufferedReader reader = new BufferedReader(new FileReader("file.txt"))) {
    // Code to read from the file using the BufferedReader
    while ((line = reader.readLine()) != null) {
        System.out.println(line);
    }
} catch (IOException e) {
    // Exception handling
}
```

##### Further Explanation
In this example, the `BufferedReader` is initialized inside the parentheses of the try statement. When the try block is exited, either normally or due to an exception, the `BufferedReader` will be automatically closed. This ensures that the resources are properly released, even if an exception occurs.

You can perform any operations that require the `BufferedReader` within the try block. In this case, we are reading lines from a file and printing them to the console. If an `IOException` occurs while reading the file, the catch block will handle the exception.

Note that in this example, we're using the `FileReader` class to create a `BufferedReader`. Make sure to adjust the code according to your specific needs, such as using a different input stream or specifying a different file path.

Using try-with-resources simplifies the code by eliminating the need for explicit resource cleanup and ensures that resources are properly closed, even in the presence of exceptions.

### References
1. 