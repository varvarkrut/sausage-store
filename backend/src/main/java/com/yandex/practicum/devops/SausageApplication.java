package com.yandex.practicum.devops;

import com.yandex.practicum.devops.model.Product;
import com.yandex.practicum.devops.service.ProductService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class SausageApplication {

    public static void main(String[] args) {
        SpringApplication.run(SausageApplication.class, args);
    }

    @Bean
    CommandLineRunner runner(ProductService productService) {
        return args -> {
            productService.save(new Product(1L, "Сливочная", 320.00, "https://storage.yandexcloud.net/10-shkurko-ivan/6.jpeg"));
            productService.save(new Product(2L, "Особая", 179.00, "https://storage.yandexcloud.net/10-shkurko-ivan/5.jpeg"));
            productService.save(new Product(3L, "Молочная", 225.00, "https://storage.yandexcloud.net/10-shkurko-ivan/4.jpeg"));
            productService.save(new Product(4L, "Нюренбергская", 315.00, "https://storage.yandexcloud.net/10-shkurko-ivan/3.jpeg"));
            productService.save(new Product(5L, "Мюнхенская", 330.00, "https://storage.yandexcloud.net/10-shkurko-ivan/2.jpeg"));
            productService.save(new Product(6L, "Еврейская", 189.00, "https://storage.yandexcloud.net/10-shkurko-ivan/1.jpeg"));
        };
    }
}
