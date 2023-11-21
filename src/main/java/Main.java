import exceptions.NegativeValueException;
import interfaces.ISleep;
import models.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import util.CustomLinkedList;

import java.util.*;

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
        Employee vet = new Employee("573928374",24,"John", "Doe",male,mexico,
                                    2019, 1800);
        Employee manager = new Employee("928599807",32,"Alvaro", "Rodriguez",
                                        male, argentina, 2021,2000);
        Employee securityGuard = new Employee("193857460",29,"Karen","Lopez",
                                              female,mexico,2020,1500);
        List<Employee> administrationEmployees
                    = new ArrayList<>(Arrays.asList(vet,manager,securityGuard));

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
        Animal axolotl = new Amphibian("Axolotl",1.2D,male,wetlands,
                                    insects);
        Animal frog = new Amphibian("Frog",1,female,wetlands,insects);
        Animal parrot = new Bird("Parrot",2.5D,female,forest,seeds);
        Animal pigeon = new Bird("Pigeon",3,male,forest,seeds);
        List<Animal> birdsRoomAnimals
                        = new ArrayList<>(Arrays.asList(parrot,pigeon));
        List<Animal> amphibianRoomAnimals
                        = new ArrayList<>(Arrays.asList(axolotl,frog));


        // Instantiating a animal rooms for the zoo
        AnimalRoom birdsRoom = new AnimalRoom("Birds Room",birdsRoomAnimals,45);
        AnimalRoom amphibiansRoom = new AnimalRoom("Amphibians Room",
                                                    amphibianRoomAnimals,20);
        List<AnimalRoom> zooAnimalRooms
                    = new ArrayList<>(Arrays.asList(birdsRoom, amphibiansRoom));


        // Instantiating the zoo
        Zoo californiaZoo = new Zoo("California Zoo",zooAnimalRooms,
                                    zooDepartments);

        // Instantiating customers of the zoo
        Customer louis = new Customer("204980609",40,"Louis","Smith",male,
                                      argentina, "358472034",2,"Taxi Driver");
        Customer pablo = new Customer("493485321",18,"Pablo","Gerardi",male,
                                      mexico, "3584293109",7,"Programmer");

        // Applying the concept of polymorphism
        List<Person> persons
                    = new ArrayList<>(Arrays.asList(vet, manager, securityGuard,
                                                    louis, pablo));

        for (Person p: persons) {
            p.walk();
        }

        List<ISleep> sleepers
                   = new ArrayList<>(Arrays.asList(pablo, louis, parrot, pigeon,
                                                   securityGuard));

        for (ISleep sleeper: sleepers) {
            sleeper.sleep();
        }

        LOGGER.info("There are " + Animal.getQuantityOfAnimals()
                            + " Animals");

        // Using try-catch with resources
        try (Scanner sc = new Scanner(System.in)){
            LOGGER.info("Insert two integer numbers");
            int firstNumber = sc.nextInt();
            int secondNumber = sc.nextInt();
            LOGGER.info("The result of the sum is " +
                    (firstNumber + secondNumber));
        } catch ( InputMismatchException e) {
            LOGGER.error("You haven't inserted a number",e);
        }

        // Second way of handling an exception, using try-catch
        try {
            louis.setAge(-4);
        } catch (NegativeValueException e) {
            LOGGER.error(e.getMessage(),e);
        } finally{
            LOGGER.info("Current age of Louis is " + louis.getAge());
        }

        // Using my custom LinkedList

        CustomLinkedList<String> names = new CustomLinkedList<>();

        names.addNode("Albert");
        names.addNode("Nikolas");
        names.addNode("Ada");
        names.addNode("Alan");

        names.printNodes();

    }
}
