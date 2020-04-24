package com.ryanhuen.depdencies.node

class DependenciesNode {
    String name
    String alias
    String version

    DependenciesNode(String name) {
        this.name = name
    }

    String getDep() {
        return alias + ":" + version
    }

    void alias(String alias) {
        this.alias = alias
    }

    void version(String version) {
        this.version = version
    }
}