package br.com.murilo.meudimdim.model;

import br.com.murilo.meudimdim.types.FinancesFrequency;
import br.com.murilo.meudimdim.types.FinancesTypes;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;
import java.util.UUID;

@Entity
public class Finance {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "finance_id", updatable = false, unique = true, nullable = false)
    private UUID financeId;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "amount", nullable = false, precision = 9, scale = 2)
    private BigDecimal amount;

    @Enumerated(EnumType.STRING)
    private FinancesTypes type;

    @Enumerated(EnumType.STRING)
    private FinancesFrequency frequency;

    @Column(name = "date", nullable = false)
    private LocalDate date;

    @ManyToOne(cascade = CascadeType.ALL)
    private User user;

    public Finance(final UUID financeId, final String description, final BigDecimal amount, final FinancesTypes type, final FinancesFrequency frequency, final LocalDate date, final User user) {
        this.financeId = financeId;
        this.description = description;
        this.amount = amount;
        this.type = type;
        this.frequency = frequency;
        this.date = date;
        this.user = user;
    }

    public UUID getFinanceId() {
        return financeId;
    }

    public void setFinanceId(final UUID financeId) {
        this.financeId = financeId;
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

    public User getUser() {
        return user;
    }

    public void setUser(final User user) {
        this.user = user;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (!(o instanceof Finance)) return false;
        final Finance finance = (Finance) o;
        return getFinanceId().equals(finance.getFinanceId()) &&
                getDescription().equals(finance.getDescription()) &&
                getAmount().equals(finance.getAmount()) &&
                getType() == finance.getType() &&
                getFrequency() == finance.getFrequency() &&
                getDate().equals(finance.getDate()) &&
                getUser().equals(finance.getUser());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getFinanceId(), getDescription(), getAmount(), getType(), getFrequency(), getDate(), getUser());
    }
}
