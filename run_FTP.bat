@echo off

REM This is the batch file the call the .java file to upload the files
REM This batch file must be in the same directory as the .java files
REM cd C:/JavaTest

javac FileTransferTest.java
java FileTransferTest

echo "finish file transfer"

pause