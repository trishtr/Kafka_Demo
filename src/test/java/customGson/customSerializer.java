package customGson;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;

public class customSerializer {

    public customSerializer (genericPayload payload) {
        Type typeToken = null;

       if(typeToken == new TypeToken<genericPayload<String>>() {}.getType())
       {
           new Gson().toJson(payload, typeToken);
       }
       else if (typeToken == new TypeToken<genericPayload<censusPayload>>() {}.getType())
       {
         new Gson().toJson(payload, typeToken);
       } else if (typeToken == new TypeToken<genericPayload<Integer>>() {}.getType())
       {
          new Gson().toJson(payload, typeToken);
       }
    }
}