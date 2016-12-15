package main;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils.Collections;

import beans.Car;
import beans.Cat;
import beans.Human;

public class Main {
	
	public static List<Marker> listOfBeans;
	
	public static void main(String[] args) {
		
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		
		Car car = new Car();
		Cat cat = new Cat();
		Human human = new Human();
		
		listOfBeans = Arrays.asList(car, cat, human);
		
		String inputBean;
		
		do{
			inputBean = scan.nextLine();
			selectObj(inputBean);

		}while(!inputBean.equals("exit"));
		System.exit(0);
	}
	
	public static void selectObj(String inputBean){
		listOfBeans.stream()
					.filter( a -> a.getClass().getSimpleName().equals(inputBean) )
					.forEach(Manager::new);
	}
}
