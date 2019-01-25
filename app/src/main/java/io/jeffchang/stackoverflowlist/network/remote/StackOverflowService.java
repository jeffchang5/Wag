package io.jeffchang.stackoverflowlist.network.remote;


import io.jeffchang.stackoverflowlist.models.UserResponse;
import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Service that defines the RESTful interactions with the API.
 */

public interface StackOverflowService {

    @GET("/users")
    Single<UserResponse> getStackOverflowUsers(@Query("site") String stackExchange);

}
