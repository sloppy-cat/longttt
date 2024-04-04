package longttt.infra;

import java.util.Optional;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;
import longttt.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//<<< Clean Arch / Inbound Adaptor

@RestController
// @RequestMapping(value="/freights")
@Transactional
public class FreightController {

    @Autowired
    FreightRepository freightRepository;

    @RequestMapping(
        value = "freights/",
        method = RequestMethod.POST,
        produces = "application/json;charset=UTF-8"
    )
    public Freight registFreight(
        HttpServletRequest request,
        HttpServletResponse response,
        @RequestBody Freight freight
    ) throws Exception {
        System.out.println("##### /freight/registFreight  called #####");
        freight.registFreight(registFreightcommand);
        freightRepository.save(freight);
        return freight;
    }

    @RequestMapping(
        value = "freights/{id}/selectfreight",
        method = RequestMethod.PUT,
        produces = "application/json;charset=UTF-8"
    )
    public Freight selectFreight(
        @PathVariable(value = "id") Integer id,
        @RequestBody SelectFreightCommand selectFreightCommand,
        HttpServletRequest request,
        HttpServletResponse response
    ) throws Exception {
        System.out.println("##### /freight/selectFreight  called #####");
        Optional<Freight> optionalFreight = freightRepository.findById(id);

        optionalFreight.orElseThrow(() -> new Exception("No Entity Found"));
        Freight freight = optionalFreight.get();
        freight.selectFreight(selectFreightCommand);

        freightRepository.save(freight);
        return freight;
    }
}
//>>> Clean Arch / Inbound Adaptor
