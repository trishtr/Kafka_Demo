package map;

import com.google.gson.Gson;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import static org.apache.commons.collections4.IteratorUtils.forEach;

public class testGson {

    public static void main(String[] args) {
        Gson gson = new Gson();
        String jsonString = "{\"payload\":[" +
                "{block_size:4, " +
                "census_data:[{unit_code:\"2W\"," +
                "forecast_datetime:\"2022-12-31T23:00:00.000-05:00\"," +
                "predicted_census:8.39000034338}]}]}";


        TestPayload test1 = gson.fromJson(jsonString, TestPayload.class);


        System.out.println(gson.toJson(test1));

        System.out.println(gson.toJson(test1.getPayload()));


        for(int i = 0; i< test1.getPayload().size(); i ++ )
        {   //[]
            Map payload = test1.getPayload().get(i);

            System.out.println(payload.get("census_data"));
            //casting list<map> to the object
            List<Map> censusData = (List<Map>) payload.get("census_data");
            System.out.println(censusData.get(0));


        }

    }
}
