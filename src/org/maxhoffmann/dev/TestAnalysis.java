package org.maxhoffmann.dev;

import java.util.*;
import org.hi

public class TestAnalysis {
	
	private SessionFactory sessionFactory;
	
	public static void main(String[] args) {
		
		System.out.println("---------------");
		System.out.println("Initializing Hibernate!");
		sessionFactory = new Configuration().configure().buildSessionFactory();
		
		
		
		System.out.println("Dies ist ein Test!\nZweite Zeile");
	}

}
