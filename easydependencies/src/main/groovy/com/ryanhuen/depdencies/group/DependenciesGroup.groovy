package com.ryanhuen.depdencies.group

import com.ryanhuen.depdencies.node.DependenciesNode
import org.gradle.api.NamedDomainObjectContainer
import org.gradle.api.NamedDomainObjectList

class DependenciesGroup {

    String name
    NamedDomainObjectContainer<DependenciesNode> nodes;

    DependenciesGroup(String name) {
        this.name = name
    }

    def nodes(final Closure configureClosure) {
        nodes.configure(configureClosure)
    }

}