# TopStack SDK Java 发布到 Maven Central 指南

## 一、前置条件

1. **Sonatype Central Portal 账号**
   - 注册：https://central.sonatype.com/
   - 申请 GroupId 权限（如 com.iotopo.topstack）
   - 进入 "Account" 页面，点击 "Generate User Token" 获取 token 用户名和密码

2. **GPG 密钥**
   - 安装 GPG（Windows 推荐 [Gpg4win](https://www.gpg4win.org/)）
   - 生成密钥：`gpg --gen-key`
   - 查看密钥ID：`gpg --list-keys`
   - 上传公钥：`gpg --keyserver keyserver.ubuntu.com --send-keys YOUR_KEY_ID`

   参考：https://central.sonatype.org/publish/requirements/gpg/

3. **Maven 环境**
   - 推荐 Maven 3.6 及以上

## 二、环境变量设置

发布前请设置以下环境变量（推荐写入 shell/cmd 脚本或 CI 环境变量）：

```bash
# Windows (cmd)
set SONATYPE_USERNAME=your_token_username
set SONATYPE_PASSWORD=your_token_password
set GPG_KEY_ID=your_gpg_key_id
set GPG_PASSPHRASE=your_gpg_passphrase

# Linux/macOS (bash)
export SONATYPE_USERNAME=your_token_username
export SONATYPE_PASSWORD=your_token_password
export GPG_KEY_ID=your_gpg_key_id
export GPG_PASSPHRASE=your_gpg_passphrase
```

## 三、发布步骤

### 1. 生成并上传 GPG 密钥（如未完成）
```bash
gpg --gen-key
gpg --list-keys
gpg --keyserver keyserver.ubuntu.com --send-keys YOUR_KEY_ID
```

### 2. 构建与发布

- **Windows**
  ```cmd
  deploy.bat
  ```
- **Linux/macOS**
  ```bash
  ./deploy.sh
  ```

脚本会自动检查所有环境变量，缺失时会提示输入。

### 3. 发布后操作

1. 登录 https://central.sonatype.com/
2. 进入 "My Staging Repositories"
3. 找到你的 staging repository
4. 点击 "Close" 按钮
5. 等待校验通过后点击 "Release" 按钮

## 四、常见问题与排查

### 1. 缺少签名（Missing signature）
- 检查 GPG 密钥是否生成、上传、环境变量是否正确
- 检查 `settings.xml` 和 `pom.xml` 是否包含 gpg 配置

### 2. 认证失败（401/403）
- 确认使用的是 Central Portal 的 User Token 账号密码
- 不要用 OSSRH 旧账号

### 3. 版本冲突（409）
- Maven Central 不允许覆盖已发布版本，需升级 `<version>`

### 4. CI/CD 自动化
- 推荐所有敏感信息用环境变量注入
- 可直接调用 `deploy.sh` 或 `deploy.bat`

## 五、相关脚本说明

- `setup-gpg.bat`：一键生成并上传 GPG 密钥（Windows）
- `deploy.bat`：Windows 一键发布脚本
- `deploy.sh`：Linux/macOS 一键发布脚本
- `check-config.bat`：环境与配置检查脚本
- `deploy-test.bat`：详细调试发布脚本

## 六、参考资料
- [Sonatype Central Portal 官方文档](https://central.sonatype.org/publish/publish-portal-maven/)
- [GPG 签名要求](https://central.sonatype.org/publish/requirements/gpg/)
- [Maven GPG Plugin 官方文档](https://maven.apache.org/plugins/maven-gpg-plugin/)

---
如有疑问，建议先运行 `check-config.bat` 或查阅上述官方文档。 