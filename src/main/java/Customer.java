
public class Customer {

    //constructor
    public Customer(){

    }

    //data members
    private String Name;
    private int Age;
    private String City;
    private double PurchaseAmount;

    private Gender gender;
    //enumeration
    public enum Gender{
        Male, Female, Other
    }
    //parameterized constructor
    public Customer(String Name, int Age, String City, Gender gender, double PurchaseAmount) {
        this.Name = Name;
        this.Age = Age;
        this.City = City;
        this.gender = gender;
        this.PurchaseAmount = PurchaseAmount;
    }

    //setters getters
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

    //toString override for display
    @Override
    public String toString() {
        return "Name: " + Name + ", Age: " + Age + ", City: " + City + ", Gender: " + gender + ", PurchaseAmount: " + PurchaseAmount;
    }
}