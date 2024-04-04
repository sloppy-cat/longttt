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
    public void onPostPersist() {}

    @PostUpdate
    public void onPostUpdate() {
        DeliveryStarted deliveryStarted = new DeliveryStarted(this);
        deliveryStarted.publishAfterCommit();

        DeliveryCompleted deliveryCompleted = new DeliveryCompleted(this);
        deliveryCompleted.publishAfterCommit();

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

    public static FreightDeliveryRepository repository() {
        FreightDeliveryRepository freightDeliveryRepository = DeliveryApplication.applicationContext.getBean(
            FreightDeliveryRepository.class
        );
        return freightDeliveryRepository;
    }

    //<<< Clean Arch / Port Method
    public static void registerDelivery(FreightSelected freightSelected) {
        //implement business logic here:

        /** Example 1:  new item 
        FreightDelivery freightDelivery = new FreightDelivery();
        repository().save(freightDelivery);

        */

        /** Example 2:  finding and process
        
        repository().findById(freightSelected.get???()).ifPresent(freightDelivery->{
            
            freightDelivery // do something
            repository().save(freightDelivery);


         });
        */

    }

    //>>> Clean Arch / Port Method
    //<<< Clean Arch / Port Method
    public static void deleteDelivery(FreightDeleted freightDeleted) {
        //implement business logic here:

        /** Example 1:  new item 
        FreightDelivery freightDelivery = new FreightDelivery();
        repository().save(freightDelivery);

        FreightDeleted freightDeleted = new FreightDeleted(freightDelivery);
        freightDeleted.publishAfterCommit();
        DeliveryCanceled deliveryCanceled = new DeliveryCanceled(freightDelivery);
        deliveryCanceled.publishAfterCommit();
        */

        /** Example 2:  finding and process
        
        repository().findById(freightDeleted.get???()).ifPresent(freightDelivery->{
            
            freightDelivery // do something
            repository().save(freightDelivery);

            FreightDeleted freightDeleted = new FreightDeleted(freightDelivery);
            freightDeleted.publishAfterCommit();
            DeliveryCanceled deliveryCanceled = new DeliveryCanceled(freightDelivery);
            deliveryCanceled.publishAfterCommit();

         });
        */

    }
    //>>> Clean Arch / Port Method

}
//>>> DDD / Aggregate Root
