package a4336.a0.practise.james.mvppractise.Model;

import a4336.a0.practise.james.mvppractise.DTO.IDTO;

/**
 * Created by james on 13/12/16.
 */

public interface ModelInterface {

    IDTO getNoteList();

    boolean SaveNote(String title, String noteBody);
    boolean clean();
    IDTO getSpecificNote(String note_title);
    boolean deleteNote(String note_title);
}
