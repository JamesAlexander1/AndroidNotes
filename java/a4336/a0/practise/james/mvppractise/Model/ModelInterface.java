package a4336.a0.practise.james.mvppractise.Model;

import java.io.File;
import java.util.ArrayList;

import a4336.a0.practise.james.mvppractise.DAO.IDAO;

/**
 * Created by james on 13/12/16.
 */

public interface ModelInterface {

    IDAO getNoteList();

    boolean SaveNote(String title, String noteBody);
    boolean clean();
    IDAO getSpecificNote(String note_title);
    boolean deleteNote(String note_title);
}
