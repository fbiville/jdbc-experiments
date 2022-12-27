# JDBC experiments

## Prerequisites

 - [Maven](https://maven.apache.org/download.cgi)
 - [JDK 17](https://www.azul.com/downloads/?version=java-17-lts&package=jdk)
 - [Docker](https://docs.docker.com/get-docker/)

## JDBC Bolt 5.x with Neo4j 5

```shell
mvn --quiet --also-make --projects neo4j-5 compile exec:java
```

If you see anything other than 42, then something is wrong.
Please [open an issue](https://github.com/fbiville/jdbc-experiments/issues/new).

## JDBC Bolt 4.x with Neo4j 4.4

```shell
mvn --quiet --also-make --projects neo4j-44 compile exec:java
```

If you see anything other than 42, then something is wrong.
Please [open an issue](https://github.com/fbiville/jdbc-experiments/issues/new).
