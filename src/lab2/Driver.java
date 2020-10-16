package lab2;

public class Driver {
    public static void main(String[] args) {
        Canada canada = new Canada(); // create a model with default value(all provinces)
        canada.displayAllProvinces();
        System.out.println(canada.getNumOfProvincesBetween(1,15));
    }

}
