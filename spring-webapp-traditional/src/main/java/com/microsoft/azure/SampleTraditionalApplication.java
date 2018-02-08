/*
 * Copyright 2012-2013 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.microsoft.azure;

import com.microsoft.azure.LogWriter;
import com.microsoft.azure.serverless.functions.*;
import com.microsoft.azure.serverless.functions.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

import java.util.*;

@SpringBootApplication
public class SampleTraditionalApplication {
    private static final Logger LOGGER = LoggerFactory.getLogger(SampleTraditionalApplication.class);

    @FunctionName("hello")
    public HttpResponseMessage<String> hello(
            @HttpTrigger(name = "req", methods = {"get", "post"}, authLevel = AuthorizationLevel.ANONYMOUS) HttpRequestMessage<Optional<String>> request,
            final ExecutionContext context) {
        context.getLogger().info("java http trigger processed a request");

        return request.createResponse(200, "Hello World from Azure Function!");
    }

    public static void main(String[] args) throws Exception {
        LogWriter.writeLogs();
        LogWriter.writeLogs();

        LOGGER.info("Starting traditional application..");
        LOGGER.trace("Trace log: Starting traditional application..");

        SpringApplication.run(SampleTraditionalApplication.class, args);
    }

}
