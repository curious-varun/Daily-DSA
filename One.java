import java.util.Scanner;

public class One {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of employees: ");
        int n = scanner.nextInt();
        scanner.nextLine(); // consume newline

        Employee[] employees = new Employee[n];
        int count = 0;

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Add Employee");
            System.out.println("2. Display Employees");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline
            switch (choice) {
                case 1:
                    if (count < n) {
                        System.out.print("Enter Employee ID: ");
                        int id = scanner.nextInt();
                        scanner.nextLine(); // consume newline

                        System.out.print("Enter Employee Name: ");
                        String name = scanner.nextLine();

                        System.out.print("Enter Employee Department: ");
                        String department = scanner.nextLine();
                        System.out.print("Enter Employee Salary: ");
                        double salary = scanner.nextDouble();

                        employees[count] = new Employee(id, name, department, salary);
                        count++;
                        System.out.println("Employee added successfully!");
                    } else {
                        System.out.println("Employee array is full!");
                    }
                    break;

                case 2:
                    if (count == 0) {
                        System.out.println("No employees to display.");
                    } else {
                        System.out.println("\nEmployee Details:");
                        for (int i = 0; i < count; i++) {
                            employees[i].displayEmployee();
                        }
                    }
                    break;

                case 3:
                    System.out.println("Exiting program. Goodbye!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}





class Employee {
    int id;
    String name;
    String department;
    double salary;

    Employee(int id, String name, String department, double salary) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    void displayEmployee() {
        System.out.printf("ID: %d, Name: %s, Department: %s, Salary: %.2f\n", id, name, department, salary);
    }
}


