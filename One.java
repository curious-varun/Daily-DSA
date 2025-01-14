import java.util.Scanner;

public class One {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of data entries: ");
        int n = scanner.nextInt();
        scanner.nextLine();

        Data[] dataArray = new Data[n];

        for (int i = 0; i < n; i++) {
            System.out.println("Enter details for entry " + (i + 1));

            System.out.print("Enter name: ");
            String name = scanner.nextLine();

            System.out.print("Enter income: ");
            double income = scanner.nextDouble();

            System.out.print("Enter house allowance: ");
            double houseAllowance = scanner.nextDouble();
            scanner.nextLine(); // Consume newline

            dataArray[i] = new Data(name, income, houseAllowance);
        }

        System.out.println("\nStored Data:");
        for (int i = 0; i < n; i++) {
            dataArray[i].printData();
            System.out.println();
        }

        scanner.close();
    }
}

class Data {
    String name;
    double income;
    double houseAllowance;

    Data(String name, double income, double houseAllowance) {
        this.name = name;
        this.income = income;
        this.houseAllowance = houseAllowance;
    }

    public void printData() {
        System.out.println("Name: " + name);
        System.out.println("Income: " + income);
        System.out.println("House Allowance: " + houseAllowance);
    }
}
