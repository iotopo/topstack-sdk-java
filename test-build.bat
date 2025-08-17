@echo off
echo ========================================
echo TopStack SDK Java ���Թ����ű�
echo ========================================

echo ������Ŀ...
call mvn clean

if %ERRORLEVEL% neq 0 (
    echo ����ʧ��
    pause
    exit /b 1
)

echo.
echo ������Ŀ...
call mvn compile -DskipTests

if %ERRORLEVEL% neq 0 (
    echo ����ʧ��
    pause
    exit /b 1
)

echo.
echo ���в���...
call mvn test

if %ERRORLEVEL% neq 0 (
    echo ����ʧ��
    pause
    exit /b 1
)

echo.
echo �����Ŀ...
call mvn package -DskipTests

if %ERRORLEVEL% neq 0 (
    echo ���ʧ��
    pause
    exit /b 1
)

echo.
echo ========================================
echo ���Թ����ɹ���
echo ========================================
echo.
echo ���ɵ��ļ���
echo - target/topstack-sdk-1.0.2.jar
echo - target/topstack-sdk-1.0.2-sources.jar
echo - target/topstack-sdk-1.0.2-javadoc.jar
echo.
pause 