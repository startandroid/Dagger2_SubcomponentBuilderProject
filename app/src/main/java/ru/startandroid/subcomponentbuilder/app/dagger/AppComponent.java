package ru.startandroid.subcomponentbuilder.app.dagger;

import dagger.Component;
import ru.startandroid.subcomponentbuilder.app.ComponentsHolder;

@AppScope
@Component(modules = AppModule.class)
public interface AppComponent {
    void injectComponentsHolder(ComponentsHolder componentsHolder);
}
