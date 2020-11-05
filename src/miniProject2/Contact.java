package miniProject2;

/**Contact class represents individual Contact information**/

public class Contact {
    // instance variables
    private int index;
    private String name;
    private String mobile;
    private String work;
    private String home;
    private String city;

    // constructors
    public Contact(int index, String name, String mobile, String work, String home, String city){
        this.index = index;
        this.name = name;
        this.mobile = mobile;
        this.work = work;
        this.home = home;
        this.city = city;
    }

    public Contact(){
        setIndex(index);
        setName(name);
        setMobile(mobile);
        setCity(city);
        setWork(work);
        setHome(home);
        setCity(city);
    }

    // getter methods
    public int getIndex(){
        return index;
    }
    public String getName(){
        return name;
    }
    public String getMobile(){
        return mobile;
    }
    public String getWork(){
        return work;
    }
    public String getHome(){
        return home;
    }
    public String getCity(){
        return city;
    }

    // setter methods
    public void setIndex(int index){
        this.index = index;
    }
    public void setName(String name){
        this.name = name;
    }
    public void setMobile(String mobile){
        this.mobile = mobile;
    }
    public void setWork(String work){
        this.work = work;
    }
    public void setHome(String home){
        this.home = home;
    }
    public void setCity(String city) {
        this.city = city;
    }


    /**
     * check validity of name: has to be more than one char and contains a space
     * @param name
     * @return boolean
     */
    public static boolean isNameValid(String name){
        if(name.length() > 1 && name.contains(" ")){
            return true;
        }
        return false;
    }


    /**
     * Align name format: always first letter of first name and last name to be capital letters
     * @param name
     * @return str
     */
    public static String nameFormat(String name){
        String str = "";
        char c;
        String storeName = name;
        for (int i = 0; i < storeName.length(); i++){
            c = storeName.charAt(i);
            if (i == 0){
                str = str + name.substring(i,i + 1).toUpperCase();
            } else if (Character.isWhitespace(c)){
                str = str + " " + name.substring(i + 1 , i + 2).toUpperCase();
                i = i+ 1;
            }
            else {
                str = str + name.substring(i, i + 1).toLowerCase();
            }
        }
        return str;
    }

    /**
     * Check phone number format
     * @param number
     * @return
     */
    public static boolean isValidNumber(String number) {

        if(number.length() == 12){
            String str = "-";
            String first = number.substring(3,4);
            String second = number.substring(7,8);
            if (first.equals(str) && second.equals(str)){
                return true;
            }
        }
        return false;
    }


    @Override
    public String toString() {
        String str1 =  getIndex() + ". <" + getName() + ">" + " (mobile=" + getMobile() ;

        if (getWork() == "" && getHome() =="" && getCity() == ""){
            return str1 + ")";
        }else if (getWork() == "" && getHome() == ""){
                String str2 = ", city=" + getCity() +")";
                return str1 + str2;
        }else if (getWork()== "" && getCity()== ""){
                String str25 = ", home=" + getHome() +")";
                return str1 + str25;
        }else if(getCity()=="" && getHome() == ""){
            String str26 = ", work=" + getWork() + ")";
            return str1 + str26;
        }else if(getWork() == ""){
               String str3 =  ", home=" + getHome() + ", city=" + getCity() +")";
               return str1 + str3;
        } else if (getHome() == ""){
                String str4 = ", work=" + getWork() + ", city=" + getCity() +")";
                return str1 + str4;
        } else if (getCity() == ""){
                String str5 = ", work=" + getWork() + ", home=" + getHome() + ")";
                return str1 + str5;
        } else {
            return str1 + ", work=" + getWork() + ", home=" + getHome() + ", city=" + getCity() +")";
        }
    }
}
