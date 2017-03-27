package ru.startandroid.subcomponentbuilder.first.dagger;

import dagger.Module;
import dagger.Provides;
import ru.startandroid.subcomponentbuilder.first.FirstActivityPresenter;

@Module
public class FirstActivityModule {

    @FirstActivityScope
    @Provides
    FirstActivityPresenter provideFirstActivityPresenter() {
        return new FirstActivityPresenter();
    }

}
