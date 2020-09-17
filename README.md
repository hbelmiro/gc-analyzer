# gc-analyzer

This project is a tool to analyze Java Garbage Collection logs.

It uses Quarkus, the Supersonic Subatomic Java Framework.

If you want to learn more about Quarkus, please visit its website: https://quarkus.io/ .

## Features

There is only one for now. New features will be added in the future. PRs with new ones would be great too. 
* List top N Pause Full durations found in the log

## Running the application in dev mode

You can run your application in dev mode that enables live coding using:
```
./mvnw quarkus:dev "\"-Dquarkus.args=--file=/directory/my_gc.log -n=5\""
```

For the sample log in src/main/resources/examples/gc-logs/my_gc.log, an output similar to the following will be printed:

````
[INFO] Scanning for projects...
[INFO]
[INFO] ----------------------< com.hbelmiro:gc-analyzer >----------------------
[INFO] Building gc-analyzer 1.0.0-SNAPSHOT
[INFO] --------------------------------[ jar ]---------------------------------
[INFO]
[INFO] --- maven-resources-plugin:2.6:resources (default-resources) @ gc-analyzer ---
[INFO] Using 'UTF-8' encoding to copy filtered resources.
[INFO] Copying 2 resources
[INFO]
[INFO] --- maven-compiler-plugin:3.8.1:compile (default-compile) @ gc-analyzer ---
[INFO] Nothing to compile - all classes are up to date
[INFO]
[INFO] --- quarkus-maven-plugin:1.6.1.Final:dev (default-cli) @ gc-analyzer ---
OpenJDK 64-Bit Server VM warning: Options -Xverify:none and -noverify were deprecated in JDK 13 and will likely be removed in a future release.
Listening for transport dt_socket at address: 5005
__  ____  __  _____   ___  __ ____  ______
 --/ __ \/ / / / _ | / _ \/ //_/ / / / __/
 -/ /_/ / /_/ / __ |/ , _/ ,< / /_/ /\ \
--\___\_\____/_/ |_/_/|_/_/|_|\____/___/
2020-08-10 18:43:35,304 INFO  [io.quarkus] (Quarkus Main Thread) gc-analyzer 1.0.0-SNAPSHOT on JVM (powered by Quarkus 1.6.1.Final) started in 0.733s.
2020-08-10 18:43:35,321 INFO  [io.quarkus] (Quarkus Main Thread) Profile dev activated. Live Coding activated.
2020-08-10 18:43:35,321 INFO  [io.quarkus] (Quarkus Main Thread) Installed features: [cdi, picocli]
PauseFullDuration{dateTime=2020-08-06T00:34:41.620-03:00, duration=392ms}
PauseFullDuration{dateTime=2020-08-05T17:47:01.736-03:00, duration=327ms}
PauseFullDuration{dateTime=2020-08-05T16:02:29.174-03:00, duration=199ms}
PauseFullDuration{dateTime=2020-08-05T16:50:17.598-03:00, duration=194ms}
PauseFullDuration{dateTime=2020-08-06T07:35:12.706-03:00, duration=191ms}
2020-08-10 18:43:35,419 INFO  [io.quarkus] (Quarkus Main Thread) gc-analyzer stopped in 0.020s
Quarkus application exited with code 0
Press Enter to restart or Ctrl + C to quit
````

What matters about the GC analysis in the output above is the followins lines:

````
PauseFullDuration{dateTime=2020-08-06T00:34:41.620-03:00, duration=392ms}
PauseFullDuration{dateTime=2020-08-05T17:47:01.736-03:00, duration=327ms}
PauseFullDuration{dateTime=2020-08-05T16:02:29.174-03:00, duration=199ms}
PauseFullDuration{dateTime=2020-08-05T16:50:17.598-03:00, duration=194ms}
PauseFullDuration{dateTime=2020-08-06T07:35:12.706-03:00, duration=191ms}
````

That was the top 5 Full Pause durations found in the log.

## Packaging and running the application

The application can be packaged using `./mvnw package`.
It produces the `gc-analyzer-1.0.0-SNAPSHOT-runner.jar` file in the `/target` directory.
Be aware that it’s not an _über-jar_ as the dependencies are copied into the `target/lib` directory.

The application is now runnable using `java -jar target/gc-analyzer-1.0.0-SNAPSHOT-runner.jar`.

## Creating a native executable

You can create a native executable using: `./mvnw package -Pnative`.

Or, if you don't have GraalVM installed, you can run the native executable build in a container using: `./mvnw package -Pnative -Dquarkus.native.container-build=true`.

You can then execute your native executable with: `./target/gc-analyzer-1.0.0-SNAPSHOT-runner`

If you want to learn more about building native executables, please consult https://quarkus.io/guides/building-native-image.