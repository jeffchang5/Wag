package io.jeffchang.stackoverflowlist.models;

import com.squareup.moshi.Json;

public class StackOverflowUser {

	@Json(name = "reputation_change_quarter")
	private int reputationChangeQuarter;

	@Json(name = "link")
	private String link;

	@Json(name = "last_modified_date")
	private int lastModifiedDate;

	@Json(name = "last_access_date")
	private int lastAccessDate;

	@Json(name = "reputation")
	private int reputation;

	@Json(name = "badge_counts")
	private BadgeCounts badgeCounts;

	@Json(name = "creation_date")
	private int creationDate;

	@Json(name = "display_name")
	private String displayName;

	@Json(name = "reputation_change_year")
	private int reputationChangeYear;

	@Json(name = "accept_rate")
	private int acceptRate;

	@Json(name = "is_employee")
	private boolean isEmployee;

	@Json(name = "profile_image")
	private String profileImage;

	@Json(name = "account_id")
	private int accountId;

	@Json(name = "user_type")
	private String userType;

	@Json(name = "website_url")
	private String websiteUrl;

	@Json(name = "reputation_change_week")
	private int reputationChangeWeek;

	@Json(name = "user_id")
	private int userId;

	@Json(name = "reputation_change_day")
	private int reputationChangeDay;

	@Json(name = "location")
	private String location;

	@Json(name = "reputation_change_month")
	private int reputationChangeMonth;

	public void setReputationChangeQuarter(int reputationChangeQuarter){
		this.reputationChangeQuarter = reputationChangeQuarter;
	}

	public int getReputationChangeQuarter(){
		return reputationChangeQuarter;
	}

	public void setLink(String link){
		this.link = link;
	}

	public String getLink(){
		return link;
	}

	public void setLastModifiedDate(int lastModifiedDate){
		this.lastModifiedDate = lastModifiedDate;
	}

	public int getLastModifiedDate(){
		return lastModifiedDate;
	}

	public void setLastAccessDate(int lastAccessDate){
		this.lastAccessDate = lastAccessDate;
	}

	public int getLastAccessDate(){
		return lastAccessDate;
	}

	public void setReputation(int reputation){
		this.reputation = reputation;
	}

	public int getReputation(){
		return reputation;
	}

	public void setBadgeCounts(BadgeCounts badgeCounts){
		this.badgeCounts = badgeCounts;
	}

	public BadgeCounts getBadgeCounts(){
		return badgeCounts;
	}

	public void setCreationDate(int creationDate){
		this.creationDate = creationDate;
	}

	public int getCreationDate(){
		return creationDate;
	}

	public void setDisplayName(String displayName){
		this.displayName = displayName;
	}

	public String getDisplayName(){
		return displayName;
	}

	public void setReputationChangeYear(int reputationChangeYear){
		this.reputationChangeYear = reputationChangeYear;
	}

	public int getReputationChangeYear(){
		return reputationChangeYear;
	}

	public void setAcceptRate(int acceptRate){
		this.acceptRate = acceptRate;
	}

	public int getAcceptRate(){
		return acceptRate;
	}

	public void setIsEmployee(boolean isEmployee){
		this.isEmployee = isEmployee;
	}

	public boolean isIsEmployee(){
		return isEmployee;
	}

	public void setProfileImage(String profileImage){
		this.profileImage = profileImage;
	}

	public String getProfileImage(){
		return profileImage;
	}

	public void setAccountId(int accountId){
		this.accountId = accountId;
	}

	public int getAccountId(){
		return accountId;
	}

	public void setUserType(String userType){
		this.userType = userType;
	}

	public String getUserType(){
		return userType;
	}

	public void setWebsiteUrl(String websiteUrl){
		this.websiteUrl = websiteUrl;
	}

	public String getWebsiteUrl(){
		return websiteUrl;
	}

	public void setReputationChangeWeek(int reputationChangeWeek){
		this.reputationChangeWeek = reputationChangeWeek;
	}

	public int getReputationChangeWeek(){
		return reputationChangeWeek;
	}

	public void setUserId(int userId){
		this.userId = userId;
	}

	public int getUserId(){
		return userId;
	}

	public void setReputationChangeDay(int reputationChangeDay){
		this.reputationChangeDay = reputationChangeDay;
	}

	public int getReputationChangeDay(){
		return reputationChangeDay;
	}

	public void setLocation(String location){
		this.location = location;
	}

	public String getLocation(){
		return location;
	}

	public void setReputationChangeMonth(int reputationChangeMonth){
		this.reputationChangeMonth = reputationChangeMonth;
	}

	public int getReputationChangeMonth(){
		return reputationChangeMonth;
	}

	@Override
 	public String toString(){
		return 
			"StackOverflowUser{" +
			"reputation_change_quarter = '" + reputationChangeQuarter + '\'' + 
			",link = '" + link + '\'' + 
			",last_modified_date = '" + lastModifiedDate + '\'' + 
			",last_access_date = '" + lastAccessDate + '\'' + 
			",reputation = '" + reputation + '\'' + 
			",badge_counts = '" + badgeCounts + '\'' + 
			",creation_date = '" + creationDate + '\'' + 
			",display_name = '" + displayName + '\'' + 
			",reputation_change_year = '" + reputationChangeYear + '\'' + 
			",accept_rate = '" + acceptRate + '\'' + 
			",is_employee = '" + isEmployee + '\'' + 
			",profile_image = '" + profileImage + '\'' + 
			",account_id = '" + accountId + '\'' + 
			",user_type = '" + userType + '\'' + 
			",website_url = '" + websiteUrl + '\'' + 
			",reputation_change_week = '" + reputationChangeWeek + '\'' + 
			",user_id = '" + userId + '\'' + 
			",reputation_change_day = '" + reputationChangeDay + '\'' + 
			",location = '" + location + '\'' + 
			",reputation_change_month = '" + reputationChangeMonth + '\'' + 
			"}";
		}
}