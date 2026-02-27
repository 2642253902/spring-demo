# Spring 核心机制演示项目

基础的Spring核心机制IoC和AOP演示项目

## 📋 项目简介

本项目是一个Spring框架的基础学习项目，主要演示了Spring的两大核心机制：
- **IoC（控制反转）**：通过依赖注入实现对象的创建和管理
- **AOP（面向切面编程）**：通过切面实现横切关注点的模块化

本项目提供了多种Spring配置方式的示例，包括XML配置、注解配置和Java配置类。

## 🎯 学习资源

> 出处：[Spring核心机制详解视频教程](https://www.bilibili.com/video/BV1w3411s7ur/?spm_id_from=333.337.search-card.all.click&vd_source=5ddade9eefcdf707199779be0224af48)

## 🛠️ 技术栈

- **Java**: 17
- **Spring Framework**: 6.2.7
  - spring-context
  - spring-aspects
- **Lombok**: 1.18.38
- **Maven**: 项目构建工具

## 📁 项目结构

```
spring-demo/
├── src/main/java/com/pan/
│   ├── aop/                        # AOP 示例
│   │   ├── Cal.java                # 计算器接口
│   │   ├── CalImpl.java            # 计算器实现类
│   │   ├── LoggerAspect.java       # 日志切面
│   │   └── Test.java               # AOP 测试类
│   │
│   ├── configuration/              # Java配置类示例
│   │   └── BeanConfiguration.java  # Bean配置类
│   │
│   └── ioc/                        # IoC 示例
│       ├── DataConfig.java         # 数据库配置类
│       ├── GlobalConfig.java       # 全局配置类
│       ├── User.java               # 用户实体类
│       └── Test.java               # IoC 测试类
│
└── src/main/resources/
    └── spring.xml                  # Spring XML配置文件
```

## 🚀 核心功能详解

### 1. AOP（面向切面编程）示例

#### 📌 切面功能
在 `LoggerAspect` 类中实现了日志切面，可以在目标方法执行前后自动记录日志：

- **前置通知 (@Before)**: 方法执行前记录方法名和参数
- **返回通知 (@AfterReturning)**: 方法正常返回后记录方法名和返回值

#### 📌 目标类
`CalImpl` 类实现了基本的计算器功能：
- `add(int a, int b)` - 加法运算
- `sub(int a, int b)` - 减法运算
- `mul(int a, int b)` - 乘法运算
- `div(int a, int b)` - 除法运算

#### 📌 关键配置
```xml
<!-- spring.xml -->
<!-- 自动扫描组件 -->
<context:component-scan base-package="com.pan.aop"/>

<!-- 启用AspectJ自动代理 -->
<aop:aspectj-autoproxy/>
```

#### 📌 运行示例
运行 `com.pan.aop.Test` 类：
```java
ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
Cal bean = context.getBean(Cal.class);
System.out.println(bean.add(1, 3));  // 输出: 4
```

**控制台输出**:
```
add方法的参数是[1, 3]
add方法的结果是4
4
```

### 2. IoC（控制反转）示例

#### 📌 依赖注入方式

**1. @Value 注解注入** (`DataConfig.java`):
```java
@Component("config")
public class DataConfig {
    @Value("localhost:3306/dbname")
    private String url;
    @Value("Driver")
    private String driverName;
    // ...
}
```

**2. @Autowired 自动装配** (`GlobalConfig.java`):
```java
@Component
public class GlobalConfig {
    @Value("8080")
    private String port;
    
    @Autowired
    @Qualifier("config")
    private DataConfig dataConfig;  // 自动注入DataConfig
}
```

**3. @Configuration + @Bean** (`BeanConfiguration.java`):
```java
@Configuration
public class BeanConfiguration {
    @Bean(name = "config")
    public DataConfig dataConfig() {
        DataConfig dataConfig = new DataConfig();
        dataConfig.setDriverName("Driver");
        // 手动配置属性
        return dataConfig;
    }
}
```

## 🎓 配置方式对比

### 1. XML 配置方式
```xml
<!-- spring.xml -->
<context:component-scan base-package="com.pan.aop"/>
```
```java
ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
```

### 2. 注解配置方式
```java
@Component
@Autowired
@Value
```
```java
ApplicationContext context = new AnnotationConfigApplicationContext("com.pan.ioc");
```

### 3. Java 配置类方式
```java
@Configuration
@Bean
```
```java
ApplicationContext context = new AnnotationConfigApplicationContext("com.pan.configuration");
```

## 🏃 运行项目

### 前置要求
- JDK 17 或更高版本
- Maven 3.6+

### 运行步骤

1. **克隆或下载项目**
```bash
git clone <repository-url>
cd spring-demo
```

2. **使用Maven编译项目**
```bash
mvn clean compile
```

3. **运行AOP示例**
```bash
# 运行 com.pan.aop.Test
mvn exec:java -Dexec.mainClass="com.pan.aop.Test"
```

4. **运行IoC示例**
```bash
# 运行 com.pan.ioc.Test
mvn exec:java -Dexec.mainClass="com.pan.ioc.Test"
```

### IDE 运行
- 直接在 IDE（如 IntelliJ IDEA 或 Eclipse）中运行：
  - `com.pan.aop.Test` - 查看AOP效果
  - `com.pan.ioc.Test` - 查看IoC效果

## 📝 核心知识点

### AOP 核心概念
- **切面（Aspect）**: 使用 `@Aspect` 注解标识
- **切点（Pointcut）**: 使用 `execution` 表达式定义
- **通知（Advice）**: `@Before`、`@AfterReturning` 等
- **连接点（JoinPoint）**: 获取方法信息和参数

### IoC 核心概念
- **Bean**: Spring容器管理的对象
- **依赖注入**: 通过 `@Autowired`、`@Value` 等注解实现
- **组件扫描**: 使用 `@Component`、`@Configuration` 等注解
- **Bean作用域**: 默认为单例（Singleton）

## 🔍 扩展学习

可以在此项目基础上尝试：

1. **AOP扩展**
   - 添加异常通知 `@AfterThrowing`
   - 添加环绕通知 `@Around`
   - 尝试不同的切点表达式

2. **IoC扩展**
   - 实现不同的Bean作用域（prototype、request等）
   - 使用 `@PostConstruct` 和 `@PreDestroy`
   - 配置多个数据源

3. **整合其他技术**
   - 整合Spring JDBC
   - 整合MyBatis
   - 添加单元测试（JUnit + Spring Test）
