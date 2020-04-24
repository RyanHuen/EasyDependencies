# EasyDependencies
- 完整博文可以看这里 [Gradle依赖关系解决方案](https://ryanhuen.tech/blog/article/22/)
- 轻便快捷的管理全工程所有Module依赖关系、Version的Gradle插件库

# dependencies统一
### 声明
- 首先在根目录build.gradle中声明插件

```
classpath 'com.ryanhuen.easy_dependencies:easydependencies:1.0.3'
```

### 添加依赖
- 插件已经上传jcenter，直接引用就好
- 随后在根目录build.gradle添加依赖：

```
buildscript {
    dependencies {
        classpath classpath 'com.ryanhuen.easy_dependencies:easydependencies:1.0.3'
        // NOTE: Do not place your application dependencies here; they belong
        // in the individual module build.gradle files
    }
}
```
### 使用
- 工程中根目录创建dependencies.gradle文件（这一步可省略）
- sync工程完毕后，在根目录build.gradle引用该插件，在build.gradle文件中头部插入以下代码

```
apply plugin: 'easy_dependencies'
apply from: "./dependency/dependencies.gradle"  //dependencies.gradle创建在哪里就指向该路径
```

### 配置dependencies
- 此时插件已经引用上，接下来就是配置dependencies.gradle中的依赖了
```
easyDep {
    compileSdkVersion 29
    buildToolsVersion "29.0.2"
    minSdkVersion 23
    targetSdkVersion 29

    groups {
        androidx {
            nodes {
                appcompat {
                    alias 'androidx.appcompat:appcompat'
                    version '1.1.0'
                }
                constraintlayout {
                    alias 'androidx.constraintlayout:constraintlayout'
                    version '1.1.3'
                }
            }
        }
        unit_test {
            nodes {
                junit {
                    alias 'junit:junit'
                    version '4.12'
                }
                ext_junit {
                    alias 'androidx.test.ext:junit'
                    version '1.1.1'
                }
                espresso_core {
                    alias 'androidx.test.espresso:espresso-core'
                    version '3.2.0'
                }
            }
        }
    }
}
```

- 直接看代码，我在插件中声明了Module中常用的compileSdkVersion等版本，各位可以在此声明一次，全局进行调用。
- 同时，dependencies的声明，我拆分了alias和version，用于区分依赖声明和版本。因为version是经常被改动的，所以单独拆出来方便修改。
- 每一个dependencies的声明，就是一个node节点。这些节点自己可以作为一个group。比如androidx相关的依赖，就可以作为一个group进行管理。

### 引用
- 声明完毕就是引用了。
- Module中使用如下：

```
dependencies {
    implementation fileTree(dir: 'libs', include: ['*.jar'])

    implementation easyDep.groups.androidx.nodes.appcompat.dep
    implementation easyDep.groups.androidx.nodes.constraintlayout.dep
    testImplementation easyDep.groups.unit_test.nodes.junit.dep
    androidTestImplementation easyDep.groups.unit_test.nodes.ext_junit.dep
    androidTestImplementation easyDep.groups.unit_test.nodes.espresso_core.dep
}
```
