# DN_CMS
DN_CMS网站后台管理系统

部署说明：
        1.已测试部署环境：
                Jdk_7，MySql_5.5；Jetty_9/Tomcat_8；linux（centos）。
        2.数据源在mysql55.properties中修改。
                数据库默认：
                user/pwd：root/root
                database：dn_cms_db
        3.默认端口号为8989；若需要请到springmvc-servlet.xml中将freemarker的全局变量webRoot更改"http://127.0.0.1:8080/"，避免出现图片等静态资源路径失效。
        4.app登录名/密码：dn_cms_db/dn_cms_db。 

项目概述： 
1.使用到的技术（框架）： 
        后台：spring3(基于注解的IOC)，springMVC，freemarker模板，mybatis3/jdbc 
        前台：jquery，dwz富客户端框架 
        构建工具：maven 
        其他：log4j2(log4jdbc)，junit4，kapcha验证码，c3p0 
2.登陆(验证)模块：登入退出、验证码刷新；登录验证。 
        登陆检查是自写的Interceptor，实现自springMVC；验证码使用了kaptcha框架。拦截器和验证码的业务逻辑均为对HttpSession的存取和判断。 
3.内容管理模块：分页（排序），删除（多选），添加，修改。 
        请求数据绑定是springMVC的注解自动绑定方式；返回数据和页面的渲染采用的是freemarker模板。前端是在dwz框架下jquery开发的，分页是根据dwz参数构造了对应的BO类。事务管理是spring-tx。业务逻辑层与dao层解耦；dao的实现是mybatis。
4.通用模块： 
        日志由log4j2和log4jdbc管理，输出标准sql语句、异常等到控制台和文件，日志级别可动态更改。异常记录后抛出到控制器由springmvc统一处理返回错误页面。项目的构建使用maven，发布、部署使用jetty-maven-plugin，结合eclipse的m2e插件。单元测试使用了junit4和maven的junit插件。项目总体分层解耦，方便dao层换实现、扩展模块。

