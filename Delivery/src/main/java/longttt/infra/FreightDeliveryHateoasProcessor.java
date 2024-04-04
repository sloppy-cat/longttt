package longttt.infra;

import longttt.domain.*;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelProcessor;
import org.springframework.stereotype.Component;

@Component
public class FreightDeliveryHateoasProcessor
    implements RepresentationModelProcessor<EntityModel<FreightDelivery>> {

    @Override
    public EntityModel<FreightDelivery> process(
        EntityModel<FreightDelivery> model
    ) {
        return model;
    }
}
