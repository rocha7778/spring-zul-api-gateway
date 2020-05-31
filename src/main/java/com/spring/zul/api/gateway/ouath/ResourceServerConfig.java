package com.spring.zul.api.gateway.ouath;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

@EnableResourceServer
@Configuration
public class ResourceServerConfig  extends ResourceServerConfigurerAdapter{

	@Override
	public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
		resources.tokenStore(tokenStore());
	}

	@Override
	public void configure(HttpSecurity http) throws Exception {
		
		http.authorizeRequests().antMatchers("/api/security/oauth/token").permitAll().
		antMatchers(HttpMethod.GET,"/api/productos/productos", "/api/items/items","/api/users/users").permitAll().
		antMatchers(HttpMethod.GET,"/api/productos/productos/{id}", "/api/items/items/{id}/cantidad/{cantidad}","/api/users/users/{id}").
		hasAnyRole("USER","ADMIN").
		antMatchers("/api/productos/productos/**", "/api/items/items/**","/api/users/users/**").hasRole("ADMIN").
		anyRequest().authenticated();
	}
	
	
	@Bean
	public JwtTokenStore tokenStore() {
		return new JwtTokenStore(accessTokenConverter());
	}

	@Bean
	public  JwtAccessTokenConverter accessTokenConverter() {
		JwtAccessTokenConverter tokenConverter = new JwtAccessTokenConverter();
		tokenConverter.setSigningKey("jxve9BzzkIF11tKPwx0bPWJH_VIKJKDWOno-I-br0JhL00wl2NBZwLmcT10fe_MROLTT0WK9JGN1i6X78xJlaRD1dnIM4NJ7gRc4gZ-3pfX4LFGa5R-9DRehqmZ7MDlTXVMusMm-GfKyJQ7Rnz0rOoD2MgqoC_mmyFy0O5zVUZBH5FoPDzSICFGNuOPoRnJ6MVr5hEatqoBlxr0xYn1eRkqoJnjyGPl9v-NqY31l4rIbYQN5vrTKUBVFIguKi54FNXz_e-Q56Wdrq3ver2s0eYxygWjLlkxRv_xcx_gY0QfFftDEG6lT5lb5U1FMedtwe6UWSsoN2aACx0Zwme_4kw");
		return tokenConverter;
	}
	
	

}
