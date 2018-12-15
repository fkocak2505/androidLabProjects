package tr.com.fkocak.treeview;

/**
 * Created by fatihkocak on 17.10.2018.
 */

public class File implements LayoutItemType {
    public String fileName;

    public File(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public int getLayoutId() {
        return R.layout.item_file;
    }
}
