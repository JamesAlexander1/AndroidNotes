package a4336.a0.practise.james.mvppractise.Presenter;

import android.content.Context;

import a4336.a0.practise.james.mvppractise.DAO.IDAO;
import a4336.a0.practise.james.mvppractise.Model.ModelImpl;
import a4336.a0.practise.james.mvppractise.Model.ModelInterface;
import a4336.a0.practise.james.mvppractise.View.AddNoteActivity;
import a4336.a0.practise.james.mvppractise.View.ViewInterface;

/**
 * Created by james on 15/12/16.
 */

public class AddNotePresenter implements PresenterInterface {

    private ModelInterface model;
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
    public void onDestroy() {
        model.clean();
        model = null;
        mainView = null;

    }

    @Override
    public void onPause() {

    }

    @Override
    public void onResume() {

    }

    @Override
    public IDAO retrieveModel() {
        return null;
    }
}
