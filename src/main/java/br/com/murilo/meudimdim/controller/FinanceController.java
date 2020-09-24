package br.com.murilo.meudimdim.controller;

import br.com.murilo.meudimdim.dto.request.FinanceRequest;
import br.com.murilo.meudimdim.dto.response.FinanceResponse;
import br.com.murilo.meudimdim.facade.FinanceFacade;
import br.com.murilo.meudimdim.types.FinancesTypes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import static org.springframework.data.domain.Sort.Direction.ASC;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.security.core.context.SecurityContextHolder;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/v1/finances")
public class FinanceController {

    private final FinanceFacade financeFacade;

    @Autowired
    public FinanceController(final FinanceFacade financeFacade) {
        this.financeFacade = financeFacade;
    }

    @PostMapping
    public ResponseEntity<FinanceResponse> save(final FinanceRequest request) {
        var username = getUsername();
        var response = this.financeFacade.save(username, request);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping("/expenses")
    public ResponseEntity<List<FinanceResponse>> findByExpenses(final LocalDate startDate,
                                                                final LocalDate endDate,
                                                                @PageableDefault(page = 0, size = 10, direction = ASC, sort = "date") final Pageable pageable) {

        var username = getUsername();
        var response = this.financeFacade.findBy(FinancesTypes.EXPENSES, startDate, endDate, username, pageable);

        return (response.isEmpty()) ? ResponseEntity.noContent().build() : ResponseEntity.ok(response);
    }

    @GetMapping("/gains")
    public ResponseEntity<List<FinanceResponse>> findByGains(final LocalDate startDate,
                                                                final LocalDate endDate,
                                                                @PageableDefault(page = 0, size = 10, direction = ASC, sort = "date") final Pageable pageable) {

        var username = getUsername();
        var response = this.financeFacade.findBy(FinancesTypes.GAINS, startDate, endDate, username, pageable);

        return (response.isEmpty()) ? ResponseEntity.noContent().build() : ResponseEntity.ok(response);
    }

    private String getUsername() {
        return SecurityContextHolder.getContext().getAuthentication().getPrincipal().toString();
    }
}
