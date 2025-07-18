@echo off
echo ========================================
echo TopStack SDK Java �����ű�
echo ========================================

REM ��黷������
if "%SONATYPE_USERNAME%"=="" (
    echo δ���� SONATYPE_USERNAME ��������
    set /p SONATYPE_USERNAME="���������� Sonatype Central �û���: "
    set SONATYPE_USERNAME=%SONATYPE_USERNAME%
)

if "%SONATYPE_PASSWORD%"=="" (
    echo δ���� SONATYPE_PASSWORD ��������
    set /p SONATYPE_PASSWORD="���������� Sonatype Central ����: "
    set SONATYPE_PASSWORD=%SONATYPE_PASSWORD%
)

echo.
if "%GPG_PASSPHRASE%"=="" (
    echo δ���� GPG_PASSPHRASE ��������
    set /p GPG_PASSPHRASE="���������� GPG ��Կ����: "
    set GPG_PASSPHRASE=%GPG_PASSPHRASE%
)

echo.
if "%GPG_KEY_ID%"=="" (
    echo δ���� GPG_KEY_ID ��������
    set /p GPG_KEY_ID="���������� GPG ��Կ ID (��ͨ�� 'gpg --list-keys' �鿴): "
    set GPG_KEY_ID=%GPG_KEY_ID%
)

echo.
echo �����������ͨ��
echo SONATYPE_USERNAME: %SONATYPE_USERNAME%
echo SONATYPE_PASSWORD: %SONATYPE_PASSWORD%
echo GPG_KEY_ID: %GPG_KEY_ID%
echo GPG_PASSPHRASE: (������)
echo.

echo ����������Ŀ...
call mvn clean package -DskipTests

if %ERRORLEVEL% neq 0 (
    echo ����ʧ��
    pause
    exit /b 1
)

echo.
echo ������ Sonatype Central Portal...
call mvn clean deploy -s settings.xml -DskipTests

if %ERRORLEVEL% neq 0 (
    echo ����ʧ��
    pause
    exit /b 1
)

echo.
echo ========================================
echo �����ɹ���
echo ========================================
echo.
echo ��һ����
echo 1. ��¼ https://central.sonatype.com/
echo 2. ���� "My Staging Repositories"
echo 3. �ҵ���� staging repository
echo 4. ��� "Close" ��ť
echo 5. ��� "Release" ��ť
echo.
echo ע�⣺Central Portal ��Ҫ GPG ǩ������ȷ������ȷ���� GPG ��Կ
echo.
pause 