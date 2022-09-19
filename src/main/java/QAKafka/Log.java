package QAKafka;

import com.opencsv.bean.CsvBindByName;

public class Log {
    @CsvBindByName(column = "log.function")
    private String function;
    @CsvBindByName(column = "log.timestamp")
    private String timestamp;
    @CsvBindByName(column = "log.result")
    private String result;

    public String getFunction() {
        return function;
    }

    public void setFunction(String function) {
        this.function = function;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}
