package com.chuonghoang.service01.common.service;

import com.chuonghoang.service01.common.exception.CommandException;
import com.chuonghoang.service01.common.exception.TranslatedCommandException;
import com.chuonghoang.service01.common.response.ErrorResponse;
import com.chuonghoang.service01.common.response.SuccessResponse;
import org.springframework.http.ResponseEntity;


public interface ResponseService {
    <T> SuccessResponse<T> success(T data);

    SuccessResponse<?> success();

    SuccessResponse<?> successWithMsg(String msgCode);

    <T> SuccessResponse<T> successWithMsg(String msgCode, T data);

    ResponseEntity<ErrorResponse> error(CommandException exception);

    ResponseEntity<ErrorResponse> error(TranslatedCommandException exception);

    String getTraceId();
}
