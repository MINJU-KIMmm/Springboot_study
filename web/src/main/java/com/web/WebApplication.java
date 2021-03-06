package com.web;

import com.web.domain.Board;
import com.web.domain.BoardType;
import com.web.domain.User;
import com.web.repository.BoardRepository;
import com.web.repository.UserRepository;
import org.springframework.aop.TargetSource;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.stream.IntStream;

@SpringBootApplication
public class WebApplication {

    public static void main(String[] args) {
        SpringApplication.run(WebApplication.class, args);
    }

    //CommandLineRunner를 빈으로 등록한 후 UserRepository와 BoardRepository를 주입받음
    @Bean
    public CommandLineRunner runner(UserRepository userRepository, BoardRepository boardRepository) throws Exception{
        return(args)->{
            User user=userRepository.save(User.builder()
                .name("havi")
                    .password("test")
                    .email("havi@gmail.com")
                    .createdDate(LocalDateTime.now())
                    .build()
            );

            //index순서대로 Board 객체 200개를 생성하여 저장
            IntStream.rangeClosed(1,200).forEach(index->
                    boardRepository.save(Board.builder()
                    .title("게시글"+index)
                    .subTitle("순서"+index)
                    .content("콘텐츠")
                    .boardType(BoardType.free)
                    .createdDate(LocalDateTime.now())
                    .updatedDate(LocalDateTime.now())
                    .user(user).build())
            );
        };
    }
}
