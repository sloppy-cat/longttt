package longttt.domain;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;
import longttt.SettlementApplication;
import longttt.domain.SettlementPaid;

@Entity
@Table(name = "Settlement_table")
@Data
//<<< DDD / Aggregate Root
public class Settlement {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Long carOwnerId;

    private Long freightOwnerId;

    private Double fee;

    private String state;

    @PostPersist
    public void onPostPersist() {
        SettlementPaid settlementPaid = new SettlementPaid(this);
        settlementPaid.publishAfterCommit();
    }

    public static SettlementRepository repository() {
        SettlementRepository settlementRepository = SettlementApplication.applicationContext.getBean(
            SettlementRepository.class
        );
        return settlementRepository;
    }
}
//>>> DDD / Aggregate Root
