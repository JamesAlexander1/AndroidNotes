package a4336.a0.practise.james.mvppractise.View;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import a4336.a0.practise.james.mvppractise.Presenter.PresenterImpl;
import a4336.a0.practise.james.mvppractise.R;

public class ListActivity extends AppCompatActivity implements ViewInterface{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        Button backButton = (Button) findViewById(R.id.listAc_Back_Button);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    @Override
    public void doAction() {

    }
}

