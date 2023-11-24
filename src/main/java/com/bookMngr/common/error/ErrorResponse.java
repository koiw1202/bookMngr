package com.bookMngr.common.error;

import com.bookMngr.common.constant.CCConst;
import com.bookMngr.common.response.ApiResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpStatus;

import javax.servlet.http.HttpServletResponse;
import java.io.DataOutputStream;

import static com.bookMngr.common.error.ErrorMessage.MSG_ERROR_002;
import static com.bookMngr.common.error.ErrorMessage.MSG_ERROR_003;

/**
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023-11-24        koiw1       최초 생성
 */
public class ErrorResponse {

    /**
     * 401 Response
     *
     * @param httpResponse
     */
    public static void setUnauthorizedResponse(HttpServletResponse httpResponse) {

        try (DataOutputStream printWriter = new DataOutputStream(httpResponse.getOutputStream())) {
            httpResponse.setStatus(HttpStatus.FORBIDDEN.value());
            httpResponse.setContentType("application/json");

            printWriter.write((new ObjectMapper()).writeValueAsBytes(
                    ApiResponse.builder()
                            .status(401)
                            .code(CCConst.FAIL_CODE)
                            .message(MSG_ERROR_002)
                            .build()
            ));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    /**
     * 401 Response
     *
     * @param httpResponse
     */
    public static void setForbiddenResponse(HttpServletResponse httpResponse) {

        try(DataOutputStream printWriter = new DataOutputStream(httpResponse.getOutputStream())) {
            httpResponse.setStatus(HttpStatus.FORBIDDEN.value());
            httpResponse.setContentType("application/json");

            printWriter.write((new ObjectMapper()).writeValueAsBytes(
                    ApiResponse.builder()
                            .status(403)
                            .code(CCConst.FAIL_CODE)
                            .message(MSG_ERROR_003)
                            .build()
            ));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
