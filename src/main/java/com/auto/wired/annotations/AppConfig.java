package com.auto.wired.annotations;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.auto.wired.annotations")
public class AppConfig {
}
