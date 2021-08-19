adb shell logcat -b all -c
adb logcat *:S KRANBERRY_LOG:V & LOGCAT_PID=$$!;

RESULT=$(adb shell "am instrument -w -e package $1 $2/androidx.test.runner.AndroidJUnitRunner; printf $?" | tail -1);
echo "Result running tests: ${RESULT}" ;
if [ $RESULT -ne 0 ]; then exit $RESULT; else echo "Success running tests"; fi;

PATH_PULL="/storage/emulated/0/Android/media/$1"
adb pull $PATH_PULL;
RESULT_PULL=$?;
echo "Result pulling files from ${PATH_PULL}: ${RESULT_PULL}" ;
if [ $RESULT_PULL -ne 0 ]; then echo "Error pulling files"; else echo "Success pulling files"; fi;

#if [ -n "$$LOGCAT_PID" ]; then kill $$LOGCAT_PID; fi;
exit $RESULT