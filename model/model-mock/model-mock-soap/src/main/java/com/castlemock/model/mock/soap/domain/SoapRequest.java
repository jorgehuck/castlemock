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

package com.castlemock.model.mock.soap.domain;

import com.castlemock.model.core.http.HttpHeader;
import com.castlemock.model.core.http.HttpMethod;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;
import java.util.Objects;

/**
 * @author Karl Dahlgren
 * @since 1.0
 */
@XmlRootElement
public class SoapRequest {

    private String body;
    private String envelope;
    private String contentType;
    private String uri;
    private HttpMethod httpMethod;
    private String operationName;
    private SoapVersion soapVersion;
    private List<HttpHeader> httpHeaders;
    private SoapOperationIdentifier operationIdentifier;

    private SoapRequest(){

    }

    private SoapRequest(final Builder builder){
        this.body = Objects.requireNonNull(builder.body, "body");
        this.envelope = builder.envelope;
        this.contentType = builder.contentType;
        this.uri = Objects.requireNonNull(builder.uri, "uri");
        this.httpMethod = Objects.requireNonNull(builder.httpMethod, "httpMethod");
        this.operationName = builder.operationName;
        this.soapVersion = Objects.requireNonNull(builder.soapVersion, "soapVersion");
        this.httpHeaders = Objects.requireNonNull(builder.httpHeaders, "httpHeaders");
        this.operationIdentifier = Objects.requireNonNull(builder.operationIdentifier, "operationIdentifier");
    }


    @XmlElement
    public String getBody() {
        return body;
    }

    @XmlElement
    public String getEnvelope() {
        return envelope;
    }

    @XmlElement
    public String getContentType() {
        return contentType;
    }

    @XmlElement
    public String getUri() {
        return uri;
    }

    @XmlElement
    public HttpMethod getHttpMethod() {
        return httpMethod;
    }

    @XmlElement
    public String getOperationName() {
        return operationName;
    }

    @XmlElement
    public SoapOperationIdentifier getOperationIdentifier() {
        return operationIdentifier;
    }

    @XmlElement
    public SoapVersion getSoapVersion() {
        return soapVersion;
    }

    @XmlElement
    public List<HttpHeader> getHttpHeaders() {
        return httpHeaders;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static final class Builder {

        private String body;
        private String envelope;
        private String contentType;
        private String uri;
        private HttpMethod httpMethod;
        private String operationName;
        private SoapVersion soapVersion;
        private List<HttpHeader> httpHeaders;
        private SoapOperationIdentifier operationIdentifier;

        private Builder() {
        }

        public Builder body(final String body) {
            this.body = body;
            return this;
        }

        public Builder envelope(final String envelope) {
            this.envelope = envelope;
            return this;
        }

        public Builder contentType(final String contentType) {
            this.contentType = contentType;
            return this;
        }

        public Builder uri(final String uri) {
            this.uri = uri;
            return this;
        }

        public Builder httpMethod(final HttpMethod httpMethod) {
            this.httpMethod = httpMethod;
            return this;
        }

        public Builder operationName(final String operationName) {
            this.operationName = operationName;
            return this;
        }

        public Builder soapVersion(final SoapVersion soapVersion) {
            this.soapVersion = soapVersion;
            return this;
        }

        public Builder httpHeaders(final List<HttpHeader> httpHeaders) {
            this.httpHeaders = httpHeaders;
            return this;
        }

        public Builder operationIdentifier(final SoapOperationIdentifier operationIdentifier) {
            this.operationIdentifier = operationIdentifier;
            return this;
        }

        public SoapRequest build() {
            return new SoapRequest(this);
        }
    }
}
