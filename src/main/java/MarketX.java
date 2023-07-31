package main.java;

import main.java.Customer;

import java.util.*;
import java.util.stream.Collectors;

public class MarketX {

    public static void main(String [] args)
    {
        //arrayList of objects

        List<Customer> customers=new ArrayList();
        customers.add(new Customer("Aleena",21,"New York", Customer.Gender.Female, 345678));
        customers.add(new Customer("Zummer",30,"New York", Customer.Gender.Female, 123445));
        customers.add(new Customer("Laiba",21,"New York", Customer.Gender.Female, 102130));
        customers.add(new Customer("Ali",40,"New York", Customer.Gender.Male, 500000));
        customers.add(new Customer("Ahmed",39,"New York", Customer.Gender.Male, 100000));
        customers.add(new Customer("Joe",30,"New York", Customer.Gender.Other, 100000));


        //filtering on conditions. filtering, mapping, sorting and collecting

        List<String> filterResults=customers.stream()
                .filter(customer -> customer.getAge() >= 25 && customer.getAge()<=40)
                .filter(customer->customer.getCity().equals("New York"))
                .filter(customer->customer.getGender()== Customer.Gender.Male|| customer.getGender()== Customer.Gender.Female)
                .map(Customer::getName)
                .sorted()
                .collect(Collectors.toList());


        double TotalPurchaseAmount;
        TotalPurchaseAmount = customers.stream().mapToDouble(Customer::getPurchaseAmount).sum();

        Customer customerWithHighestPurchase;
        customerWithHighestPurchase= customers.stream()
                .max(Comparator.comparingDouble(Customer::getPurchaseAmount))
                .orElse(null);


        //using hashmap to calculate average purchase amount for each city

        Map<String, Double> totalPurchaseByCity = customers.stream()
                .collect(Collectors.groupingBy(Customer::getCity, Collectors.summingDouble(Customer::getPurchaseAmount)));
        Map<String, Double> averagePurchaseByCity = new HashMap<>();
        int numberOfCustomers = customers.size();

        for (String city : totalPurchaseByCity.keySet()) {
            double totalPurchase = totalPurchaseByCity.get(city);
            double averagePurchase = totalPurchase / numberOfCustomers;
            averagePurchaseByCity.put(city, averagePurchase);
        }



        System.out.println("Filtered Customer Names in alphabetical order: " + filterResults);
        System.out.println("Total Purchase Amount: " + TotalPurchaseAmount);
        System.out.println("Customers with Highest Purchase: " + customerWithHighestPurchase);
        System.out.println("Average Purchase Amount by City: ");
        for (String city : averagePurchaseByCity.keySet()) {
            System.out.println("City: " + city + ", Average Purchase Amount: " + averagePurchaseByCity.get(city));
        }

    }
}
