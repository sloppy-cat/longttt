package longttt.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import longttt.domain.*;
import longttt.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class DeliveryReceived extends AbstractEvent {

    private Long id;
    private Long freightId;
    private Long carOwnerId;
    private Date createdAt;
    private String state;
    private Boolean isRecieved;
    private Long freightOwnerId;

    public DeliveryReceived(FreightDelivery aggregate) {
        super(aggregate);
    }

    public DeliveryReceived() {
        super();
    }
}
//>>> DDD / Domain Event
