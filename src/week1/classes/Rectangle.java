package week1.classes;

/**
 * Rectangle class represents a rectangle object that has width, height, ...
 */
public class Rectangle {
    /* width, height, color as data fields */
    private int width;
    private int height;
    private String color;

    /* Method Overloading */
    /* Define a method with the same name (existing) but different set of parameters */
    public Rectangle(int width, int height) {
        this(width, height, "Blue");
    }

    /* Designated constructor */
    public Rectangle(int width, int height, String color) {
        setWidth(width);
        setHeight(height);
        setColor(color);
    }

    public void draw() {
        char firstLetter = color.charAt(0);
        for (int h = 0; h < height; h++) {
            for (int w = 0; w < width; w++) {
                System.out.print(firstLetter);
            }
            System.out.print('\n');
        }
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public String getColor() {
        return color;
    }

    public final void setWidth(int width) {
        this.width = (width > 0) ? width : 1;
    }

    public final void setHeight(int height) {
        this.height = (height > 0) ? height : 1;
    }

    public final void setColor(String color) {
        char firstLetter = color.charAt(0);
        if ((firstLetter >= 'A' && firstLetter <= 'Z')
                && color.length() > 2 && color.length() < 20) {
            this.color = color;
        } else {
            this.color = "Blue";
        }
    }
}
