@echo off
setlocal
cd /d "%~dp0desktop\build\install\LangLaDesktop"
if not exist "bin\LangLaDesktop.bat" (
    echo Please run build-desktop.bat first.
    pause
    exit /b 1
)
call "bin\LangLaDesktop.bat"
if errorlevel 1 pause
