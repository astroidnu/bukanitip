package dietbisabesok.com.bukanitip.helper;

/**
 * Created by ibnumuzzakkir on 5/24/17.
 */

public interface AppConst {
    interface activity_request_code{
        int SELECT_PICTURE= 0;
    }
    interface  database_name{
        String TAG_DATABASE_NAME = "bukanitipdb";
    }
    interface fragment_type{
        String TAG_FRAGMENT_HOME = "home";
        String TAG_FRAGMENT_MY_REQUEST = "my_request";
        String TAG_FRAGMENT_MY_TRIP = "my_trip";
        String TAG_FRAGMENT_PROFILE = "profile";
    }
    interface base_url{
        String TAG_LOCAL_BASE_URL = "http://katakamu.id/bukanitip/api_001/index.php/api/";
    }
}
