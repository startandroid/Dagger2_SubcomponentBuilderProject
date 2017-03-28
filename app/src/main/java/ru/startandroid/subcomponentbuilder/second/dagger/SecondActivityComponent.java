package ru.startandroid.subcomponentbuilder.second.dagger;

import dagger.Subcomponent;
import ru.startandroid.subcomponentbuilder.base.ActivityComponent;
import ru.startandroid.subcomponentbuilder.base.ActivityComponentBuilder;
import ru.startandroid.subcomponentbuilder.second.SecondActivity;

@SecondActivityScope
@Subcomponent(modules = SecondActivityModule.class)
public interface SecondActivityComponent extends ActivityComponent<SecondActivity> {

    @Subcomponent.Builder
    interface Builder extends ActivityComponentBuilder<SecondActivityComponent, SecondActivityModule> {

    }

}
