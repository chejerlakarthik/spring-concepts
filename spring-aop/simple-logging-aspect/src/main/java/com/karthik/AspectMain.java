package com.karthik;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class AspectMain 
{
    public static void main( String[] args )
    {
       AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(SpringConfiguration.class);
       ctx.registerShutdownHook();
      
       Circle circle = ctx.getBean("circle", Circle.class);
       circle.getArea(25.0);
       
       circle.getArea(5.0);
       
       ctx.close();
    }
}
