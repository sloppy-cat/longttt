package longttt.domain;

import java.util.*;
import lombok.*;
import longttt.domain.*;
import longttt.infra.AbstractEvent;

@Data
@ToString
public class SettlementPaid extends AbstractEvent {

    private Long id;
    private Long carOwnerId;
    private Long freightOwnerId;
    private String state;
}
