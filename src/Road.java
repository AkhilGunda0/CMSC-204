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


public class Road implements Comparable<Road> {
	private Town[] endpoints = new Town[2];
	int weight;
	String name;
	
	//default constructor
	public Road() {
		endpoints[0] = endpoints[1] = null;
		this.name = null;
		weight = 0;
	}
	
	//constructor
	public Road(Town start, Town end, int distance, String name) {
		endpoints[0] = start;
		endpoints[1] = end;
		this.weight = distance;
		this.name = name;
	}
	
	//no distance
	public Road(Town start, Town end, String name) {
		endpoints[0] = start;
		endpoints[1] = end;
		this.weight = 0;
		this.name = name;
	}
	
	//constructor with endpoints & name
	public Road(Town[] endpoints, String name, int weight) {
		super();
		this.endpoints = endpoints;
		this.name = name;
		this.weight = weight;
	}
	
	//getters and setters
	public Town getStart() {
		return endpoints[0];
	}

	public Town getDestination() {
		return endpoints[1];
	}
	public Town[] getEndpoints() {
		return endpoints;
	}

	public void setEndpoints(Town[] endpoints) {
		this.endpoints = endpoints;
	}

	public int getDistance() {
		return weight;
	}
	
	public int getWeight() {
		return weight;
	}

	public void setDistance(int distance) {
		this.weight = distance;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public int compareTo(Road o) {
		return this.name.compareTo(o.getName());
	}
	
	@Override
	public String toString() {
		return "Road Source = " + endpoints[0] + "and Destination = " + endpoints[1] + ", weight = " + weight + ", name = " + name;
	}
	
	public boolean hasEndpoint(Town t) {
		return (endpoints[0].equals(t) || endpoints[1].equals(t));
	}
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Road) {
			Road r = (Road) obj;
			Boolean b = r.hasEndpoint(endpoints[0]) && r.hasEndpoint(endpoints[1]);
			return b;
		}
		return false;
	}
	
	public Town getOtherTown(Road r, Town t) {
		if (r.getStart().equals(t)) {
			return r.getDestination();
		}
		else if (r.getDestination().equals(t)) {
			return r.getStart();
		}
		else {
			throw new IllegalArgumentException();
		}
	}
}























