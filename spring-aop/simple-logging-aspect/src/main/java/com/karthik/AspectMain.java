package com.karthik;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.karthik.model.Shape;


public class AspectMain 
{
    public static void main( String[] args )
    {
       AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(SpringConfiguration.class);
       ctx.registerShutdownHook();
       
       // Rectangle - Area
       Shape rectangle = ctx.getBean("rectangle", Shape.class);
       Double[] dimensions = getDimensions();
       dimensions[0] = 15.0;
       dimensions[1] = 10.0;
       rectangle.getArea(dimensions);
       
       // Rectangle - Perimeter
       rectangle.getPerimeter(dimensions);
       
       // Circle - Area
       Shape circle = ctx.getBean("circle", Shape.class);
       dimensions[0] = 25.0;
       circle.getArea(dimensions);

       // Circle - Perimeter
       circle.getPerimeter(dimensions);
       
		dimensions = getDimensions();
		dimensions[0] = 5.0; // Test that an exception is thrown
		
		try {
			circle.getArea(dimensions);
		} catch (IllegalArgumentException ex) {
			System.out.println("Illegal Argument Exception caught");
		}
       
       ctx.close();
    }

	private static Double[] getDimensions() {
		Double[] doubles = new Double[2];
		return doubles;
	}
}
