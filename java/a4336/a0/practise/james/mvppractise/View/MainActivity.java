package a4336.a0.practise.james.mvppractise.View;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


import a4336.a0.practise.james.mvppractise.Presenter.PresenterImpl;
import a4336.a0.practise.james.mvppractise.Presenter.PresenterInterface;
import a4336.a0.practise.james.mvppractise.R;


/**
 * A view Component of MVP pattern.
 */
public class MainActivity extends AppCompatActivity implements ViewInterface{

    private PresenterInterface presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /**
         * Reference between View and Presenter.
         */
        presenter = new PresenterImpl(this);

        Button getStartedButton = (Button) findViewById(R.id.get_started_button);
        getStartedButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ListActivity.class);
                startActivity(intent);
            }
        });
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

        super.onResume();
        presenter.onResume();
    }

    public void doAction(){



    }


}
