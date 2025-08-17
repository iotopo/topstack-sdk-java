@echo off
echo ========================================
echo TopStack SDK Java 部署脚本
echo ========================================

echo 确保 gpg-agent 已启动: gpg-agent --daemon

REM 检查环境变量
if "%SONATYPE_USERNAME%"=="" (
    echo 缺少 SONATYPE_USERNAME 环境变量
    set /p SONATYPE_USERNAME="请输入 Sonatype Central 用户名: "
    set SONATYPE_USERNAME=%SONATYPE_USERNAME%
)

if "%SONATYPE_PASSWORD%"=="" (
    echo 缺少 SONATYPE_PASSWORD 环境变量
    set /p SONATYPE_PASSWORD="请输入 Sonatype Central 密码: "
    set SONATYPE_PASSWORD=%SONATYPE_PASSWORD%
)

echo.
if "%GPG_PASSPHRASE%"=="" (
    echo 缺少 GPG_PASSPHRASE 环境变量
    set /p GPG_PASSPHRASE="请输入 GPG 密钥密码: "
    set GPG_PASSPHRASE=%GPG_PASSPHRASE%
)

echo.
if "%GPG_KEY_ID%"=="" (
    echo 缺少 GPG_KEY_ID 环境变量
    set /p GPG_KEY_ID="请输入 GPG 密钥 ID (通过 'gpg --list-keys' 查看): "
    set GPG_KEY_ID=%GPG_KEY_ID%
)

echo.
echo 环境变量如下:
echo SONATYPE_USERNAME: %SONATYPE_USERNAME%
echo SONATYPE_PASSWORD: %SONATYPE_PASSWORD%
echo GPG_KEY_ID: %GPG_KEY_ID%
echo GPG_PASSPHRASE: (已设置)
echo.

echo 清理并构建项目...
call mvn clean package -DskipTests

if %ERRORLEVEL% neq 0 (
    echo 构建失败
    pause
    exit /b 1
)

echo.
echo 部署到 Sonatype Central Portal...
call mvn clean deploy -s settings.xml -DskipTests

if %ERRORLEVEL% neq 0 (
    echo 部署失败
    pause
    exit /b 1
)

echo.
echo ========================================
echo 部署成功
echo ========================================
echo.
echo 第一步:
echo 1. 登录 https://central.sonatype.com/
echo 2. 进入 "My Staging Repositories"
echo 3. 找到对应的 staging repository
echo 4. 点击 "Close" 按钮
echo 5. 点击 "Release" 按钮
echo.
echo 注意: Central Portal 需要 GPG 签名来确保部署的准确性
echo.
pause 