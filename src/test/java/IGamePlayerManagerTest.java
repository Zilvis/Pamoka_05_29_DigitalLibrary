import org.example.GamePlayerManager;
import org.example.IGamePlayerManager;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class IGamePlayerManagerTest {
	IGamePlayerManager iGamePlayerManager = new GamePlayerManager();
	HashMap<String, String> playerList;
	String player;
	String player2;
	int playerScore;

	@Before
	public void setUp() {
		iGamePlayerManager.registerPlayer("1", "Zaidejas1");
		player = iGamePlayerManager.getPlayerDetails("1");
		playerScore = 1;
	}

	@Test
	public void testRegisterPlayer() {
		// Act
		iGamePlayerManager.registerPlayer("2","Zaidejas2");
		player2 = iGamePlayerManager.getPlayerDetails("2");

		// Assert
		assertEquals("2, Zaidejas2", player2);
	}

	@Test
	public void getPlayerDetailsTest() {
		// Assert
		assertEquals("1, Zaidejas1", player);
	}

	@Test
	public void updatePlayerScoreTestPositive() {
		// Act
		iGamePlayerManager.updatePlayerScore("1",1);

		// Execute
		playerScore ++;

        // Assert
        assertEquals(2, playerScore);
	}

	@Test
	public void updatePlayerScoreTestNegative() {
		// Act
		iGamePlayerManager.updatePlayerScore("1",-1);
		playerScore --;

		// Assert
		assertEquals(0, playerScore);
	}

	@Test
	public void checkLevelUpTestPassFail(){
		// Assert
		assertEquals(false, iGamePlayerManager.checkLevelUp("1"));
	}

	@Test
	public void deletePlayerTestPass() {
        // Assert
		assertEquals(true ,iGamePlayerManager.deletePlayer("1"));
	}
}






















