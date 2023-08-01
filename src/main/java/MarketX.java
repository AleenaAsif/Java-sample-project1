


import java.util.*;
import java.util.stream.Collectors;
public class MarketX {

    public static List<String> getFilteredCustomerNames(List<Customer> customers) {
        return customers.stream()
                .filter(customer -> customer.getAge() >= 25 && customer.getAge() <= 40)
                .filter(customer -> customer.getCity().equals("New York"))
                .filter(customer -> customer.getGender() == Customer.Gender.Male || customer.getGender() == Customer.Gender.Female)
                .map(Customer::getName)
                .sorted()
                .collect(Collectors.toList());
    }

    public static double getTotalPurchaseAmount(List<Customer> customers) {
        return customers.stream().mapToDouble(Customer::getPurchaseAmount).sum();
    }

    public static Customer getCustomerWithHighestPurchase(List<Customer> customers) {
        return customers.stream()
                .max(Comparator.comparingDouble(Customer::getPurchaseAmount))
                .orElse(null);
    }

    public static Map<String, Double> getAveragePurchaseByCity(List<Customer> customers) {
        Map<String, Double> totalPurchaseByCity = customers.stream()
                .collect(Collectors.groupingBy(Customer::getCity, Collectors.summingDouble(Customer::getPurchaseAmount)));
        Map<String, Double> averagePurchaseByCity = new HashMap<>();
        int numberOfCustomers = customers.size();

        for (String city : totalPurchaseByCity.keySet()) {
            double totalPurchase = totalPurchaseByCity.get(city);
            double averagePurchase = totalPurchase / numberOfCustomers;
            averagePurchaseByCity.put(city, averagePurchase);
        }

        return averagePurchaseByCity;
    }

    public static void main(String[] args) {
        List<Customer> customers = new ArrayList();
        customers.add(new Customer("Aleena", 21, "New York", Customer.Gender.Female, 345678));
        customers.add(new Customer("Zummer", 30, "New York", Customer.Gender.Female, 123445));
        customers.add(new Customer("Laiba", 21, "New York", Customer.Gender.Female, 102130));
        customers.add(new Customer("Ali", 40, "New York", Customer.Gender.Male, 500000));
        customers.add(new Customer("Ahmed", 39, "New York", Customer.Gender.Male, 100000));
        customers.add(new Customer("Joe", 30, "New York", Customer.Gender.Other, 100000));

        List<String> filterResults = getFilteredCustomerNames(customers);
        double totalPurchaseAmount = getTotalPurchaseAmount(customers);
        Customer customerWithHighestPurchase = getCustomerWithHighestPurchase(customers);
        Map<String, Double> averagePurchaseByCity = getAveragePurchaseByCity(customers);

        System.out.println("Filtered Customer Names in alphabetical order: " + filterResults);
        System.out.println("Total Purchase Amount: " + totalPurchaseAmount);
        System.out.println("Customers with Highest Purchase: " + customerWithHighestPurchase);
        System.out.println("Average Purchase Amount by City: ");
        for (String city : averagePurchaseByCity.keySet()) {
            System.out.println("City: " + city + ", Average Purchase Amount: " + averagePurchaseByCity.get(city));
        }
    }
}
