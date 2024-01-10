package business.baelle;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BallTest {

	private Ball ball;
	
	@BeforeEach
	void setUp() throws Exception {
		this.ball = new Ball(2013081, "Leder", null, "in Gebrauch", "Spiel", -50);
	}

	@AfterEach
	void tearDown() throws Exception {
		this.ball = null;
	}

	@Test
	void test() {
		assertTrue(this.ball.ueberpruefeSportart() == false, "Das Ergebnis muss false ergeben");
		
		this.ball.setSportart("Fußball");
		assertTrue(this.ball.ueberpruefeSportart() == true, "Das Ergebnis muss true ergeben");
	}

}
