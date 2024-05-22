package com.example.shoppingmall.member;

import com.example.shoppingmall.utils.ApiUtils;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

//import static com.example.shoppingmall.member.Member.fromDtoToEntity;
import static com.example.shoppingmall.utils.ApiUtils.error;
import static com.example.shoppingmall.utils.ApiUtils.success;

@Slf4j
@AllArgsConstructor
@RestController
public class MemberController {

    MemberService memberService;

//    @GetMapping("/datasource")
//    public void makeConnection() {
//        memberService.makeConnection();
//    }

//    @PostMapping("/join/res/en") // Before
//    public ResponseEntity<String> joinByResponseEntity(@RequestBody Member member) {
//        log.info(member.toString());
//
//        if(isDuplicateId(member))
//            return new ResponseEntity<>(null, HttpStatus.CONFLICT);
//
//        String userId = memberService.join(member);
//        return new ResponseEntity<>(userId, HttpStatus.OK);
//    }

    @PostMapping("/join") // After
    public ApiUtils.ApiResult join(@Valid @RequestBody MemberDto memberDto) { // , Errors errors) {
//        if(errors.hasErrors()) {
//            Map<String, String> errorMessages = new HashMap<>();
//
//            for (FieldError error : errors.getFieldErrors()) {
//                String errorField = error.getField(); // 예외 field
//                String errorMessage = error.getDefaultMessage(); // 예외 message
//                errorMessages.put(errorField, errorMessage);
//            }
//
//            return error(errorMessages, HttpStatus.BAD_REQUEST);
//        }

//        if(isDuplicateId(memberDto))
//            return error("아이디 중복", HttpStatus.CONFLICT);

        Member requestMember = memberDto.convertToEntity();
                        // fromDtoToEntity(memberDto);
        String userId = memberService.join(requestMember);
        return success(userId);
    }

    private boolean isDuplicateId(MemberDto memberDto) {
        return memberService.checkDuplicateId(memberDto.getUserId());
    }

//    // 유효성 검사하다가 에러가 터지면 호출되는 예외 처리 메소드
//    @ExceptionHandler//(MethodArgumentNotValidException.class)
//    @ResponseStatus(HttpStatus.BAD_REQUEST)
//    public ApiUtils.ApiResult<Map<String, String>> handleValidationExceptions(MethodArgumentNotValidException errors) {
//        Map<String, String> errorMessages = new HashMap<>();
//
//        for (FieldError error : errors.getFieldErrors()) {
//            String errorField = error.getField(); // 예외 field
//            String errorMessage = error.getDefaultMessage(); // 예외 message
//            errorMessages.put(errorField, errorMessage);
//        }
//
//        return error(errorMessages, HttpStatus.BAD_REQUEST);
//    }
}
