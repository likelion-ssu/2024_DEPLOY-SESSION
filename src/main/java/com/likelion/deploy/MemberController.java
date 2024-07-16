package com.likelion.deploy;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@Tag(name = "Member API")
public class MemberController {

    private final MemberService memberService;

    @GetMapping(value = "/members")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "회원 목록 조회", description = "회원들의 이름을 조회합니다.")
    public List<MemberResponse> getMemberList() {
        return memberService.getMemberList().stream()
                .map(MemberResponse::new)
                .collect(Collectors.toList());
    }

    @GetMapping(value = "/members/{name}")
    @Operation(summary = "회원 정보 조회", description = "특정 이름을 가진 회원의 정보를 조회합니다.")
    @Parameter(name = "name", description = "이름", example = "박수영")
    public ResponseEntity<MemberDetailResponse> getMemberDetail(@PathVariable String name) {
        try {
            String position = memberService.getMemberPosition(name);
            MemberDetailResponse response = new MemberDetailResponse(name, position);

            return ResponseEntity.ok(response);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.notFound().build();
        }
    }

    public MemberController(MemberService homeService) {
        this.memberService = homeService;
    }
}
