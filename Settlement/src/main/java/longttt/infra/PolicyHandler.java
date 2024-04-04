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
    SettlementRepository settlementRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString) {}

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='DeliveryReceived'"
    )
    public void wheneverDeliveryReceived_CreateSettlement(
        @Payload DeliveryReceived deliveryReceived
    ) {
        DeliveryReceived event = deliveryReceived;
        System.out.println(
            "\n\n##### listener CreateSettlement : " + deliveryReceived + "\n\n"
        );

        // Sample Logic //
        Settlement.createSettlement(event);
    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='DeliveryTimeHasPassed'"
    )
    public void wheneverDeliveryTimeHasPassed_CreateSettlement(
        @Payload DeliveryTimeHasPassed deliveryTimeHasPassed
    ) {
        DeliveryTimeHasPassed event = deliveryTimeHasPassed;
        System.out.println(
            "\n\n##### listener CreateSettlement : " +
            deliveryTimeHasPassed +
            "\n\n"
        );

        // Sample Logic //
        Settlement.createSettlement(event);
    }
}
//>>> Clean Arch / Inbound Adaptor
