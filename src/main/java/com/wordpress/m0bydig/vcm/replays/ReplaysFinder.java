package com.wordpress.m0bydig.vcm.replays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.LinkedList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.wordpress.m0bydig.vcm.exceptions.HttpConnectionException;

public class ReplaysFinder {
	private static final String LOL_KING_REPLAYS_URL = "http://www.lolking.net/replays?platform=KR&lks=2900";
	
	public static String findReplay() throws HttpConnectionException {
		HttpURLConnection connection = null;
		
		try {
			URL url = new URL(LOL_KING_REPLAYS_URL);
			connection = (HttpURLConnection) url.openConnection();
			connection.setRequestMethod("GET");
			connection.setRequestProperty("accept", "text/html");
			
			if (connection.getResponseCode() != 200) {
				throw new HttpConnectionException("Failed - HTTP error code : "
						+ connection.getResponseCode());
			}
	
			try (BufferedReader br = new BufferedReader(
					new InputStreamReader((connection.getInputStream())))) {
				StringBuilder htmlPageResult = new StringBuilder();
				String line;
		
				while ((line = br.readLine()) != null) {
					htmlPageResult.append(line + '\n');
				}
				
				parseHtml(htmlPageResult);
			}
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (connection != null) {
				connection.disconnect();
			}
		}
		
		return null;
	}

	private static void parseHtml(StringBuilder htmlPageResult) {
		Document doc = Jsoup.parse(htmlPageResult.toString());
//		Elements gamesPlayed = doc.select("#leftcol.replays > table");
		List<GameReplay> allGames = new LinkedList<GameReplay>();
		Elements summaries = doc.select("div.summary");
		Elements blueTeams = doc.select("div.player-table-100");
		Elements redTeams = doc.select("div.player-table-200");
		
		int maxLength = summaries.size();
		
		for (int index = 0; index < maxLength; index++) {
			Element summary = summaries.get(index);
			Element blueTeam = blueTeams.get(index);
			Element redTeam = redTeams.get(index);
			GameReplay gameInfo = getGameGeneralInfo(summary, blueTeam, redTeam);
			allGames.add(gameInfo);
//			break;
		}
		
		for (GameReplay gameReplay : allGames) {
			System.out.println(gameReplay);
		}
	}

	private static GameReplay getGameGeneralInfo(Element summary, Element blueTeam, Element redTeam) {
		GameReplay game = new GameReplay();
		
		// Get summary
		String region = summary.select("label").get(1).text();
		game.setRegion(region);
		String tier = summary.select("label").get(3).text();
		game.setTier(tier);
		String winningTeam = summary.select("label").get(5).text();
		game.setWinningTeam(winningTeam);
		String matchDuration = summary.select("label").get(7).text();
		game.setDuration(matchDuration);
		String date = summary.select("label").get(9).text();
		game.setDate(date);
		String queue = summary.select("label").get(11).text();
		game.setQueue(queue);
		
		// Get blue team info
		
		
		// Get red team info
		
		
		return game;
	}
}
