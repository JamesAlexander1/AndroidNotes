package a4336.a0.practise.james.mvppractise.Presenter;

import android.content.Context;

import java.util.ArrayList;


import a4336.a0.practise.james.mvppractise.DAO.IDAO;
import a4336.a0.practise.james.mvppractise.Model.ModelImpl;
import a4336.a0.practise.james.mvppractise.Model.ModelInterface;
import a4336.a0.practise.james.mvppractise.View.ViewInterface;

/**
 * Created by james on 17/12/16.
 */

public class NoteDetailPresenter implements PresenterInterface<String>{

    private ViewInterface mainView;
    private ModelInterface model;
    private String note_title;

    public NoteDetailPresenter(ViewInterface view, Context context, String title){

        mainView = view;
        model = new ModelImpl(context);
        note_title = title;
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
    public IDAO retrieveModel() {
        IDAO<String> dao = model.getSpecificNote(note_title);

        return dao;
    }



    @Override
    public void doAction(IDAO<String> dao) {



            model.deleteNote(note_title);

    }


}
