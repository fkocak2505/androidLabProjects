package tr.com.fkocak.retrofitpostwithheader.api;

import tr.com.fkocak.retrofitpostwithheader.api.interfaced.APIService;

/**
 * Created by fatihkocak on 25.04.2019.
 */

public class ApiUtils {
    private ApiUtils() {}

    public static final String BASE_URL = "http://10.0.201.87:8872/";

    public static APIService getAPIService() {

        return RetrofitClient.getClient(BASE_URL).create(APIService.class);
    }
}
