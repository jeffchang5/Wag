package io.jeffchang.stackoverflowlist.di.modules;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import io.jeffchang.stackoverflowlist.network.remote.StackOverflowService;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.moshi.MoshiConverterFactory;

/**
 * Provides dependency injection for networking singletons.
 */

@Module
public class NetworkModule {

    private final String BASE_URL = "";

    @Provides
    @Singleton
    Retrofit provideRetrofit() {
        return new Retrofit.Builder()
                .addConverterFactory(MoshiConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .baseUrl(BASE_URL)
                .build();
    }

    @Provides
    @Singleton
    StackOverflowService provideStackOverflowService(Retrofit retrofit) {
        return retrofit.create(StackOverflowService.class);
    }
}
