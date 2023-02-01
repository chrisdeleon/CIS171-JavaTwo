/*  
*    Chris de Leon
*    1/31/2023
*    Geometric Objects Comparable 
*/

package com.mycompany.exercise13_5;

public class Exercise13_5 {

    public static void main(String[] args) {
        // declare and initialize two geometric objects
        
        GeometricObject geoObject1 = new Circle(5);
        GeometricObject geoObject2 = new Rectangle(5,3);
        

        GeometricObject geoObject3 = new Circle(8);
        GeometricObject geoObject4 = new Rectangle(8,5);
        
        
        System.out.println("The two object have the same area?");
        
        // display circle
        displayGeometricObject(geoObject1);
        
        // display rectangle
        displayGeometricObject(geoObject2);
        
        // implements the comparable in main method
        
        System.out.println(geoObject1.compareTo(geoObject2));
        
        // implements the max method
        
        System.out.println(GeometricObject.max(geoObject1, geoObject2));
        
        // displays the larger of two circles
        
        System.out.println("-----------------------");
        System.out.println(GeometricObject.max(geoObject1, geoObject3));
        System.out.println("-----------------------");
        
        // displays the larger of two rectangles
        
        System.out.println("-----------------------");
        System.out.println(GeometricObject.max(geoObject2, geoObject4));
        System.out.println("-----------------------");
    }
    
    // this method compares the area of two geometric objects
    public static boolean equalArea(GeometricObject object1, GeometricObject object2){
        return object1.getArea() == object2.getArea();
    }
    
    
    // this method displays the geometric object
    public static void displayGeometricObject(GeometricObject object){
        System.out.println();
        System.out.println("The area is " + object.getArea());
        System.out.println("The perimeter is " + object.getPerimeter());
    }
}
