### LINT ###
detekt:
	./gradlew detekt

### BUILD AND INSTALL ###
build:
	./gradlew assemble

generate-sources:
	./gradlew androidSourcesJar javadocJar

### PUBLISH ###
publish:
	./gradlew publishReleasePublicationToSonatypeRepository --max-workers 1 closeAndReleaseSonatypeStagingRepository

close-staging-repo:
	./gradlew closeAndReleaseSonatypeStagingRepository