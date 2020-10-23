package lab1;


/**
 * @author yumi
 */

public class Model {

    // data field
    // constants
    public static final int INCHES_PER_FOOT = 12;
    public static final double POUNDS_PER_KG = 2.2046;
    public static final int BASE_RATE_DOLLARS_PER_HOUR = 60;
    public static final int TALL_INCHES = 67;
    public static final double THIN_POUNDS = 140.0;
    public static final int TALL_THIN_BONUS_DOLLARS_PER_HOUR = 5;
    public static final int TRAVEL_BONUS_DOLLARS_PER_HOUR = 4;
    public static final int SMOKER_DEDUCTION_DOLLARS_PER_HOUR  = 10;

    private String firstName;
    private String lastName;
    private int height; // inches
    private double weight;
    private boolean canTravel;
    private boolean smokes;

    // constructor 1 (default) does nothing
    /**
     * default constructor, takes no parameters
     * @param
     */
    Model(){

    }

    // constructor 2 (take the 6 fields as parameters)
    /**
     * constructor which takes 6 parameters
     * @param firstName
     * @param lastName
     * @param height
     * @param weight
     * @param canTravel
     * @param smokes
     */
    Model(String firstName, String lastName, int height, double weight, boolean canTravel, boolean smokes)
    {
        setFirstName(firstName);
        setLastName(lastName);
        setHeight(height);
        setWeight(weight);
        this.canTravel = canTravel;
        this.smokes = smokes;
    }

    // constructor 3: take only first,last name , height in inches and weight in pounds
    /**
     * constructor which takes 4 parameters, with other 2 set values
     * @param firstName
     * @param lastName
     * @param height
     * @param weight
     */
    Model(String firstName, String lastName, int height, double weight ){
        setFirstName(firstName);
        setLastName(lastName);
        setHeight(height);
        setWeight(weight);
        // default value
        this.canTravel = true;
        this.smokes = false;
    }

    // getter/accessor methods for each instance variable

    /**
     * return firstName
     * @return firstName
     */
    public String getFirstName(){
        return firstName;
    }

    /**
     * return lastName
     * @return lastName
     */
    public String getLastName(){
        return lastName;
    }

    /**
     * return height
     * @return height
     */
    public int getHeight(){
        return height;
    }

    /**
     *
     * @return feet
     */
   public int getFeet(){
       int feet = height / INCHES_PER_FOOT;
       return feet;
   }

    /**
     *
     * @return inches
     */
   public double getInches(){
       double inches = (height % INCHES_PER_FOOT) * INCHES_PER_FOOT;
       return inches;
   }


    /**
     * return weight
     * @return weight
     */
    public double getWeight(){
        return weight;
    }


    /**
     * return true or false
     * @return true or false
     */
    public boolean getCanTravel(){
        return canTravel;
    }

    /**
     * return true or false
     * @return true or false
     */
    public boolean getSmokes(){
        return smokes;
    }


    /**
     * Returns the height in feet and inches
     * @param height
     * @return the height in feet and inches
     */
    public String getHeightInFeetAndInches(int height) {
        int feet = height / 12;
        double inches = ((height % 12) * 12);
        if (inches < 0){
            String str = String.format("%d",feet);
            return str;
        }else if(inches == 1){
            String str2 = String.format("%d feet %f inch", feet, inches);
            return str2;
        } else{
            String str3 = String.format("%d feet %f inches",feet, inches);
            return str3;
        }
    }




    // setter/mutator method for each field
    /**
     * set the firstName
     * @param firstName
     */
    public void setFirstName(String firstName) {
        if (firstName.length() >= 3 && firstName.length() <= 20) {
            this.firstName = firstName;
        } else {
            this.firstName = null;
        }
    }

    /**
     * set the lastName
     * @param lastName
     */
    public void setLastName(String lastName){
        if (lastName.length() >= 3 && lastName.length() <= 20){
            this.lastName = lastName;
        }
    }

    /**
     * set the height
     * @param height
     */
    public void setHeight(int height){
        if(height >= 24 && height <= 84){
            this.height = height;
        }
    }

    /**
     * set height in inches
     * @param feet
     * @param inches
     */
    public void setHeightFeet(int feet, int inches) {
        this.height = feet * 12 + inches;
    }

    /**
     * set the weight in pounds
     * @param pounds pounds (lb)
     */
    public void setWeight(double pounds) {
        if(pounds >= 80 && pounds <= 280){
            this.weight = pounds;
        }
    }

    /**
     * set kilogram input as pounds
     * @param kilograms
     */
    public void setWeightKg(long kilograms) {
        this.weight = kilograms * 2.20462;
    }

    /**
     * prints detail information about this Model
     */
    public void printDetails() {
        String str = String.format("Name: %s %s\nHeight: %d inches\nWeight: %.0f pounds\n", getFirstName(),getLastName(),getHeight(),getWeight());

        String str2;
        if (getCanTravel()) {
            str2 = "Does travel";
        } else{
            str2 = "Does not travel";
        }
        String str3;
        if (getSmokes()){
            str3 = "Does smoke";
        } else{
            str3 = "Does not smoke";
        }
        System.out.println(str + str2 + "\n" + str3);
    }


    /**
     * returns model's pay dollars per hour
     * @return int value of model's pay dollars per hour
     */
    public int calculatePayDollarsPerHour() {
        int total = BASE_RATE_DOLLARS_PER_HOUR;
        if (getHeight() >= TALL_INCHES && getWeight() < THIN_POUNDS ){
            total = total + TALL_THIN_BONUS_DOLLARS_PER_HOUR;
        }
        if (getSmokes()){
            total = total - SMOKER_DEDUCTION_DOLLARS_PER_HOUR;
        }
        if (getCanTravel()){
            total = total + TRAVEL_BONUS_DOLLARS_PER_HOUR;
        }
        return total;
    }

    public void displayModelDetails() {
        String str = String.format("Name: %s %s\nHeight:%d feet %.0f inches\nWeight: %.1f pounds",getFirstName(),getLastName(),getFeet(),getInches(),getWeight());

        String str2;
        if (getCanTravel()) {
            str2 = "yep";
        } else{
            str2 = "nope";
        }

        String str3;
        if (getSmokes()){
            str3 = "yep";
        } else{
            str3 = "nope";
        }

        System.out.println(str + str2 + "\n" + str3 + "\n" + "Hourly rate: $" + calculatePayDollarsPerHour() );
    }

}
