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

package com.castlemock.service.mock.rest.project.adapter;

import com.castlemock.model.core.ServiceProcessor;
import com.castlemock.model.mock.rest.domain.RestProject;
import com.castlemock.model.mock.rest.domain.RestProjectTestBuilder;
import com.castlemock.service.mock.rest.project.input.ReadAllRestProjectsInput;
import com.castlemock.service.mock.rest.project.output.ReadAllRestProjectsOutput;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.List;

/**
 * @author Karl Dahlgren
 * @since 1.0
 */
public class RestProjectServiceAdapterTest {

    @Mock
    private ServiceProcessor serviceProcessor;

    @InjectMocks
    private RestProjectServiceAdapter adapter;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testReadAll(){
        final RestProject project = RestProjectTestBuilder.builder().build();
        final List<RestProject> projects = List.of(project);
        final ReadAllRestProjectsOutput output = ReadAllRestProjectsOutput.builder().projects(projects).build();

        Mockito.when(serviceProcessor.process(Mockito.any(ReadAllRestProjectsInput.class))).thenReturn(output);

        final List<RestProject> returnedProjects = adapter.readAll();

        Assertions.assertEquals(projects, returnedProjects);
        Mockito.verify(serviceProcessor, Mockito.times(1)).process(Mockito.any(ReadAllRestProjectsInput.class));
    }

}
