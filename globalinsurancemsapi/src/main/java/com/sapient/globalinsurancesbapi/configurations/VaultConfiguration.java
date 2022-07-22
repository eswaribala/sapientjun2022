package com.sapient.globalinsurancesbapi.configurations;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ConfigurationProperties
public class VaultConfiguration {

	private String username;
	private String password;
}
