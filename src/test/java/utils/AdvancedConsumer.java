package utils;

import com.google.common.util.concurrent.ThreadFactoryBuilder;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.KafkaConsumer;

import java.io.Serializable;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;

public class AdvancedConsumer<K extends Serializable, V extends Serializable> implements Runnable {

    private KafkaConsumer<K, V> consumer;
    private final String clientId;

    private List<String> topics;

    //multiple threads need to check and change the boolean
    private AtomicBoolean closed = new AtomicBoolean();

    //CountDownLatch is used when a thread needs to wait for the other threads before starting its work

    private CountDownLatch shutdownLatch = new CountDownLatch(1);

    public AdvancedConsumer(Properties configs, String clientId, List<String> topics){
        this.clientId = clientId;
        this.topics = topics;
        configs.put(ConsumerConfig.CLIENT_ID_CONFIG, clientId);
        this.consumer = new KafkaConsumer<>(configs);
    }


    @Override
    public void run() {

        Log.info("Starting consumer: " + clientId);
        //Java concurrent
        ExecutorService executor = Executors.newSingleThreadExecutor(new ThreadFactoryBuilder().setNameFormat(clientId + "_Processor").build());
    }

}