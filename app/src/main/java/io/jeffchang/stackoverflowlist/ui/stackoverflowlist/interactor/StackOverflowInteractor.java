package io.jeffchang.stackoverflowlist.ui.stackoverflowlist.interactor;

import java.util.List;

import javax.inject.Inject;

import io.jeffchang.stackoverflowlist.models.StackOverflowUser;
import io.jeffchang.stackoverflowlist.models.UserResponse;
import io.jeffchang.stackoverflowlist.ui.stackoverflowlist.repository.StackOverflowRepository;
import io.reactivex.Single;

public class StackOverflowInteractor {

    private final StackOverflowRepository stackOverflowRepository;

    @Inject
    StackOverflowInteractor(StackOverflowRepository stackOverflowRepository) {
        this.stackOverflowRepository = stackOverflowRepository;
    }

    public Single<List<StackOverflowUser>> getStackOverflowUsers() {
        return stackOverflowRepository.getStackOverflowUsers()
                .map(UserResponse::getItems);
    }

}
