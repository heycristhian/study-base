package br.com.heycristhian.studybase.config;

import br.com.heycristhian.studybase.entity.User;
import br.com.heycristhian.studybase.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Instantiation implements CommandLineRunner {

    @Autowired
    private UserService userService;

    @Override
    public void run(String... args) throws Exception {
        userService.save(
                User.builder()
                        .name("Cristhian Dias")
                        .email("heycristhian@gmail.com")
                        .build()
        );
    }
}
