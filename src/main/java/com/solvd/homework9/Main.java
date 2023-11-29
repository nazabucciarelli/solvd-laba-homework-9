package com.solvd.homework9;

import com.solvd.homework9.exceptions.NegativeValueException;
import com.solvd.homework9.functional_interfaces.IAdder;
import com.solvd.homework9.functional_interfaces.IConcatenate;
import com.solvd.homework9.functional_interfaces.ICreateInstance;
import com.solvd.homework9.interfaces.ISleep;
import com.solvd.homework9.models.*;
import com.solvd.homework9.util.CustomLinkedList;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;

public class Main {
    public static final Logger LOGGER = LogManager.getLogger(Main.class);

    public static void main(String[] args) {
        // Instantiating countries
        Country mexico = new Country("Mexico");
        Country argentina = new Country("Argentina");

        // Instantiating genders
        Gender male = new Gender("Male");
        Gender female = new Gender("Female");

        // Instantiating employees for the zoo
        Employee vet = new Employee("573928374", 24, "John", "Doe", male, mexico,
                2019, 1800);
        Employee manager = new Employee("928599807", 32, "Alvaro", "Rodriguez",
                male, argentina, 2021, 2000);
        Employee securityGuard = new Employee("193857460", 29, "Karen", "Lopez",
                female, mexico, 2020, 1500);
        List<Employee> administrationEmployees
                = new ArrayList<>(Arrays.asList(vet, manager, securityGuard));

        // Instantiating a department for the zoo
        Department administrationDepartment =
                new Department("Administration Department",
                        administrationEmployees);
        List<Department> zooDepartments
                = new ArrayList<>(List.of(administrationDepartment));

        // Instantiating feeding for each animal from the zoo
        Feeding insects = new Feeding("Insects");
        Feeding seeds = new Feeding("Seeds");

        // Instantiating natural habitats of the animals
        Habitat wetlands = new Habitat("Wetlands");
        Habitat forest = new Habitat("Forest");

        // Instantiating animals for the zoo
        Animal axolotl = new Amphibian("Axolotl", 1.2D, male, wetlands,
                insects);
        Animal frog = new Amphibian("Frog", 1, female, wetlands, insects);
        Animal parrot = new Bird("Parrot", 2.5D, female, forest, seeds);
        Animal pigeon = new Bird("Pigeon", 3, male, forest, seeds);
        List<Animal> birdsRoomAnimals
                = new ArrayList<>(Arrays.asList(parrot, pigeon));
        List<Animal> amphibianRoomAnimals
                = new ArrayList<>(Arrays.asList(axolotl, frog));


        // Instantiating an animal room for the zoo
        AnimalRoom birdsRoom = new AnimalRoom("Birds Room", birdsRoomAnimals, 45);
        AnimalRoom amphibiansRoom = new AnimalRoom("Amphibians Room",
                amphibianRoomAnimals, 20);
        List<AnimalRoom> zooAnimalRooms
                = new ArrayList<>(Arrays.asList(birdsRoom, amphibiansRoom));


        // Instantiating the zoo
        Zoo californiaZoo = new Zoo("California Zoo", zooAnimalRooms,
                zooDepartments);

        // Instantiating customers of the zoo
        Customer louis = new Customer("204980609", 40, "Louis", "Smith", male,
                argentina, "358472034", 2, "Taxi Driver");
        Customer pablo = new Customer("493485321", 18, "Pablo", "Gerardi", male,
                mexico, "3584293109", 7, "Programmer");

        // Applying the concept of polymorphism
        List<Person> persons
                = new ArrayList<>(Arrays.asList(vet, manager, securityGuard,
                louis, pablo));

        // Using the Consumer Functional Interface to iterate using the
        // forEach method.
        persons.forEach(p -> p.walk());

        List<ISleep> sleepers
                = new ArrayList<>(Arrays.asList(pablo, louis, parrot, pigeon,
                securityGuard));

        sleepers.forEach(s -> s.sleep());

        LOGGER.info("There are " + Animal.getQuantityOfAnimals()
                + " Animals");

        // Using try-catch with resources
        try (Scanner sc = new Scanner(System.in)) {
            LOGGER.info("Insert two integer numbers");
            int firstNumber = 6; //sc.nextInt(); Lines commented in order to not
            // interrupt the program's execution.
            int secondNumber = 6; //sc.nextInt();
            LOGGER.info("The result of the sum is " +
                    (firstNumber + secondNumber));
        } catch (InputMismatchException e) {
            LOGGER.error("You haven't inserted a number", e);
        }

        // Second way of handling an exception, using try-catch
        try {
            louis.setAge(-4);
        } catch (NegativeValueException e) {
            LOGGER.error(e.getMessage(), e);
        } finally {
            LOGGER.info("Current age of Louis is " + louis.getAge());
        }

        // Using my custom LinkedList
        CustomLinkedList<String> names = new CustomLinkedList<>();

        names.addNode("Albert");
        names.addNode("Nikolas");
        names.addNode("Ada");
        names.addNode("Alan");

        names.printNodes();

        // Reading file and getting number of unique words
        try {
            String text = FileUtils.readFileToString(
                    new File("src/main/resources/file_to_read.txt"),
                    StandardCharsets.UTF_8);
            text = text.replaceAll("[^A-Za-z ]", "");
            String[] wordsArray = StringUtils.split(text, " ");
            int uniqueWords = getUniqueWords(wordsArray);
            String result = "There are " + uniqueWords + " unique words.";
            LOGGER.info(result);
            FileUtils.writeStringToFile(
                    new File("src/main/resources/file_to_write.txt"), result,
                    StandardCharsets.UTF_8, false);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // Using the Predicate Functional Interface to get the employees over
        // 25 years old
        List<Employee> employeesOver25 =
                administrationEmployees.stream().filter(e -> e.getAge() > 25)
                        .collect(Collectors.toList());
        LOGGER.info("The employees over 25 years old are: ");
        employeesOver25.forEach(e -> LOGGER.info(e.getFirstName() + " " +
                e.getLastName()));

        // Using the Function Functional Interface to get person's ages.
        List<Integer> ages = persons.stream().map(p -> p.getAge())
                .collect(Collectors.toList());
        LOGGER.info("The person's ages are: ");
        ages.forEach(a -> LOGGER.info(a));

        // Using Supplier Functional Interface to get a Zoo's instance
        Supplier<Zoo> zooSupplier = () -> new Zoo("International Zoo", null, null);
        LOGGER.info("The created zoo is called " + zooSupplier.get().getName());

        // Using UnaryOperator Functional Interface to square the person's ages
        UnaryOperator<Integer> unaryOperator = age -> age * age;
        LOGGER.info("The ages of the persons squared are: ");
        ages.forEach(a -> LOGGER.info(unaryOperator.apply(a)));

        // Using my custom functional interfaces

        // IConcatenate Lambda
        IConcatenate<String> iConcatenate = (firstElement, secondElement,
                                             thirdElement) ->
                firstElement + " " + secondElement + " " + thirdElement;

        LOGGER.info(iConcatenate.concatenate("This", "is", "concatenation"));

        // IAdder Lambda
        IAdder<Double> iAdder = ((firstNumber, secondNumber, thirdNumber) ->
                firstNumber + secondNumber + thirdNumber);
        LOGGER.info("The result of the sum is " + iAdder.sum(10.2, 30.86, 15.3));

        // ICreateInstance Lambda
        ICreateInstance<Habitat> iCreateInstance = () -> new Habitat("Savanna");
        LOGGER.info("The created habitat is called " +
                iCreateInstance.getInstance().getName());
    }

    private static int getUniqueWords(String[] wordsArray) {
        Map<String, Integer> wordsAmountMap = new HashMap<>();
        for (String word : wordsArray) {
            if (wordsAmountMap.containsKey(word)) {
                int amount = wordsAmountMap.get(word);
                wordsAmountMap.put(word, ++amount);
            } else {
                wordsAmountMap.put(word, 1);
            }
        }
        int uniqueWords = 0;
        for (Map.Entry<String, Integer> entry : wordsAmountMap.entrySet()) {
            if (entry.getValue() == 1)
                uniqueWords++;
        }
        return uniqueWords;
    }
}
