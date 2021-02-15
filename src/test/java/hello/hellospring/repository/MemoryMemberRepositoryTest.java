package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class MemoryMemberRepositoryTest {

    MemoryMemberRepository repository = new MemoryMemberRepository();

    @Test
    public void save(){
        Member member = new Member();
        member.setName("spring");

        repository.save(member);

        Member result = repository.findById(member.getId()).get();
        //System.out.println("result =" + (result == member));
        //Assertions.assertEquals(member, result); // 정상 케이스
        //Assertions.assertEquals(member, null); // 오류 케이스
        //위의 Assertions 와 import가 다름 위는 juint, 아래는 assertj
        assertThat(member).isEqualTo(result);
    }

    

}
