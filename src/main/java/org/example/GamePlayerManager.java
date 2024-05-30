package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GamePlayerManager implements IGamePlayerManager {

	private HashMap<String, String> playerList = new HashMap<>();
	private HashMap<String, Integer> playerDetails = new HashMap<>();
	private int playerScore = 0;

	@Override
	public void registerPlayer(String playerId, String playerName) {
		playerList.put(playerId, playerName);
		playerDetails.put(playerId, playerScore);
	}

	@Override
	public String getPlayerDetails(String playerId) {
		for (Map.Entry<String, String> set :
				playerList.entrySet()) {
			if (set.getKey().equals(playerId)) {
				return set.getKey() + ", " + set.getValue();
			}
		}
		return null;
	}

	@Override
	public void updatePlayerScore(String playerId, int scoreToAdd) {
		for (Map.Entry<String, Integer> set :
				playerDetails.entrySet()) {
			if (set.getKey().equals(playerId)) {
				set.setValue(set.getValue() + scoreToAdd);
			}
		}
	}

	@Override
	public boolean checkLevelUp(String playerId) {
		for (Map.Entry<String, Integer> set :
				playerDetails.entrySet()) {
			if (set.getKey().equals(playerId)) {
				int score = set.getValue();
				if (score == 100) {
					updatePlayerScore(playerId, 0);
					return true;
				}
			}
		}
		return false;
	}

	@Override
	public boolean deletePlayer(String playerId) {
		for (Map.Entry<String, String> set :
				playerList.entrySet()) {
			if (set.getKey().equals(playerId)) {
				playerList.remove(playerId);
				return true;
			}
		}
		return false;
	}

	@Override
	public String toString() {
		return "%s,%s";
	}
}
