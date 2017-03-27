package ru.startandroid.subcomponentbuilder.app;

import android.content.Context;
import android.os.Bundle;

import ru.startandroid.subcomponentbuilder.app.dagger.AppComponent;
import ru.startandroid.subcomponentbuilder.app.dagger.AppModule;
import ru.startandroid.subcomponentbuilder.app.dagger.DaggerAppComponent;
import ru.startandroid.subcomponentbuilder.first.dagger.FirstActivityComponent;
import ru.startandroid.subcomponentbuilder.second.dagger.SecondActivityComponent;
import ru.startandroid.subcomponentbuilder.second.dagger.SecondActivityModule;

public class ComponentsHolder {

    private final Context context;

    private AppComponent appComponent;
    private FirstActivityComponent firstActivityComponent;
    private SecondActivityComponent secondActivityComponent;

    public ComponentsHolder(Context context) {
        this.context = context;
    }

    void init() {
        appComponent = DaggerAppComponent.builder().appModule(new AppModule(context)).build();
    }

    // AppComponent

    public AppComponent getAppComponent() {
        return appComponent;
    }


    // FirstActivityComponent

    public FirstActivityComponent getFirstActivityComponent() {
        if (firstActivityComponent == null) {
            firstActivityComponent = getAppComponent().createFirstActivityComponent();
        }
        return firstActivityComponent;
    }

    public void releaseFirstActivityComponent() {
        firstActivityComponent = null;
    }


    //SecondActivityComponent

    public SecondActivityComponent getSecondActivityComponent(Bundle args) {
        if (secondActivityComponent == null) {
            secondActivityComponent = getAppComponent().createSecondActivityComponent(new SecondActivityModule(args));
        }
        return secondActivityComponent;
    }

    public void releaseSecondActivityComponent() {
        secondActivityComponent = null;
    }

}
