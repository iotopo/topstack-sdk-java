@echo off
echo ========================================
echo TopStack SDK Java GPG 密钥设置脚本
echo ========================================

echo 此脚本将帮助您设置 GPG 密钥用于 Maven Central 发布
echo.

echo 1. 检查是否已安装 GPG...
gpg --version >nul 2>&1
if %ERRORLEVEL% neq 0 (
    echo 错误: 未找到 GPG，请先安装 GPG
    echo Windows 用户可以从 https://www.gpg4win.org/ 下载
    pause
    exit /b 1
)

echo GPG 已安装
echo.

echo 2. 检查现有密钥...
gpg --list-keys

echo.
echo 3. 生成新的 GPG 密钥...
echo 请按照提示输入以下信息：
echo - 密钥类型: 选择默认 (RSA and RSA)
echo - 密钥大小: 选择 4096
echo - 有效期: 选择 0 (永不过期)
echo - 用户信息: 输入您的姓名和邮箱
echo - 密码: 设置一个安全的密码
echo.

gpg --gen-key

if %ERRORLEVEL% neq 0 (
    echo GPG 密钥生成失败
    pause
    exit /b 1
)

echo.
echo 4. 显示生成的密钥...
gpg --list-keys

echo.
echo 5. 上传公钥到密钥服务器...
echo 请输入您的密钥 ID (显示在上一行的 pub 行中):
set /p KEY_ID="密钥 ID: "

echo 正在上传到 Ubuntu 密钥服务器...
gpg --keyserver keyserver.ubuntu.com --send-keys %KEY_ID%

if %ERRORLEVEL% neq 0 (
    echo 警告: 密钥上传可能失败，请稍后手动上传
    echo 手动上传命令: gpg --keyserver keyserver.ubuntu.com --send-keys %KEY_ID%
) else (
    echo 密钥上传成功
)

echo.
echo ========================================
echo GPG 密钥设置完成
echo ========================================
echo.
echo 请记录以下信息用于发布：
echo 密钥 ID: %KEY_ID%
echo 密码: (您刚才设置的密码)
echo.
echo 发布时请设置环境变量：
echo set GPG_KEY_ID=%KEY_ID%
echo set GPG_PASSPHRASE=your_password
echo.
pause 