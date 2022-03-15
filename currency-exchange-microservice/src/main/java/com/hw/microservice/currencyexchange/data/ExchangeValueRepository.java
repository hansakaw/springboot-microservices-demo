/**
 * PROJECT NAME
 *    currency-exchange-microservice
 *
 * FILE NAME
 *    ExchangeValueRepository.java
 *
 * CREATED ON
 *    Mar 14, 2022 7:51:54 PM
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
package com.hw.microservice.currencyexchange.data;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hw.microservice.currencyexchange.entity.ExchangeValue;

/**
 * <p>
 * Data repository for exchange entity.
 * </p>
 *
 * @since 1.0.0
 *
 * @author Hansaka Weerasingha
 *
 * @version $Id$
 */
public interface ExchangeValueRepository extends JpaRepository<ExchangeValue, Long> {

    /**
     * Query method to retrieve exchange values based on given from and to.
     *
     * @param from
     *            Currency to be converted from
     * @param to
     *            Currency to be converted to
     * @return THe conversion data
     */
    ExchangeValue findByFromAndTo(String from, String to);

}
