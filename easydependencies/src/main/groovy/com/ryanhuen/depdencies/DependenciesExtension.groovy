package com.ryanhuen.depdencies

import com.ryanhuen.depdencies.group.DependenciesGroup
import org.gradle.api.NamedDomainObjectContainer

class DependenciesExtension {

    int compileSdkVersion;
    int minSdkVersion;
    int targetSdkVersion;
    String buildToolsVersion;

    NamedDomainObjectContainer<DependenciesGroup> dependenciesGroups;

    def dependenciesGroups(final Closure configureClosure) {
        dependenciesGroups.configure(configureClosure)
    }
}