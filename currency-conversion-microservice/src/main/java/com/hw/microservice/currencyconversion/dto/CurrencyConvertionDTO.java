/**
 * PROJECT NAME
 *    currency-conversion-microservice
 *
 * FILE NAME
 *    CurrencyConvertionDTO.java
 *
 * CREATED ON
 *    Mar 15, 2022 9:31:13 AM
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
package com.hw.microservice.currencyconversion.dto;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * <p>
 * DTO to pass currency conversion data.
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
public class CurrencyConvertionDTO {

    private Long       id;
    private String     from;
    private String     to;
    private BigDecimal conversionMultiple;
    private BigDecimal amount;
    private BigDecimal calculatedAmount;
    private int        port;

}
