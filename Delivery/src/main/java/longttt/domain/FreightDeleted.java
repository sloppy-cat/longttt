package longttt.domain;

import java.util.*;
import lombok.*;
import longttt.domain.*;
import longttt.infra.AbstractEvent;

@Data
@ToString
public class FreightDeleted extends AbstractEvent {

    private Integer id;
    private String origin;
    private String destination;
    private Double fee;
    private String status;
    private Integer freightOwnerId;
}
