package longttt.domain;

import java.util.*;
import lombok.*;
import longttt.domain.*;
import longttt.infra.AbstractEvent;

@Data
@ToString
public class FreightRegistered extends AbstractEvent {

    private Long id;
    private String origin;
    private String destination;
    private Double fee;
    private String status;
    private Long freightOwnerId;
}
