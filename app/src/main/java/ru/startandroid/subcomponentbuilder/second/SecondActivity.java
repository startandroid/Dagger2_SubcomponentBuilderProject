package ru.startandroid.subcomponentbuilder.second;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import javax.inject.Inject;

import ru.startandroid.subcomponentbuilder.R;
import ru.startandroid.subcomponentbuilder.app.App;

public class SecondActivity extends AppCompatActivity {

    public static final String EXTRA_ARGS = "args";

    @Inject
    SecondActivityPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_activity);

        Bundle args = getIntent().getBundleExtra(EXTRA_ARGS);
        App.getApp(this).getComponentsHolder().getSecondActivityComponent(args).inject(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (isFinishing()) {
            App.getApp(this).getComponentsHolder().releaseSecondActivityComponent();
        }

    }
}
