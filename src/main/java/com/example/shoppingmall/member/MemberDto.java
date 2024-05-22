package com.example.shoppingmall.member;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MemberDto {
    // MemberRequestDto, MemberResponseDto
    // SignUpReqDto, SignUpResDto
    // LoginReqDto, LoginResDto
    private int id;

    @JsonProperty("user_id")
    @NotBlank(message = "아이디는 필수 입력입니다.")
    private String userId;

    @NotBlank(message = "비밀번호는 필수 입력입니다.")
    @Size(min=8, message = "최소 8자리 이상 입력해주세요.")
    private String pw;

    @NotBlank(message = "이름은 필수 입력입니다.")
    private String name;

    @Pattern(regexp = "^[a-zA-Z0-9+-_.]+@[a-zA-Z0-9-]+.[a-zA-Z]+$", message = "올바른 이메일 형식을 입력하세요.")
    @NotBlank(message = "이메일은 필수 입력입니다.")
    private String email;

    @Pattern(regexp = "^\\d{3}-\\d{3,4}-\\d{4}$", message = "올바른 연락처 형식이 아닙니다. ex. 010-0000-0000")
    @NotBlank(message = "연락처는 필수 입력입니다.")
    private String contact;

    public Member convertToEntity() {
        return new Member(userId, pw, name, email, contact);
    }
}
