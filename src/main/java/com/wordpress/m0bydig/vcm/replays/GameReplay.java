package com.wordpress.m0bydig.vcm.replays;

public class GameReplay {
	private String replayDownloadUrl;
	private Team blueTeam; 
	private Team redTeam;
	private long replayRating;
	private String region;
	private String tier;
	private String winningTeam;
	private String duration;
	private int durationSeconds;
	private String date;
	private String queue;
	private String matchUrl;
	
	public String getReplayDownloadUrl() {
		return replayDownloadUrl;
	}
	
	public void setReplayDownloadUrl(String replayDownloadUrl) {
		this.replayDownloadUrl = replayDownloadUrl;
	}
	
	public Team getBlueTeam() {
		return blueTeam;
	}
	
	public void setBlueTeam(Team blueTeam) {
		this.blueTeam = blueTeam;
	}
	
	public Team getRedTeam() {
		return redTeam;
	}
	
	public void setRedTeam(Team redTeam) {
		this.redTeam = redTeam;
	}
	
	public long getReplayRating() {
		return replayRating;
	}
	
	public void setReplayRating(long replayRating) {
		this.replayRating = replayRating;
	}
	
	public String getRegion() {
		return region;
	}
	
	public void setRegion(String region) {
		this.region = region;
	}
	
	public String getTier() {
		return tier;
	}
	
	public void setTier(String tier) {
		this.tier = tier;
	}
	
	public String getWinningTeam() {
		return winningTeam;
	}
	
	public void setWinningTeam(String winningTeam) {
		this.winningTeam = winningTeam;
	}
	
	public String getDuration() {
		return duration;
	}
	
	public void setDuration(String duration) {
		this.duration = duration;
	}
	
	public int getDurationSeconds() {
		return durationSeconds;
	}
	
	public void setDurationSeconds(int durationSeconds) {
		this.durationSeconds = durationSeconds;
	}
	
	public String getDate() {
		return date;
	}
	
	public void setDate(String date) {
		this.date = date;
	}
	
	public String getQueue() {
		return queue;
	}
	
	public void setQueue(String queue) {
		this.queue = queue;
	}
	
	public String getMatchUrl() {
		return matchUrl;
	}
	
	public void setMatchUrl(String matchUrl) {
		this.matchUrl = matchUrl;
	}

	@Override
	public String toString() {
		return "GameReplay [replayDownloadUrl=" + replayDownloadUrl + ", blueTeam=" + blueTeam + ", redTeam=" + redTeam
				+ ", replayRating=" + replayRating + ", region=" + region + ", tier="
				+ tier + ", winningTeam=" + winningTeam + ", duration=" + duration + ", durationSeconds="
				+ durationSeconds + ", date=" + date + ", queue=" + queue + ", matchUrl=" + matchUrl + "]";
	}
	
}
