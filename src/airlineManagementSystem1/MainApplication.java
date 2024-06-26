package airlineManagementSystem1;

import java.util.Arrays;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MainApplication {

    public static void main(String[] args) {
    	
        Scanner scanner = new Scanner(System.in);
        Airline airline = new Airline();

        while (true) {
        	System.out.println("Welcome to Indian International Airport.......!!");
            System.out.println("Enter Your Choice:");
            System.out.println("1. Add Flight");
            System.out.println("2. Remove Flight");
            System.out.println("3. Register Passenger");
            System.out.println("4. Unregister Passenger");
            System.out.println("5. Book Flight");
            System.out.println("6. Cancel Booking");
            System.out.println("7. List Available Flights");
            System.out.println("8. List Booked Flights");
            System.out.println("9. Perform String Operations");
            System.out.println("10. Exit");
            System.out.print("Enter your choice: ");

            int choice;
            try {
                choice = scanner.nextInt();
                scanner.nextLine(); //  newline 
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid integer.");
                scanner.next(); //  invalid input
                continue;
            }

            switch (choice) {
                case 1:
                    System.out.print("Enter flight number: ");
                    String flightNumber = scanner.next();
                    System.out.print("Enter origin: ");
                    String origin = scanner.next();
                    System.out.print("Enter destination: ");
                    String destination = scanner.next();
                    System.out.print("Enter departure time: ");
                    String departureTime = scanner.next();
                    System.out.print("Enter arrival time: ");
                    String arrivalTime = scanner.next();
                    Flight flight = new Flight(flightNumber, origin, destination, departureTime, arrivalTime);
                    airline.addFlight(flight);
                    break;
                case 2:
                    System.out.print("Enter flight number to remove: ");
                    String removeFlightNumber = scanner.next();
                    airline.removeFlight(removeFlightNumber);
                    break;
                case 3:
                    System.out.print("Enter passenger name: ");
                    String passengerName = scanner.next();
                    System.out.print("Enter passport number: ");
                    String passportNumber = scanner.next();
                    Passenger passenger = new Passenger(passengerName, passportNumber);
                    airline.registerPassenger(passenger);
                    break;
                case 4:
                    System.out.print("Enter passport number to unregister: ");
                    String unregisterPassportNumber = scanner.next();
                    airline.unregisterPassenger(unregisterPassportNumber);
                    break;
                case 5:
                    System.out.print("Enter passport number: ");
                    String bookPassportNumber = scanner.next();
                    System.out.print("Enter flight number to book: ");
                    String bookFlightNumber = scanner.next();
                    airline.bookFlight(bookPassportNumber, bookFlightNumber);
                    break;
                case 6:
                    System.out.print("Enter passport number: ");
                    String cancelPassportNumber = scanner.next();
                    System.out.print("Enter flight number to cancel: ");
                    String cancelFlightNumber = scanner.next();
                    airline.cancelBooking(cancelPassportNumber, cancelFlightNumber);
                    break;
                case 7:
                    airline.listAvailableFlights();
                    break;
                case 8:
                    airline.listBookedFlights();
                    break;
                case 9:
                    System.out.println("Exiting the main menu...");
                    System.out.println("======================================================================");
                    System.out.println("String Operations:");
                    System.out.println("Enter a string to count occurrences of 'a':");
                    String str = scanner.next();
                    System.out.println("Occurrences of 'a': " + StringUtil.countOccurrences(str, 'a'));
                    System.out.println("======================================================================");

                    System.out.println("Enter a string to reverse:");
                    str = scanner.next();
                    System.out.println("Reversed string: " + StringUtil.reverseString(str));
                    System.out.println("======================================================================");

                    System.out.println("Enter a string to check if it's a palindrome:");
                    str = scanner.next();
                    System.out.println("Is palindrome: " + StringUtil.isPalindrome(str));
                    System.out.println("======================================================================");

                    System.out.println("Enter a string to capitalize words:");
                    str = scanner.next();
                    System.out.println("Capitalized words: " + StringUtil.capitalizeWords(str));
                    System.out.println("======================================================================");

                    System.out.println("Enter a list of numbers separated by spaces:");
                    Scanner sc = new Scanner(System.in);
                    String numbersStr = sc.nextLine();
                    Integer[] numbers = Arrays.stream(numbersStr.split(" ")).map(Integer::parseInt).toArray(Integer[]::new);
                    System.out.println("Max number: " + WrapperUtil.findMax(numbers));
                    System.out.println("======================================================================");

                    System.out.println("Enter a binary string:");
                    String binaryString = scanner.next();
                    Boolean[] boolArray = WrapperUtil.convertToBooleanArray(binaryString);
                    System.out.println("Boolean array: "+ Arrays.toString(boolArray));
                    String newBinaryString = WrapperUtil.convertToBinaryString(boolArray);
                    System.out.println("New binary string: " + newBinaryString);
                    System.out.println("======================================================================");

                    System.out.println("Enter a list of doubles separated by spaces:");
                    while (true) {
                        String doublesStr = scanner.next();
                        try {
                            Double[] doubles = Arrays.stream(doublesStr.split(" ")).map(Double::parseDouble).toArray(Double[]::new);
                            System.out.println("Average: " + WrapperUtil.calculateAverage(doubles));
                            break;
                        } catch (Exception e) {
                            System.out.println("Invalid input. Please enter a list of doubles separated by spaces.");
                        }
                       
                    }
                
                    continue;
                case 10:
                    System.out.println("Thank You.....");
                   return;
                default:
                    System.out.println("Thank You.....");
            }
            
        }
    }
}



