package io.jeffchang.stackoverflowlist.models;

import com.squareup.moshi.Json;

import org.jetbrains.annotations.NotNull;

public class BadgeCounts {

	@Json(name = "gold")
	private int gold;

	@Json(name = "silver")
	private int silver;

	@Json(name = "bronze")
	private int bronze;

	public void setGold(int gold){
		this.gold = gold;
	}

	public int getGold(){
		return gold;
	}

	public void setSilver(int silver){
		this.silver = silver;
	}

	public int getSilver(){
		return silver;
	}

	public void setBronze(int bronze){
		this.bronze = bronze;
	}

	public int getBronze(){
		return bronze;
	}

	@NotNull
	@Override
 	public String toString(){
		return 
			"BadgeCounts{" + 
			"gold = '" + gold + '\'' + 
			",silver = '" + silver + '\'' + 
			",bronze = '" + bronze + '\'' + 
			"}";
		}
}