package a4336.a0.practise.james.mvppractise.View;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

import a4336.a0.practise.james.mvppractise.DAO.DAO;
import a4336.a0.practise.james.mvppractise.DAO.IDAO;
import a4336.a0.practise.james.mvppractise.Presenter.AddNotePresenter;
import a4336.a0.practise.james.mvppractise.Presenter.PresenterInterface;
import a4336.a0.practise.james.mvppractise.R;

public class AddNoteActivity extends AppCompatActivity implements ViewInterface{

    private PresenterInterface presenter;
    private EditText titleText;
    private EditText bodyText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_note);

        presenter = new AddNotePresenter(this, getApplicationContext());

        Button backButton = (Button) findViewById(R.id.add_note_back_button);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        titleText = (EditText) findViewById(R.id.add_note_editText_title);
        bodyText = (EditText) findViewById(R.id.note_text_body_editText);

        Button addButton = (Button) findViewById(R.id.save_and_add_note_button);
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                doAction();
            }
        });


    }

    @Override
    public void doAction() {


        ArrayList<String> input = new ArrayList<String>();
        input.add(titleText.getText().toString());
        input.add(bodyText.getText().toString());
        System.out.println(bodyText.getText().toString());
        IDAO<String> dao = new DAO<String>(input);
        input = null;

        presenter.doAction(dao);
        finish();
    }

    @Override
    protected void onStart() {

        super.onStart();
        presenter.onStart();
    }

    @Override
    protected void onRestart() {

        super.onRestart();
        presenter = new AddNotePresenter(this, getApplicationContext());
        presenter.onRestart();
    }

    @Override
    protected void onStop(){

        super.onStop();
        presenter.onStop();
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
}
