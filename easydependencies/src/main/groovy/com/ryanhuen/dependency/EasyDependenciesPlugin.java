package com.ryanhuen.dependency;

import org.gradle.api.Plugin;
import org.gradle.api.Project;

/**
 * EasyDependenciesPlugin
 * 插件入口
 *
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
 * 2020/4/22 : 11:50
 */
public class EasyDependenciesPlugin implements Plugin<Project> {

    @Override
    public void apply(Project project) {

        project.getExtensions().create("easyDepend", DepConfigureExtension.class, project);
    }
}
