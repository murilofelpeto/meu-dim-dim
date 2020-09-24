package br.com.murilo.meudimdim.converter;

import br.com.murilo.meudimdim.dto.request.FinanceRequest;
import br.com.murilo.meudimdim.model.Finance;
import br.com.murilo.meudimdim.model.User;
import br.com.murilo.meudimdim.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;

public class FinanceRequestToFinanceConverter implements Converter<FinanceRequest, Finance> {

    private final UserService userService;

    @Autowired
    public FinanceRequestToFinanceConverter(final UserService userService) {
        this.userService = userService;
    }

    @Override
    public Finance convert(final FinanceRequest financeRequest) {
        final var user = this.userService.findByEmail(financeRequest.getUsername());
        
        return new Finance(
                financeRequest.getId(),
                financeRequest.getDescription(),
                financeRequest.getAmount(),
                financeRequest.getType(),
                financeRequest.getFrequency(),
                financeRequest.getDate(),
                user);
    }
}
