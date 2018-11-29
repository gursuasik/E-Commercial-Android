package tr.com.rnd.master.Model;

/**
 * Created by gursuasik on 22/12/17.
 */

public class CellData {
    public String name, value;
    public boolean hasChildren, isGroup;

    public CellData(String name, boolean isGroup, boolean hasChildren, String value) {
        this.name = name;
        this.value = value;
        this.isGroup = isGroup;
        this.hasChildren = hasChildren;
    }
}
