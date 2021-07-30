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

### RUN UI TESTS ###
test:
	@adb logcat *:S KRANBERRY_LOG:V & LOGCAT_PID=$$!; \
	TERM=dumb ./gradlew connectedAndroidTest -Pandroid.testInstrumentationRunnerArguments.class=io.kranberry.SampleTest; \
	RESULT=$$?; \
	if [ -n "$$LOGCAT_PID" ]; then kill $$LOGCAT_PID; fi; \
	exit $$RESULT

copy-screenshots:
	@adb pull /storage/emulated/0/Pictures/Screenshots