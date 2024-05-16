@echo off
chcp 65001

setlocal enabledelayedexpansion

set "command="
set "exitCommand=exit"

:main
set /p "command= "

if "%command%"=="%exitCommand%" (
    goto :eof
)

java -jar Task2.jar !command!

goto :main