package ru.startandroid.subcomponentbuilder.first.dagger;

import dagger.Subcomponent;
import ru.startandroid.subcomponentbuilder.first.FirstActivity;

@FirstActivityScope
@Subcomponent(modules = FirstActivityModule.class)
public interface FirstActivityComponent {
    void inject(FirstActivity firstActivity);
}
