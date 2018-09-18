package system.exception;

import system.requesthandle.StatusCode;

public class Exception extends RuntimeException {

    private StatusCode code = StatusCode.ERROR;

    public Exception() {
        super();
    }

    public Exception(String message) {
        super(message);
    }

    public Exception(StatusCode code, String message) {
        super(message);
        this.code = code;
    }

    public StatusCode getCode() {
        return code;
    }

    public void setCode(StatusCode code) {
        this.code = code;
    }



}
