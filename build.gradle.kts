plugins {
    `maven-publish`
}

interface ImagePublication : Publication

abstract class DefaultImagePublication
@Inject
constructor(
    private val name: String,
) : ImagePublication {

    override fun getName(): String = name

    override fun withoutBuildIdentifier() {}

    override fun withBuildIdentifier() {}
}

publishing.publications.registerBinding(ImagePublication::class, DefaultImagePublication::class)

publishing {
    repositories {
        // also custom repository (e.g. Docker Registry via extension method)
    }

    publications {
        register<ImagePublication>("myImagePublication")
    }
}
