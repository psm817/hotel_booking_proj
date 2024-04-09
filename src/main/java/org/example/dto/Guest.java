package org.example.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Guest extends Dto {
    public String regDate;      // 회원 등록 날짜
    public String loginId;      // 로그인 id
    public String loginPw;      // 로그인 pw
    public String name;         // 회원 이름
    public String email;        // 회원 이메일
    public String phoneNum;     // 회원 휴대전화

    public Guest(int id, String regDate, String loginId, String loginPw, String name, String email, String phoneNum) {
        this.id = id;
        this.regDate = regDate;
        this.loginId = loginId;
        this.loginPw = loginPw;
        this.name = name;
        this.email = email;
        this.phoneNum = phoneNum;
    }
}
