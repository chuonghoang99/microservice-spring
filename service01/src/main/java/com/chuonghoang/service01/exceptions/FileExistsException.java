package com.chuonghoang.service01.exceptions;


public class FileExistsException extends RuntimeException {

    public FileExistsException(String message) {
        super(message);
    }
}
