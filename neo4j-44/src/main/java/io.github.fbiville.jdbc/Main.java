package io.github.fbiville.jdbc;

import org.testcontainers.containers.GenericContainer;
import org.testcontainers.containers.Neo4jContainer;
import org.testcontainers.containers.output.OutputFrame;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Main {
    @SuppressWarnings("rawtypes")
    public static void main(String[] args) throws Exception {
        try (Neo4jContainer container = new Neo4jContainer<>("neo4j:4.4.16-enterprise")
                .withAdminPassword("supersecret")
                .withEnv("NEO4J_ACCEPT_LICENSE_AGREEMENT", "yes")) {
            container.start();
            try (Connection connection = DriverManager.getConnection("jdbc:neo4j:" + container.getBoltUrl(), "neo4j", container.getAdminPassword());
                 Statement statement = connection.createStatement();
                 ResultSet resultSet = statement.executeQuery("RETURN 42 AS result")) {
                resultSet.next();
                System.out.println(resultSet.getLong("result"));
            }
        }
    }
}
