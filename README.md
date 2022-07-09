# Java Microservice Demo


## Docker

### Buidling docker

```Bash
docker build . -t frannnnk/accounts
docker build . -t frannnnk/loans
docker build . -t frannnnk/cards
```

### Check Docker Images

```Bash
docker images
```

### Inspect Docker Images

```Bash
docker image inspect <image_id>
```


### Run Docker Container using Image

```Bash
docker run -p 8080:8080 <image_id>
```

### Other useful commands

```Bash
docker logs <container_id>
docker logs -f <container_id>
docker container pause <container_id>
docker container unpause <container_id>
docker stop <container_id>              --> gracefully  
docker kill <container_id>              --> immediately
docker stats                            --> show statistics
docker run -d -p 8080:8080 <image_id>   --> run in detached mode
```

### Push images to dockerhub

```Bash
docker push docker.io/frannnnk/accounts
docker push docker.io/frannnnk/cards
docker push docker.io/frannnnk/loans
```


## Buildpacks

>A buildpack is a program that turns source code into a runnable container image. Usually, buildpacks encapsulate a single language ecosystem toolchain. There are buildpacks for Ruby, Go, NodeJs, Java, Python, and more. These buildpacks can be grouped together into collections called a builder.

Ref: https://technology.doximity.com/articles/buildpacks-vs-dockerfiles

### Add configuration in pom file

```xml
<build>
    <plugins>
        <plugin>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-maven-plugin</artifactId>
            <configuration>
                <image>
                    <name>frank/${project.artifactId}</name>
                </image>
            </configuration>
        </plugin>
    </plugins>
</build>
```

Generate docker image using buildpack 
```bash
mvn spring-boot:build-image
```


## Config Server

Spring Cloud Config is Spring's client/server approach for storing and serving distributed configurations across multiple applications and environments.


Add `dependencyManagement` in pom

```xml
<dependencyManagement>
		<dependencies>
			<dependency>
				<groupId>org.springframework.cloud</groupId>
				<artifactId>spring-cloud-dependencies</artifactId>
				<version>${spring-cloud.version}</version>
				<type>pom</type>
				<scope>import</scope>
			</dependency>
		</dependencies>
	</dependencyManagement>
```

Add `@EnableConfigServer` in Application Class

```Java
@SpringBootApplication
@EnableConfigServer
public class ConfigserverApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConfigserverApplication.class, args);
	}

}
```

Add config in the application.properties

```
spring.application.name=configserver
spring.profiles.active=native
spring.cloud.config.server.native.search-locations=classpath:/config

server.port=8071
```

Then, you can access the config server via http://localhost:8071/accounts/default 


### Config Local Locations

`spring.cloud.config.server.native.search-locations` can be set to:
- file:///C://config
- classpath:/config

### Config Git Locations



















