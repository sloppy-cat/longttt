package longttt.domain;

import java.util.*;
import lombok.*;
import longttt.domain.*;
import longttt.infra.AbstractEvent;

@Data
@ToString
public class DeliveryTimeHasPassed extends AbstractEvent {

    private Long id;
    private Long freightId;
    private Long carOwnerId;
    private Date createdAt;
    private String state;
    private Boolean isRecieved;
    private Long freightOwnerId;
}
