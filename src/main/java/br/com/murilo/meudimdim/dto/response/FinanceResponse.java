package br.com.murilo.meudimdim.dto.response;

import br.com.murilo.meudimdim.types.FinancesFrequency;
import br.com.murilo.meudimdim.types.FinancesTypes;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

public class FinanceResponse {

    private UUID id;
    private String description;
    private BigDecimal amount;
    private FinancesTypes type;
    private FinancesFrequency frequency;
    private LocalDate date;

    public FinanceResponse(final UUID id, final String description, final BigDecimal amount, final FinancesTypes type, final FinancesFrequency frequency, final LocalDate date) {
        this.id = id;
        this.description = description;
        this.amount = amount;
        this.type = type;
        this.frequency = frequency;
        this.date = date;
    }

    public UUID getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public FinancesTypes getType() {
        return type;
    }

    public FinancesFrequency getFrequency() {
        return frequency;
    }

    public LocalDate getDate() {
        return date;
    }
}
