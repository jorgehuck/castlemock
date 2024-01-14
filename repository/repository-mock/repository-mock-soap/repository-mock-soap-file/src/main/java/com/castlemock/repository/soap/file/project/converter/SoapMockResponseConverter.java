/*
 * Copyright 2024 Karl Dahlgren
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.castlemock.repository.soap.file.project.converter;

import com.castlemock.model.mock.soap.domain.SoapMockResponse;
import com.castlemock.repository.core.file.http.converter.HttpHeaderConverter;
import com.castlemock.repository.soap.file.project.model.SoapMockResponseFile;

import java.util.stream.Collectors;

public final class SoapMockResponseConverter {

    private SoapMockResponseConverter() {

    }

    public static SoapMockResponseFile toSoapMockResponseFile(final SoapMockResponse soapMockResponse) {
        return SoapMockResponseFile.builder()
                .id(soapMockResponse.getId())
                .body(soapMockResponse.getBody())
                .usingExpressions(soapMockResponse.getUsingExpressions()
                        .orElse(null))
                .status(soapMockResponse.getStatus())
                .operationId(soapMockResponse.getOperationId())
                .contentEncodings(soapMockResponse.getContentEncodings())
                .httpStatusCode(soapMockResponse.getHttpStatusCode())
                .name(soapMockResponse.getName())
                .httpHeaders(soapMockResponse.getHttpHeaders()
                        .stream()
                        .map(HttpHeaderConverter::toHttpHeaderFile)
                        .collect(Collectors.toList()))
                .xpathExpressions(soapMockResponse.getXpathExpressions()
                        .stream()
                        .map(SoapXPathExpressionConverter::toSoapXPathExpressionFile)
                        .collect(Collectors.toList()))
                .build();
    }
}
