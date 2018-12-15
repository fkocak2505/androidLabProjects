package tr.org.tobb.retrofitpost.modelOfData;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by fatihkocak on 1.09.2018.
 */

public class Response4ActionCards {
    @SerializedName("success")
    @Expose
    private Boolean success;
    @SerializedName("result")
    @Expose
    private List<ResultActionCards> result = null;

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public List<ResultActionCards> getResult() {
        return result;
    }

    public void setResult(List<ResultActionCards> result) {
        this.result = result;
    }
}
