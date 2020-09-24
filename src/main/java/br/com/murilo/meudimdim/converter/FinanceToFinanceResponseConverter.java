package br.com.murilo.meudimdim.converter;

import br.com.murilo.meudimdim.dto.response.FinanceResponse;
import br.com.murilo.meudimdim.model.Finance;
import org.springframework.core.convert.converter.Converter;

public class FinanceToFinanceResponseConverter implements Converter<Finance, FinanceResponse> {

    @Override
    public FinanceResponse convert(final Finance finance) {
        return new FinanceResponse(
                finance.getFinanceId(),
                finance.getDescription(),
                finance.getAmount(),
                finance.getType(),
                finance.getFrequency(),
                finance.getDate());
    }
}
