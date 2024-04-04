package longttt.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import longttt.domain.*;
import longttt.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class FreightSelected extends AbstractEvent {

    private Long id;
    private String origin;
    private String destination;
    private String status;
    private String carOwnerId;
    private Double fee;
    private Long freightOwnerId;

    public FreightSelected(Freight aggregate) {
        super(aggregate);
    }

    public FreightSelected() {
        super();
    }
}
//>>> DDD / Domain Event
