package br.com.murilo.meudimdim.dto.request;

import br.com.murilo.meudimdim.types.FinancesFrequency;
import br.com.murilo.meudimdim.types.FinancesTypes;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

public class FinanceRequest {

    private UUID id;
    private String description;
    private BigDecimal amount;
    private FinancesTypes type;
    private FinancesFrequency frequency;
    private LocalDate date;
    private String username;

    public FinanceRequest(final UUID id, final String description, final BigDecimal amount, final FinancesTypes type, final FinancesFrequency frequency, final LocalDate date, final String username) {
        this.id = id;
        this.description = description;
        this.amount = amount;
        this.type = type;
        this.frequency = frequency;
        this.date = date;
        this.username = username;
    }

    public UUID getId() {
        return id;
    }

    public void setId(final UUID id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(final String description) {
        this.description = description;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(final BigDecimal amount) {
        this.amount = amount;
    }

    public FinancesTypes getType() {
        return type;
    }

    public void setType(final FinancesTypes type) {
        this.type = type;
    }

    public FinancesFrequency getFrequency() {
        return frequency;
    }

    public void setFrequency(final FinancesFrequency frequency) {
        this.frequency = frequency;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(final LocalDate date) {
        this.date = date;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(final String username) {
        this.username = username;
    }
}
