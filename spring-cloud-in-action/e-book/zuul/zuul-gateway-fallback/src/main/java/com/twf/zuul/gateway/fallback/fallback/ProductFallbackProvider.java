package com.twf.zuul.gateway.fallback.fallback;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;

import org.springframework.cloud.netflix.zuul.filters.route.ZuulFallbackProvider;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;

@Component
public class ProductFallbackProvider implements ZuulFallbackProvider {

	/**
	 * 代表为哪个服务提供fallback，这里我们为e-book-product这个服务提供fallback
	 */
	@Override
	public String getRoute() {
		return "e-book-product";
	}

	@Override
	public ClientHttpResponse fallbackResponse() {
		return new ClientHttpResponse() {

			@Override
			public InputStream getBody() throws IOException {
				String input = "商品服务不可用，请联系管理员！";
				return new ByteArrayInputStream(input.getBytes());
			}

			@Override
			public HttpHeaders getHeaders() {
				HttpHeaders header = new HttpHeaders();
				MediaType mt = new MediaType("application","json",Charset.forName("UTF-8"));
				header.setContentType(mt);
				return header;
			}

			@Override
			public HttpStatus getStatusCode() throws IOException {
				// httpresponse的fallback的状态码，HttpStatus值
				return HttpStatus.OK;
			}

			@Override
			public int getRawStatusCode() throws IOException {
				// httpresponse的fallback的状态码，int值
				return this.getStatusCode().value();
			}

			@Override
			public String getStatusText() throws IOException {
				// httpresponse的fallback的状态码，String值
				return this.getStatusCode().getReasonPhrase();
			}

			@Override
			public void close() {
				
			}};
	}
}
