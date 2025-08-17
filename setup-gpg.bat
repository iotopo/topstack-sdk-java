@echo off
echo ========================================
echo TopStack SDK Java GPG ��Կ���ýű�
echo ========================================

echo �˽ű������������� GPG ��Կ���� Maven Central ����
echo.

echo 1. ����Ƿ��Ѱ�װ GPG...
gpg --version >nul 2>&1
if %ERRORLEVEL% neq 0 (
    echo ����: δ�ҵ� GPG�����Ȱ�װ GPG
    echo Windows �û����Դ� https://www.gpg4win.org/ ����
    pause
    exit /b 1
)

echo GPG �Ѱ�װ
echo.

echo 2. ���������Կ...
gpg --list-keys

echo.
echo 3. �����µ� GPG ��Կ...
echo �밴����ʾ����������Ϣ��
echo - ��Կ����: ѡ��Ĭ�� (RSA and RSA)
echo - ��Կ��С: ѡ�� 4096
echo - ��Ч��: ѡ�� 0 (��������)
echo - �û���Ϣ: ������������������
echo - ����: ����һ����ȫ������
echo.

gpg --gen-key

if %ERRORLEVEL% neq 0 (
    echo GPG ��Կ����ʧ��
    pause
    exit /b 1
)

echo.
echo 4. ��ʾ���ɵ���Կ...
gpg --list-keys

echo.
echo 5. �ϴ���Կ����Կ������...
echo ������������Կ ID (��ʾ����һ�е� pub ����):
set /p KEY_ID="��Կ ID: "

echo �����ϴ��� Ubuntu ��Կ������...
gpg --keyserver keyserver.ubuntu.com --send-keys %KEY_ID%

if %ERRORLEVEL% neq 0 (
    echo ����: ��Կ�ϴ�����ʧ�ܣ����Ժ��ֶ��ϴ�
    echo �ֶ��ϴ�����: gpg --keyserver keyserver.ubuntu.com --send-keys %KEY_ID%
) else (
    echo ��Կ�ϴ��ɹ�
)

echo.
echo ========================================
echo GPG ��Կ�������
echo ========================================
echo.
echo ���¼������Ϣ���ڷ�����
echo ��Կ ID: %KEY_ID%
echo ����: (���ղ����õ�����)
echo.
echo ����ʱ�����û���������
echo set GPG_KEY_ID=%KEY_ID%
echo set GPG_PASSPHRASE=your_password
echo.
pause 