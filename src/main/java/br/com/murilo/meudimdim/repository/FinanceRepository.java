package br.com.murilo.meudimdim.repository;

import br.com.murilo.meudimdim.model.Finance;
import br.com.murilo.meudimdim.types.FinancesTypes;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Repository
public interface FinanceRepository extends JpaRepository<Finance, UUID> {

    List<Finance> findByTypeAndDateBetweenAndUserEmail(FinancesTypes type, LocalDate startDate, LocalDate endDate, String email, Pageable pageable);
}
