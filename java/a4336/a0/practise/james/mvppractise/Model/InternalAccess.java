package a4336.a0.practise.james.mvppractise.Model;

import android.content.Context;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;
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

    /**
     * getNoteList method queries internal storage for list of file names.
     * @return ArrayList of file names as Strings.
     */
    public ArrayList<String> getNoteList(){

        File directory = retrieveInternalDirectory();

        ArrayList<String> noteList = new ArrayList<String>();
        File[] files = directory.listFiles();

        for(File f : files){
            noteList.add(f.getName());
        }

        files = null;
        directory = null;
        return noteList;
    }

    /**
     * private method for retrieving file directory.
     * @return
     */
    private File retrieveInternalDirectory(){

        File dir = context.getDir(dirName, Context.MODE_PRIVATE);

        return dir;
    }

    /**
     * method for deleting File with specified file name.
     * @param fileName String
     * @return boolean value. always true as of now.
     */
    public boolean deleteNote(String fileName){
        File dir = retrieveInternalDirectory();
        File file_to_delete = new File(dir, fileName);
        file_to_delete.delete();
        return true;
    }

    /**
     * method for cleaning up InternalAccess object's instanced variables.
     * @return
     */
    @Override
    public boolean clean() {

        context = null;
        if(context == null) {
            return true;
        }else{
            return false;
        }
    }

    /**
     * Method for retrieving text of specific file.
     * @param title String containing name of file to read.
     * @return a ArrayList containing name and content of file.
     */
    @Override
    public ArrayList<String> getSpecificNote(String title) {

        File specific_note = new File(retrieveInternalDirectory(), title);
        ArrayList<String> note = new ArrayList<>();

        try{



            FileInputStream inputStream = new FileInputStream(specific_note);
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
            String lineRead;
            StringBuilder builder = new StringBuilder();
            while((lineRead = reader.readLine()) != null){

                builder = builder.append(lineRead);
            }

            lineRead = builder.toString();


            reader.close();


            /**
             * why does the question mark character show up?
             */


            System.out.println(lineRead);
            note.add(specific_note.getName());
            note.add(lineRead);

        }catch (IOException e){

            note.add("Error, note retrieval fail - NodeDetailActivity");

        }
        return note;

    }

    /**
     * Method to modify content of file
     * @param fileName String containing name of file.
     * @param body String containing new file body.
     * @return default boolean value.
     */
    @Override
    public boolean modifyNote(String fileName, String body) {

        createFile(fileName, body);
        /**
         * Change from boolean ?
         */
        return true;
    }

    public boolean createFile(String title, String noteBody){

        File newFile = new File(retrieveInternalDirectory(), title);

        try {


            FileOutputStream outputStream = new FileOutputStream(newFile);
            Writer out = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
            out.write(noteBody);
            out.close();

            return true;

        }catch(FileNotFoundException e){
            e.printStackTrace();
            /**
             * should Log file error / display error code.
             */
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

}
