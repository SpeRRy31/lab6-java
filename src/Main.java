import java.util.*;
public class Main {

    public static void main(String[] args) {
        Main main = new Main();
        main.run();
    }

    public static void printMenu() {
        System.out.println("Menu choose operation");
        System.out.println("1 - Generate Customers");
        System.out.println("2 - Save Customers to .txt");
        System.out.println("3 - Save Customers to .dat");
        System.out.println("4 - Load Customers to .txt");
        System.out.println("5 - Load Customers to .dat");
        System.out.println("6 - Show Customers by name");
        System.out.println("7 - Show Customers by range balance");
        System.out.println("8 - Show Customers with null balance");
        System.out.println("9 - Show all Customers");
        System.out.println("10 - Add Customer by id");
        System.out.println("11 - Change Customer by id");
        System.out.println("12 - Delete Customer by id");
        System.out.println("13 - Exit");
        System.out.printf("\n Input here --> ");
    }

    public static int menu() {
        printMenu();
        Scanner s = new Scanner(System.in);
        return s.nextInt();
    }

    public static void pressEnterToContinue(){
        Scanner t = new Scanner(System.in);
        System.out.println("press Enter to continue");
        t.nextLine();
    }

    public void run() {

        //CustomerArrayManager app = new CustomerArrayManager();
        CustomerListManager app = new CustomerListManager();
        boolean close = false;
        while (!close) {
            switch (menu()) {
                case 1:
                    app.createCustomers();
                    app.printCustomers();
                    pressEnterToContinue();
                    break;
                case 2:
                    app.saveToTxt();
                    break;
                case 3:
                    app.saveToDat();
                    break;
                case 4:
                    app.loadFromTxt();
                    break;
                case 5:
                    app.loadFromDat();
                    break;
                case 6:
                    app.printCustomersByName();
                    pressEnterToContinue();
                    break;
                case 7:
                    app.printCustomersBetweenBalanceRange();
                    pressEnterToContinue();
                    break;
                case 8:
                    app.printCustomersNullBalance();
                    pressEnterToContinue();
                    break;
                case 9:
                    app.printCustomers();
                    pressEnterToContinue();
                    break;
                case 10:
                    app.addCustomer();
                    app.printCustomers();
                    pressEnterToContinue();
                    break;
                case 11:
                    app.editCustomer();
                    app.printCustomers();
                    pressEnterToContinue();
                    break;
                case 12:
                    app.removeCustomer();
                    app.printCustomers();
                    pressEnterToContinue();
                    break;
                case 13:
                    close=true;
                    break;
                default:
                    System.out.println("invalid number");
                    break;
            }
        }
    }
}