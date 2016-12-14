package a4336.a0.practise.james.mvppractise.View;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.io.File;
import java.util.ArrayList;


import a4336.a0.practise.james.mvppractise.DAO.IDAO;
import a4336.a0.practise.james.mvppractise.Presenter.ListPresenter;
import a4336.a0.practise.james.mvppractise.Presenter.PresenterInterface;
import a4336.a0.practise.james.mvppractise.R;

public class ListActivity extends AppCompatActivity implements ViewInterface{

    private PresenterInterface presenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        presenter = new ListPresenter(this, getApplicationContext());

        Button backButton = (Button) findViewById(R.id.listAc_Back_Button);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
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

        presenter.onResume();
    }

    @Override
    public void doAction() {

        /**
         * In this case: query ListPresenter about list of currently written notes.
         */

        IDAO data = presenter.retrieveModel();
        ArrayList<String> notes = data.getFields();

        /**
         * Display fields in listView.
         */

    }


}

