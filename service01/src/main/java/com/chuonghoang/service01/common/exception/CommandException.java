package com.chuonghoang.service01.common.exception;



import com.chuonghoang.service01.common.response.ErrorCode;

import java.util.Arrays;

public class CommandException extends RuntimeException {
    private final transient ErrorCode[] errorCodes;
    private final transient Object[] args;

    public CommandException(String message, ErrorCode[] errorCodes) {
        super(message);
        this.errorCodes = errorCodes;
        this.args = null;
    }

    public CommandException(String message, ErrorCode[] errorCodes, Object[] args) {
        super(message);
        this.errorCodes = errorCodes;
        this.args = args;
    }

    public String toString() {
        String var10000 = super.getMessage();
        return "CommandException[message=" + var10000 + ",errorCodes=" + Arrays.toString(this.errorCodes) + ",args=" + Arrays.toString(this.args) + "]";
    }

    public ErrorCode[] getErrorCodes() {
        return this.errorCodes;
    }

    public Object[] getArgs() {
        return this.args;
    }
}