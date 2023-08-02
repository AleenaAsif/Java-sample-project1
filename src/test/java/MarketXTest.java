
import java.util.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import org.mockito.stubbing.OngoingStubbing;

public class MarketXTest {

   @Test
   public void testGetFilteredCustomerNames() {
        List<Customer> customers = new ArrayList<>();
        // Add some test data to the list
        customers.add(new Customer("Aleena", 21, "New York", Customer.Gender.Female, 345678));
        customers.add(new Customer("Zummer", 30, "New York", Customer.Gender.Female, 123445));
        customers.add(new Customer("Laiba", 21, "New York", Customer.Gender.Female, 102130));
        customers.add(new Customer("Ali", 40, "New York", Customer.Gender.Male, 500000));
        customers.add(new Customer("Ahmed", 39, "New York", Customer.Gender.Male, 100000));
        customers.add(new Customer("Joe", 30, "New York", Customer.Gender.Other, 100000));

        List<String> expectedNames = new ArrayList<>();
        // Add expected names based on the test data

        expectedNames.add("Ahmed");
       expectedNames.add("Ali");
       expectedNames.add("Zummer");


        List<String> filteredNames = MarketX.getFilteredCustomerNames(customers);
        assertEquals(expectedNames, filteredNames);
    }



    @Test

    public void testGetAveragePurchaseByCity() {

        List<Customer> customers = new ArrayList<>();
        customers.add(new Customer("Customer1", 30, "New York", Customer.Gender.Male, 100.0));
        customers.add(new Customer("Customer2", 25, "New York", Customer.Gender.Female, 200.0));
        customers.add(new Customer("Customer3", 35, "Los Angeles", Customer.Gender.Other, 150.0));
        customers.add(new Customer("Customer4", 28, "Los Angeles", Customer.Gender.Female, 50.0));

        Map<String, Double> expectedAverageByCity = new HashMap<>();
        expectedAverageByCity.put("New York", 75.0);
        expectedAverageByCity.put("Los Angeles", 50.0);


        Map<String, Double> averageByCity = MarketX.getAveragePurchaseByCity(customers);


        assertEquals(expectedAverageByCity, averageByCity);
    }
}










