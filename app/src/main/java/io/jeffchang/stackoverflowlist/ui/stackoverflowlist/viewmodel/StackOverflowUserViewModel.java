package io.jeffchang.stackoverflowlist.ui.stackoverflowlist.viewmodel;

import java.util.List;

import javax.inject.Inject;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import io.jeffchang.stackoverflowlist.models.StackOverflowUser;
import io.jeffchang.stackoverflowlist.ui.stackoverflowlist.interactor.StackOverflowInteractor;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import timber.log.Timber;

public class StackOverflowUserViewModel extends ViewModel {

    private final StackOverflowInteractor stackOverflowInteractor;

    private CompositeDisposable compositeDisposable = new CompositeDisposable();

    private MutableLiveData<List<StackOverflowUser>> stackOverflowUserListLiveData =
            new MutableLiveData<>();

    @Inject
    StackOverflowUserViewModel(StackOverflowInteractor stackOverflowInteractor) {
        this.stackOverflowInteractor = stackOverflowInteractor;
    }

    public void getStackOverflowUsers() {
        Disposable disposable = stackOverflowInteractor
                .getStackOverflowUsers()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
        .subscribe(
                stackOverflowUser -> stackOverflowUserListLiveData.setValue(stackOverflowUser),
                throwable -> {
            Timber.e(throwable);
        });
        compositeDisposable.add(disposable);
    }

    public LiveData<List<StackOverflowUser>> getStackOverflowUserListLiveData() {
        return stackOverflowUserListLiveData;
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        compositeDisposable.clear();
    }

}
