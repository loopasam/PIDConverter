/**
 * 
 */
package pid;

/**
 * @author Samuel Croset
 *
 */
public class LabelValue {

    private String name;
    private int id;
    private String parent_idref;
    private String go;
    
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getParent_idref() {
        return parent_idref;
    }
    public void setParent_idref(String parent_idref) {
        this.parent_idref = parent_idref;
    }
    public String getGo() {
        return go;
    }
    public void setGo(String go) {
        this.go = go;
    }
    
    
}
