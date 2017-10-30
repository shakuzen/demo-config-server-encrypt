package com.example.democonfigserverencrypt;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
@EnableConfigurationProperties(ConfigServerSecurityConfiguration.SecurityProperties.class)
class ConfigServerSecurityConfiguration {

	//	@Bean
	//	public UserDetailsService userDetailsService(SecurityProperties properties) {
	//		InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
	//		manager.createUser(
	//				User.withUsername("user")
	//						.password(properties.getPassword())
	//						.roles("USER")
	//						.build()
	//		);
	//		return manager;
	//	}

	@Bean
	CommandLineRunner printSecurityPasswordRunner(SecurityProperties properties) {
		return args -> System.out.println("\n\nSecurity password (@ConfigurationProperties): " + properties.getPassword() + "\n\n");
	}

	@ConfigurationProperties("myorg.security")
	static class SecurityProperties {
		private String password;

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}
	}
}
