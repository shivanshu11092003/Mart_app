import org.gradle.internal.impldep.org.apache.ivy.plugins.repository.url.URLRepository
import java.net.URL

pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
        maven {
            url=uri("https://jcenter.bintray.com")
        }

    }
}



rootProject.name = "KietMart"
include(":app")
 