package main.java;

public class Customer {

    public Customer(){

    }
    private String Name;
    private int Age;
    private String City;
    private double PurchaseAmount;

    private Gender gender;
    public enum Gender{
        Male, Female, Other
    }
    public Customer(String Name, int Age, String City, Gender gender, double PurchaseAmount) {
        this.Name = Name;
        this.Age = Age;
        this.City = City;
        this.gender = gender;
        this.PurchaseAmount = PurchaseAmount;
    }
    public void setName(String Name){
        this.Name=Name;
    }
    public String getName(){
        return Name;
    }
    public void setAge(int Age){
        this.Age=Age;
    }
    public int getAge(){
        return Age;
    }
    public void setCity(String City){
        this.City=City;
    }
    public String getCity(){
        return City;
    }
    public void setPurchaseAmount(double PurchaseAmount){
        this.PurchaseAmount=PurchaseAmount;
    }
    public double getPurchaseAmount(){
        return PurchaseAmount;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Gender getGender() {
        return gender;
    }
}