package a4336.a0.practise.james.mvppractise.Model;

import android.content.Context;

import a4336.a0.practise.james.mvppractise.DTO.DTO;
import a4336.a0.practise.james.mvppractise.DTO.IDTO;

/**
 * Model component of MVP.
 * Created by james on 13/12/16.
 */

public class ModelImpl implements ModelInterface{

    private StorageInterface storageAccess;

    public ModelImpl(Context context){

        storageAccess = new InternalAccess(context);
    }

    public IDTO getNoteList(){

        return new DTO(storageAccess.getNoteList());
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

    public IDTO getSpecificNote(String note_title){

        DTO<String> DTO = new DTO<String>(storageAccess.getSpecificNote(note_title));

        return DTO;
    }

    @Override
    public boolean deleteNote(String note_title){
        /**
         * add boolean checks.
         */
        storageAccess.deleteNote(note_title);
        return true;
    }


}
