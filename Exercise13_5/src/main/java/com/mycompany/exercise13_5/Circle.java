/*  
*    Chris de Leon
*    1/31/2023
*    Geometric Objects Comparable 
*/

package com.mycompany.exercise13_5;

public class Circle extends GeometricObject {
    private double radius;
    
    public Circle(){
        
    }
    
    public Circle (double radius){
        this.radius = radius;
    }
    
    public double getRadius(){
        return radius;
    }
    
    public void setRadius(double radius){
        this.radius = radius;
    }
    
    
    // the two methods below are the abstract classes that GeometricObjects forces subclasses to use
    
    public double getArea(){
        return radius * radius * Math.PI;
    }
    
    public double getPerimeter(){
        return 2*radius * Math.PI;
    }
    
    public void printCircle(){
        System.out.println("The circle is created " + getDateCreated() +
                " and the radius is " + radius);
    }
}
