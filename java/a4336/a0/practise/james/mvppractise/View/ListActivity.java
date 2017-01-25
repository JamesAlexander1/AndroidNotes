package a4336.a0.practise.james.mvppractise.View;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

import a4336.a0.practise.james.mvppractise.DTO.IDTO;
import a4336.a0.practise.james.mvppractise.Presenter.ListPresenter;
import a4336.a0.practise.james.mvppractise.Presenter.PresenterInterface;
import a4336.a0.practise.james.mvppractise.R;

public class ListActivity extends AppCompatActivity implements ViewInterface{

    private PresenterInterface presenter;
    private ListView listView;
    private ArrayAdapter<String> adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        presenter = new ListPresenter(this, getApplicationContext());


        /**
         * Should put this in button method.
         */
        Button backButton = (Button) findViewById(R.id.listAc_Back_Button);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        Button addButton = (Button) findViewById(R.id.Add_Note_Button);
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent intent = new Intent(ListActivity.this, AddNoteActivity.class);
                startActivity(intent);
            }
        });

        listView = (ListView) findViewById(R.id.Note_List_View);


        /**
         * Some temporary values.
         */
        String[] defaultValues = {"empty", "list"};
        ArrayList<String> defListValues = new ArrayList<>();

        for(int ctr = 0; ctr < defaultValues.length; ctr ++){
            defListValues.add(defaultValues[ctr]);
        }

        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, defListValues);
        listView.setAdapter(adapter);


        /**
         * replace with more appropriate concurrency code.
         */
        new Thread(new Runnable() {
            @Override
            public void run() {
                doAction();
            }
        }).start();

    }
    @Override
    protected void onStart() {

        super.onStart();
        presenter.onStart();
    }

    @Override
    protected void onRestart() {

        super.onRestart();
        presenter = new ListPresenter(this, getApplicationContext());
        presenter.onRestart();
        doAction();
    }

    @Override
    protected void onStop(){
        /**
         * Free all resources here !
         * in all activites and presenter classes.
         */
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
        //doAction();
        new Thread(new Runnable() {
            @Override
            public void run() {
                doAction();
            }
        }).start();
    }



    @Override
    /**
     * DoAction method retrieves list of files from internal storage.
     */
    public void doAction() {

        /**
         * In this case: query ListPresenter about list of currently written notes.
         */

        IDTO data = presenter.retrieveModel();
        ArrayList<String> notes = data.getFields();
       final ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, notes);


        /**
         * Display fields in listView.
         */
        try {
            listView.setAdapter(adapter2);

            /**
             * Add functionality for clicking on specific list items.
             */
            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                    String temp = adapter2.getItem(position);

                    TextView tempText = (TextView) findViewById(R.id.temp_textView);
                    /**
                     * currently on brings up file name / note title.
                     * Needs to pass to note detail activity.
                     */
                    tempText.setText(temp);

                    Intent detailIntent = new Intent(ListActivity.this, NoteDetailActivity.class);
                    detailIntent.putExtra("note_title", temp);


                    startActivity(detailIntent);
                }
            });


        } catch (NullPointerException e) {
            adapter = null;
            /**
             * More work to be done here.
             */
        }







    }


}

