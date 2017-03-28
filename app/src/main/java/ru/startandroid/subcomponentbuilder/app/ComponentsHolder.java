package ru.startandroid.subcomponentbuilder.app;

import android.content.Context;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;
import javax.inject.Provider;

import ru.startandroid.subcomponentbuilder.app.dagger.AppComponent;
import ru.startandroid.subcomponentbuilder.app.dagger.AppModule;
import ru.startandroid.subcomponentbuilder.app.dagger.DaggerAppComponent;
import ru.startandroid.subcomponentbuilder.base.ActivityComponent;
import ru.startandroid.subcomponentbuilder.base.ActivityComponentBuilder;
import ru.startandroid.subcomponentbuilder.base.ActivityModule;

public class ComponentsHolder {

    private final Context context;

    @Inject
    Map<Class<?>, Provider<ActivityComponentBuilder>> builders;

    private Map<Class<?>, ActivityComponent> components;
    private AppComponent appComponent;

    public ComponentsHolder(Context context) {
        this.context = context;
    }

    void init() {
        appComponent = DaggerAppComponent.builder().appModule(new AppModule(context)).build();
        appComponent.injectComponentsHolder(this);
        components = new HashMap<>();
    }

    public AppComponent getAppComponent() {
        return appComponent;
    }


    public ActivityComponent getActivityComponent(Class<?> cls) {
        return getActivityComponent(cls, null);
    }

    public ActivityComponent getActivityComponent(Class<?> cls, ActivityModule module) {
        ActivityComponent component = components.get(cls);
        if (component == null) {
            ActivityComponentBuilder builder = builders.get(cls).get();
            if (module != null) {
                builder.module(module);
            }
            component = builder.build();
            components.put(cls, component);
        }
        return component;
    }

    public void releaseActivityComponent(Class<?> cls) {
        components.put(cls, null);

    }

}
