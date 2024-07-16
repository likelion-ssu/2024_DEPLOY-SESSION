package com.likelion.deploy;

import io.swagger.v3.oas.annotations.media.Schema;

public class MemberDetailResponse {

    @Schema(title = "이름", type = "string", example = "박수영")
    private final String name;

    @Schema(title = "직위", type = "string", example = "백엔드 파트장")
    private final String position;

    public MemberDetailResponse(String name, String position) {
        this.name = name;
        this.position = position;
    }

    public String getName() {
        return name;
    }

    public String getPosition() {
        return position;
    }
}
