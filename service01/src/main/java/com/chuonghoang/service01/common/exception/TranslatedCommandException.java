package com.chuonghoang.service01.common.exception;


import com.chuonghoang.service01.common.response.TranslatedErrorCode;

import java.util.Arrays;

public class TranslatedCommandException extends RuntimeException {
    private final transient TranslatedErrorCode[] errorCodes;

    public TranslatedCommandException(String message, TranslatedErrorCode[] errorCodes) {
        super(message);
        this.errorCodes = errorCodes;
    }

    public String toString() {
        String var10000 = super.getMessage();
        return "TranslatedCommandException[message=" + var10000 + ",errorCodes=" + Arrays.toString(this.errorCodes) + "]";
    }

    public TranslatedErrorCode[] getErrorCodes() {
        return this.errorCodes;
    }
}

