/**
 * PROJECT NAME
 *    limits-microservice
 *
 * FILE NAME
 *    LimitsServiceApplicationTests.java
 *
 * CREATED ON
 *    Mar 11, 2022 4:52:05 PM
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
package com.hw.microservice.limits;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

/**
 * Tests for {@link LimitsServiceApplication}.
 *
 * @author Hansaka Weerasingha
 */
@SpringBootTest
@AutoConfigureMockMvc
public class LimitsServiceApplicationTests {

    @Autowired
    private MockMvc mvc;

    @Test
    public void testContextLoads() throws Exception {
        assertThat(mvc).isNotNull();
    }

    @Test
    public void testLimits() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/limits") //
                .contentType(MediaType.APPLICATION_JSON)) //
        .andExpect(status().isOk()) //
        .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON)) //
        .andExpect(jsonPath("$.minimum", is(10))) //
        .andExpect(jsonPath("$.maximum", is(1000)));
    }

}
