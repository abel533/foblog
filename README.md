# fo-blog

项目 Fork 自 [FireOct](https://git.oschina.net/phn) 的 [fo-blog](https://git.oschina.net/phn/foblog).

响应式开源个人博客（简洁清爽风格）

## 项目改动

经过 abel533(liuzh) 的修改，使得本项目变成一个基于通用Mapper 和 分页插件 PageHelper 的示例项目。

更多 MyBatis 相关内容可以访问：https://mybatis.io

### 基本改动

- MyBatis 升级为 3.4.4
- MyBatis-Spring 升级为 1.3.2
- 增加通用 Mapper 3.4.2
- 增加分页插件 5.0.3
- 将实体类中的基本类型修改为包装类型
- 所有DAO改为基于通用Mapper
- 分页使用PageHelper，去掉项目中的count查询

### 配置改动

applicationContext.xml 中的 `MapperScannerConfigurer` 修改如下：
```xml
<!-- 该方式用来注入dao或者mapper接口 -->
<bean class="tk.mybatis.spring.mapper.MapperScannerConfigurer">
    <property name="basePackage" value="studio.baxia.fo.dao"/>
</bean>
```
`SqlSessionFactoryBean` 增加了分页插件配置，修改如下：
```xml
<!-- mybatis 集成配置 -->
<bean id="sqlSessionFactory" class="org.mybatis.spring.SqlSessionFactoryBean">
    <property name="dataSource" ref="dataSource" />
    <property name="mapperLocations">
        <list>
            <value>classpath*:config/mybatis/**/*SqlMap.xml</value>
        </list>
    </property>
    <property name="plugins">
        <array>
            <bean class="com.github.pagehelper.PageInterceptor">
                <!-- 这里的几个配置主要演示如何使用，如果不理解，一定要去掉下面的配置 -->
                <property name="properties">
                    <value>
                        helperDialect=mysql
                        reasonable=true
                        supportMethodsArguments=true
                        params=count=countSql;pageNum=pageNumber
                    </value>
                </property>
            </bean>
        </array>
    </property>
</bean>
```
特别注意：`params=count=countSql;pageNum=pageNumber`.

### 错误修复

- t_authors 表中 varif_code_deadline 改为 verif_code_deadline

### 其他

Maven 私服改为aliyun:
```xml
<repositories>
    <repository>
        <id>aliyun</id>
        <name>aliyun</name>
        <url>http://maven.aliyun.com/nexus/content/groups/public/</url>
        <layout>default</layout>
    </repository>
</repositories>
```

# 使用手册

注意：

作者管理账户的登录地址为：http://ip:port(/project)/#!/manage/sign

这里需要到JUnit测试类
```
studio.baxia.fo.service.IUserServiceTest
```

中运行`testAddAuthors`测试方法，根据自身情况设置用户名密码，然后运行即可。
这样就可以通过刚刚生成的用户名密码进行登录了。

