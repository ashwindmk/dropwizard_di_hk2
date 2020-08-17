package com.ashwin.java.resource;

import com.ashwin.java.DiHk2Application;
import com.ashwin.java.domain.service.UserService;
import com.codahale.metrics.annotation.Timed;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Optional;

@Path("/user")
public class UserResource {
    private static final String TAG = UserResource.class.getName();
    private Log LOG = LogFactory.getLog(DiHk2Application.LOGGER);

    private UserService userService;

    @Inject
    public UserResource(UserService service) {
        this.userService = service;
    }

    @GET
    @Timed
    @Path("/greet")
    @Produces(MediaType.APPLICATION_JSON)
    public Response greet(@QueryParam("id") Optional<Long> id) {
        Response response = null;
        try {
            long uid = id.orElse(-1L);
            String msg = this.userService.greet(uid);
            LOG.debug(TAG + " | greet (" + uid + ") | " + msg);
            response = Response.ok(msg).build();
        } catch (Exception e) {
            response = Response.serverError().build();
        }
        return response;
    }
}
