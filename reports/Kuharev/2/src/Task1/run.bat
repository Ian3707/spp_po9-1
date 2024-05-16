@echo off
chcp 65001

set /p fileName=Введите имя выходного файла: 

java -jar Task_1.jar %fileName%

pause