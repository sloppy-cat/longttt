package longttt.domain;

import java.util.Date;
import java.util.List;
import longttt.domain.*;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

//<<< PoEAA / Repository
@RepositoryRestResource(collectionResourceRel = "freights", path = "freights")
public interface FreightRepository
    extends PagingAndSortingRepository<Freight, Integer> {}
