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

package com.fortmocks.core.basis.model.project.dto;

import com.fortmocks.core.basis.model.TypeIdentifiable;
import com.fortmocks.core.basis.model.project.domain.Project;
import com.fortmocks.core.basis.model.TypeIdentifier;
import com.fortmocks.core.basis.model.project.domain.DomainNameStrategy;
import org.dozer.Mapping;

import java.util.Date;

/**
 * The Project DTO is a DTO (Data transfer object) class for the project class.
 * @author Karl Dahlgren
 * @since 1.0
 * @see Project
 */
public class ProjectDto implements TypeIdentifiable {


    @Mapping("id")
    private Long id;

    @Mapping("name")
    private String name;

    @Mapping("updated")
    private Date updated;

    @Mapping("created")
    private Date created;

    @Mapping("description")
    private String description;

    @Mapping("domainNameStrategy")
    private DomainNameStrategy domainNameStrategy;

    private TypeIdentifier typeIdentifier;

    /**
     * The default constructor for the project DTO
     */
    public ProjectDto() {
        // Empty constructor
    }

    /**
     * The constructor provides the functionality to initiate a new project DTO based on another project DTO
     * @param projectDto The project DTO that the new project DTO is going to based on
     */
    protected ProjectDto(ProjectDto projectDto){
        this.id = projectDto.getId();
        this.name = projectDto.getName();
        this.updated = projectDto.getUpdated();
        this.created = projectDto.getCreated();
        this.description = projectDto.getDescription();
        this.domainNameStrategy = projectDto.getDomainNameStrategy();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getUpdated() {
        return updated;
    }

    public void setUpdated(Date updated) {
        this.updated = updated;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public DomainNameStrategy getDomainNameStrategy() {
        return domainNameStrategy;
    }

    public void setDomainNameStrategy(DomainNameStrategy domainNameStrategy) {
        this.domainNameStrategy = domainNameStrategy;
    }


    @Override
    public TypeIdentifier getTypeIdentifier() {
        return typeIdentifier;
    }

    @Override
    public void setTypeIdentifier(final TypeIdentifier typeIdentifier) {
        this.typeIdentifier = typeIdentifier;
    }
}