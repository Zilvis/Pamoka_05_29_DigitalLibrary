import org.example.IGamePlayerManager;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class IGamePlayerManagerTest {
	IGamePlayerManager iGamePlayerManager;
	HashMap<String, String> playerList;
	String player;

	@Before
	public void setUp() {
		iGamePlayerManager.registerPlayer("1", "Zaidejas1");
		player = iGamePlayerManager.getPlayerDetails("1");
	}

	@Test
	public void testAddPlayer() {
		// Assert
		assertEquals("1", player.getPlayerId());
		assertEquals("Zaidejas1", player.getPlayerName());
	}

	@Test
	public void getPlayerDetailsTest() {
		// Assert
		assertEquals(player.toString(), "1, Zaidejas1");
	}

	@Test
	public void updatePlayerScoreTestPositive() {
		// Act
		iGamePlayerManager.updatePlayerScore(player,1);
        // Assert
        assertEquals(2, player.getScore);
	}

	@Test
	public void updatePlayerScoreTestNegative() {
		// Act
		iGamePlayerManager.updatePlayerScore(player,-1);
		// Assert
		assertEquals(0, player.getScore);
	}

	@Test
	public void checkLevelUpTest(){
		// Act
		iGamePlayerManager.checkLevelUp("1");
		// Assert
		assertEquals(1, player.getLevel);
	}

	@Test
	public void deletePlayerTestPass() {
        // Assert
		assertEquals(true ,iGamePlayerManager.deletePlayer("1"));
	}
}






















