package a4336.a0.practise.james.mvppractise.Presenter;

import a4336.a0.practise.james.mvppractise.DAO.IDAO;
import a4336.a0.practise.james.mvppractise.Model.ModelImpl;
import a4336.a0.practise.james.mvppractise.Model.ModelInterface;
import a4336.a0.practise.james.mvppractise.View.ViewInterface;

/**
 * Presenter component in MVP.
 * Created by james on 13/12/16.
 */

public class PresenterImpl implements PresenterInterface{

    private ViewInterface mainView;
    //private ModelInterface model;
    public PresenterImpl(ViewInterface view){

        mainView = view;
       // model = new ModelImpl();

    }


    public void onStart(){

    }
    public void onRestart() {

    }


    public void onDestroy() {
        /**
         * add functionality to dereference all model.
         */
        //model = null;
        mainView = null;
    }


    public void onPause() {

    }


    public void onResume() {

    }

    @Override
    public IDAO retrieveModel() {
        return null;
    }


}
