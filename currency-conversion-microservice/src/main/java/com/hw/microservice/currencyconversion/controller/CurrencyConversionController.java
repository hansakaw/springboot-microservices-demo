/**
 * PROJECT NAME
 *    currency-conversion-microservice
 *
 * FILE NAME
 *    CurrencyConversionController.java
 *
 * CREATED ON
 *    Mar 15, 2022 8:56:40 AM
 *
 * COPYRIGHT
 *    Copyright 2022 © Hansaka Weerasingha. All rights reserved.
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */
package com.hw.microservice.currencyconversion.controller;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.hw.microservice.currencyconversion.dto.CurrencyConvertionDTO;
import com.hw.microservice.currencyconversion.service.CurrencyExchangeServiceProxy;

/**
 * <p>
 * REST controller for currency conversion.
 * </p>
 *
 * @since 1.0.0
 *
 * @author Hansaka Weerasingha
 *
 * @version $Id$
 */
@RestController
public class CurrencyConversionController {

    @Value("${service.currency-exchange.url}")
    private String             exchangeService;

    private final RestTemplate restTemp;

    @Autowired
    private CurrencyExchangeServiceProxy currExchProxy;

    /**
     * The default constructor with rest template builder injected.
     *
     * @param restTemplateBuilder
     *            Rest template builder to be injected
     */
    @Autowired
    public CurrencyConversionController(final RestTemplateBuilder restTemplateBuilder) {
        restTemp = restTemplateBuilder.build();
    }

    @GetMapping("/currency-converter/from/{from}/to/{to}/amount/{amount}")
    public CurrencyConvertionDTO convertCurrency(@PathVariable final String from, @PathVariable final String to, @PathVariable final BigDecimal amount) {

        // Call currency exchange service over REST
        final ResponseEntity<CurrencyConvertionDTO> responseEntity = restTemp.getForEntity(exchangeService, CurrencyConvertionDTO.class, from, to);
        final var convResp = responseEntity.getBody();

        return new CurrencyConvertionDTO(convResp.getId(), from, to, convResp.getConversionMultiple(), amount, amount.multiply(convResp.getConversionMultiple()), convResp.getPort());
    }

    @GetMapping("/currency-converter-feign/from/{from}/to/{to}/amount/{amount}")
    public CurrencyConvertionDTO convertCurrencyFeign(@PathVariable final String from, @PathVariable final String to, @PathVariable final BigDecimal amount) {

        // Call currency exchange service over Feign client
        final var convResp = currExchProxy.convertCurrencyFeign(from, to);

        return new CurrencyConvertionDTO(convResp.getId(), from, to, convResp.getConversionMultiple(), amount, amount.multiply(convResp.getConversionMultiple()), convResp.getPort());
    }

}
