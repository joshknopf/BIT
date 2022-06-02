//Josh Knopf
//BIT 143
//2022, Spring Quarter
// This program creates a list of students and allows the user to 
// lookup information about a student given the ID number.
// This is meant to loosely simulate what happens at the Student
// Services desk (Kodiak Corner here at Cascadia College).
//
// In real life when a student scans their Student ID card
// the computer reads their Student ID Number from the bar code
// The computer then looks up the information about the student
// and allows the employee to look and and modify the information.
//

import java.util.*;

public class Student_Services_Desk {

    private static int nextSID = 22; // must be greater than any of the Students' IDs that we pre-load

    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);

        Map<Integer, Student> studentInfo = new TreeMap<Integer, Student>();
        studentInfo.put(21,
                new Student(21, "Zog", "TheDestroyer",
                        new ArrayList<String>(Arrays.asList("BIT 143", "MATH 411", "ENG 120"))));
        studentInfo.put(20,
                new Student(20, "Mary", "Sue", new ArrayList<String>(Arrays.asList("BIT 142", "MATH 142", "ENG 100"))));
        studentInfo.put(1,
                new Student(1, "Joe", "Bloggs",
                        new ArrayList<String>(Arrays.asList("BIT 115", "MATH 141", "ENG 101"))));

        char choice = 'L'; // anything but 'q' is fine
        while (choice != 'q') { // Will keep asking the user what they want to do until they quit out
            System.out.println("\nWhat would you like to do next? ");
            System.out.println("F - Find a specific student");
            System.out.println("L - List all the students (for debugging purposes)");
            System.out.println("A - Add a new student");
            System.out.println("D - Delete an existing student");
            System.out.println("M - Modify an existing student");
            System.out.println("Q - Quit (exit) the program");
            System.out.print("What is your choice?\n(type in the letter & then the enter/return key) ");
            choice = keyboard.nextLine().trim().toLowerCase().charAt(0);
            System.out.println();

            switch (choice) {
                case 'f': // Finds a student based off of their SID and prints the information tied to the
                          // account
                    System.out.println("Find a student (based on their ID number):\n");
                    System.out.print("What is the ID number of the student to find? ");
                    int num = 0;
                    if (keyboard.hasNextInt()) {
                        num = Integer.parseInt(keyboard.nextLine());
                        if (studentInfo.containsKey(num)) {
                            System.out.printf("%s, %s (SID=%d)\nClasses:\n", studentInfo.get(num).getLastName(),
                                    studentInfo.get(num).getFirstName(), studentInfo.get(num).getSID());
                            for (String className : studentInfo.get(num).getClasses()) {
                                System.out.println("\t" + className);
                            }
                        } else {
                            System.out.println("Didn't find a student with ID #" + num);
                        }
                    } else {
                        System.out.println("Please type a valid ID #");
                    }

                    break;

                case 'l': // Lists out all students and their information for debugging purposes
                    System.out.println("The following students are registered:");
                    for (Map.Entry<Integer, Student> entry : studentInfo.entrySet()) {
                        System.out.println(entry.toString());
                    }
                    break;
                case 'a': // Adds students to the system
                    String firstName = "";
                    String lastName = "";
                    List<String> classes = new ArrayList<String>();

                    System.out.println("Adding a new student\n");
                    System.out.println("Please provide the following information:");
                    System.out.print("Student's first name? ");

                    if (keyboard.hasNext()) {
                        firstName = keyboard.nextLine();
                    }
                    System.out.print("Student's last name? ");

                    if (keyboard.hasNext()) {
                        lastName = keyboard.nextLine();
                    }
                    System.out
                            .println("Type the name of class, or leave empty to stop.  Press enter/return regardless");
                    String studentClass = keyboard.nextLine();
                    while (studentClass.equals("") == false) {
                        classes.add(studentClass);
                        studentClass = keyboard.nextLine();
                    }
                    studentInfo.put(nextSID, new Student(nextSID, firstName, lastName, classes));
                    nextSID++;
                    break;
                case 'd': // Deletes students from the system
                    System.out.println("Deleting an existing student\n");
                    System.out.print("What is the ID number of the student to delete? ");

                    if (keyboard.hasNextInt()) {
                        int key = Integer.parseInt(keyboard.nextLine());
                        if (studentInfo.containsKey(key)) {
                            studentInfo.remove(key);
                            System.out.println("Student account found and removed from the system!");
                        } else {
                            System.out.println("Didn't find a student with ID # " + key);
                        }
                    }

                    break;
                case 'm': // Modifies any part of a students information
                    System.out.println("Modifying an existing student\n");
                    System.out.print("What is the ID number of the student to modify? ");
                    if (keyboard.hasNextInt()) {
                        int key = keyboard.nextInt();
                        keyboard.nextLine();
                        if (studentInfo.containsKey(key)) {
                            String newName = "";
                            System.out.println(
                                    "Student account found!\nFor each of the following type in the new info or leave empty to keep the existing info.  Press enter/return in both cases.");
                            System.out.print("Student's first name: " + studentInfo.get(key).getFirstName()
                                    + " New first name? ");
                            newName = keyboard.nextLine();
                            if ("".equals(newName) == false) {
                                studentInfo.get(key).setFirstName(newName);
                            }
                            System.out.print(
                                    "Student's last name: " + studentInfo.get(key).getLastName() + " New last name? ");
                            newName = keyboard.nextLine();
                            if ("".equals(newName) == false) {
                                studentInfo.get(key).setLastName(newName);
                            }
                            System.out.println("Updating class list");
                            System.out.println("Here are the current classes: " + studentInfo.get(key).getClasses());
                            System.out.println("First, are there any classes you'd like to remove?");
                            System.out.println("\nType d<enter/return> to remove, or just <enter/return> to keep ");
                            List<String> tempList = new ArrayList<>();
                            for (String className : studentInfo.get(key).getClasses()) {
                                System.out.println(className);
                                String delete = keyboard.nextLine();
                                if (delete.toLowerCase().equals("d")) {
                                    System.out.println("Removing " + className + "\n");
                                } else {
                                    System.out.println("Keeping " + className + "\n");
                                    tempList.add(className);
                                }
                            }
                            studentInfo.get(key).getClasses().removeAll(studentInfo.get(key).getClasses());
                            studentInfo.get(key).getClasses().addAll(tempList);
                            System.out.println(
                                    "Type the name of the class you'd like to add, or leave empty to stop.  Press enter/return regardless");
                            String newClass = " ";
                            while (newClass.equals("") == false) {
                                newClass = keyboard.nextLine();
                                studentInfo.get(key).getClasses().add(newClass);
                            }
                            System.out.println(
                                    "Here's the student's new, updated info: " + studentInfo.get(key).toString());
                        } else {
                            System.out.println("Didn't find a student with ID #" + key);
                        }
                    }

                    break;
                case 'q': // Quits out of the program
                    System.out.println("Thanks for using the program - goodbye!\n");
                    keyboard.close();
                    break;
                default: // Any other character will be caught
                    System.out.println("Sorry, but I didn't recognize the option " + choice);
                    break;
            }

        }
    }
}
