package tr.org.tobb.retrofitpost.modelOfData;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by fatihkocak on 1.09.2018.
 */

public class RuleTemplateArr {
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("metaType")
    @Expose
    private String metaType;
    @SerializedName("metaTitle")
    @Expose
    private String metaTitle;
    @SerializedName("conditions")
    @Expose
    private List<ConditionActionCards> conditions = null;
    @SerializedName("metaStruct")
    @Expose
    private String metaStruct;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMetaType() {
        return metaType;
    }

    public void setMetaType(String metaType) {
        this.metaType = metaType;
    }

    public String getMetaTitle() {
        return metaTitle;
    }

    public void setMetaTitle(String metaTitle) {
        this.metaTitle = metaTitle;
    }

    public List<ConditionActionCards> getConditions() {
        return conditions;
    }

    public void setConditions(List<ConditionActionCards> conditions) {
        this.conditions = conditions;
    }

    public String getMetaStruct() {
        return metaStruct;
    }

    public void setMetaStruct(String metaStruct) {
        this.metaStruct = metaStruct;
    }
}
