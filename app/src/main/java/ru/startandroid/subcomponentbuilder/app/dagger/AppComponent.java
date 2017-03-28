package ru.startandroid.subcomponentbuilder.app.dagger;

import java.util.Map;

import dagger.Component;
import ru.startandroid.subcomponentbuilder.app.ComponentsHolder;
import ru.startandroid.subcomponentbuilder.first.dagger.FirstActivityComponent;
import ru.startandroid.subcomponentbuilder.second.dagger.SecondActivityComponent;
import ru.startandroid.subcomponentbuilder.second.dagger.SecondActivityModule;

@AppScope
@Component(modules = AppModule.class)
public interface AppComponent {
    void injectComponentsHolder(ComponentsHolder componentsHolder);
}
