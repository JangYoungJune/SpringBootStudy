package me.Lancoru;

        import org.springframework.boot.SpringApplication;
        import org.springframework.boot.WebApplicationType;
        import org.springframework.boot.autoconfigure.SpringBootApplication;
        import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(Application.class);
        application.setWebApplicationType(WebApplicationType.NONE);
        application.run(args);
    }

    /*기존 2.0.3버전의 스프링에서는 해당 부분이 무시된다.
    * 1페이즈에서 컴포넌트스캔에서 패키지 내 빈을 읽지만,
    * 2페이즈에서 autoConfiguration에서 기존 holoman을 덮어씌운다.
    * 하지만, 최신버전에선 해당 오버라이드가 막혔다.
    * 아래 메세지와 같이 추가 설정을 넣어야지 오버라이딩을 허용한다.
    * */

    @Bean
    public Holoman holoman(){
        Holoman holoman = new Holoman();
        holoman.setName("Jang");
        holoman.setHowLong(28);
        return holoman;
    }
}
