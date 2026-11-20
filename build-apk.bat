@echo off
title Build APK Release

echo ============================
echo   BUILD RELEASE APK
echo ============================

call gradlew.bat android:assembleRelease

echo.
echo DONE! APK tai:
echo android\build\outputs\apk\release

pause
