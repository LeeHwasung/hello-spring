package hello.hellospring;

import hello.hellospring.repository.MemberRepository;
import hello.hellospring.repository.MemoryMemberRepository;
import hello.hellospring.service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// 컴포넌트 스캔 방식으로 하지 않고 직접 빈을 등록하는 방식으로 테스트
// Service.java, Repository.java 에서 @Service, @Repository 제거

@Configuration
public class SpringConfig {

    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository(); // MemberRepository.java 인터페이스는 new 사용 불가
    }
}
