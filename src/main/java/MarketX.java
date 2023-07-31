import java.util.*;

public class MarketX {

    public static void main(String [] args)
    {
        List<Customer> customers=new ArrayList();
        customers.add(new Customer("Aleena",21,"Lahore", Customer.Gender.Female, 345678));
        customers.add(new Customer("Zummer",20,"Lahore", Customer.Gender.Female, 123445));
        customers.add(new Customer("Laiba",21,"Lahore", Customer.Gender.Female, 102130));
        customers.add(new Customer("Ali",21,"Lahore", Customer.Gender.Male 500000));
        customers.add(new Customer("Ahmed",21,"Lahore", Customer.Gender.Male, 100000));
        customers.add(new Customer("Joe",21,"Lahore", Customer.Gender.Other, 100000));
    }
}
