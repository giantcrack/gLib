package me.giantcrack.glib.db;

import com.mongodb.MongoClient;

public class GMongoClient {

    private MongoClient mongoClient;

    private String host;

    private int port;

    public GMongoClient(String host, int port, String username, String password) {
        this.host = host;
        this.port = port;
        this.mongoClient = new MongoClient(host,port);
    }

    public MongoClient getMongoClient() {
        return mongoClient;
    }

    public String getHost() {
        return host;
    }

    public int getPort() {
        return port;
    }
}
