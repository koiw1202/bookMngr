package com.bookMngr.common.error;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@Builder
@AllArgsConstructor
@ToString
public class ErrorHandler extends RuntimeException {

    private int status ;
    private String code ;
    private String message ;
    private String internalMessage ;

    public ErrorHandler(ErrorCode errorCode, String internalMessage) {
        super(errorCode.getMessage()) ;

        this.message = errorCode.getMessage() ;
        this.status = errorCode.getStatus() ;
        this.code = errorCode.getCode() ;
        this.internalMessage = internalMessage ;
    }

    public ErrorHandler(ErrorCode errorCode) {
        super(errorCode.getMessage()) ;

        this.message = errorCode.getMessage() ;
        this.status = errorCode.getStatus() ;
        this.code = errorCode.getCode() ;
        this.internalMessage = errorCode.getInternalMessage() ;
    }

    public ErrorHandler(String errorMsg, String code) {
        super(errorMsg);

        this.message = errorMsg ;
        this.code = code ;

    }

}
