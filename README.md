# Test Driven Development Like a Hero

Software development approach that you create test cases to validate actual code.

> [tr] TDD, kodun doğruluğunu teyit etmek için test case'lerinin yazıldığı yazılım geliştirme yaklaşımıdır.

### 3 Laws of TDD

- Don't write production code without failing tests.
- Write only enough test code as is sufficient enough to fail tests.
- Implement minimum code to make test fail. (Step-by-step)

### Advantages of TDD

- Modular and Testable code
- Easy to maintain
- Smooth refactoring
- Eliminate Debugging
- Tests are the documentation of code

### Disadvantages of TDD

- Slows down development process (in the beginning)
- TDD approach is hard to learn (in the beginning)
- Hard to maintain especially within strict deadlines
- All the team members should use it

## Unit Testing

Testing individual modules in isolation without dependencies to confirm code works.

## Integration Testing

Checking multiple modules toherher to see they work correctly.
<pre>
                                  /\                          |    Slower -> Faster
                                 /  \                         |    Less Isolation -> More Isolation
                                /    \                        |    Expensive -> Cheap
                               /      \                       |
                              /   e2e  \                      |
                             /__________\                     |
                            /            \                    |
                           /              \                   |
                          / Integragration \                  |
                         /__________________\                 |
                        /                    \                |
                       /      Unit Test       \               V
                      /________________________\
</pre>
## JUnit

Unit testing framework in Java world that empowers TDD.

## Mockito

Mockito is to isolate the behaviour of dependency and focus on the part that being tested.

Mockito is mocking library in Java.

## Argument Capture

It allows us to capture the argument passed to a method which we don't have direct access.
