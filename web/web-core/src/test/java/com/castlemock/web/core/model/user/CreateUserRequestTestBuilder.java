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

package com.castlemock.web.core.model.user;

import com.castlemock.model.core.user.Role;
import com.castlemock.model.core.user.Status;

public final class CreateUserRequestTestBuilder {

    private CreateUserRequestTestBuilder() {

    }

    public static CreateUserRequest.Builder builder() {
        return CreateUserRequest.builder()
                .role(Role.ADMIN)
                .status(Status.ACTIVE)
                .email("test@test.com")
                .password("password")
                .username("admin");
    }

    public static CreateUserRequest build() {
        return builder().build();
    }

}
