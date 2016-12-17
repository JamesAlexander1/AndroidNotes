package a4336.a0.practise.james.mvppractise.View;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

import a4336.a0.practise.james.mvppractise.DAO.IDAO;
import a4336.a0.practise.james.mvppractise.Presenter.NoteDetailPresenter;
import a4336.a0.practise.james.mvppractise.Presenter.PresenterInterface;
import a4336.a0.practise.james.mvppractise.R;

/**
 * views details on specified note file.
 * returns back to ListActivity
 */
public class NoteDetailActivity extends AppCompatActivity implements ViewInterface{

    private PresenterInterface presenter;
    private String noteTitle;
    TextView title;
    EditText editText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note_detail);

        Button detailBackButton = (Button) findViewById(R.id.note_detail_back_button);
        detailBackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        Button deleteButton = (Button) findViewById(R.id.note_detail_delete_button);
        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.doAction(null);
                finish();
            }
        });
        title = (TextView) findViewById(R.id.node_detail_title_text_view);
        editText = (EditText) findViewById(R.id.note_detail_editText);

        noteTitle = getIntent().getStringExtra("note_title");
        presenter = new NoteDetailPresenter(this, getApplicationContext(), noteTitle);

        /**
         * add editing text functionality.
         */

        doAction();

    }

    @Override
    protected void onStart() {

        super.onStart();
        presenter.onStart();
    }

    @Override
    protected void onRestart() {

        super.onRestart();
        presenter = new NoteDetailPresenter(this, getApplicationContext(),noteTitle);
        presenter.onRestart();
        doAction();
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
    @Override
    public void doAction() {
        /**
         * Query internal storage for specific note.
         */
        IDAO data = presenter.retrieveModel();


        ArrayList<String> dataView = data.getFields();

        title.setText(dataView.get(0));
        editText.setText(dataView.get(1));


    }
}
