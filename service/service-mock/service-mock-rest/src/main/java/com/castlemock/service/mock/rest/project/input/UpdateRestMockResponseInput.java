/*
 * Copyright 2015 Karl Dahlgren
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

package com.castlemock.service.mock.rest.project.input;

import com.castlemock.model.core.Input;
import com.castlemock.model.core.http.HttpContentEncoding;
import com.castlemock.model.core.http.HttpHeader;
import com.castlemock.model.mock.rest.domain.RestHeaderQuery;
import com.castlemock.model.mock.rest.domain.RestJsonPathExpression;
import com.castlemock.model.mock.rest.domain.RestMockResponseStatus;
import com.castlemock.model.mock.rest.domain.RestParameterQuery;
import com.castlemock.model.mock.rest.domain.RestXPathExpression;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

/**
 * @author Karl Dahlgren
 * @since 1.0
 */
public final class UpdateRestMockResponseInput implements Input {

    private final String projectId;
    private final String applicationId;
    private final String resourceId;
    private final String methodId;
    private final String mockResponseId;
    private final String name;
    private final Integer httpStatusCode;
    private final RestMockResponseStatus status;
    private final String body;
    private final Boolean usingExpressions;
    private final List<HttpHeader> httpHeaders;
    private final List<HttpContentEncoding> contentEncodings;
    private final List<RestParameterQuery> parameterQueries;
    private final List<RestXPathExpression> xpathExpressions;
    private final List<RestJsonPathExpression> jsonPathExpressions;
    private final List<RestHeaderQuery> headerQueries;

    private UpdateRestMockResponseInput(final Builder builder) {
        this.projectId = Objects.requireNonNull(builder.projectId, "projectId");
        this.applicationId = Objects.requireNonNull(builder.applicationId, "applicationId");
        this.resourceId = Objects.requireNonNull(builder.resourceId, "resourceId");
        this.methodId = Objects.requireNonNull(builder.methodId, "methodId");
        this.mockResponseId = Objects.requireNonNull(builder.mockResponseId, "mockResponseId");
        this.name = Objects.requireNonNull(builder.name, "name");
        this.httpStatusCode = Objects.requireNonNull(builder.httpStatusCode, "httpStatusCode");
        this.status = Objects.requireNonNull(builder.status, "status");
        this.body = builder.body;
        this.usingExpressions = builder.usingExpressions;
        this.httpHeaders = builder.httpHeaders;
        this.contentEncodings = builder.contentEncodings;
        this.parameterQueries = builder.parameterQueries;
        this.xpathExpressions = builder.xpathExpressions;
        this.jsonPathExpressions = builder.jsonPathExpressions;
        this.headerQueries = builder.headerQueries;
    }

    public String getProjectId() {
        return projectId;
    }

    public String getApplicationId() {
        return applicationId;
    }

    public String getResourceId() {
        return resourceId;
    }

    public String getMethodId() {
        return methodId;
    }

    public String getMockResponseId() {
        return mockResponseId;
    }

    public String getName() {
        return name;
    }

    public Optional<String> getBody() {
        return Optional.ofNullable(body);
    }

    public Integer getHttpStatusCode() {
        return httpStatusCode;
    }

    public RestMockResponseStatus getStatus() {
        return status;
    }

    public Optional<Boolean> getUsingExpressions() {
        return Optional.ofNullable(usingExpressions);
    }

    public List<HttpHeader> getHttpHeaders() {
        return Optional.ofNullable(httpHeaders)
                .map(List::copyOf)
                .orElseGet(List::of);
    }

    public List<HttpContentEncoding> getContentEncodings() {
        return Optional.ofNullable(contentEncodings)
                .map(List::copyOf)
                .orElseGet(List::of);
    }

    public List<RestParameterQuery> getParameterQueries() {
        return Optional.ofNullable(parameterQueries)
                .map(List::copyOf)
                .orElseGet(List::of);
    }

    public List<RestXPathExpression> getXpathExpressions() {
        return Optional.ofNullable(xpathExpressions)
                .map(List::copyOf)
                .orElseGet(List::of);
    }

    public List<RestJsonPathExpression> getJsonPathExpressions() {
        return Optional.ofNullable(jsonPathExpressions)
                .map(List::copyOf)
                .orElseGet(List::of);
    }

    public List<RestHeaderQuery> getHeaderQueries() {
        return Optional.ofNullable(headerQueries)
                .map(List::copyOf)
                .orElseGet(List::of);
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final UpdateRestMockResponseInput that = (UpdateRestMockResponseInput) o;
        return Objects.equals(projectId, that.projectId) && Objects.equals(applicationId, that.applicationId) &&
                Objects.equals(resourceId, that.resourceId) && Objects.equals(methodId, that.methodId) &&
                Objects.equals(mockResponseId, that.mockResponseId) && Objects.equals(name, that.name) &&
                Objects.equals(httpStatusCode, that.httpStatusCode) && status == that.status &&
                Objects.equals(body, that.body) && Objects.equals(usingExpressions, that.usingExpressions) &&
                Objects.equals(httpHeaders, that.httpHeaders) && Objects.equals(contentEncodings, that.contentEncodings) &&
                Objects.equals(parameterQueries, that.parameterQueries) &&
                Objects.equals(xpathExpressions, that.xpathExpressions) &&
                Objects.equals(jsonPathExpressions, that.jsonPathExpressions) &&
                Objects.equals(headerQueries, that.headerQueries);
    }

    @Override
    public int hashCode() {
        return Objects.hash(projectId, applicationId, resourceId, methodId, mockResponseId,
                name, httpStatusCode, status, body, usingExpressions, httpHeaders,
                contentEncodings, parameterQueries, xpathExpressions, jsonPathExpressions, headerQueries);
    }

    @Override
    public String toString() {
        return "UpdateRestMockResponseInput{" +
                "projectId='" + projectId + '\'' +
                ", applicationId='" + applicationId + '\'' +
                ", resourceId='" + resourceId + '\'' +
                ", methodId='" + methodId + '\'' +
                ", mockResponseId='" + mockResponseId + '\'' +
                ", name='" + name + '\'' +
                ", httpStatusCode=" + httpStatusCode +
                ", status=" + status +
                ", body='" + body + '\'' +
                ", usingExpressions=" + usingExpressions +
                ", httpHeaders=" + httpHeaders +
                ", contentEncodings=" + contentEncodings +
                ", parameterQueries=" + parameterQueries +
                ", xpathExpressions=" + xpathExpressions +
                ", jsonPathExpressions=" + jsonPathExpressions +
                ", headerQueries=" + headerQueries +
                '}';
    }

    public static Builder builder(){
        return new Builder();
    }

    public static final class Builder {

        private String projectId;
        private String applicationId;
        private String resourceId;
        private String methodId;
        private String mockResponseId;
        private String name;
        private String body;
        private Integer httpStatusCode;
        private RestMockResponseStatus status;
        private Boolean usingExpressions;
        private List<HttpHeader> httpHeaders;
        private List<HttpContentEncoding> contentEncodings;
        private List<RestParameterQuery> parameterQueries;
        private List<RestXPathExpression> xpathExpressions;
        private List<RestJsonPathExpression> jsonPathExpressions;
        private List<RestHeaderQuery> headerQueries;

        public Builder projectId(final String projectId){
            this.projectId = projectId;
            return this;
        }

        public Builder applicationId(final String applicationId){
            this.applicationId = applicationId;
            return this;
        }

        public Builder resourceId(final String resourceId){
            this.resourceId = resourceId;
            return this;
        }

        public Builder methodId(final String methodId){
            this.methodId = methodId;
            return this;
        }

        public Builder mockResponseId(final String mockResponseId){
            this.mockResponseId = mockResponseId;
            return this;
        }

        public Builder name(final String name) {
            this.name = name;
            return this;
        }

        public Builder body(final String body) {
            this.body = body;
            return this;
        }

        public Builder httpStatusCode(final Integer httpStatusCode) {
            this.httpStatusCode = httpStatusCode;
            return this;
        }

        public Builder status(final RestMockResponseStatus status) {
            this.status = status;
            return this;
        }

        public Builder usingExpressions(final Boolean usingExpressions) {
            this.usingExpressions = usingExpressions;
            return this;
        }

        public Builder httpHeaders(final List<HttpHeader> httpHeaders) {
            this.httpHeaders = httpHeaders;
            return this;
        }

        public Builder contentEncodings(final List<HttpContentEncoding> contentEncodings) {
            this.contentEncodings = contentEncodings;
            return this;
        }

        public Builder parameterQueries(final List<RestParameterQuery> parameterQueries) {
            this.parameterQueries = parameterQueries;
            return this;
        }

        public Builder xpathExpressions(final List<RestXPathExpression> xpathExpressions) {
            this.xpathExpressions = xpathExpressions;
            return this;
        }

        public Builder jsonPathExpressions(final List<RestJsonPathExpression> jsonPathExpressions) {
            this.jsonPathExpressions = jsonPathExpressions;
            return this;
        }

        public Builder headerQueries(final List<RestHeaderQuery> headerQueries) {
            this.headerQueries = headerQueries;
            return this;
        }

        public UpdateRestMockResponseInput build(){
            return new UpdateRestMockResponseInput(this);
        }

    }

}
