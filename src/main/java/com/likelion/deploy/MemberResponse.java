package com.likelion.deploy;

import io.swagger.v3.oas.annotations.media.Schema;

public class MemberResponse {

    @Schema(title = "이름", type = "string", example = "박수영")
    private final String name;

    public MemberResponse(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
}
