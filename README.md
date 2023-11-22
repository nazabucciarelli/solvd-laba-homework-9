# 8th Homework of Java Test Automation Course - Solvd Laba
This repository stores the 8th homework given by our mentor in the Java Test 
Automation Course at Solvd Laba. It consists in a basic algorithm about 
detecting the number of unique words from a file and write the result in 
another file using StringUtils and FileUtils in order to use fewer lines of
code.

## Explanation

To accomplish the requirements of the homework, I've added the commons-io and
commons-lang3 dependencies into the pom.xml in order to have access to the
StringUtils and FileUtils classes. After that, at the end of the Main class,
I've created a method with the responsibility of getting the unique words from
the obtained array of strings from the file_to_read.txt file read in the 
try-catch block and then the result was written in the file_to_write.txt file.
I've learnt to be aware of deprecated methods given by libraries and use the
recent ones.

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
You will need an IDE to open the project folder and, finally, run the Main.java 
file to see the program output.

## Author

- [@Nazareno Bucciarelli](https://github.com/nazabucciarelli)
