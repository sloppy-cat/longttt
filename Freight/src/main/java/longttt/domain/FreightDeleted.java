package longttt.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import longttt.domain.*;
import longttt.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class FreightDeleted extends AbstractEvent {

    private Integer id;
    private String origin;
    private String destination;
    private Double fee;
    private String status;
    private Integer freightOwnerId;

    public FreightDeleted(Freight aggregate) {
        super(aggregate);
    }

    public FreightDeleted() {
        super();
    }
}
//>>> DDD / Domain Event
