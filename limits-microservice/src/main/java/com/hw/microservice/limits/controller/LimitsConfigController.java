/**
 * PROJECT NAME
 *    limits-microservice
 *
 * FILE NAME
 *    LimitsConfigController.java
 *
 * CREATED ON
 *    Mar 11, 2022 4:55:28 PM
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
package com.hw.microservice.limits.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hw.microservice.limits.dto.LimitsConfig;

/**
 * <p>
 * REST controller to retrieve limits configs.
 * </p>
 *
 * @since 1.0.0
 *
 * @author Hansaka Weerasingha
 *
 * @version $Id$
 */
@RestController
public class LimitsConfigController {

    @Autowired
    private LimitsConfig limitsConf;

    @GetMapping("/limits")
    public LimitsConfig getLimitsConfig() {
        return new LimitsConfig(limitsConf.getMinimum(), limitsConf.getMaximum());
    }

}
