/**
 * PROJECT NAME
 *    currency-conversion-microservice
 *
 * FILE NAME
 *    CurrencyConversionMicroserviceApplication.java
 *
 * CREATED ON
 *    Mar 15, 2022 8:42:05 AM
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
package com.hw.microservice.currencyconversion;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * <p>
 * Main class to start currency conversion service spring boot application.
 * </p>
 *
 * @since 1.0.0
 *
 * @author Hansaka Weerasingha
 *
 * @version $Id$
 */
@SpringBootApplication
@EnableFeignClients("com.hw.microservice.currencyconversion")
public class CurrencyConversionMicroserviceApplication {

    public static void main(final String[] args) {
        SpringApplication.run(CurrencyConversionMicroserviceApplication.class, args);
    }

}
