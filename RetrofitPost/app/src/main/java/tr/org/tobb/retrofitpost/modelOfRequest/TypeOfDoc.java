package tr.org.tobb.retrofitpost.modelOfRequest;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by fatihkocak on 1.09.2018.
 */

public class TypeOfDoc {
    @SerializedName("type")
    @Expose
    private String type;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
