package io.egreen.wimukthi.microsys.application.api;

import com.mongodb.WriteResult;
import com.mongodb.client.result.UpdateResult;
import io.egreen.wimukthi.microsys.application.data.dto.ApplicationModel;
import io.egreen.wimukthi.microsys.application.server.AppicatiinServer;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Authorization;

import javax.inject.Inject;
import javax.ws.rs.*;
import java.util.List;

/**
 * Created by Pramode Wimukthi on 9/1/2016.
 */
@Path("/application")
@Api(value = "application", authorizations = {
        @Authorization(value = "application", scopes = {})
})
@Produces("application/json")
@Consumes("application/json")
public class ApplicationControllerApi {

    @Inject
    private AppicatiinServer appicatiinServer;

    @POST
    @Path("/saveapp")
    @ApiOperation(
            value = "add new Application",
            notes = "Add new Application for the Customers & Users ..."
    )
    public boolean newApplication(ApplicationModel applicationModel) {
        return appicatiinServer.newApplication(applicationModel);
    }

    @GET
    @Path("/viewapp")
    @ApiOperation(
            value = "view Application Detail",
            notes = "View Application detail,... If You are a Admin you can view all Applications ... but your a customer You can view only your own applications"
    )
    public Object viewApplicationDetailbyUserType(@QueryParam("username") String username, @QueryParam("password") String password) {
        return appicatiinServer.viewApplicationDetailbyUserType(username, password);
    }

    @DELETE
    @Path("/deleteapp")
    @ApiOperation(
            value = "delete Application Detail",
            notes = "Delete Application detail,... If You are a Admin you can # Delete # all Applications" +
                    " ... but your a customer You can # Delete # only your own applications"
    )
    public WriteResult deleteApp(@QueryParam("username") String username, @QueryParam("password") String password, @QueryParam("appId") String appId) {
        return appicatiinServer.deleteApp(username, password, appId);
    }

    @POST
    @Path("/updateapp")
    @ApiOperation(
            value = "update Application Detail",
            notes = "update Application detail,... If You are a Admin you can # update # all Applications" +
                    " ... but your a customer You can # update # only your own applications {Not Working}"
    )
    public boolean updateApp(@QueryParam("username") String username, @QueryParam("password") String password, ApplicationModel applicationModel) {
        return appicatiinServer.updateApplication(username, password, applicationModel);
    }

}
