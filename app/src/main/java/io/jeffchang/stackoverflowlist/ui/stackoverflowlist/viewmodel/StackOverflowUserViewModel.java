package io.jeffchang.stackoverflowlist.ui.stackoverflowlist.viewmodel;

import javax.inject.Inject;

import androidx.lifecycle.ViewModel;
import io.jeffchang.stackoverflowlist.ui.stackoverflowlist.interactor.StackOverflowInteractor;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import timber.log.Timber;

public class StackOverflowUserViewModel extends ViewModel {

    private final StackOverflowInteractor stackOverflowInteractor;

    private CompositeDisposable compositeDisposable = new CompositeDisposable();

    @Inject
    StackOverflowUserViewModel(StackOverflowInteractor stackOverflowInteractor) {
        this.stackOverflowInteractor = stackOverflowInteractor;
    }

    public void getStackOverflowUsers() {
        Disposable disposable = stackOverflowInteractor
                .getStackOverflowUsers()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
        .subscribe(stackOverflowUser -> {
            Timber.d(stackOverflowUser.toString());
        }, throwable -> {
            Timber.e(throwable);
        });
        compositeDisposable.add(disposable);
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        compositeDisposable.clear();
    }

}
