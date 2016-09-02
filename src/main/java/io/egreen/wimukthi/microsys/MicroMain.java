package io.egreen.wimukthi.microsys;

import io.egreen.apistudio.bootstrap.ApiStudio;
import io.egreen.apistudio.bootstrap.config.MSApp;
import io.egreen.apistudio.datalayer.mongodb.MongoModuleInitializer;

import javax.ws.rs.ApplicationPath;

/**
 * Created by Pramode Wimukthi on 9/1/2016.
 */
@ApplicationPath("/")
@MSApp(name = "micro")
public class MicroMain {
    public static void main(String[] args) {
        ApiStudio.boot(MicroMain.class, "localhost", 6060, "/micro", MongoModuleInitializer.class);
    }
}
