package customGson;

public class genericPayload<T> {

    private T payLoadContent;

    public genericPayload(T t) {
        this.payLoadContent = t;
    }
}
