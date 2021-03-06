package a4336.a0.practise.james.mvppractise.Model;

import java.io.File;
import java.util.ArrayList;

/**
 * Created by james on 13/12/16.
 */

public interface StorageInterface {

    ArrayList<String> getNoteList();

    boolean deleteNote(String fileName);
    boolean createFile(String title, String noteBody);
    boolean clean();
    ArrayList<String> getSpecificNote(String title);
    boolean modifyNote(String fileName, String body);
}
