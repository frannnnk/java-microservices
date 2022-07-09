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












