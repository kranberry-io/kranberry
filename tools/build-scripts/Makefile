### LINT ###
detekt:
	./gradlew detekt

### BUILD ###
build:
	./gradlew assemble

buildAndroidTest:
	./gradlew assembleAndroidTest

generate-sources:
	./gradlew androidSourcesJar javadocJar

### PUBLISH ###
publish:
	./gradlew publishReleasePublicationToSonatypeRepository --max-workers 1 closeAndReleaseSonatypeStagingRepository

close-staging-repo:
	./gradlew closeAndReleaseSonatypeStagingRepository

### RUN UI TESTS ###
test:
	tools/build-scripts/execute-tests.sh

copy-screenshots:
	@adb pull /storage/emulated/0/Pictures/Screenshots