package tr.com.fkocak.treeview;

/**
 * Created by fatihkocak on 17.10.2018.
 */

public class Dir implements LayoutItemType {
    public String dirName;

    public Dir(String dirName) {
        this.dirName = dirName;
    }

    @Override
    public int getLayoutId() {
        return R.layout.item_dir;
    }
}
