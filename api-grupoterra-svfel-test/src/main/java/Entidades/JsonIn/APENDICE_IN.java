package Entidades.JsonIn;

import java.io.Serializable;
import java.util.List;

public class APENDICE_IN implements Serializable {

    private static final long serialVersionUID = 1L;
    
    private List<String> items;

    public APENDICE_IN(List<String> items) {
        this.items = items;
    }

    public APENDICE_IN() {
    }

    public List<String> getItems() {
        return items;
    }

    public void setItems(List<String> items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return "APENDICE{" + "items=" + items + '}';
    }
    
}
