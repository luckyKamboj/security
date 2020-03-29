package com.tech.kamboj.component;

public interface ResponseCode {
    int OK = 200;
    int NOT_FOUND = 404;
    int NO_CONTENT = 204;
    int CONFLICT = 409;
    int UNAUTHORIZED_USER = 403;
    int NOT_VALID_USER = 707;
    int NOT_ELIGIBLE = 708;
    int ERROR_IN_SAVE = 800;
    String OK_CODE = "OK";
    String NOT_FOUND_CODE = "NOT_FOUND";
    String NO_CONTENT_CODE = "NO_CONTENT";
    String CONFLICT_CODE = "CONFLICT";
    String ERROR_IN_SAVE_CODE = "ERROR_IN_SAVE_CODE";
}
