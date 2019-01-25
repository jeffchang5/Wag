package io.jeffchang.stackoverflowlist.ui.stackoverflowlist.repository;

import javax.inject.Inject;

import io.jeffchang.stackoverflowlist.models.UserResponse;
import io.jeffchang.stackoverflowlist.network.remote.StackOverflowService;
import io.reactivex.Single;

public class StackOverflowRepository {

    private final StackOverflowService stackOverflowService;

    @Inject
    StackOverflowRepository(StackOverflowService stackOverflowService) {
        this.stackOverflowService = stackOverflowService;
    }

    public Single<UserResponse> getStackOverflowUsers() {
        return stackOverflowService.getStackOverflowUsers("stackoverflow");
    }
}
