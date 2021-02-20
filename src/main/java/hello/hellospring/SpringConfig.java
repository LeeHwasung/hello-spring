package hello.hellospring;

import hello.hellospring.aop.TimeTraceAop;
import hello.hellospring.repository.JpaMemberRepository;
import hello.hellospring.repository.MemberRepository;
import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// 컴포넌트 스캔 방식으로 하지 않고 직접 빈을 등록하는 방식으로 테스트
// Service.java, Repository.java 에서 @Service, @Repository 제거

@Configuration
public class SpringConfig {

    /*private DataSource dataSource;

    @Autowired
    public SpringConfig(DataSource dataSource) {
        this.dataSource = dataSource;
    }*/

    //JPA
    /*private EntityManager em;

    public SpringConfig(EntityManager em) {
        this.em = em;
    }*/

    //Spring DATA JPA
    private final MemberRepository memberRepository;

    @Autowired
    public SpringConfig(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }


/*    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository());
    }*/

    //Spring DATA JPA
    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository);
    }

/*    @Bean
    public TimeTraceAop timeTraceAop() {
        return new TimeTraceAop();
    }*/

    /*@Bean
    public MemberRepository memberRepository() {
        //메모리 사용
        //return new MemoryMemberRepository(); // MemberRepository.java 인터페이스는 new 사용 불가

        //순수 JDBC 방식 사용
        //return new JdbcMemberRepository(dataSource);

        //JdbcTemplate 사용
        //return new JdbcTemplateMemberRepository(dataSource);

        //JPA
        return new JpaMemberRepository(em);
    }*/
}
