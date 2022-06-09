package co.develhope.MongoDBORM.config;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoClientConfiguration;

import java.util.Collection;
import java.util.Collections;

@Configuration
//stiamo configurando un client
public class MongoDBconfig extends AbstractMongoClientConfiguration {

    @Override
    protected String getDatabaseName() {
        return "develhope";
    }

    @Override
    protected Collection<String> getMappingBasePackages(){
        return Collections.singleton("co.develhope");
    }

    public MongoClient mongoClient(){
        ConnectionString connectionString = new ConnectionString("mongodb+srv://develhope.tt7ss6u.mongodb.net/?authSource=%24external&authMechanism=MONGODB-X509&retryWrites=true&w=majority");
        MongoClientSettings mongoClientSettings = MongoClientSettings.builder()
                .applyConnectionString(connectionString)
                .build();
        return MongoClients.create(mongoClientSettings);

    }
}
