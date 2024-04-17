package com.chuonghoang.service01.common.service;

import com.chuonghoang.service01.common.response.ErrorCode;
import com.chuonghoang.service01.common.response.TranslatedErrorCode;

public interface TranslateService {
    String translate(String messageCode);

    String translateWithArgs(String messageCode, Object... args);

    String translateWithLang(String messageCode, String lang);

    String translateWithLangAndArgs(String messageCode, String lang, Object... args);

    TranslatedErrorCode[] translateErrorCodes(ErrorCode[] errorCodes, Object... args);

    TranslatedErrorCode[] translateErrorCodes(ErrorCode[] errorCodes);

    TranslatedErrorCode[] translateErrorCode(ErrorCode errorCode, Object[][] args);
}
