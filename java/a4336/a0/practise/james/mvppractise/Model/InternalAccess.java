package a4336.a0.practise.james.mvppractise.Model;

import android.content.Context;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
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
        File dir = retrieveInternalDirectory();
        File file_to_delete = new File(dir, fileName);
        file_to_delete.delete();
        return true;
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

    @Override
    public ArrayList<String> getSpecificNote(String title) {

        File specific_note = new File(retrieveInternalDirectory(), title);
        ArrayList<String> note = new ArrayList<>();
        try{
            FileReader fr = new FileReader(specific_note);
            char[] ch = new char[100];

            /**
             * Learn Why fileInputStream works: byte[] -> char[] -> string
             */
            fr.read(ch);

            note.add(specific_note.getAbsolutePath());
            note.add(String.copyValueOf(ch));
            fr.close();


        }catch (IOException e){

            note.add("Error, note retrieval fail - NodeDetailActvity");

        }
        return note;

    }

    public boolean createFile(String title, String noteBody){

        File newFile = new File(retrieveInternalDirectory(), title);

        try {
            System.out.println(noteBody.getBytes());
            FileOutputStream outputStream = new FileOutputStream(newFile);
            outputStream.write(noteBody.getBytes());

            outputStream.close();
            return true;

        }catch(FileNotFoundException e){
            e.printStackTrace();
            /**
             * Log file error / display error code.
             */
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

}
