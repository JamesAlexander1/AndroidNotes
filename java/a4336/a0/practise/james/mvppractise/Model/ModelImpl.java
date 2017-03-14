package a4336.a0.practise.james.mvppractise.Model;

import android.content.Context;

import a4336.a0.practise.james.mvppractise.DTO.DTO;
import a4336.a0.practise.james.mvppractise.DTO.IDTO;

/**
 * Model component of MVP.
 * Extends ModelInterface to search/store/retrieve user notes (Strings essentially) inside phone file system.
 * Created by james on 13/12/16.
 */

public class ModelImpl implements ModelInterface{

    /**
     * StorageInterface class is another layer of abstraction containing read/write() methods.
     */
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

    /**
     * Exactly what the name implies. retrieves note in file system, and returns.
     * @param note_title        - note title to search for.
     * @return  Dto containing note body contents.
     */
    public IDTO getSpecificNote(String note_title){

        DTO<String> DTO = new DTO<String>(storageAccess.getSpecificNote(note_title));

        return DTO;
    }

    /**
     * Deletes note file in file system with specified note_title.
     * @param note_title    - title of note file (also txt filename)
     * @return              - always returns true, will change.
     */
    @Override
    public boolean deleteNote(String note_title){
        /**
         * add boolean checks.
         */
        storageAccess.deleteNote(note_title);
        return true;
    }


}
