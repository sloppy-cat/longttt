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
    NotificationRepository notificationRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString) {}

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='SettlementPaid'"
    )
    public void wheneverSettlementPaid_CreateNotification(
        @Payload SettlementPaid settlementPaid
    ) {
        SettlementPaid event = settlementPaid;
        System.out.println(
            "\n\n##### listener CreateNotification : " + settlementPaid + "\n\n"
        );
        // Sample Logic //

    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='DeliveryCompleted'"
    )
    public void wheneverDeliveryCompleted_CreateNotification(
        @Payload DeliveryCompleted deliveryCompleted
    ) {
        DeliveryCompleted event = deliveryCompleted;
        System.out.println(
            "\n\n##### listener CreateNotification : " +
            deliveryCompleted +
            "\n\n"
        );
        // Sample Logic //

    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='DeliveryStarted'"
    )
    public void wheneverDeliveryStarted_CreateNotification(
        @Payload DeliveryStarted deliveryStarted
    ) {
        DeliveryStarted event = deliveryStarted;
        System.out.println(
            "\n\n##### listener CreateNotification : " +
            deliveryStarted +
            "\n\n"
        );
        // Sample Logic //

    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='DeliveryCanceled'"
    )
    public void wheneverDeliveryCanceled_CreateNotification(
        @Payload DeliveryCanceled deliveryCanceled
    ) {
        DeliveryCanceled event = deliveryCanceled;
        System.out.println(
            "\n\n##### listener CreateNotification : " +
            deliveryCanceled +
            "\n\n"
        );
        // Sample Logic //

    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='FreightRegistered'"
    )
    public void wheneverFreightRegistered_CreateNotification(
        @Payload FreightRegistered freightRegistered
    ) {
        FreightRegistered event = freightRegistered;
        System.out.println(
            "\n\n##### listener CreateNotification : " +
            freightRegistered +
            "\n\n"
        );
        // Sample Logic //

    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='DeliveryTimeHasPassed'"
    )
    public void wheneverDeliveryTimeHasPassed_CreateNotification(
        @Payload DeliveryTimeHasPassed deliveryTimeHasPassed
    ) {
        DeliveryTimeHasPassed event = deliveryTimeHasPassed;
        System.out.println(
            "\n\n##### listener CreateNotification : " +
            deliveryTimeHasPassed +
            "\n\n"
        );
        // Sample Logic //

    }
}
//>>> Clean Arch / Inbound Adaptor
