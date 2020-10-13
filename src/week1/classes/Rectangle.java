package week1.classes;

public class Rectangle {
    // Data field
    private int width;
    private int height;
    private String color;
    // Constructor (default)
    Rectangle(){
        this.width = 1;
        this.height = 1;
        this.color = "Blue";
    }

    // Constructor
    Rectangle(int width, int height, String color){
        this.width = width;
        this.height = height;
        this.color = color;
    }

    // Methods------------
    // getter methods
    public int getWidth(){
        return width;
    }
    public int getHeight(){
        return height;
    }
    public String getColor(){
        return color;
    }

    // setter methods
    public void setWidth(int width){
        if (width > 0 && width < 10){
            this.width = width;
        } else{
            this.width = 1;
        }
    }

    public void setHeight(int height){
        if (height > 0 && height < 10){
            this.height = height;
        } else{
            this.height = 1;
        }
    }

    public void setColor(String color){
        char firstChar = color.charAt(0);
        int stringLength = color.length();
        if (Character.isUpperCase(firstChar) && stringLength > 2 &&
        stringLength < 20){
            this.color = color;
        } else {
            this.color = "Blue";
        }
    }

    // draw
    public void draw(){
        char firstChar = color.charAt(0);
        for (int i = 0; i <= height ; i++){
            for(int j = 0; j <= width; j++){
                System.out.print(firstChar);
            }
            System.out.println("");
        }
    }



}
