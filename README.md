# 6th Homework of Java Test Automation Course - Solvd Laba
This repository stores the 6th homework given by our mentor in the Java Test 
Automation Course at Solvd Laba. It consists in a modification of the last 
homework (5th), but using the Collections framework from Java and with a
custom Double Linked List created by me.

## Explanation

To accomplish the requirements of the homework, I've replaced the use of regular
arrays by ArrayLists. It was necessary to refactor some classes in order to
make the code compile. I've used ArrayLists because they are faster regarding
storing and accessing data, comparing with the LinkedLists that are used to
manipulate data. Finally, I've made a custom class that represents the basic
behavior of a Generic Doubly Linked List. It is in the util package, with its class 
CustomNode that represents a Node from the LinkedList which has a pointer to the
next and previous node, and contains the element itself.

## Technologies

- Java
- Log4j2

## Set-Up

To run this project you will need an updated version of Java.
First, clone this repository in a folder of your PC.
You have to put the following command in a terminal:

```bash
  git clone this-repo-url
```
You will need an IDE to open the project folder and, finally, run the Main.java 
file to see the program output.

## Author

- [@Nazareno Bucciarelli](https://github.com/nazabucciarelli)
