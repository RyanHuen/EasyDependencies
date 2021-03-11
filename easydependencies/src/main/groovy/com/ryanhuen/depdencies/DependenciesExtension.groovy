package com.ryanhuen.depdencies

import com.ryanhuen.depdencies.group.DependenciesGroup
import org.gradle.api.NamedDomainObjectContainer

class DependenciesExtension {

    int compileSdkVersion;
    int minSdkVersion;
    int targetSdkVersion;
    String buildToolsVersion;
    Map<String, String> versionPair;

    NamedDomainObjectContainer<DependenciesGroup> groups;

    def groups(final Closure configureClosure) {
        groups.configure(configureClosure)
    }

    void compileSdkVersion(int compileSdkVersion) {
        this.compileSdkVersion = compileSdkVersion;
    }

    void minSdkVersion(int minSdkVersion) {
        this.minSdkVersion = minSdkVersion
    }

    void targetSdkVersion(int targetSdkVersion) {
        this.targetSdkVersion = targetSdkVersion
    }

    void buildToolsVersion(String buildToolsVersion) {
        this.buildToolsVersion = buildToolsVersion
    }

    void versionPair(Map<String, String> versionPair) {
        this.versionPair = versionPair
    }
}