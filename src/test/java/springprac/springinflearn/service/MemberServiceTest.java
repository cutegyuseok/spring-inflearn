package springprac.springinflearn.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import springprac.springinflearn.domain.Member;

import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;


class MemberServiceTest {
    MemberService memberService = new MemberService();

    @Test
    void join() {
        //given
        Member member = new Member();
        member.setName("spring");
        //when
        Long saveId = memberService.join(member);


        //then
        Member findMember = memberService.findOne(saveId).get();
        assertThat(member.getName()).isEqualTo(findMember.getName());


    }

    @Test
    void findMembers() {
        //given
        Member member1 = new Member();
        member1.setName("name");
        Member member2 = new Member();
        member2.setName("name");

        memberService.join(member1);
        try {
            memberService.join(member2);
            fail();
        }catch (IllegalStateException e){
            assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");
        }
        
    }

    @Test
    void findOne() {
    }
}