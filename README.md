# 9th Homework of Java Test Automation Course - Solvd Laba
This repository stores the 9th homework given by our mentor in the Java Test 
Automation Course at Solvd Laba. It consists of implementing some functional 
interfaces, that the java.util.function package gives us, with lambda functions.
Moreover, we had to create three functional interfaces with generics, and 
finally create five complex enums, with methods, fields and constructors.

## Explanation

To accomplish the requirements of the homework, I've changed the lines 97 and
103 from the Main class, which were using the enhanced for loop, now those
lists are being iterated with the forEach method, passing as argument a lambda
function that implements the Consumer functional interface. Moreover, almost
at the end of the main method, I've implemented the Predicate, Function, Supplier
and UnaryOperator functional interfaces with lambdas, using the Stream API in
some cases. Finally, I've created three custom functional interfaces  with
generics to implement them at the end of the main method (notice that they
are in the functional_interface package) and also I've created enums with fields,
methods and constructors (in the enums package).

## What did I learn?

It was a rewarding homework, since I've learnt how the lambda expressions
work and the useful they are to save lines of code. Also, I've known the
most used functional interfaces that Java provides us as Predicate, UnaryOperator,
Function or Consumer. Although I already had simple knowledge about enums, this
time I've noticed that they can have methods and constructors. In other words,
they are like regular classes with the difference that the instances are 
pre-declared in the beginning of the enum declaration. 

## Technologies

- Java
- Maven

## Set-Up

To run this project you will need an updated version of Java.
First, clone this repository in a folder of your PC.
You have to put the following command in a terminal:

```bash
  git clone this-repo-url
```
You will need an IDE to open the project folder and, finally, run the 
Main.java file to see the program output.

## Author

- [@Nazareno Bucciarelli](https://github.com/nazabucciarelli)
