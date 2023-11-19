package com.example.common.error;

import com.example.common.response.CommCd;
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

    public ErrorHandler(String message) {
        super(message) ;

        this.message = message ;
        this.status = CommCd.FAIL_STATUS ;
        this.code = CommCd.FAIL_CODE ;
    }


}
