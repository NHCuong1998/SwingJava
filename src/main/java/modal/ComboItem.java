package modal;

public class ComboItem {

    private String id;
    private String value;
    
    public ComboItem() {}
    public ComboItem(String id, String value) {
        this.id = id;
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }

    public String getId() {
        return this.id;
    }

    @Override
    public String toString() {
        
        	return id==null ? value : "["+id+"] - "+ value;
    }
}