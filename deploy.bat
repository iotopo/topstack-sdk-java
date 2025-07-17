@echo off
echo ========================================
echo TopStack SDK Java 发布脚本
echo ========================================

REM 检查环境变量
if "%SONATYPE_USERNAME%"=="" (
    echo 未设置 SONATYPE_USERNAME 环境变量
    set /p SONATYPE_USERNAME="请输入您的 Sonatype Central 用户名: "
    set SONATYPE_USERNAME=%SONATYPE_USERNAME%
)

if "%SONATYPE_PASSWORD%"=="" (
    echo 未设置 SONATYPE_PASSWORD 环境变量
    set /p SONATYPE_PASSWORD="请输入您的 Sonatype Central 密码: "
    set SONATYPE_PASSWORD=%SONATYPE_PASSWORD%
)

echo.
if "%GPG_PASSPHRASE%"=="" (
    echo 未设置 GPG_PASSPHRASE 环境变量
    set /p GPG_PASSPHRASE="请输入您的 GPG 密钥密码: "
    set GPG_PASSPHRASE=%GPG_PASSPHRASE%
)

echo.
if "%GPG_KEY_ID%"=="" (
    echo 未设置 GPG_KEY_ID 环境变量
    set /p GPG_KEY_ID="请输入您的 GPG 密钥 ID (可通过 'gpg --list-keys' 查看): "
    set GPG_KEY_ID=%GPG_KEY_ID%
)

echo.
echo 环境变量检查通过
echo SONATYPE_USERNAME: %SONATYPE_USERNAME%
echo SONATYPE_PASSWORD: %SONATYPE_PASSWORD%
echo GPG_KEY_ID: %GPG_KEY_ID%
echo GPG_PASSPHRASE: (已隐藏)
echo.

echo 清理并构建项目...
call mvn clean package -DskipTests

if %ERRORLEVEL% neq 0 (
    echo 构建失败
    pause
    exit /b 1
)

echo.
echo 发布到 Sonatype Central Portal...
call mvn clean deploy -s settings.xml -DskipTests

if %ERRORLEVEL% neq 0 (
    echo 发布失败
    pause
    exit /b 1
)

echo.
echo ========================================
echo 发布成功！
echo ========================================
echo.
echo 下一步：
echo 1. 登录 https://central.sonatype.com/
echo 2. 进入 "My Staging Repositories"
echo 3. 找到你的 staging repository
echo 4. 点击 "Close" 按钮
echo 5. 点击 "Release" 按钮
echo.
echo 注意：Central Portal 需要 GPG 签名，请确保已正确配置 GPG 密钥
echo.
pause 