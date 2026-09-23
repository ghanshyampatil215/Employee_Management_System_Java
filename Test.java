package p1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Test {

    public static void main(String[] args) {

        ArrayList<Employee> employees = new ArrayList<Employee>();

        Scanner sc = new Scanner(System.in);

        int choice;

        do {

            System.out.println("\n===== Employee Management System =====");
            System.out.println("1. Add Employee");
            System.out.println("2. Display Employee");
            System.out.println("3. Search Employee");
            System.out.println("4. Sort Employee");
            System.out.println("5. Delete Employee");
            System.out.println("6. Exit");

            System.out.print("Enter your choice: ");

            // Main menu choice validation
            while (!sc.hasNextInt()) {

                System.out.println("Please enter integer value for choice.");
                sc.next();

                System.out.print("Enter your choice: ");
            }

            choice = sc.nextInt();

            switch (choice) {
            //   ADD EMPLOYEE

            case 1:

                int id;

                // ID validation
                while (true) {

                    System.out.print("Enter Employee ID: ");

                    if (sc.hasNextInt()) {

                        id = sc.nextInt();
                        break;

                    } else {

                        System.out.println("Please enter integer value for ID."  );

                        sc.next();
                    }
                }


                String name;

                // Name validation
                while (true) {

                    System.out.print("Enter Employee Name: ");

                    name = sc.next();

                    if (name.matches("[a-zA-Z]+")) {

                        break;

                    } else {

                        System.out.println( "Please enter character value for Name.");
                    }
                }


                double salary;

                // Salary validation
                while (true) {

                    System.out.print("Enter Employee Salary: ");

                    if (sc.hasNextDouble()) {

                        salary = sc.nextDouble();
                        break;

                    } else {

                        System.out.println("Please enter numeric value for Salary."  );
                         sc.next();
                    }
                }


                employees.add(
                        new Employee(id, name, salary)
                );

                System.out.println(
                        "Employee added successfully."
                );

                break;

   //  DISPLAY EMPLOYEE
            case 2:

                if (employees.isEmpty()) {

                    System.out.println( "No employees available."  );

                } else {

                    System.out.println( "\n===== Employee Details =====" );

                    for (Employee e : employees) {

                        System.out.println(e);
                    }
                }

                break;

 //      SEARCH EMPLOYEE

            case 3:

                int searchChoice;

                do {

                    System.out.println( "\n===== Search Employee ====="  );

                    System.out.println("1. Search by ID");
                    System.out.println("2. Search by Name");
                    System.out.println("3. Search by Salary");
                    System.out.println("4. Exit");

                    System.out.print("Enter your choice: ");

                    // Search choice validation
                    while (!sc.hasNextInt()) {

                        System.out.println("Please enter integer value for choice.");

                        sc.next();

                        System.out.print("Enter your choice: " );
                    }

                    searchChoice = sc.nextInt();


                    switch (searchChoice) {
    // Search by ID

                    case 1:

                        int searchId;

                        while (true) {

                            System.out.print("Enter Employee ID: ");

                            if (sc.hasNextInt()) {

                                searchId = sc.nextInt();
                                break;

                            } else {

                                System.out.println("Please enter integer value for ID." );

                                sc.next();
                            }
                        }


                        boolean foundId = false;

                        for (Employee e : employees) {

                            if (e.id == searchId) {

                                System.out.println("Employee Found:");

                                System.out.println(e);

                                foundId = true;

                                break;
                            }
                        }


                        if (!foundId) {

                            System.out.println("Employee not found." );
                        }

                        break;

  // Search by Name

                    case 2:

                        String searchName;

                        while (true) {

                            System.out.print( "Enter Employee Name: " );

                            searchName = sc.next();

                            if (searchName.matches("[a-zA-Z]+")) {

                                break;

                            } else {

                                System.out.println( "Please enter character value for Name." );
                            }
                        }


                        boolean foundName = false;

                        for (Employee e : employees) {

                            if (e.name.equalsIgnoreCase(searchName)) {

                                System.out.println("Employee Found:" );

                                System.out.println(e);

                                foundName = true;

                                break;
                            }
                        }


                        if (!foundName) {

                            System.out.println( "Employee not found.");
                        }

                        break;

    // Search by Salary
                    case 3:

                        double searchSalary;

                        while (true) {

                            System.out.print(
                                    "Enter Employee Salary: "
                            );

                            if (sc.hasNextDouble()) {

                                searchSalary = sc.nextDouble();

                                break;

                            } else {

                                System.out.println( "Please enter numeric value for Salary.");

                                sc.next();
                            }
                        }


                        boolean foundSalary = false;

                        for (Employee e : employees) {

                            if (Double.compare( e.salary, searchSalary ) == 0) {

                                System.out.println("Employee Found:");

                                System.out.println(e);

                                foundSalary = true;

                                break;
                            }
                        }


                        if (!foundSalary) {

                            System.out.println( "Employee not found." );
                        }

                        break;

  // Exit Search

                    case 4:

                        System.out.println( "Exiting Search..." );

                        break;


                    default:

                        System.out.println( "Invalid choice." );
                    }

                } while (searchChoice != 4);

                break;

 // SORT EMPLOYEE

            case 4:

                int sortChoice;

                do {

                    System.out.println( "\n===== Sort Employee =====" );

                    System.out.println("1. Sort by ID");
                    System.out.println("2. Sort by Name");
                    System.out.println("3. Sort by Salary");
                    System.out.println("4. Exit");

                    System.out.print("Enter your choice: ");


                    // Sort choice validation
                    while (!sc.hasNextInt()) {

                        System.out.println( "Please enter integer value for choice." );

                        sc.next();

                        System.out.print("Enter your choice: " );
                    }

                    sortChoice = sc.nextInt();


                    switch (sortChoice) {

 // Sort by ID

                    case 1:

                        Collections.sort(employees, new MyIDComparator() );

                        System.out.println("\nSorted by ID:" );

                        for (Employee e : employees) {

                            System.out.println(e);
                        }

                        break;

 // Sort by Name

                    case 2:

                        Collections.sort( employees,new MyNameComparator()
                        );

                        System.out.println("\nSorted by Name:" );

                        for (Employee e : employees) {

                            System.out.println(e);
                        }

                        break;

     // Sort by Salary

                    case 3:

                        Collections.sort( employees, new MySalaryComparator() );

                        System.out.println( "\nSorted by Salary:" );

                        for (Employee e : employees) {

                            System.out.println(e);
                        }

                        break;

     // Exit Sort         

                    case 4:

                        System.out.println("Exiting Sort..." );

                        break;


                    default:

                        System.out.println(
                                "Invalid choice."
                        );
                    }

                } while (sortChoice != 4);

                break;


   //DELETE EMPLOYEE
            
            case 5:

                int deleteId;

                // Delete ID validation
                while (true) {

                    System.out.print( "Enter Employee ID to delete: " );

                    if (sc.hasNextInt()) {

                        deleteId = sc.nextInt();

                        break;

                    } else {

                        System.out.println("Please enter integer value for ID.");

                        sc.next();
                    }
                }


                boolean deleted = false;


                for (int i = 0; i < employees.size(); i++) {

                    if (employees.get(i).id == deleteId) {

                        employees.remove(i);

                        System.out.println("Employee deleted successfully." );

                        deleted = true;

                        break;
                    }
                }


                if (!deleted) {

                    System.out.println("Employee not found.");
                }

                break;

  // EXIT
           
            case 6:

                System.out.println( "Thank you!" );

                break;

            default:

                System.out.println("Invalid choice.");
            }


        } while (choice != 6);


        sc.close();
    }
}