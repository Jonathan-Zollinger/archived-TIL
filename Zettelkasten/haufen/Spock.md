### Data Driven Tests
example:
```groovy
given: 
```


exceptions expectations only allowed in `then` blocks
Example from [Stack Overflow](https://stackoverflow.com/a/19187445/12253607)
```groovy
def 'validate valid user'() {
        when:
        validateUser(user)

        then:
        noExceptionThrown()

        where:
        user << [
                new User(userName: 'tester'),
                new User(userName: 'joe')]
    }

    def 'validate invalid user'() {
        when:
        validateUser(user)

        then:
        def error = thrown(expectedException)
        error.message == expectedMessage

        where:
        user                     || expectedException | expectedMessage
        new User(userName: null) || Exception         | 'no userName'
        new User(userName: '')   || Exception         | 'no userName'
        null                     || Exception         | 'no user'
    }

    private validateUser(User user) {
        if (!user) throw new Exception('no user')
        if (!user.userName) throw new Exception('no userName')
    }
```
## Blocks
![[Spock Testing.png]]

## Primers
```Java
def setup() {}          // run before every feature method
def cleanup() {}        // run after every feature method
def setupSpec() {}     // run before the first feature method
def cleanupSpec() {}   // run after the last feature method
```