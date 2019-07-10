package tr.com.fkocak.retrofitpostwithheader.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ResponseData {

    @SerializedName("resultList")
    @Expose
    private ResultList resultList;

    public ResultList getResultList() {
        return resultList;
    }

    public void setResultList(ResultList resultList) {
        this.resultList = resultList;
    }


}
