FROM openjdk:11.0.15-jre-slim

# Create a workspace folder
WORKDIR /usr/share/udemy

# Add all .jar under targe from host
# into this image
ADD target/selenium-docker.jar            selenium-docker.jar
ADD target/selenium-docker-tests.jar      selenium-docker-tests.jar
ADD target/libs                           libs

# Add suite files
ADD book-flight-module.xml                book-flight-module.xml
ADD search-module.xml                     search-module.xml


ENTRYPOINT java -cp selenium-docker.jar:selenium-docker-tests.jar:libs/* -DBROWSER=$BROWSER -DHUB_HOST=$HUB_HOST -DPORT=$PORT org.testng.TestNG $MODULE


