package longttt.infra;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import javax.naming.NameParser;
import javax.naming.NameParser;
import javax.transaction.Transactional;
import longttt.config.kafka.KafkaProcessor;
import longttt.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

//<<< Clean Arch / Inbound Adaptor
@Service
@Transactional
public class PolicyHandler {

    @Autowired
    FreightDeliveryRepository freightDeliveryRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString) {}

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='FreightSelected'"
    )
    public void wheneverFreightSelected_RegisterDelivery(
        @Payload FreightSelected freightSelected
    ) {
        FreightSelected event = freightSelected;
        System.out.println(
            "\n\n##### listener RegisterDelivery : " + freightSelected + "\n\n"
        );
        // Sample Logic //

    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='FreightDeleted'"
    )
    public void wheneverFreightDeleted_DeleteDelivery(
        @Payload FreightDeleted freightDeleted
    ) {
        FreightDeleted event = freightDeleted;
        System.out.println(
            "\n\n##### listener DeleteDelivery : " + freightDeleted + "\n\n"
        );
        // Sample Logic //

    }
}
//>>> Clean Arch / Inbound Adaptor
