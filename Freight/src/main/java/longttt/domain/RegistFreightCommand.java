package longttt.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.Data;

@Data
public class RegistFreightCommand {

    private Integer id;
    private String origin;
    private String destination;
    private Double fee;
    private String status;
    private Integer freightOwnerId;
}
