package ru.startandroid.subcomponentbuilder.first;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import javax.inject.Inject;

import butterknife.ButterKnife;
import butterknife.OnClick;
import ru.startandroid.subcomponentbuilder.R;
import ru.startandroid.subcomponentbuilder.second.SecondActivity;
import ru.startandroid.subcomponentbuilder.app.App;

public class FirstActivity extends AppCompatActivity {

    @Inject
    FirstActivityPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.first_activity);

        ButterKnife.bind(this);

        App.getApp(this).getComponentsHolder().getFirstActivityComponent().inject(this);
    }

    @OnClick(R.id.goToSecondActivity)
    void onGoToSecondActivityClick() {
        startActivity(new Intent(this, SecondActivity.class));
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (isFinishing()) {
            App.getApp(this).getComponentsHolder().releaseFirstActivityComponent();
        }
    }
}
