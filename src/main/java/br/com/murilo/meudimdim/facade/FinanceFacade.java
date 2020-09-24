package br.com.murilo.meudimdim.facade;

import br.com.murilo.meudimdim.dto.request.FinanceRequest;
import br.com.murilo.meudimdim.dto.response.FinanceResponse;
import br.com.murilo.meudimdim.model.Finance;
import br.com.murilo.meudimdim.service.FinanceService;
import br.com.murilo.meudimdim.types.FinancesTypes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class FinanceFacade {

    private final FinanceService financeService;
    private final ConversionService conversionService;

    @Autowired
    public FinanceFacade(final FinanceService financeService,
                         final ConversionService conversionService) {
        this.financeService = financeService;
        this.conversionService = conversionService;
    }

    public FinanceResponse save(final String username, final FinanceRequest request) {
        final var finance = this.conversionService.convert(request, Finance.class);
        var savedFinance = this.financeService.save(finance);
        return this.conversionService.convert(savedFinance, FinanceResponse.class);
    }

    public List<FinanceResponse> findBy(final FinancesTypes type, final LocalDate startDate, final LocalDate endDate, final String username, final Pageable pageable) {
        var finances = this.financeService.findFinancesBy(type, startDate, endDate, username, pageable);
        return finances.stream().map(finance -> this.conversionService.convert(finance, FinanceResponse.class)).collect(Collectors.toList());
    }
}
