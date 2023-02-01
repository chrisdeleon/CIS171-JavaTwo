/*  
*    Chris de Leon
*    1/31/2023
*    Geometric Objects Comparable 
*/

package com.mycompany.exercise13_5;

public class Rectangle extends GeometricObject {
    private double width;
    private double height;
    
    public Rectangle(){
        
    }
    
    public Rectangle(double width, double height){
        this.width = width;
        this.height = height;
    }
    
    public double getWidth(){
        return width;
    }
    
    public void setWidth(double width){
        this.width = width;
    }
    
    public double getHeight(){
        return height;
    }
    
    public void setHeight(double height){
        this.height = height;
    }
    
    // two required classes below
    
    public double getArea(){
        return width * height;
    }
    
    public double getPerimeter(){
        return 2 * (width + height);
    }
}
