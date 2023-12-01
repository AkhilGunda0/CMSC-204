


import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class TownGraphManager_STUDENT_Test {
	private TownGraphManagerInterface graph;
	private String[] town;
	  
	@Before
	public void setUp() throws Exception {
		  graph = new TownGraphManager();
		  town = new String[12];
		  
		  for (int i = 1; i < 12; i++) {
			  town[i] = "StudentTown_" + i;
			  graph.addTown(town[i]);
		  }
		  
		  graph.addRoad(town[1], town[2], 2, "BatRoad");
		  graph.addRoad(town[1], town[3], 2, "FlashRoad");
		  graph.addRoad(town[2], town[3], 2, "SuperRoad");
	}

	@After
	public void tearDown() throws Exception {
		graph = null;
	}

	@Test
	public void testAddRoad() {
		ArrayList<String> roads = graph.allRoads();
		assertEquals("BatRoad", roads.get(0));
		assertEquals("FlashRoad", roads.get(1));
		assertEquals("SuperRoad", roads.get(2));
	}
}