package lab1;

/**
 * @author Derrick Park
 */
public class Model {
    /**
     * Constants
     */
    public static final int INCHES_PER_FOOT = 12;
    public static final double POUNDS_PER_KG = 2.2046;
    public static final int BASE_RATE_DOLLARS_PER_HOUR = 60;
    public static final int TALL_INCHES = 67;
    public static final double THIN_POUNDS = 140.0;
    public static final int TALL_THIN_BONUS_DOLLARS_PER_HOUR = 5;
    public static final int TRAVEL_BONUS_DOLLARS_PER_HOUR = 4;
    public static final int SMOKER_DEDUCTION_DOLLARS_PER_HOUR = 10;

    /**
     * Instance variables (data fields)
     */
    private String firstName;
    private String lastName;
    private int height;
    private double weight;
    private boolean canTravel;
    private boolean smokes;

    /**
     * Default constructor
     */
    public Model() { }

    /**
     * Second constructor with 6 params
     *
     * @param firstName
     * @param lastName
     * @param height
     * @param weight
     * @param canTravel
     * @param smokes
     */
    public Model(String firstName, String lastName, int height, double weight, boolean canTravel, boolean smokes) {
        setFirstName(firstName);
        setLastName(lastName);
        setHeight(height);
        setWeight(weight);
        this.canTravel = canTravel;
        this.smokes = smokes;
    }

    /**
     * Third constructor with 4 params
     * @param firstName
     * @param lastName
     * @param height
     * @param weight
     */
    public Model(String firstName, String lastName, int height, double weight) {
        this(firstName, lastName, height, weight, false, false);
    }

    public String getHeightInFeetAndInches() {
        // 1 foot == 12 inches
        int feet = height / INCHES_PER_FOOT;
        int inches = height % INCHES_PER_FOOT;
        String inchUnit;
        if (inches == 0) {
            inchUnit = "";
        } else if (inches == 1) {
            inchUnit = "1 inch";
        } else {
            inchUnit = inches + " inches";
        }
        return feet + " feet " + inchUnit;
    }

    public long getWeightKg() {
        return Math.round(weight / POUNDS_PER_KG);
    }

    public String getFirstName() {
        return firstName;
    }

    public final void setFirstName(String firstName) {
        if (firstName.length() >= 3 && firstName.length() <= 20) {
            this.firstName = firstName;
        }
    }

    public String getLastName() {
        return lastName;
    }

    public final void setLastName(String lastName) {
        if (lastName.length() >= 3 && lastName.length() <= 20) {
            this.lastName = lastName;
        }
    }

    public int getHeight() {
        return height;
    }

    public final void setHeight(int height) {
        if (height >= 24 && height <= 84) {
            this.height = height;
        }
    }

    public void setHeight(int feet, int inches) {
        this.height = feet * INCHES_PER_FOOT + inches;
    }

    public double getWeight() {
        return weight;
    }

    public final void setWeight(double weight) {
        if (weight >= 80 && weight <= 280) {
            this.weight = weight;
        }
    }

    public void setWeight(long kilograms) {
        this.weight = kilograms * POUNDS_PER_KG;
    }

    public boolean isCanTravel() {
        return canTravel;
    }

    public void setCanTravel(boolean canTravel) {
        this.canTravel = canTravel;
    }

    public boolean isSmokes() {
        return smokes;
    }

    public void setSmokes(boolean smokes) {
        this.smokes = smokes;
    }

    public void printDetails() {
        System.out.println("Name: " + firstName + " " + lastName);
        System.out.println("Height: " + height + " inches");
        System.out.println("Weight: " + weight + " pounds");
        String travelMessage = canTravel ? "Does travel" : "Does not travel";
        System.out.println(travelMessage);
        String smokeMessage = smokes ? "Does smoke" : "Does not smoke";
        System.out.println(smokeMessage);
    }

    public int calculatePayDollarsPerHour() {
        int salary = BASE_RATE_DOLLARS_PER_HOUR;
        if (height > TALL_INCHES && weight < THIN_POUNDS) {
            salary += TALL_THIN_BONUS_DOLLARS_PER_HOUR;
        }
        if (canTravel) {
            salary += TRAVEL_BONUS_DOLLARS_PER_HOUR;
        }
        if (smokes) {
            salary -= SMOKER_DEDUCTION_DOLLARS_PER_HOUR;
        }
        return salary;
    }

    public void displayModelDetails() {
        System.out.println("Name: " + firstName + " " + lastName);
        System.out.println("Height: " + getHeightInFeetAndInches());
        System.out.println("Weight: " + getWeight() + " pounds");
        String travelMessage = canTravel ? "yep" : "nope";
        System.out.println("Travels: " + travelMessage);
        String smokeMessage = smokes ? "yep" : "nope";
        System.out.println("Smokes: " + smokeMessage);
        System.out.println("Hourly rate: $" + calculatePayDollarsPerHour());
    }
}

