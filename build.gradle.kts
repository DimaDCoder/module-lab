val springVersion by extra { "3.3.8" }

buildscript {
	repositories {
		mavenLocal()
		mavenCentral()
	}
}

plugins {
	java
	id("org.springframework.boot") version "3.3.8"
	id("io.spring.dependency-management") version "1.1.7"
	id("org.hibernate.orm") version "6.5.3.Final"
	id("org.openapi.generator") version "7.12.0"
}

allprojects {
	group = "dima.d.coder"
	version = "0.0.1-SNAPSHOT"

	repositories {
		mavenLocal()
		mavenCentral()
	}
}

configure(subprojects) {

	apply {
		plugin("java")
		plugin("org.springframework.boot")
		plugin("io.spring.dependency-management")
	}

	dependencyManagement {
		imports {
			mavenBom("org.springframework.boot:spring-boot-dependencies:$springVersion")
		}
	}

	dependencies {
		implementation("org.springframework.boot:spring-boot-starter")
		testImplementation("org.springframework.boot:spring-boot-starter-test")
		testRuntimeOnly("org.junit.platform:junit-platform-launcher")
	}

	java {
		toolchain {
			languageVersion = JavaLanguageVersion.of(17)
		}
	}

	tasks.withType<Test> {
		useJUnitPlatform()
	}
}