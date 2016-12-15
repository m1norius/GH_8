package main;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import beans.Car;
import beans.Cat;
import beans.Human;

public class Manager {

	private static Marker marker;
	
	public Manager(Marker marker){
		this.marker = marker;
		getData();
	}
	
	private void getData(){
		
		System.out.println(marker.getClass().getSimpleName());
		
		Class c = marker.getClass();
		
		for(Field cl : c.getDeclaredFields()){
			cl.setAccessible(true);
			try {
				Object o = cl.get(marker);
				System.out.print(cl.getName()+"...");
				System.out.println(o);
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}
		}
	}
}
