package tr.org.tobb.retrofitpost.api;

import tr.org.tobb.retrofitpost.api.interfaced.APIService;

/**
 * Created by fatihkocak on 1.09.2018.
 */

public class ApiUtils {
    private ApiUtils() {}

    public static final String BASE_URL = "http://node-express-env.apx3d27ccn.eu-west-1.elasticbeanstalk.com/";

    public static APIService getAPIService() {

        return RetrofitClient.getClient(BASE_URL).create(APIService.class);
    }
}
