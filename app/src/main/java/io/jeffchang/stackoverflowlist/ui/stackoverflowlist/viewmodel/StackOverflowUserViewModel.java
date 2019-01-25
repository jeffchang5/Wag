package io.jeffchang.stackoverflowlist.ui.stackoverflowlist.viewmodel;

import java.util.List;
import java.util.concurrent.TimeUnit;

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
import retrofit2.HttpException;

public class StackOverflowUserViewModel extends ViewModel {

    private final StackOverflowInteractor stackOverflowInteractor;

    private CompositeDisposable compositeDisposable = new CompositeDisposable();

    private MutableLiveData<List<StackOverflowUser>> stackOverflowUserListLiveData =
            new MutableLiveData<>();

    private MutableLiveData<ErrorType> errorTypeLiveData = new MutableLiveData<>();

    @Inject
    StackOverflowUserViewModel(StackOverflowInteractor stackOverflowInteractor) {
        this.stackOverflowInteractor = stackOverflowInteractor;
    }

    public void getStackOverflowUsers() {
        Disposable disposable = stackOverflowInteractor
                .getStackOverflowUsers()
                .delay(750, TimeUnit.MILLISECONDS)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
        .subscribe(
                stackOverflowUser -> stackOverflowUserListLiveData.setValue(stackOverflowUser),
                throwable -> {
                    // TODO: Do more complex error handling.
                    if (throwable instanceof HttpException) {
                        errorTypeLiveData.setValue(ErrorType.OTHER);
                    } else {
                        errorTypeLiveData.setValue(ErrorType.NETWORK);
                    }
                });
        compositeDisposable.add(disposable);
    }

    public LiveData<List<StackOverflowUser>> getStackOverflowUserListLiveData() {
        return stackOverflowUserListLiveData;
    }

    public LiveData<ErrorType> getErrorTypeLiveData() {
        return errorTypeLiveData;
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        compositeDisposable.clear();
    }

    public enum ErrorType {
        NETWORK, OTHER
    }

}
