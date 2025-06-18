package io.github.nicheengine.aerial.mqtt;

import io.github.nichetoolkit.rest.util.GeneralUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.integration.mqtt.inbound.MqttPahoMessageDrivenChannelAdapter;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;

@Slf4j
@Service
public class MqttTopicService implements AerialTopicService {
    
    @Resource
    private MqttPahoMessageDrivenChannelAdapter channelAdapter;
    
    @Override
    public void subscribe(String... topics)  {
        Set<String> topicSet = subscribedTopics();
        Arrays.stream(topics).filter(topic -> !topicSet.contains(topic)).forEach(topic -> subscribe(topic, 1));
    }

    @Override
    public void subscribe(String topic, int qos)  {
        Set<String> topicSet = subscribedTopics();
        if (!topicSet.contains(topic)) {
            channelAdapter.addTopic(topic, qos);
            log.debug("The service of mqtt subscribe topic: {}", topic);
        }
    }

    @Override
    public void unsubscribe(String... topics)  {
        log.debug("The service of mqtt unsubscribe topic: {}", Arrays.toString(topics));
        channelAdapter.removeTopic(topics);
    }

    @Override
    public Set<String> subscribedTopics()  {
        String[] topics = channelAdapter.getTopic();
        if (GeneralUtils.isNotEmpty(topics)) {
            return new HashSet<>(Arrays.asList(topics));
        }
        return Collections.emptySet();
    }
}
