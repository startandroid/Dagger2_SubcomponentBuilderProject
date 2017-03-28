package ru.startandroid.subcomponentbuilder.second;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import javax.inject.Inject;

import ru.startandroid.subcomponentbuilder.R;
import ru.startandroid.subcomponentbuilder.app.App;
import ru.startandroid.subcomponentbuilder.second.dagger.SecondActivityComponent;
import ru.startandroid.subcomponentbuilder.second.dagger.SecondActivityModule;

public class SecondActivity extends AppCompatActivity {

    public static final String EXTRA_ARGS = "args";

    @Inject
    SecondActivityPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_activity);

        Bundle args = getIntent().getBundleExtra(EXTRA_ARGS);
        args = new Bundle();
        args.putString("1", "2");
        SecondActivityComponent component = (SecondActivityComponent) App.getApp(this).getComponentsHolder().getActivityComponent(getClass(), new SecondActivityModule(args));
        component.inject(this);
        Log.d("qweee", " presenter " + presenter + ", "  + presenter.gett());
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (isFinishing()) {
            App.getApp(this).getComponentsHolder().releaseActivityComponent(getClass());
        }

    }
}
