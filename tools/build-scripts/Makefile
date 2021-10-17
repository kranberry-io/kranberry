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

### RUN UI TESTS ###
kranberry-test: buildAndroidTestDebug installAndroidTestDebug clear-logcat-logs
	@adb logcat *:S KRANBERRY_LOG:V & LOGCAT_PID=$$!; \
	TERM=dumb adb shell am instrument -w io.kranberry.test/androidx.test.runner.AndroidJUnitRunner ; \
	RESULT=$$?; \
	if [ -n "$$LOGCAT_PID" ]; then kill $$LOGCAT_PID; fi; \
	exit $$RESULT

buildAndroidTestDebug:
	./gradlew assembleDebugAndroidTest

installAndroidTestDebug:
	adb install app/build/outputs/apk/androidTest/debug/app-debug-androidTest.apk


clear-logcat-logs:
	@adb shell logcat -b all -c