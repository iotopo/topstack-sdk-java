@echo off
echo ========================================
echo TopStack SDK Java 测试构建脚本
echo ========================================

echo 清理项目...
call mvn clean

if %ERRORLEVEL% neq 0 (
    echo 清理失败
    pause
    exit /b 1
)

echo.
echo 编译项目...
call mvn compile -DskipTests

if %ERRORLEVEL% neq 0 (
    echo 编译失败
    pause
    exit /b 1
)

echo.
echo 运行测试...
call mvn test

if %ERRORLEVEL% neq 0 (
    echo 测试失败
    pause
    exit /b 1
)

echo.
echo 打包项目...
call mvn package -DskipTests

if %ERRORLEVEL% neq 0 (
    echo 打包失败
    pause
    exit /b 1
)

echo.
echo ========================================
echo 测试构建成功！
echo ========================================
echo.
echo 生成的文件：
echo - target/topstack-sdk-1.0.0.jar
echo - target/topstack-sdk-1.0.0-sources.jar
echo - target/topstack-sdk-1.0.0-javadoc.jar
echo.
pause 