package com.jgji.sokdak.global.config;

import com.jgji.sokdak.global.util.MessageUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.MessageSourceAccessor;


@RequiredArgsConstructor
@Configuration
public class MessageConfig {

    private final MessageSource messageSource;

    @Bean
    public MessageSourceAccessor messageSourceAccessor() {
        MessageSourceAccessor sourceAccessor = new MessageSourceAccessor(messageSource);
        MessageUtils.setMessageSourceAccessor(sourceAccessor);
        return sourceAccessor;
    }
}
