package tr.org.tobb.retrofitpost.modelOfData;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by fatihkocak on 1.09.2018.
 */

public class ResultActionCards {
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("docTypeGroup")
    @Expose
    private String docTypeGroup;
    @SerializedName("ruleTemplateArr")
    @Expose
    private List<RuleTemplateArr> ruleTemplateArr = null;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDocTypeGroup() {
        return docTypeGroup;
    }

    public void setDocTypeGroup(String docTypeGroup) {
        this.docTypeGroup = docTypeGroup;
    }

    public List<RuleTemplateArr> getRuleTemplateArr() {
        return ruleTemplateArr;
    }

    public void setRuleTemplateArr(List<RuleTemplateArr> ruleTemplateArr) {
        this.ruleTemplateArr = ruleTemplateArr;
    }
}
