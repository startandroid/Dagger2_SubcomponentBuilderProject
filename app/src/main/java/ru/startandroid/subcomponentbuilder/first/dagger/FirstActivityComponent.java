package ru.startandroid.subcomponentbuilder.first.dagger;

import dagger.Subcomponent;
import ru.startandroid.subcomponentbuilder.base.ActivityComponent;
import ru.startandroid.subcomponentbuilder.base.ActivityComponentBuilder;
import ru.startandroid.subcomponentbuilder.first.FirstActivity;

@FirstActivityScope
@Subcomponent(modules = FirstActivityModule.class)
public interface FirstActivityComponent extends ActivityComponent<FirstActivity> {

    @Subcomponent.Builder
    interface Builder extends ActivityComponentBuilder<FirstActivityComponent, FirstActivityModule> {

    }


}
