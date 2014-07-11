1.gradle init --type java-library
(要使用Java插件)要支持生成jar包的jar工程，只要在build.gradle里面添加一行
apply plugin: 'java'
现在在这个目录的命令行里运行gradle jar就可以自动完成把/src/main/java下的java文件编译，自动单元测试/src/test/java下的类


2.Java plugin - tasks    
    gradle clean		     Deletes the project build directory.
    gradle cleanTaskName	     Deletes the output files produced by the specified task.
				     For example cleanJar will delete the JAR file created by the jar task,
				     and cleanTest will delete the test results created by the test task.
    gradle jar			     Assembles the JAR file. 在build/libs/目录下生成jar文件
    gradle compilejava		     Compiles production Java source files using javac.
    gradle processResources	     Copies production resources into the production classes directory.
    gradle classes		     Assembles(装配，集合，收集) the production classes directory.
    gradle testClasses		     Assembles the test classes directory.
    gradle javadoc		     Generates API documentation for the production Java source, using Javadoc
    gradle test			     Runs the unit tests using JUnit or TestNG.
    gradle uploadArchives	     Uploads the artifacts in the archives configuration, including the JAR file.
Java plugin - source set tasks
    gradle compileSourceSetJava	     Compiles the given source set's Java source files using javac.
    gradle processSourceSetResources Copies the given source set's resources into the classes directory.
    gradle sourceSetClasses	     Assembles the given source set's classes director
Java plugin - lifecycle tasks
    gradle assemble		     Assembles all the archives in the project.
    gradle check		     Performs all verification tasks in the project.
    gradle buildNeeded		     Performs a full build of the project and all projects it depends on.
    gradle build		     Performs a full build of the project.
    gradle buildDependents	     Performs a full build of the project and all projects which depend on it.
    gradle buildConfigurationName    Assembles the artifacts in the specified configuration.
				     The task is added by the Base plugin which is implicitly applied by the Java plugin.
    gradle uploadConfigurationName   Assembles and uploads the artifacts in the specified configuration. 
				     The task is added by the Base plugin which is implicitly applied by the Java plugin.

Java plugin - default project layout
    src/main/java		     Production Java source
    src/main/resources		     Production resources
    src/test/java	             Test Java source
    src/test/resources	             Test resources
    src/sourceSet/java		     Java source for the given source set
    src/sourceSet/resources	     Resources for the given source set
    
Changing the project layout改变工程布局
可以通过配置合适的源集来配置布局。后面还会详细讨论，下面是一个简单的例子修改了main中的 Java 和resource source 目录.
Example Custom Java source layout
build.gradle
sourceSets {
    main {
        java {
            srcDir 'src/java'
        }
        resources {
            srcDir 'src/resources'
        }
    }
}    
  

Dependency management依赖管理
Java插件有很多依赖配置，它把这些配置非给各个任务，如compileJava 和 test.
Example Java plugin - dependency configurations
Name		Extends			Used by tasks	        Meaning
compile		-			compileJava		Compile time dependencies
runtime		compile			-			Runtime dependencies
testCompile	compile			compileTestJava	        Additional dependencies for compiling tests.
testRuntime	runtime, testCompile	test		        Additional dependencies for running tests only.
archives	-			uploadArchives	        Artifacts (e.g. jars) produced by this project.
default		runtime			-		        The default configuration used by a project dependency on this project.
							        Contains the artifacts and dependencies required by this project at runtime.
对于加入工程的每个源集，Java插件增加如下依赖配置：
Example: Java plugin - source set dependency configurations
Name			Extends			Used by tasks	        Meaning
sourceSetCompile	-			compileSourceSetJava	Compile time dependencies for the given source set
sourceSetRuntime	sourceSetCompile	-	                Runtime time dependencies for the given source set


Convention properties传统属性
Java插件有一些传统属性，如下。你可以直接在脚本中使用这些属性，更多参考 Section 21.3, “Conventions”
Table: Java plugin - directory properties
Property name	    Type		Default value	             Description
reportsDirName	    String		reports		             The name of the directory to generate reports into, relative to the build directory.
reportsDir	    File (read-only)	buildDir/reportsDirName	     The directory to generate reports into.
testResultsDirName  String		test-results	             The name of the directory to generate test result .xml files into,
							             relative to the build directory.
testResultsDir	    File (read-only)	buildDir/testResultsDirName  The directory to generate test result .xml files into.
testReportDirName   String		tests		             The name of the directory to generate the test report into,
							             relative to the reports directory.
testReportDir	    File (read-only)	reportsDir/testReportDirName The directory to generate the test report into.
libsDirName	    String		libs		             The name of the directory to generate libraries into, relative to the build directory.
libsDir		    File (read-only)	buildDir/libsDirName	     The directory to generate libraries into.
distsDirName	    String		distributions	             The name of the directory to generate distributions into,
							             relative to the build directory.
distsDir	    File (read-only)	buildDir/distsDirName	     The directory to generate distributions into.
docsDirName	    String		docs		             The name of the directory to generate documentation into,
							             relative to the build directory.
docsDir		    File (read-only)	buildDir/docsDirName	     The directory to generate documentation into.
dependencyCacheDirName	String		dependency-cache	     The name of the directory to use to cache source dependency information,
							             relative to the build directory.
dependencyCacheDir  File (read-only)	buildDir/dependencyCacheDirName	 The directory to use to cache source dependency information.

Table: Java plugin - other properties
Property name		Type				Default value	                Description
sourceSets		SourceSetContainer(read-only)	Not null	                Contains the project's source sets.
sourceCompatibility	JavaVersion.			Value of the current used JVM	Java version compatibility to use when compiling Java source.
targetCompatibility	JavaVersion.			sourceCompatibility	        Java version to generate classes for.
archivesBaseName	String				projectName	                The basename to use for archives, such as JAR or ZIP files.
manifest		Manifest			an empty manifest	        The manifest to include in all JAR files.


这些属性来自传统对象：JavaPluginConvention, BasePluginConvention 和 ReportingBasePluginConvention.
Working with source sets使用源集
通过 sourceSets 属性访问源集，它是工程盛放源集的容器， SourceSetContainer类型的。 还有一个基本块 sourceSets { } ，可以使用闭包来配置源集容器。源集容器工作方式和其他容器完全一样，比如任务tasks.
Example: Accessing a source set
build.gradle
// Various ways to access the main source set
println sourceSets.main.output.classesDir
println sourceSets['main'].output.classesDir
sourceSets {
    println main.output.classesDir
}
sourceSets {
    main {
        println output.classesDir
    }
}

// Iterate over the source sets
sourceSets.all {
    println name
}

要配置容器，只要用上面的任意一个方法设置源集属性值即可。源集的属性下面会描述。先简单看个例子：
Example:  Configuring the source directories of a source set
build.gradle
sourceSets {
    main {
        java {
            srcDir 'src/java'
        }
        resources {
            srcDir 'src/resources'
        }
    }
}

Source set properties源集属性
下面是一些常用的重要的属性，更多的参见：SourceSet.
Table: Java plugin - source set properties
Property name		Type				Default value	                Description
name			String (read-only)		Not null	                The name of the source set, used to identify it.
output			SourceSetOutput (read-only)	Not null	                The output files of the source set,
							                                containing its compiled classes and resources.
output.classesDir	File				buildDir/classes/name	        The directory to generate the classes of this source set into.
output.resourcesDir	File				buildDir/resources/name         The directory to generate the resources of this source set into.
compileClasspath	FileCollection			compileSourceSet configuration.	The classpath to use when compiling the
							                                source files of this source set.
runtimeClasspath	FileCollection			output+runtimeSourceSetconfiguration.	The classpath to use when executing the classes of this source set.
java			SourceDirectorySet (read-only)	Not null	                 The Java source files of this source set. Contains only .java
							                                 files found in the Java source directories, and excludes all other files.
java.srcDirs		Set<File>. Can set using	[projectDir/src/name/java]	 The source directories containing the Java source files of this source set.
			anything described in
			Section 16.5, “Specifying a
			set of input files”.	  
resources		SourceDirectorySet (read-only)	Not null	                 The resources of this source set. Contains only resources, and excludes
							                                 any.java files found in the resource source directories. Other plugins,
											 such as the Groovy plugin, exclude additional types of files from this collection.
resources.srcDirs	Set<File>. Can set using	[projectDir/src/name/resources]  The source directories containing the resources of this source set.
			anything described in Section
			16.5, “Specifying a set of
			input files”.		
allJava			SourceDirectorySet(read-only)	java	                         All .java files of this source set. Some plugins, such as the Groovy plugin,
							                                 add additional Java source files to this collection.
allSource		SourceDirectorySet(read-only)	resources + java	         All source files of this source set. This include all resource files and all
							                                 Java source files. Some plugins, such as the Groovy plugin, add additional
											 source files to this collection.

Defining new source sets新建源集
在 sourceSets { } 块中命名就可以创建源集了：
Example  Defining a source set
build.gradle
sourceSets {
    intTest
}
新建源集后Java插件会给它增加一些依赖配置，见上文： Table: “Java plugin - source set dependency configurations”. 你可以用这些配置定义源集的编译和运行时依赖。
Example  Defining source set dependencies
build.gradle
sourceSets {
    intTest
}

dependencies {
    intTestCompile 'junit:junit:4.11'
    intTestRuntime 'org.ow2.asm:asm-all:4.0'
}
Java插件会增加一些汇编任务给源集，见上文 Table 23.2, “Java plugin - source set tasks”. 比如对于 intTest的源集可以通过执行 gradle intTestClasses 来编译
Example  Compiling a source set

Output of gradle intTestClasses
> gradle intTestClasses
:compileIntTestJava
:processIntTestResources
:intTestClasses

BUILD SUCCESSFUL

Total time: 1 secs


javadoc
javadoc任务是Javadoc的实例。它支持核心javadoc选项和标准doclet选项（见 reference documentation )。完整信息参考 CoreJavadocOptions and StandardJavadocDocletOptions.
Table: Java plugin - Javadoc properties
Task Property			    Type		           Default Value
classpath			    FileCollection	           sourceSets.main.output + sourceSets.main.compileClasspath
source				    FileTree. Can set using anything described in Section 16.5, “Specifying a set of input files”.	sourceSets.main.allJava
destinationDir			    File		           docsDir/javadoc
title				    String		           The name and version of the project

clean
clean 任务是Delete的实例，它会把 dir 属性值对应的目录删掉.
Table  Java plugin - Clean properties
Task Property			    Type		            Default Value
dir				    File		            buildDir


Resources资源
The Java plugin uses the Copy task for resource handling. It adds an instance for each source set in the project. You can find out more about the copy task in Section 16.6, “Copying files”.
Table: Java plugin - ProcessResources properties
Task Property			    Type		                                                                                Default Value
srcDirs			            Object. Can set using anything described in Section 16.5, “Specifying a set of input files”.	sourceSet.resources
destinationDir			    File. Can set using anything described in Section 16.1, “Locating files”.	                        sourceSet.output.resourcesDir

CompileJava编译
Java插件会给工程中的每个源集增加一个 JavaCompile 类型实例。主要的配置选项如下：
Table:. Java plugin - Compile properties
Task Property			    Type		                                                                         Default Value
classpath			    FileCollection	                                                                         sourceSet.compileClasspath
source				    FileTree.Can set using anything described in Section16.5,“Specifying a set of input files”.	 sourceSet.java
destinationDir			    File.		                                                                         sourceSet.output.classesDir
编译任务委托了Ant的 javac 任务，将options.useAnt设为false可以激活Grass的编译集成从而绕过Ant的任务。以后这会成为默认任务。

默认Java的编译工作在Gradle进程中执行。将options.fork 设为 true 会生成单独的进程。在Ant中这样做会减慢编译速度，而在Gradle中相反，Gradle会尽量重复使用编译进程。优先尊重的选项是options.forkOptions
 

Jar打包
jar任务会生成jar文件，包括了工程的类文件和资源文件。jar文件是 archives 依赖配置的产出，所以依赖工程可以直接引用。如果要把工程上传到库，jar文件会被声明为依赖描述符的一部分。更多请阅读 Section 16.8, “Creating archives” 和 Chapter 51, Publishing artifacts.

Manifest主配置清单
每个jar或war对象都有一个 manifest 属性，值为 Manifest的单独实例。压缩后对应的MANIFEST.MF文件就写入压缩文件中了。
Example: Customization of MANIFEST.MF
build.gradle
jar {
    manifest {
        attributes("Implementation-Title": "Gradle", "Implementation-Version": version)
    }
}
可以创建 Manifest 的独立实例，这样就可以在jar中共享主配信息了。
Example: Creating a manifest object.
build.gradle
ext.sharedManifest = manifest {
    attributes("Implementation-Title": "Gradle", "Implementation-Version": version)
}
task fooJar(type: Jar) {
    manifest = project.manifest {
        from sharedManifest
    }
}

Manifest 对象可以随便合并，可以是文件路径也可以是主配引用等等。
Example: Separate MANIFEST.MF for a particular archive
build.gradle
task barJar(type: Jar) {
    manifest {
        attributes key1: 'value1'
        from sharedManifest, 'src/config/basemanifest.txt'
        from('src/config/javabasemanifest.txt', 'src/config/libbasemanifest.txt') {
            eachEntry { details ->
                if (details.baseValue != details.mergeValue) {
                    details.value = baseValue
                }
                if (details.key == 'foo') {
                    details.exclude()
                }
            }
        }
    }
}
Manifest会按照from 语句中的顺序进行合并。如果合并中发现相同的值则保持原来的，可以通过增加eachEntry 动作自定义合并行为，在里面要访问 ManifestMergeDetails 的实例。合并并不是立即执行的，而是在生成jar文件或者调用 writeTo 和 effectiveManifest的时候。要把主配写入硬盘很简单：
Example: Separate MANIFEST.MF for a particular archive
build.gradle
jar.manifest.writeTo("$buildDir/mymanifest.mf")
23.14. Uploading上传










3.Dependencies{} 是一个configuration block。它会在所有的Task执行之前运行，其作用就是准备好要用的变量和数据结构。
1）dependencies用于声明一组依赖，这些依赖会被组合为configuration;
2）configuration代表了一组构件及其依赖。
dependencies的语法结构如下：
dependencies {
    configurationName dependencyNotation1, dependencyNotation2, ...
}
testCompile 就是configuration, 'junit:junit:4.11'则是dependencyNotation
例如:compile files('./a.jar')

还可以直接依赖本地jar包，如：
dependencies {
    compile fileTree(dir: 'libs', include: '*.jar')
}这样就可以直接依赖/libs/目录下所有的jar文件了。


4.// Redefine where Gradle should expect Java source files (*.java)
    sourceSets {
        main {
            manifest.srcFile 'build/mergeOut.xml'
            java.srcDirs = ['../../src']
            resources.srcDirs = ['../../src']
            aidl.srcDirs = ['../../src']
            renderscript.srcDirs = ['../../src']
            res.srcDirs = ['.res_temp']
            assets.srcDirs = ['../../assets']
	    jniLibs.srcDirs = ['../../libs','../hll_ser_3.2.2/libs']
        }

    }
// Redefine where .class files are written
sourceSets.main.output.classesDir = file("classes")


5.task
task doMyShell(type: Exec) {
    executable 'sh'
    args '-c','bash test.sh $arg'
}



    
