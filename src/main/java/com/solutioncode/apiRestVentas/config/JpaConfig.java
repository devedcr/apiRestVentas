package com.solutioncode.apiRestVentas.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableJpaRepositories(basePackages = "com.solutioncode.apiRestVentas.repository")
@EntityScan(basePackages = "com.solutioncode.apiRestVentas.entity")
@EnableTransactionManagement
@EnableJpaAuditing
public class JpaConfig {
}
