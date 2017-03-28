package ru.startandroid.subcomponentbuilder.first.dagger;

import dagger.Module;
import dagger.Provides;
import ru.startandroid.subcomponentbuilder.base.ActivityModule;
import ru.startandroid.subcomponentbuilder.first.FirstActivityPresenter;

@Module
public class FirstActivityModule implements ActivityModule {

    @FirstActivityScope
    @Provides
    FirstActivityPresenter provideFirstActivityPresenter() {
        return new FirstActivityPresenter();
    }

}
