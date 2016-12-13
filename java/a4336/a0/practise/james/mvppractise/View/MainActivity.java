package a4336.a0.practise.james.mvppractise.View;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import a4336.a0.practise.james.mvppractise.Presenter.PresenterImpl;
import a4336.a0.practise.james.mvppractise.R;


/**
 * View Component of MVP pattern
 */
public class MainActivity extends AppCompatActivity implements ViewInterface{

    private PresenterImpl presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /**
         * Reference between View and Presenter
         */
        presenter = new PresenterImpl(this);
    }

    @Override
    protected void onStart() {

        super.onStart();
        presenter.onStart();
    }

    @Override
    protected void onRestart() {

        super.onRestart();
        presenter.onRestart();
    }

    @Override
    protected void onDestroy() {

        super.onDestroy();
        
        presenter.onDestroy();
        presenter = null;
    }

    @Override
    protected void onPause() {

        super.onPause();
        presenter.onPause();
    }

    @Override
    protected void onResume() {

        presenter.onResume();
    }

}
