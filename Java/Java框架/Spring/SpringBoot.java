// Spring Boot 启动流程分析--http://www.cnblogs.com/xinzhao/p/5551828.html
1.Spring Boot 启动方式:
	(1).直接运行 main 方法
	(2).使用命令:mvn spring-boot:run
	(3).编译工程:mvn install, 然后进到target目录, 执行:java -jar  *****.jar --spring.profiles.active=dev
2.Spring Boot 配置
	(1).默认是 application.properties 文件,但是可以使用 application.yml 文件来存储配置
		server:
		  port: 8080
		  #context-path: /girl
		girl:
		  cupSize: B
		  age: 18	
	(2).如果需要 将 girl映射成实体类,只需要按如下配置:
		@Component
		@ConfigurationProperties(prefix = "girl")
		public class GirlProperties{...}
	(3).多环节下配置:可以区分测试环境,开发环境,生产环境等
		新建下面两个yml配置文件
			application-dev.yml
			application-prod.yml
		在application.yml 文件中配置如下配置
			spring:
			  profiles:
			    active: dev   ----> 这里就是对应 application-dev.yml
	(4).如果需要在Java中使用application.yml 中的配置,如:
		cupSize: B
		在Java中只需要如此写:
		@Value("${cupSize}")
	  	private String cupSize;
	(5).属性配置相关注解:
		@Component
		@Value
		@ConfigurationProperties
3.Controller:
	(1).@Controller :处理 http请求,必须配合模板来使用
	(2).@RestController: Spring4 之后新加的注解, 原来返回 json需要@ResponseBody 配合 @Controller
	(3).@RequestMapping:配置url映射
	(4).@PathVariable: 获取url中的数据
	(5).@RequestParam:获取请求参数的值
	(6).@GetMapping:组合注解












