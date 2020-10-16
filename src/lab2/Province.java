package lab2;

import java.util.Arrays;

public class Province {
    // data field
    // constants
    public static final int DEFAULT_POPULATION = 4648055;
    public static final String DEFAULT_PROVINCE = "British Columbia";
    public static final String DEFAULT_CAPITAL = "Victoria";

    // 3 instance variables
    private String province;
    private String capital;
    private long population;


    /**
     * Constructor
     * @param province
     * @param capital
     * @param population
     */
    public Province(String province, String capital, long population){
        if ((isValidPopulation(population)) && (isValidProvince(province))
        && (isValidCapitalCity(capital))) {

            this.province = province;
            this.capital = capital;
            this.population = population;
        } else {
            // if there is any error; create the default data, shown below
            this.population = DEFAULT_POPULATION;
            this.province = DEFAULT_PROVINCE;
            this.capital = DEFAULT_CAPITAL;
        }
    }

    /**
     * Helper methods for constructor; check validity of provinces
     * @param province
     * @return
     */
    private boolean isValidProvince(String province){
        String[] provinces = {
                "Ontario",
                "Quebec",
                "Nova Scotia",
                "New Brunswick",
                "Manitoba",
                "British Columbia",
                "Prince Edward Island",
                "Saskatchewan",
                "Alberta",
                "Newfoundland and Labrador"
        };
        // check if the array of provinces contains the province
        for (String prov : provinces) {
            if (prov.equals(province)) {
                return true;
            }
        }
        return false;
    }


    /**
     * Helper method for constructor; check validity of capitals
     * @param capital
     * @return
     */
    private boolean isValidCapitalCity(String capital){
        String[] capitals = {
                "Toronto",
                "Quebec City",
                "Halifax",
                "Fredericton",
                "Winnipeg",
                "Victoria",
                "Charlottetown",
                "Regina",
                "Edmonton",
                "St. John's"
        };
        // check if the array of capitals contains the capital
        for (String cap : capitals) {
            if(cap.equals(capital)){
            return true;
            }
        }
        return false;
    }

    /**
     * Helper method for constructor; check validity of population
     * @param population
     * @return
     */
    private boolean isValidPopulation(long population){
        if(population >= 30000 && population <= 15000000){
            return true;
        }else{
            return false;
        }
    }

    /**
     * accessor(getter) method
     * @return province
     */
    public String getProvince(){
        return province;
    }

    /**
     * accessor(getter) method
     * @return capital
     */
    public String getCapital(){
        return capital;
    }

    /**
     * accessor (getter) method
     * @return population
     */
    public long getPopulation(){
        return population;
    }



    /**
     * mutator(setter) method
     * @param province
     */
    public void setProvince(String province){
        if (isValidProvince(province)){
            this.province = province;
        }
    }

    /**
     * mutator(setter) method
     * @param capital
     */
    public void setCapital(String capital){
        if(isValidCapitalCity(capital)){
            this.capital = capital;
        }
    }

    /**
     * mutator(setter) method
     * @param population
     */
    public void setPopulation(long population){
        if(isValidPopulation(population)){
            this.population = population;
        }
    }

    /**
     * method to get details of the province
     * @return String
     */
    public String getDetails(){
        String str = String.format("The capital of %s (population. %d) is %s.", province, population, capital);
        return str;
    }

}


