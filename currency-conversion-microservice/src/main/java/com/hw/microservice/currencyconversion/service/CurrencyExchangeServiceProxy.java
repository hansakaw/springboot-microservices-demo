/**
 * PROJECT NAME
 *    currency-conversion-microservice
 *
 * FILE NAME
 *    CurrencyExchangeServiceProxy.java
 *
 * CREATED ON
 *    Mar 15, 2022 11:24:22 AM
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
package com.hw.microservice.currencyconversion.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.hw.microservice.currencyconversion.dto.CurrencyConvertionDTO;

/**
 * <p>
 * Declarative interface for Feign REST client.
 * </p>
 *
 * @since 1.0.0
 *
 * @author Hansaka Weerasingha
 *
 * @version $Id$
 */
@FeignClient(name = "${feign.config.exchange-service.name}", url = "${feign.config.exchange-service.url}")
public interface CurrencyExchangeServiceProxy {

    @GetMapping("/currency-exchange/from/{from}/to/{to}")
    CurrencyConvertionDTO convertCurrencyFeign(@PathVariable final String from, @PathVariable final String to);

}
