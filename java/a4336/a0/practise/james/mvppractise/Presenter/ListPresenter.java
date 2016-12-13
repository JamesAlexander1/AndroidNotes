package a4336.a0.practise.james.mvppractise.Presenter;

import a4336.a0.practise.james.mvppractise.Model.ModelImpl;
import a4336.a0.practise.james.mvppractise.Model.ModelInterface;
import a4336.a0.practise.james.mvppractise.View.ViewInterface;

/**
 * Created by james on 13/12/16.
 */

public class ListPresenter implements PresenterInterface {

    private ViewInterface mainView;
    private ModelInterface model;
    public ListPresenter(ViewInterface view){

        mainView = view;
        model = new ModelImpl();

    }


    public void onStart(){

    }
    public void onRestart() {

    }


    public void onDestroy() {

    }


    public void onPause() {

    }


    public void onResume() {

    }
}
