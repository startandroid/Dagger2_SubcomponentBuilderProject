package ru.startandroid.subcomponentbuilder.second.dagger;

import android.os.Bundle;

import dagger.Module;
import dagger.Provides;
import ru.startandroid.subcomponentbuilder.second.SecondActivityPresenter;

@Module
public class SecondActivityModule {

    private final Bundle args;

    public SecondActivityModule(Bundle args) {
        this.args = args;
    }

    @SecondActivityScope
    @Provides
    SecondActivityPresenter provideSecondActivityPresenter() {
        return new SecondActivityPresenter(args);
    }

}
