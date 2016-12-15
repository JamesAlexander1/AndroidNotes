package a4336.a0.practise.james.mvppractise.View;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

import a4336.a0.practise.james.mvppractise.DAO.IDAO;
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

        Button backButton = (Button) findViewById(R.id.listAc_Back_Button);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
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
         * to do: make this method asynch.
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

    @Override
    public void doAction() {

        /**
         * In this case: query ListPresenter about list of currently written notes.
         */

        IDAO data = presenter.retrieveModel();
        ArrayList<String> notes = data.getFields();
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, notes);

        /**
         * Display fields in listView.
         */
        try {
            listView.setAdapter(adapter);

        }catch(NullPointerException e){
            adapter = null;
            /**
             * More work to be done here.
             */
        }




    }


}

