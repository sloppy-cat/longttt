package longttt.domain;

import java.util.*;
import lombok.*;
import longttt.domain.*;
import longttt.infra.AbstractEvent;

@Data
@ToString
public class FreightSelected extends AbstractEvent {

    private Integer id;
    private String origin;
    private String destination;
    private String status;
    private Integer freightOwnerId;
    private String carOwnerId;
    private Double fee;
}
