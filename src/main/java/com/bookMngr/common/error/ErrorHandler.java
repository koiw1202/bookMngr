package com.bookMngr.common.error;

import com.bookMngr.common.code.CommCd;
import lombok.*;

@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
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

    public ErrorHandler(String number) {
    }
}
