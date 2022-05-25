package com.SpringFiesta1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	ApplicationContext context = new ClassPathXmlApplicationContext("context.xml");
    	 
		Fiesta fiesta = (Fiesta) (context.getBean("fiesta"));
 
		System.out.println(fiesta.celebrar());
		System.out.println(fiesta.terminar());
		
 
		((ClassPathXmlApplicationContext) context).close();

    }
}
