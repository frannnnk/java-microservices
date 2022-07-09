package com.eazybytes.loans.context;

import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

@Component
@Getter
@Setter
public class RequestContext {

	public static final String CORRELATION_ID = "eazybank-correlation-id";

	private String correlationId = new String();

}
