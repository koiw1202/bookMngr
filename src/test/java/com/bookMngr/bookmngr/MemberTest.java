package com.bookMngr.bookmngr;

import com.bookMngr.member.model.MemberDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static com.bookMngr.common.constant.RegExpConstants.*;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("local")
public class MemberTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void joinMember() {

//        mockMvc.perform(
//           MockMvcRequestBuilders.post("localhost:8080/v1.0.0/member")
//                   .contentType(MediaType.APPLICATION_JSON)
//                   .content(MemberDto.bu)
//
//        ) ;

    }

}
