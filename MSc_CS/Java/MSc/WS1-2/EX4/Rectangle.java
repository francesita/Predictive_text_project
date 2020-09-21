/**
*   The following code is buggy. Why?
*   Answer:The reason that the code is buggy is that the value of area is not able to be calculated if an argument for area is provided. The computer will assign that value to area, even if that is not the 
*   value the variable 'area'should have. With my solution, everytime the height or width is provided, the value for 
*   area will be calculated, so the value will depend on height and width. I think that since the height and width are private variables, the area will be protected from being changed, and in fact, there is *   no variable for area any longer, so I think that the security aspect of the problem is solved as well.
*   
*    Code revised by Frances Laureano De Leon 
*    Date: 22/10/18
*
*   Manferd's JavaDoc Notes:
*
*  We define a rectangle by the three field variables width, height,
*  and area, each of type double. Furthermore, we write getters and
*  setters for the three fields as well as a toString method. We test
*  it in a main method.
*
*  @version 2018-08-31
*  @author Manfred Kerber
*/
public class Rectangle {
private double width;
private double height;

/**
*  <pre>
*  width
*  +--------------------------------------+
*  |                                      |
*  |                                      |
*  |       area = width * height          |  height
*  |                                      |
*  |                                      |
*  +--------------------------------------+
*  </pre>
*  @param width The width of the rectangle.
*  @param height The height of the rectangle.
*  @param area The area of the rectangle.
*/
public Rectangle(double width, double height) {
this.width  = width;
this.height = height;
}

public double getWidth() {
return width;
}

public double getHeight() {
return height;
}

public void setWidth(double width) {
this.width = width;
}

public void setHeight(double height) {
this.height = height;
}

public double getArea() {
return height * width;
}

public String toString() {
return "The rectangle has a width of " + width +
", a height of " + height +
", and an area of " + getArea() + ".";
}


public static void main(String[] args) {
Rectangle r = new Rectangle(2, 4);
System.out.println(r);
r.setHeight(5);
System.out.println(r);
}
}


