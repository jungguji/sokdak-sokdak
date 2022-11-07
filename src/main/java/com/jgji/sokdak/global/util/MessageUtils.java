package com.jgji.sokdak.global.util;

import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.util.ObjectUtils;

import java.util.Locale;

public class MessageUtils {

    private static MessageSourceAccessor msa;

    public static void setMessageSourceAccessor(MessageSourceAccessor messageSourceAccessor) {
        msa = messageSourceAccessor;
    }

    public static String getMessage(String code) {
        return msa.getMessage(code, Locale.getDefault());
    }

    public static String getMessage(String code, String[] args) {
        return msa.getMessage(code, args, Locale.getDefault());
    }

    public static String[] getIntegerArgs(Integer... args) {
        if (ObjectUtils.isEmpty(args)) {
            return new String[] {};
        }

        Integer[] integers = args;
        String[] messageArgs = new String[integers.length];

        for (int i = 0; i < integers.length; i++) {
            messageArgs[i] = numberToNumberString(integers[i]);
        }

        return messageArgs;
    }

    private static String numberToNumberString(int number) {
        return String.format("%,d", Math.abs(number));
    }

}
