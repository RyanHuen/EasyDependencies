package com.ryanhuen.dependency;

import com.ryanhuen.dependency.version.DependenciesNameValuePair;

import org.gradle.api.Action;
import org.gradle.api.NamedDomainObjectContainer;
import org.gradle.api.Project;

/**
 * <p>
 * <b>NOTE：注意事项</b>
 *
 * <h3>版本迭代说明</h3>
 *
 * <h4>V版本号 版本 版本编辑作者 : MuXi</h4>
 * <ul>
 *  <li>功能或重要字段说明
 * </ul>
 *
 * @author MuXi
 * 2020/4/21 : 18:25
 */
public class DepConfigureExtension {

    private int compileSdkVersion;
    private int minSdkVersion;
    private int targetSdkVersion;
    private String buildToolsVersion;

    private NamedDomainObjectContainer<DependenciesNameValuePair> dependenciesPairs;

    public DepConfigureExtension(Project project) {
        NamedDomainObjectContainer<DependenciesNameValuePair> dependenciesPairs = project.container(DependenciesNameValuePair.class);
        this.dependenciesPairs = dependenciesPairs;
    }

    public int getCompileSdkVersion() {
        return compileSdkVersion;
    }

    public void setCompileSdkVersion(int compileSdkVersion) {
        this.compileSdkVersion = compileSdkVersion;
    }

    public int getMinSdkVersion() {
        return minSdkVersion;
    }

    public void setMinSdkVersion(int minSdkVersion) {
        this.minSdkVersion = minSdkVersion;
    }

    public int getTargetSdkVersion() {
        return targetSdkVersion;
    }

    public void setTargetSdkVersion(int targetSdkVersion) {
        this.targetSdkVersion = targetSdkVersion;
    }

    public String getBuildToolsVersion() {
        return buildToolsVersion;
    }

    public void setBuildToolsVersion(String buildToolsVersion) {
        this.buildToolsVersion = buildToolsVersion;
    }

    public NamedDomainObjectContainer<DependenciesNameValuePair> getDependenciesPairs() {
        return dependenciesPairs;
    }

    public void dependenciesPairs(Action<? super NamedDomainObjectContainer<DependenciesNameValuePair>> action) {
        action.execute(dependenciesPairs);
    }
}
