package longttt.domain;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;
import longttt.DeliveryApplication;
import longttt.domain.DeliveryCanceled;
import longttt.domain.DeliveryCompleted;
import longttt.domain.DeliveryReceived;
import longttt.domain.DeliveryStarted;
import longttt.domain.DeliveryTimeHasPassed;

@Entity
@Table(name = "FreightDelivery_table")
@Data
//<<< DDD / Aggregate Root
public class FreightDelivery {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Long freightId;

    private Long carOwnerId;

    private Date createdAt;

    private String state;

    private Boolean isRecieved;

    private Long freightOwnerId;

    @PostPersist
    public void onPostPersist() {
        DeliveryStarted deliveryStarted = new DeliveryStarted(this);
        deliveryStarted.publishAfterCommit();
    }

    @PostUpdate
    public void onPostUpdate() {
        DeliveryCompleted deliveryCompleted = new DeliveryCompleted(this);
        deliveryCompleted.publishAfterCommit();

        //Following code causes dependency to external APIs
        // it is NOT A GOOD PRACTICE. instead, Event-Policy mapping is recommended.

        longttt.external.FreightDelivery freightDelivery = new longttt.external.FreightDelivery();
        // mappings goes here
        DeliveryApplication.applicationContext
            .getBean(longttt.external.FreightDeliveryService.class)
            .completeDelivery(freightDelivery);

        DeliveryTimeHasPassed deliveryTimeHasPassed = new DeliveryTimeHasPassed(
            this
        );
        deliveryTimeHasPassed.publishAfterCommit();

        DeliveryReceived deliveryReceived = new DeliveryReceived(this);
        deliveryReceived.publishAfterCommit();
    }

    @PostRemove
    public void onPostRemove() {
        DeliveryCanceled deliveryCanceled = new DeliveryCanceled(this);
        deliveryCanceled.publishAfterCommit();
    }

    @PreRemove
    public void onPreRemove() {}

    public static FreightDeliveryRepository repository() {
        FreightDeliveryRepository freightDeliveryRepository = DeliveryApplication.applicationContext.getBean(
            FreightDeliveryRepository.class
        );
        return freightDeliveryRepository;
    }
}
//>>> DDD / Aggregate Root
