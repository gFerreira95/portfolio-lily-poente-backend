package com.lilypoente.studio_api.config;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.lilypoente.studio_api.entity.PortfolioItem;
import com.lilypoente.studio_api.entity.User;
import com.lilypoente.studio_api.repository.PortfolioItemRepository;
import com.lilypoente.studio_api.repository.UserRepository;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Value("${cors.allowed.origins}")
    private String[] allowedOrigins;

    @Value("${admin.default.username}")
    private String adminUsername;

    @Value("${admin.default.password}")
    private String adminPassword;

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/api/**")
                .allowedOrigins(allowedOrigins)
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
                .allowedHeaders("*");
    }

    @Bean
    @SuppressWarnings("unused")
    CommandLineRunner initDatabase(
            PortfolioItemRepository portfolioRepository,
            UserRepository userRepository,
            PasswordEncoder passwordEncoder) {
        return args -> {
            // 1. Cria os itens iniciais do portfólio se estiver vazio
            if (portfolioRepository.count() == 0) {
                portfolioRepository.saveAll(List.of(
                    new PortfolioItem("Clube do Livro - Anne With an E", "Branding e design da marca", "Projeto editorial completo.", "/clube-livro.png"),
                    new PortfolioItem("ARTE VISUAL", "Colagem Autoral", "Exploração visual e colagens.", "/arte-visual.png"),
                    new PortfolioItem("DESIGN DE POSTS", "Para as redes sociais", "Identidade para social media.", "/posts.png")
                ));
            }

            // 2. Cria o usuário Admin (com senha criptografada BCrypt) se não existir
            if (userRepository.count() == 0) {
                User admin = new User(adminUsername, passwordEncoder.encode(adminPassword));
                userRepository.save(admin);
                System.out.println("✅ Usuário Admin criado com sucesso no MongoDB: " + adminUsername);
            }
        };
    }
}