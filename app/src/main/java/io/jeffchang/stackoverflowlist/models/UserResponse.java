package io.jeffchang.stackoverflowlist.models;

import com.squareup.moshi.Json;

import org.jetbrains.annotations.NotNull;

import java.util.List;

/**
 * POJO for response from the StackOverflow users endpoint.
 */
public class UserResponse {

    @Json(name = "quota_max")
    private int quotaMax;

    @Json(name = "quota_remaining")
    private int quotaRemaining;

    @Json(name = "has_more")
    private boolean hasMore;

    @Json(name = "items")
    private List<StackOverflowUser> items;

    public void setQuotaMax(int quotaMax){
        this.quotaMax = quotaMax;
    }

    public int getQuotaMax(){
        return quotaMax;
    }

    public void setQuotaRemaining(int quotaRemaining){
        this.quotaRemaining = quotaRemaining;
    }

    public int getQuotaRemaining(){
        return quotaRemaining;
    }

    public void setHasMore(boolean hasMore){
        this.hasMore = hasMore;
    }

    public boolean isHasMore(){
        return hasMore;
    }

    public void setItems(List<StackOverflowUser> items){
        this.items = items;
    }

    public List<StackOverflowUser> getItems(){
        return items;
    }

    @NotNull
    @Override
    public String toString(){
        return
                "Response{" +
                        "quota_max = '" + quotaMax + '\'' +
                        ",quota_remaining = '" + quotaRemaining + '\'' +
                        ",has_more = '" + hasMore + '\'' +
                        ",items = '" + items + '\'' +
                        "}";
    }
}