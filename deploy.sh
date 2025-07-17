#!/bin/bash

echo "========================================"
echo "TopStack SDK Java 发布脚本"
echo "========================================"

# 检查环境变量
if [ -z "$SONATYPE_USERNAME" ]; then
    echo "错误: 未设置 SONATYPE_USERNAME 环境变量"
    read -p "请输入您的 Sonatype Central 用户名: " SONATYPE_USERNAME
    export SONATYPE_USERNAME
fi

if [ -z "$SONATYPE_PASSWORD" ]; then
    echo "错误: 未设置 SONATYPE_PASSWORD 环境变量"
    read -s -p "请输入您的 Sonatype Central 密码: " SONATYPE_PASSWORD
    echo
    export SONATYPE_PASSWORD
fi

if [ -z "$GPG_PASSPHRASE" ]; then
    echo "错误: 未设置 GPG_PASSPHRASE 环境变量"
    read -s -p "请输入您的 GPG 密钥密码: " GPG_PASSPHRASE
    echo
    export GPG_PASSPHRASE
fi

if [ -z "$GPG_KEY_ID" ]; then
    echo "错误: 未设置 GPG_KEY_ID 环境变量"
    read -p "请输入您的 GPG 密钥 ID (可通过 'gpg --list-keys' 查看): " GPG_KEY_ID
    export GPG_KEY_ID
fi

echo "环境变量检查通过"
echo "SONATYPE_USERNAME: $SONATYPE_USERNAME"
echo "SONATYPE_PASSWORD: (已隐藏)"
echo "GPG_KEY_ID: $GPG_KEY_ID"
echo "GPG_PASSPHRASE: (已隐藏)"
echo

echo "清理并构建项目..."
mvn clean package -DskipTests

if [ $? -ne 0 ]; then
    echo "构建失败"
    exit 1
fi

echo
echo "发布到 Sonatype Central Portal..."
mvn clean deploy -s settings.xml -DskipTests

if [ $? -ne 0 ]; then
    echo "发布失败"
    exit 1
fi

echo
echo "========================================"
echo "发布成功！"
echo "========================================"
echo
echo "下一步："
echo "1. 登录 https://central.sonatype.com/"
echo "2. 进入 \"My Staging Repositories\""
echo "3. 找到你的 staging repository"
echo "4. 点击 \"Close\" 按钮"
echo "5. 点击 \"Release\" 按钮"
echo
echo "注意：Central Portal 需要 GPG 签名，请确保已正确配置 GPG 密钥"
echo 