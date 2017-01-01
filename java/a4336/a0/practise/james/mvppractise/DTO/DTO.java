package a4336.a0.practise.james.mvppractise.DTO;

import java.util.ArrayList;

/**
 * Created by james on 14/12/16.
 */

public class DTO<String> implements IDTO<String> {

    private ArrayList<String> fields;

    public DTO(ArrayList<String> modelInput){
        fields = modelInput;
    }
    @Override
    public ArrayList<String> getFields() {
        return fields;
    }
}
