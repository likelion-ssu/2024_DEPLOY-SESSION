package com.likelion.deploy;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class MemberService {

    private final Map<String, String> memberList = Map.ofEntries(
            Map.entry("유승한", "대표"), Map.entry("김지은", "부대표"), Map.entry("정의민", "기획 파트장"),
            Map.entry("유해인", "디자인 파트장"), Map.entry("박수영", "백엔드 파트장"), Map.entry("신수연", "프론트 파트장"),
            Map.entry("오유은", "총무"), Map.entry("김교휘", "운영팀장"), Map.entry("한지원", "기획팀장"),
            Map.entry("강해솔", "디자인팀장"), Map.entry("조수민", "홍보팀장")
    );

    /**
     * 회원 목록을 조회하는 메서드입니다.
     * @return 회원 이름으로 구성된 List 인스턴스
     */
    public List<String> getMemberList() {
        // 여기에 원래는 데이터베이스 조회하는 코드가 있어야겠죠?
        return memberList.keySet().stream().toList();
    }

    /**
     * 주어진 이름을 가진 회원의 직위를 조회하는 메서드입니다.
     * @param name 회원 이름
     * @return 회원 직위
     * @throws IllegalArgumentException 주어진 이름을 가진 회원이 없는 경우에 발생
     */
    public String getMemberPosition(String name) {
        // 여기에 원래는 데이터베이스 조회하는 코드가 있어야겠죠?
        String position = memberList.get(name);
        if (position == null) {
            throw new IllegalArgumentException("The member %s not found.".formatted(name));
        }
        return position;
    }
}
