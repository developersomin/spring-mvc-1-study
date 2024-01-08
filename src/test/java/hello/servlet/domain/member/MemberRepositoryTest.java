package hello.servlet.domain.member;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class MemberRepositoryTest {

    MemberRepository memberRepository = MemberRepository.getInstance();

    @AfterEach
    void afterEach(){
        memberRepository.clearStore();
    }

    @Test
    void save() {
        //g
        Member member = new Member("somin", 20);
        //w
        Member savedMember = memberRepository.save(member);
        //t
        Member findMember = memberRepository.findById(savedMember.getId());
        assertThat(findMember).isEqualTo(savedMember);
    }

    @Test
    void findAll() {
        //g
        Member member1 = new Member("somin1", 20);
        Member member2 = new Member("somin2", 30);
        memberRepository.save(member1);
        memberRepository.save(member2);
        //w
        List<Member> result = memberRepository.findAll();
        //t
        assertThat(result.size()).isEqualTo(2);
        assertThat(result).contains(member1,member2);
    }

}