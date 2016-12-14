package a4336.a0.practise.james.mvppractise.Presenter;

import a4336.a0.practise.james.mvppractise.DAO.IDAO;
import a4336.a0.practise.james.mvppractise.Model.ModelInterface;

/**
 * Created by james on 13/12/16.
 */

public interface PresenterInterface {
    public void onStart();


    public void onRestart();




    public void onDestroy();




    public void onPause();




    public void onResume();

    public IDAO retrieveModel();

}
