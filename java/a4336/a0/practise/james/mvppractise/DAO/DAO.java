package a4336.a0.practise.james.mvppractise.DAO;

import java.util.ArrayList;

/**
 * Created by james on 14/12/16.
 */

public class DAO<String> implements IDAO<String>{

    private ArrayList<String> fields;

    public DAO(ArrayList<String> modelInput){
        fields = modelInput;
    }
    @Override
    public ArrayList<String> getFields() {
        return fields;
    }
}
