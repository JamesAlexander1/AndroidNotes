package a4336.a0.practise.james.mvppractise.Presenter;

import android.content.Context;

import java.util.ArrayList;

import a4336.a0.practise.james.mvppractise.DTO.IDTO;
import a4336.a0.practise.james.mvppractise.Model.ModelImpl;
import a4336.a0.practise.james.mvppractise.Model.ModelInterface;

import a4336.a0.practise.james.mvppractise.View.ViewInterface;

/**
 *
 * AddNotePresenter class. only functionality is to call SaveNote method on ModelInterface class.
 * Created by james on 15/12/16.
 *
 */

public class AddNotePresenter implements PresenterInterface<String> {

    private ModelInterface model;       //only interacts with model class through doAction method. In this case calls SaveNote method.
    private ViewInterface mainView;

    public AddNotePresenter(ViewInterface view, Context context) {

        mainView = view;
        /**
         * maybe have view display operation success message?
         */
        model = new ModelImpl(context);

    }
    @Override
    public void onStart() {

    }

    @Override
    public void onRestart() {

    }

    @Override
    public void onStop() {
        model.clean();
        model = null;
        mainView = null;
    }


    @Override
    public void onDestroy() {


    }

    @Override
    public void onPause() {

    }

    @Override
    public void onResume() {

    }

    @Override
    public IDTO retrieveModel() {

        return null;
    }

    /**
     * Overrides PresenterInterface, calls SaveNote on model class to save note in the file system.
     * @param dao   - poorly named. but essentially contains note and other information to save to file system.
     */
    @Override
    public void doAction(IDTO<String> dao) {
        ArrayList<String> temp = dao.getFields();
        model.SaveNote(temp.get(0), temp.get(1));
    }




}
