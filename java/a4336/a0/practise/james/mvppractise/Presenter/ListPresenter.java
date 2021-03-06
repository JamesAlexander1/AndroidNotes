package a4336.a0.practise.james.mvppractise.Presenter;

import android.content.Context;

import a4336.a0.practise.james.mvppractise.DTO.IDTO;
import a4336.a0.practise.james.mvppractise.Model.ModelImpl;
import a4336.a0.practise.james.mvppractise.Model.ModelInterface;
import a4336.a0.practise.james.mvppractise.View.ViewInterface;

/**
 * Created by james on 13/12/16.
 */

public class ListPresenter implements PresenterInterface {

    private ViewInterface mainView;
    private ModelInterface model;

    /**
     *
     * @param view
     * @param context <- check if there is a way around this.
     */
    public ListPresenter(ViewInterface view, Context context){

        mainView = view;
        model = new ModelImpl(context);

    }


    public void onStart(){

    }
    public void onRestart() {

    }

    @Override
    public void onStop() {
        model.clean();
        model = null;
        mainView = null;
    }


    public void onDestroy() {

    }


    public void onPause() {

    }


    public void onResume() {

    }

    @Override
    public IDTO retrieveModel() {
        /**
         * Retreive list of txt files from file directory.
         */
        IDTO data = model.getNoteList();
        return data;
    }

    @Override
    public void doAction(IDTO dao) {

    }




}
