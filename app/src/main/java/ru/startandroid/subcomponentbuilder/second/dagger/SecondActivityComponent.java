package ru.startandroid.subcomponentbuilder.second.dagger;

import dagger.Subcomponent;
import ru.startandroid.subcomponentbuilder.second.SecondActivity;

@SecondActivityScope
@Subcomponent(modules = SecondActivityModule.class)
public interface SecondActivityComponent {
    void inject(SecondActivity secondActivity);
}
