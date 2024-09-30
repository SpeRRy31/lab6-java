import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class CustomerListManager implements CustomerManager{
    private String pathtxt= "src/customersList.txt";
    private String pathDat= "src/customersList.dat";
    private ArrayList<Customer> customerList = new ArrayList<>();

    public ArrayList<Customer> getCustomerList() {
        return customerList;
    }

    //do generate customers



    public void createCustomers(int count){
        String nameArray [] = {"Kate",
                "Colt",
                "Eren",
                "Edgar",
                "Jasie",
                "Finn",
                "Daniel",
                "Obama",
                "Lewis",
                "John",
                "Mike",
                "Lion",
                "Jinger",
                "Igger",
                "Nick",
                "Alex",
                "Piere",
                "Esteban",
                "Kevin",
                "Marci"};
        String surnameArray [] = {"Lawson",
                "Tsunoda",
                "Hamilton",
                "Franchesko",
                "Shumacher",
                "Prost",
                "Verstappen",
                "Ricciardo",
                "Levchenko",
                "Grosjean",
                "Sati",
                "Mudryk",
                "Pillow",
                "Fix",
                "Bringshtorm",
                "Hulkenderg",
                "Ocon",
                "Gasly",
                "Magnusen",
                "Gay",
                "Monkey",
                "Nigger",
                "Brain",
                "Calopinto",
                "Bearman",
                "Singapure",
                "Albon",
                "Savchenko"};
        String addressArray [] = {"Linkoln str. ",
                "Shevchenko Square ",
                "Wolf str. ",
                "Crimson str. "};
        for (int i = 0; i < count; i ++){
            String surname = surnameArray[(int)(Math.random()*surnameArray.length)];
            String name = nameArray[(int)(Math.random()*nameArray.length)];
            String fathername = nameArray[(int)(Math.random()*nameArray.length)];
            String address = addressArray[(int)(Math.random()*addressArray.length)] + (int)(Math.random()*40);

            customerList.add(new Customer(i, surname, name, fathername, address, "1000" + i, "444" + i, Math.random()*1200));
        }
    }
    public void createCustomers(){
        Scanner s = new Scanner(System.in);
        System.out.printf("Input count customers: ");
        this.createCustomers(s.nextInt());
    }

    public void printCustomers(){
        for (Customer item : customerList) {
            System.out.println(item.toString());
        }
    }

    public void printCustomersByName(){
        System.out.println("input find name: ");
        Scanner s = new Scanner(System.in);
        String name = s.nextLine();
        for (Customer item : customerList) {
            if (item.getName().equals(name)) {
                System.out.println(item.toString());
            }
        }
    }
    public void printCustomersBetweenBalanceRange(double min, double max){
        for (Customer item : customerList) {
            if (item.getBonusBalance() >= min && item.getBonusBalance() <= max){
                System.out.println(item.toString());
            }
        }
    }
    public void printCustomersBetweenBalanceRange(){
        Scanner s = new Scanner(System.in);
        System.out.println("Input range min and max");
        this.printCustomersBetweenBalanceRange(s.nextDouble(), s.nextDouble());
    }
    public void printCustomersNullBalance(){
        int count = 0;
        for (Customer item : customerList) {
            if (item.getBonusBalance() == 0){
                System.out.println(item.toString());
            }
        }
    }

    public void saveToTxt(){
        try(FileWriter writer = new FileWriter(pathtxt, false))
        {
            for (Customer item : customerList) {
                writer.write(item.toCSVString());
                writer.write("\n");
            }
            writer.flush();
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }
    }
    public void loadFromTxt(){
        try(BufferedReader reader = new BufferedReader(new FileReader(pathtxt)))
        {
            customerList.clear();
            String line;
            while ((line = reader.readLine()) != null) {
                customerList.add(Customer.fromString(line));
            }
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }
    }

    public void saveToDat(){
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(pathDat)))
        {
            oos.writeObject(customerList);
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    }
    public void loadFromDat(){
        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(pathDat)))
        {
            customerList=(ArrayList<Customer>)ois.readObject();
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    }

    //do add edit and delete customers
}
