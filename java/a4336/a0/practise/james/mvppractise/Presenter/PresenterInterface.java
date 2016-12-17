package a4336.a0.practise.james.mvppractise.Presenter;

import a4336.a0.practise.james.mvppractise.DAO.IDAO;
import a4336.a0.practise.james.mvppractise.Model.ModelInterface;

/**
 * Created by james on 13/12/16.
 */

public interface PresenterInterface<E> {

    void onStart();
    void onRestart();
    void onStop();
    void onDestroy();
    void onPause();
    void onResume();
    IDAO retrieveModel();

    void doAction(IDAO<E> dao);

}
