package a4336.a0.practise.james.mvppractise.Model;

import android.content.Context;

import java.util.ArrayList;

import a4336.a0.practise.james.mvppractise.DAO.DAO;
import a4336.a0.practise.james.mvppractise.DAO.IDAO;

/**
 * Model component of MVP.
 * Created by james on 13/12/16.
 */

public class ModelImpl implements ModelInterface{

    private StorageInterface storageAccess;

    public ModelImpl(Context context){

        storageAccess = new InternalAccess(context);
    }

    public IDAO getNoteList(){

        return new DAO(storageAccess.getNoteList());
    }

    @Override
    public boolean SaveNote(String title, String noteBody) {

        return storageAccess.createFile(title, noteBody);

    }

    @Override
    public boolean clean() {
        storageAccess.clean();
        storageAccess = null;

        if(storageAccess == null){
            return true;
        }else {
            return false;
        }


    }

    public IDAO getSpecificNote(String note_title){

        DAO<String> dao = new DAO<String>(storageAccess.getSpecificNote(note_title));

        return dao;
    }


}
