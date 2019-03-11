package tr.ms.csgb.deneme.data_model;

public class GridViewItemModel {

    private int gridItemIcon;
    private String gridItemTitle;

    public GridViewItemModel(int gridItemIcon, String gridItemTitle) {
        this.gridItemIcon = gridItemIcon;
        this.gridItemTitle = gridItemTitle;
    }

    public int getGridItemIcon() {
        return gridItemIcon;
    }

    public void setGridItemIcon(int gridItemIcon) {
        this.gridItemIcon = gridItemIcon;
    }

    public String getGridItemTitle() {
        return gridItemTitle;
    }

    public void setGridItemTitle(String gridItemTitle) {
        this.gridItemTitle = gridItemTitle;
    }
}
