package br.com.murilo.meudimdim.service;

import br.com.murilo.meudimdim.model.Finance;
import br.com.murilo.meudimdim.repository.FinanceRepository;
import br.com.murilo.meudimdim.types.FinancesTypes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class FinanceService {

    private final FinanceRepository financeRepository;

    @Autowired
    public FinanceService(final FinanceRepository financeRepository) {
        this.financeRepository = financeRepository;
    }

    public Finance save(final Finance finance) {
        return this.financeRepository.save(finance);
    }

    public List<Finance> findFinancesBy(final FinancesTypes type, final LocalDate startDate, final LocalDate endDate, final String username, final Pageable pageable) {
        return this.financeRepository.findByTypeAndDateBetweenAndUserEmail(type, startDate, endDate, username, pageable);
    }
}
