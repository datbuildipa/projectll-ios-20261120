@echo off
setlocal
cd /d "%~dp0"
call "%~dp0bin\LangLaDesktop.bat"
if errorlevel 1 pause
