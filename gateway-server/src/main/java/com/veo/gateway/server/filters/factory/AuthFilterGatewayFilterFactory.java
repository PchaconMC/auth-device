package com.veo.gateway.server.filters.factory;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.OrderedGatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.http.ResponseCookie;
import org.springframework.stereotype.Component;

import reactor.core.publisher.Mono;
/**
 * 
 * @author pchacon
 *
 */
@Component
public class AuthFilterGatewayFilterFactory extends AbstractGatewayFilterFactory<Configuration> {
	private final Logger logger = LoggerFactory.getLogger(AuthFilterGatewayFilterFactory.class);

	
	
	public AuthFilterGatewayFilterFactory() {
		super(Configuration.class);
	}

	@Override
	public GatewayFilter apply(Configuration config) {
		return new OrderedGatewayFilter((exchange,chain)->{
			logger.info("Ejecutando pre gateway filter factory: " + config.getMessage());
			return chain.filter(exchange).then(Mono.fromRunnable(()->{
				
				Optional.ofNullable(config.getCookieVal()).ifPresent(cookie->{
					exchange.getResponse().addCookie(ResponseCookie.from(config.getCookieName(), cookie).build());
				});
				logger.info("Ejecutando post gateway filter factory: " + config.getMessage());
			}));
		}, 1);
	}

	@Override
	public List<String> shortcutFieldOrder() {
		return Arrays.asList("message","cookieName","cookieVal");
	}

	@Override
	public String name() {
		return "AuthFilter";
	}


}
