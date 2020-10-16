package lab2;

import java.util.Arrays;

public class Canada {
    // data field
    private Province[] provinces; /// String province declared in Province class

    // default constructor (when calling Canada, default provinces are set as below)
    public Canada(){
        provinces = new Province[10];
        provinces[0] = new Province("Ontario", "Toronto", 14734014);
        provinces[1] = new Province("Quebec", "Quebec City",8574571);
        provinces[2] = new Province("Nova Scotia","Halifax",979351);
        provinces[3] = new Province("New Brunswick","Fredericton",781476);
        provinces[4] = new Province("Manitoba","Winnipeg",1379263);
        provinces[5] = new Province("British Columbia","Victoria",5147712);
        provinces[6] = new Province("Prince Edward Island", "Charlottetown",159625);
        provinces[7] = new Province("Saskatchewan","Regina",1178681);
        provinces[8] = new Province("Alberta","Edmonton",4421876);
        provinces[9] = new Province("Newfoundland and Labrador","St. John's",522103);
    }

    /**
     * a method to print all the provinces information
     */
    public void displayAllProvinces(){
        for (Province province : provinces){
            System.out.println(province.getDetails());
        }
    }

    /**
     * a method to get total number of provinces with population within the range
     * @param min
     * @param max
     * @return
     */
    public int getNumOfProvincesBetween(int min, int max) {
        int minRev = min * 1000000;
        int maxRev = max * 1000000;
        int count = 0;

        for (Province province : provinces) {
            if (province.getPopulation() > minRev && province.getPopulation() < maxRev) {
                count += 1;
            }
        }
        return count;
    }
}
