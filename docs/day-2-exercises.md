# Day 2 Exercises

In these exercises, we'll be implementing some maths and geometry functionality
using classes.

## Exercise 1: Static methods and properties

Let's make our own set of utility methods and properties, called `Maths`. A
skeleton file and class is provided in [Maths.java](../src/main/java/com/corndel/exercises/Maths.java)

Read the docs about
[static members](https://tech-docs.corndel.com/java/static-members.html).

To run the tests for this exercise, run `./mvnw clean test -Dtest=D2E1Tests` in your terminal.

- [ ] Add a static property `PI` to `Maths`. The value of `Maths.PI` should be
      the `double` `3.14`.

- [ ] Add the static method `Maths.max(a, b)`, which returns the largest of `a`
      and `b`.

## Exercise 2: Inheritance

To continue on with our theme with maths, we've written a `Rectangle` and a
`Square` class.

If you have a quick look through the files, you'll spot that the `Rectangle` and
`Square` classes look (and are conceptually) _very_ similar - a sign that we can
do some refactoring.

Let's start off by reading the documentation on
[Inheritance](https://tech-docs.corndel.com/java/inheritance.html)

Since a `Square` is a special type of `Rectangle`, let's make `Square` _inherit
from_ `Rectangle`.

- [ ] Use the `extends` keyword in the class definition to make `Square` a
      subclass of `Rectangle`

- [ ] We also need to call `super` in the constructor of `Square` to call the
      constructor of `Rectangle` and set the `width` and `height` properties.

- [ ] Are there any functions we can remove from `Square` that are already
      defined in `Rectangle`?

- [ ] Do we need `#side` anymore if we're using `#width` and `#height`?

## Exercise 3: Interfaces

Thinking about shapes more generally, every shape has a similar set of properties - e.g. area and perimeter - but the way you work them out can be different.

I.e. Finding the area for a square and a rectangle may be similar enough, but what about a triangle? Or a circle?

We have another set of shape classes and a shape interface:

- The interface [Shape](../src/main/java/com/corndel/exercises/Shape.java)
- The shapes [RightTriangle](../src/main/java/com/corndel/exercises/RightTriangle.java), [Circle](../src/main/java/com/corndel/exercises/Circle.java), and [Rectangle](../src/main/java/com/corndel/exercises/Rectangle.java)
  `Shape` that has placeholder methods `area` and `perimeter`.

Read the documentation on
[Method overriding](https://tech-docs.corndel.com/java/interfaces.html)

To run the tests for this exercise, run `./mvnw clean test -Dtest=D2E3Tests` in your terminal.

- [ ] Make all the shape classes implement the `Shape` interface.

- [ ] Write the `getArea` and `getPerimeter` methods in each class to return the correct values for that shape.
