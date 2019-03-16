package com.softron.constants;

import org.springframework.http.MediaType;

public interface ApiConstants {

    String EXTERNAL_MEDIA_TYPE = MediaType.APPLICATION_JSON_VALUE;

    String API_ENDPOINT = "/api";

    String ID = "id";

    String ID_PATH_VAR = "/{" + ID + "}";

    String ALL_VERB = ":all";
    
    String TREE_VERB = ":tree";

    String MODULE_ENDPOINT = API_ENDPOINT + "/module";

    String MENU_ENDPOINT = API_ENDPOINT + "/menu";

    String USERS_ENDPOINT = API_ENDPOINT + "/users";

    String ADVOCATE_ENDPOINT = API_ENDPOINT + "/advocate";

    String CASE_TYPE_ENDPOINT = API_ENDPOINT + "/casetype";

    String COURT_ENDPOINT = API_ENDPOINT + "/court";

    String PETITIONER_ENDPOINT = API_ENDPOINT + "/petitioner";

    String RESPONDENT_ENDPOINT = API_ENDPOINT + "/respondent";

    String STATUS_ENDPOINT = API_ENDPOINT + "/status";

    String LOCATION_ENDPOINT = API_ENDPOINT + "/location";

    String ORG_ENDPOINT = API_ENDPOINT + "/org";

    String ORG_TYPE_ENDPOINT = API_ENDPOINT + "/orgtype";

    /*Kashif Work end points*/
    String REPORT_END_POINT = API_ENDPOINT +"/reports";

    String REPORT_TYPE_END_POINT = API_ENDPOINT+"/report_types";
    /*End of Kashif Work*/

}
