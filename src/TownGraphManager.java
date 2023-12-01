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

import java.util.*;
import java.io.*;

public class TownGraphManager implements TownGraphManagerInterface{

	private Graph graph = new Graph();
	
	//constructor
	public TownGraphManager(Graph graph) {
		super();
		this.graph = graph;
	}
	
	//default constructor
	public TownGraphManager() {
		super();
	}

	//get graph
	public Graph getGraph() {
		return graph;
	}
	//set graph
	public void setGraph(Graph graph) {
		this.graph = graph;
	}
	//hash code 
	@Override
	public int hashCode() {
		return Objects.hash(graph);
	}
	//equals method
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TownGraphManager other = (TownGraphManager) obj;
		return Objects.equals(graph, other.graph);
	}
	
	//to string
	@Override
	public String toString() {
		return "TownGraphManager [graph=" + graph + "]";
	}
	@Override
	public boolean addRoad(String town1, String town2, int weight, String roadName) {
		Town t1 = new Town(town1);
		Town t2 = new Town (town2);
		try {
			graph.addEdge(t1, t2, weight, roadName);
		}catch(Exception e) {
			
		}
		
		if (graph.containsEdge(t1, t2)) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public String getRoad(String town1, String town2) {
		Town t1 = new Town(town1);
		Town t2 = new Town (town2);
		if (graph.getEdge(t1, t2) == null) {
			return null;
		}
		else {
			return graph.getEdge(t1,t2).getName();
		}
	}

	@Override
	public boolean addTown(String v) {
		Town town = new Town(v);
		boolean b = graph.addVertex(town);
		return b;
	}

	@Override
	public Town getTown(String name) {
		Set<Town> towns = graph.getTowns();
		Iterator<Town> it = towns.iterator();
		while(it.hasNext()) {
			Town t = it.next();
			if (t.getName().equals(name)) {
				return t;
			}
		}
		return null;
	}

	@Override
	public boolean containsTown(String v) {
		Town town = new Town(v);
		boolean b = graph.containsVertex(town);
		return b;
	}

	@Override
	public boolean containsRoadConnection(String town1, String town2) {
		Town t1 = new Town (town1);
		Town t2 = new Town(town2);
		boolean b = graph.containsEdge(t1, t2);
		return b;
	}

	@Override
	public ArrayList<String> allRoads(){
		ArrayList<String> allRoads = new ArrayList<>();
		Set<Road> roads = graph.edgeSet();
		Iterator <Road> it = roads.iterator();
		for (int i = 0; i < roads.size(); i++) {
			Road r = it.next();
			String roadName = r.getName();
			allRoads.add(roadName);	
		}
		Collections.sort(allRoads);
		return allRoads;
	}
	
	@Override
	public boolean deleteRoadConnection(String town1, String town2, String road) {
		if(graph.containsEdge(new Town(town1), new Town(town2))) {
			graph.removeEdge(new Town(town1), new Town(town2), graph.getEdge(new Town(town1), new Town(town2)).getWeight(), road);
			return true;
		}else {
			return false;
		}
	}

	@Override
	public boolean deleteTown(String v) {
		Town town = new Town(v);
		boolean b = graph.removeVertex(town);
		return b;
	}

	@Override
	public ArrayList<String> allTowns() {
		ArrayList<String> allTowns = new ArrayList<>();
		Set<Town> towns = graph.vertexSet();
		Iterator<Town> it = towns.iterator();
		for(int i =0; i < towns.size(); i++) {
			Town t = it.next();
			allTowns.add(t.getName());
		}
		Collections.sort(allTowns);
		return allTowns;
	}

	@Override
	public ArrayList<String> getPath(String town1, String town2) {
		Town t1 = new Town(town1);
		Town t2 = new Town(town2);
		ArrayList<String> path= graph.shortestPath(t1, t2);
		boolean hasTemp = false;
		for (String p : path) {
		    if (p.contains("temp")) {
		        hasTemp = true;
		        break;
		    }
		}
		if (hasTemp) {
		    return new ArrayList<String>();
		} else {
		    return path;
		}
	}
	
	public void populateTownGraph(File selectedFile) throws FileNotFoundException, IOException {
	    try (Scanner readFile = new Scanner(selectedFile)) {
	        while (readFile.hasNextLine()) {
	            String[] data = readFile.nextLine().split(";");
	            Town source = new Town(data[1]);
	            Town destination = new Town(data[2]);
	            graph.addVertex(source);
	            graph.addVertex(destination);
	            data = data[0].split(",");
	            int weight = Integer.parseInt(data[1]);
	            String name = data[0];
	            graph.addEdge(source, destination, weight, name);
	        }
	        readFile.close();
	    }
	    catch(Exception e) {
	    	e.printStackTrace();
	    }
	}
}
