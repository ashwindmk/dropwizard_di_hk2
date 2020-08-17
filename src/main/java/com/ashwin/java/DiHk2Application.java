package com.ashwin.java;

import com.ashwin.java.di.DiHk2Module;
import com.ashwin.java.resource.UserResource;
import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class DiHk2Application extends Application<DiHk2Configuration> {
    public static final String LOGGER = "hk2-logger";
    private static final String TAG = DiHk2Application.class.getName();
    private static Log LOG = LogFactory.getLog(LOGGER);

    public static void main(String[] args) throws Exception {
        new DiHk2Application().run(args);
    }

    @Override
    public void initialize(Bootstrap<DiHk2Configuration> bootstrap) {
        super.initialize(bootstrap);
        LOG.info(TAG + ": initialize");
    }

    @Override
    public void run(DiHk2Configuration config, Environment env) throws Exception {
        env.jersey().getResourceConfig().register(new DiHk2Module(config));
        env.jersey().register(UserResource.class);
    }
}
