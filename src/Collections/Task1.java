package Collections;

import java.util.ArrayList;
import java.util.LinkedList;

    public class Task1{

        public static void main(String[] args) {

            // 1. Create an ArrayList of integers, add 10 numbers, and print them using a for-each loop.
            ArrayList<Integer> Numbers = new ArrayList<>();
            for (int i = 3; i <= 30; i += 3) {
                Numbers.add(i); // Adds 2, 4, 6, ..., 20
            }
            System.out.println("1.Numbers using for-each loop:");
            for (int num : Numbers) {
                System.out.print(num + " ");
            }
            System.out.println("\n");

            // 2. Create a LinkedList of strings, add 5 names, and retrieve the 3rd element.
            LinkedList<String> cities = new LinkedList<>();
            cities.add("London");
            cities.add("New York");
            cities.add("Tokyo");
            cities.add("Sydney");
            cities.add("Paris");
            System.out.println("2. 3rd city in LinkedList: " + cities.get(2)); // 0-based index
            System.out.println();

            // 3. Demonstrate the difference between size() and isEmpty() using an ArrayList.
            ArrayList<String> tasks = new ArrayList<>();
            System.out.println("3. Is task list empty? " + tasks.isEmpty());
            tasks.add("Complete homework");
            tasks.add("Go for a walk");
            System.out.println(" Size of task list: " + tasks.size());
            System.out.println(" Is task list empty now? " + tasks.isEmpty());
            System.out.println();

            // 4. Write a program to check if an element exists in an ArrayList using contains().
            ArrayList<String> animals = new ArrayList<>();
            animals.add("Dog");
            animals.add("Cat");
            animals.add("Elephant");
            animals.add("Lion");
            System.out.println("4. Does the list contain 'Cat'? " + animals.contains("Cat"));
            System.out.println("   Does the list contain 'Tiger'? " + animals.contains("Tiger"));
            System.out.println("   Does the list contain 'Whale'? " + animals.contains("Whale"));
            System.out.println();

            // 5. Add elements to a LinkedList, then remove the first and last element.
            LinkedList<String> languages = new LinkedList<>();
            languages.add("Python");
            languages.add("Java");
            languages.add("C++");
            languages.add("JavaScript");
            languages.add("Ruby");
            System.out.println("5. Original LinkedList of languages: " + languages);
            languages.removeFirst();
            languages.removeLast();
            System.out.println("   After removing first and last: " + languages);
        }
    }


