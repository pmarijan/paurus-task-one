package si.primoz.paurustaskone.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import si.primoz.paurustaskone.dto.Incoming;
import si.primoz.paurustaskone.dto.Outgoing;
import si.primoz.paurustaskone.service.TaxationService;

@RestController
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class TaxationRestController {

    private final TaxationService taxationService;

    @PostMapping("/bet/")
    Outgoing placeBet(@RequestBody Incoming incoming) {
        return taxationService.calculateTaxation(incoming);
    }
}
