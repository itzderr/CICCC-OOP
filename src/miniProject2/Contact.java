package miniProject2;

/**/
public class Contact {
    // instance variables
    private int index;
    private String name;
    private String mobile;
    private String work;
    private String home;
    private String city;

    public Contact(int index, String name, String mobile, String work, String home, String city){
        this.index = index;
        this.name = name;
        this.mobile = mobile;
        this.work = work;
        this.home = home;
        this.city = city;

    }

    // default constructor
    public Contact(){
        this.index = index;
        setName(name);
        setMobile(mobile);
        setCity(city);
        setWork(work);
        setHome(home);
        setCity(city);
    }

    // getter
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


    // setter
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


    @Override
    public String toString() {
        String str1 =  getIndex() + ". <" + getName() + ">" + " (mobile=" + getMobile()  ;

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
