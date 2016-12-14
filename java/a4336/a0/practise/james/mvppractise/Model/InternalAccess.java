package a4336.a0.practise.james.mvppractise.Model;

import android.content.Context;

import java.io.File;
import java.util.ArrayList;

/**
 * Class for reading, writing and deleting text notes in Internal Storage.
 * Created by james on 13/12/16.
 */

class InternalAccess implements StorageInterface {

    private Context context;
    private static String dirName = "android_note_directory";

    public InternalAccess(Context ct){
        context = ct;
    }

    public ArrayList<String> getNoteList(){

        File directory = retrieveInternalDirectory();

        ArrayList<String> noteList = new ArrayList<String>();
        File[] files = directory.listFiles();

        for(File f : files){
            noteList.add(f.getName());
        }
        return noteList;
    }

    private File retrieveInternalDirectory(){

        File dir = context.getDir(dirName, Context.MODE_PRIVATE);

        return dir;
    }

    public boolean deleteNote(String fileName){
        return false;
    }

    @Override
    public boolean clean() {

        context = null;
        if(context == null) {
            return true;
        }else{
            return false;
        }
    }
}
