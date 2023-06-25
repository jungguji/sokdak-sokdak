package com.jgji.sokdak.domain.group.domain;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.stream.IntStream;

@Slf4j
class GroupInvitationTest {

    @DisplayName("랜덤 코드 생성")
    @Test
    void test() {
        IntStream.range(0, 20)
                .forEach(i -> System.out.println("random " + i + " = " + RandomStringUtils.randomAlphanumeric(8)));
    }
}