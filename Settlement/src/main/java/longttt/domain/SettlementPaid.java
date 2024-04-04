package longttt.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import longttt.domain.*;
import longttt.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class SettlementPaid extends AbstractEvent {

    private Long id;
    private Long carOwnerId;
    private Long freightOwnerId;
    private Double fee;
    private String state;

    public SettlementPaid(Settlement aggregate) {
        super(aggregate);
    }

    public SettlementPaid() {
        super();
    }
}
//>>> DDD / Domain Event
