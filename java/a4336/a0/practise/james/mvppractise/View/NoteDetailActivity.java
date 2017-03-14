package a4336.a0.practise.james.mvppractise.View;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

import a4336.a0.practise.james.mvppractise.DTO.DTO;
import a4336.a0.practise.james.mvppractise.DTO.IDTO;
import a4336.a0.practise.james.mvppractise.Presenter.AddNotePresenter;
import a4336.a0.practise.james.mvppractise.Presenter.NoteDetailPresenter;
import a4336.a0.practise.james.mvppractise.Presenter.PresenterInterface;
import a4336.a0.practise.james.mvppractise.R;

/**
 * views details on specified note file.
 * returns back to ListActivity
 */
public class NoteDetailActivity extends AppCompatActivity implements ViewInterface{

    private PresenterInterface deleteAndRetrievePresenter;  //type NodeDetailPresenter
    private PresenterInterface savePresenter;               //type AddNotePresenter
    private String noteTitle;

    /**
     * need to refactor.
     */
    boolean hack = true;
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
                /**
                 * should use threads and locks. will update
                 */
                if(hack) {
                    deleteAndRetrievePresenter.doAction(null);
                    finish();
                }
            }
        });
        title = (TextView) findViewById(R.id.node_detail_title_text_view);
        editText = (EditText) findViewById(R.id.note_detail_editText);

        //
        editText.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if(actionId == EditorInfo.IME_ACTION_DONE){
                    System.out.println("done");
                    hack = false;

                    /**
                     * not really a dao. lol. need to restructure all of this.
                     */

                    ArrayList<String> fields = new ArrayList<String>();
                    fields.add(title.getText().toString());
                    fields.add(editText.getText().toString());



                    IDTO<String> dao = new DTO<String>(fields);
                    savePresenter.doAction(dao);


                    hack = true;
                    return true;
                }
                return false;
            }
        });

        noteTitle = getIntent().getStringExtra("note_title");
        deleteAndRetrievePresenter = new NoteDetailPresenter(this, getApplicationContext(), noteTitle);
        savePresenter = new AddNotePresenter(this, getApplicationContext());

        /**
         * add editing text functionality.
         */

        doAction();

    }

    @Override
    protected void onStart() {

        super.onStart();
        deleteAndRetrievePresenter.onStart();
        savePresenter.onStart();
    }

    @Override
    protected void onRestart() {

        super.onRestart();
        deleteAndRetrievePresenter = new NoteDetailPresenter(this, getApplicationContext(),noteTitle);
        savePresenter = new AddNotePresenter(this, getApplicationContext());

        /**
         * Dont think these are needed. go over activity lifecycle. decide if presenters should be destroyed on calling onStop().
         */
        deleteAndRetrievePresenter.onRestart();
        savePresenter.onRestart();
        doAction();
    }

    @Override
    protected void onStop(){

        super.onStop();
        deleteAndRetrievePresenter.onStop();
        savePresenter.onStop();

    }
    @Override
    protected void onDestroy() {

        super.onDestroy();
        deleteAndRetrievePresenter.onDestroy();
        savePresenter.onDestroy();
        deleteAndRetrievePresenter = null;
        savePresenter = null;
    }

    @Override
    protected void onPause() {

        super.onPause();
        deleteAndRetrievePresenter.onPause();
        savePresenter.onPause();
    }

    @Override
    protected void onResume() {

        super.onResume();
        deleteAndRetrievePresenter.onResume();
        savePresenter.onResume();
    }
    @Override
    public void doAction() {
        /**
         * Query internal storage for specific note.
         */
        IDTO data = deleteAndRetrievePresenter.retrieveModel();


        ArrayList<String> dataView = data.getFields();

        title.setText(dataView.get(0));
        String temp = dataView.get(1);
        System.out.println(temp);
        editText.setText(temp);


    }
}
