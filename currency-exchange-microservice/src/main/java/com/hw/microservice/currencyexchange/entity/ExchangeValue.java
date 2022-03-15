/**
 * PROJECT NAME
 *    currency-exchange-microservice
 *
 * FILE NAME
 *    ExchangeValue.java
 *
 * CREATED ON
 *    Mar 14, 2022 11:04:48 AM
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
package com.hw.microservice.currencyexchange.entity;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.data.jpa.domain.AbstractPersistable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * <p>
 * DTO to pass currency exchange configs over REST.
 * </p>
 *
 * @since 1.0.0
 *
 * @author Hansaka Weerasingha
 *
 * @version $Id$
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "EXCHANGE_VALUE")
public class ExchangeValue extends AbstractPersistable<Long> {

    @Column(name = "CURR_FROM")
    private String     from;

    @Column(name = "CURR_TO")
    private String     to;

    @Column(name = "CONV_MULTY")
    private BigDecimal conversionMultiple;

    @Transient
    private int        port;

}
