import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.apache.kafka.common.serialization.Serializer;

import java.util.Map;

public class GsonSerializer<T> implements Serializer<T> {

    private Gson gson = new GsonBuilder().create();
    @Override
    public void configure(Map<String, ?> config, boolean isKey) {

    }

    @Override
    public byte[] serialize(String s, Object t) {
        return gson.toJson(t).getBytes();
    }

    @Override
    public void close() {

    }
}
