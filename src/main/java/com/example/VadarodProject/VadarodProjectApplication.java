package com.example.VadarodProject;

import com.example.VadarodProject.service.TableService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EnableJpaRepositories
@EnableTransactionManagement
@EnableWebMvc
public class VadarodProjectApplication {
    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(VadarodProjectApplication.class, args);
//        TableService tableService = context.getBean(TableService.class);
//        tableService.fillTable();
    }

}
