package RequestAndResponse.Response;

import RequestAndResponse.Requests.LogInRequest;
import RequestAndResponse.Requests.Request;
import com.google.gson.Gson;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;

public class JsonDeSerializerForRequest {


    public static HashMap<String, Class> map = new HashMap<>();

    public static void setMap() {
        map.clear();
        map.put("LogInRequest", LogInRequest.class);
    }


    public static Request deSerializeRequest(String requestString) {
        setMap();
        Gson gson = new Gson();
        for (String key : map.keySet()) {
            Class classOfCard = map.get(key);

            Request request2 = (Request) gson.fromJson(requestString, classOfCard);
            return request2;

        }
        return null;
    }


}
