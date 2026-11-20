@echo off
setlocal
cd /d "%~dp0"
set "GRADLE_USER_HOME=%~dp0"
call gradlew.bat -p desktop installDist distZip
if errorlevel 1 (
    echo Desktop build failed.
    pause
    exit /b 1
)
echo Desktop ready: desktop\build\install\LangLaDesktop\bin\LangLaDesktop.bat
pause
