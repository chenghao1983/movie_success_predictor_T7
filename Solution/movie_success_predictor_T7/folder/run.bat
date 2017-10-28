call setenv.bat

@echo off&setlocal
for %%i in ("%~dp0..") do set "folder=%%~fi"
echo %folder%
cd..

"%PATH%\java" -verbose -classpath  %folder%\classes;%folder%\src\weka.jar sg.edu.nus.iss.msp.main.MSPApp 
