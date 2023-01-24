import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GradeBookTest {

	private GradeBook G1, G2, G3;
	
	@BeforeEach
	void setUp() throws Exception {
		
		G1 = new GradeBook(2);
		G2 = new GradeBook(5);
		G3 = new GradeBook(3);

		G1.addScore(97);
		G1.addScore(91);
		
		G2.addScore(19);
		G2.addScore(14);
		G2.addScore(56);
		G2.addScore(67);
		G2.addScore(70);
		
		G3.addScore(88);
		G3.addScore(70);

	}

	@AfterEach
	void tearDown() throws Exception {
		G1 = G2 = G3 =  null;
	}

	@Test
	void testAddScore() {
		//part 1
		G3.addScore(94);
		assertTrue(G3.toString().equals("88.0, 70.0, 94.0"));
		//part 2
		assertEquals(3, G3.getScoreSize());
	}

	@Test
	void testSum() {
		assertEquals(226, G2.sum());
	}

	@Test
	void testMinimum() {
		assertEquals(14, G2.minimum());
	}

	@Test
	void testFinalScore() {
		assertEquals(212, G2.finalScore());
	}

	@Test
	void testGetScoreSize() {
		assertEquals(2, G1.getScoreSize());
	}

	@Test
	void testToString() {
		assertTrue("97.0, 91.0".equals(G1.toString()));
	}

}
