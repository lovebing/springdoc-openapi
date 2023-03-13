/*
 *
 *  *
 *  *  *
 *  *  *  *
 *  *  *  *  * Copyright 2019-2022 the original author or authors.
 *  *  *  *  *
 *  *  *  *  * Licensed under the Apache License, Version 2.0 (the "License");
 *  *  *  *  * you may not use this file except in compliance with the License.
 *  *  *  *  * You may obtain a copy of the License at
 *  *  *  *  *
 *  *  *  *  *      https://www.apache.org/licenses/LICENSE-2.0
 *  *  *  *  *
 *  *  *  *  * Unless required by applicable law or agreed to in writing, software
 *  *  *  *  * distributed under the License is distributed on an "AS IS" BASIS,
 *  *  *  *  * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  *  *  *  * See the License for the specific language governing permissions and
 *  *  *  *  * limitations under the License.
 *  *  *  *
 *  *  *
 *  *
 *
 */
package org.springdoc.webflux.ui;

import java.util.Map;

import io.swagger.v3.oas.annotations.Operation;

import org.springframework.http.MediaType;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import static org.springdoc.core.utils.Constants.SWAGGER_CONFIG_URL;

/**
 * The type Swagger config resource.
 * @author bnasslahsen
 */
@RestController
public class SwaggerConfigResource {

	/**
	 * The Swagger welcome common.
	 */
	private final SwaggerWelcomeCommon swaggerWelcomeCommon;

	/**
	 * Instantiates a new Swagger config resource.
	 *
	 * @param swaggerWelcomeCommon the swagger welcome common
	 */
	public SwaggerConfigResource(SwaggerWelcomeCommon swaggerWelcomeCommon) {
		this.swaggerWelcomeCommon = swaggerWelcomeCommon;
	}

	/**
	 * Gets swagger ui config.
	 *
	 * @param request the request
	 * @return the swagger ui config
	 */
	@Operation(hidden = true)
	@GetMapping(value = SWAGGER_CONFIG_URL, produces = MediaType.APPLICATION_JSON_VALUE)
	public Mono<Map<String, Object>> getSwaggerUiConfig(ServerHttpRequest request) {
		return Mono.defer(() -> Mono.just(swaggerWelcomeCommon.getSwaggerUiConfig(request)));
	}

}
