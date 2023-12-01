/*
 * Class: CMSC204
 * CRN:21078
 * Instructor: Monshi
 * Description: Dijkstra's algorithm for shortest path between two vertices
 * Due: 5/10/23
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming 
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: __Akhil Gunda______
*/

import java.util.ArrayList;

public class Town implements Comparable<Town> {
	//name of town
	String name;
	//list of adjacent towns
	ArrayList<Town> adjTowns;
	
	//constructor with name & adjacent towns list
	public Town(String townName, ArrayList<Town> adjTowns) {
		super();
		this.name = townName;
		this.adjTowns = adjTowns;
	}
	
	//default constructor
	public Town() {
		this.name = null;
		this.adjTowns = null;
	}
	
	//constructor with just town name
	public Town(String townName) {
		super();
		this.name = townName;
	}
	
	//getter
	public String getName()
	{
		return this.name;
	}
	
	//copy constructor
	public Town(Town town) {
		this.name = town.getTownName();
		this.adjTowns = town.getAdjTowns();
	}
	
	//getters and setters
	//get town name
	public String getTownName() {
		return name;
	}

	//set town name
	public void setTownName(String townName) {
		this.name = townName;
	}

	//get adjacenct towns list
	public ArrayList<Town> getAdjTowns() {
		return adjTowns;
	}
	//set adjacent towns list
	public void setAdjTowns(ArrayList<Town> adjTowns) {
		this.adjTowns = adjTowns;
	}
	
	//compare to method
	@Override
	public int compareTo(Town o) {
		return getTownName().compareTo(o.getTownName());
	}
	
	//to string method that returns name
	@Override
	public String toString() {
		return getTownName();
	}
	
	//hash code method
	@Override
	public int hashCode() {
		final int prime = 19;
		int result = 1;
		result = prime* result + name.hashCode();
		return result;
	}

	//checks if two town objects are equal
	@Override
	public boolean equals(Object obj) {	
		if(obj instanceof Town) {
			Town t = (Town) obj;
			return name.equals(t.getName());
		}
		return false;
	}
}
