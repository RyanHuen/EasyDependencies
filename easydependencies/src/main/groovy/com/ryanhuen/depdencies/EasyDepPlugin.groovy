package com.ryanhuen.depdencies

import com.ryanhuen.depdencies.group.DependenciesGroup
import com.ryanhuen.depdencies.node.DependenciesNode
import org.gradle.api.NamedDomainObjectContainer
import org.gradle.api.Plugin
import org.gradle.api.Project

class EasyDepPlugin implements Plugin<Project> {
    @Override
    void apply(Project project) {

        setupExtension(project)
    }

    private void setupExtension(Project project) {
        final NamedDomainObjectContainer<DependenciesGroup> groups = project.container(DependenciesGroup)
        groups.all {
            nodes = project.container(DependenciesNode)
        }
        DependenciesExtension dependenciesExtension = project.container(DependenciesExtension)
        dependenciesExtension.groups = groups
        project.extensions.add("easyDep", dependenciesExtension)
    }
}
