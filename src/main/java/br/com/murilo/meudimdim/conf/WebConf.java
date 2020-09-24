package br.com.murilo.meudimdim.conf;

import br.com.murilo.meudimdim.converter.FinanceRequestToFinanceConverter;
import br.com.murilo.meudimdim.converter.FinanceToFinanceResponseConverter;
import br.com.murilo.meudimdim.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.core.convert.ConversionService;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConf implements WebMvcConfigurer {

    private final UserService userService;

    public WebConf(@Autowired final UserService userService) {
        this.userService = userService;
    }

    @Override
    public void addFormatters(final FormatterRegistry registry) {
        registry.addConverter(new FinanceRequestToFinanceConverter(this.userService));
        registry.addConverter(new FinanceToFinanceResponseConverter());
    }
}
