plugins {
    id("org.hibernate.orm") version "6.5.3.Final"
    id("org.openapi.generator") version "7.12.0"
}

dependencies {
    implementation(project(":common"))

    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation("org.springframework.boot:spring-boot-starter-validation")
    implementation("org.liquibase:liquibase-core")
    implementation("org.springdoc:springdoc-openapi-starter-webmvc-ui:2.6.0")
    implementation("org.openapitools:jackson-databind-nullable:0.2.6")
    implementation("com.google.code.findbugs:jsr305:3.0.2")

    compileOnly("org.projectlombok:lombok")

    runtimeOnly("org.postgresql:postgresql")

    annotationProcessor("org.projectlombok:lombok")
    annotationProcessor("org.springframework.boot:spring-boot-configuration-processor")
}

//hibernate {
//    enhancement {
//        enableLazyInitialization = true
//        enableDirtyTracking = true
//        enableAssociationManagement = true
//        enableExtendedEnhancement = false
//    }
//}

openApiGenerate {
    generatorName.set("spring")
    inputSpec.set(layout.projectDirectory.file("src/main/resources/rest-app.yaml").asFile.path)
    outputDir.set(layout.buildDirectory.dir("generated").get().asFile.path)
    apiPackage.set("dima.d.coder.api")
    modelPackage.set("dima.d.coder.model")
    invokerPackage.set("dima.d.coder.invoker")

    configOptions.set(
        mapOf(
            "interfaceOnly" to "true",
            "useSpringBoot3" to "true",
            "dateLibrary" to "java8",
//            "serializableModel" to "true",
//            "skipDefaultInterface" to "true",
            "generateSupportingFiles" to "false"
        )
    )
}

// Подключаем сгенерированный код в компиляцию
sourceSets["main"].java.srcDir(layout.buildDirectory.dir("generated/src/main/java"))

// Генерация до компиляции
tasks.compileJava {
    dependsOn("openApiGenerate")
}

// Очищаем генерацию при clean
tasks.clean {
    doFirst {
        delete(layout.buildDirectory.dir("generated"))
    }
}