package io.egreen.wimukthi.microsys.haddle.api;

import com.mongodb.WriteResult;
import io.egreen.wimukthi.microsys.account.data.dto.AccountModel;
import io.egreen.wimukthi.microsys.haddle.data.dto.HaddleModel;
import io.egreen.wimukthi.microsys.haddle.server.HaddleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Authorization;

import javax.inject.Inject;
import javax.ws.rs.*;
import java.util.List;

/**
 * Created by Pramode Wimukthi on 9/1/2016.
 */
@Path("/haddle")
@Api(value = "haddle", authorizations = {
        @Authorization(value = "haddle", scopes = {})
})
@Produces("application/json")
@Consumes("application/json")
public class HaddleControllerApi {

    @Inject
    private HaddleService haddleService;


    @POST
    @Path("/save")
    @ApiOperation(
            value = "add new haddle Detail",
            notes = "Add new haddle Detail for only Admins .."
    )
    public boolean newHaddleDetail(@QueryParam("username") String username, @QueryParam("password") String password, HaddleModel haddleModel) {
        return haddleService.newHaddleDetail(username, password, haddleModel);
    }

    @DELETE
    @Path("/delete")
    @ApiOperation(
            value = "delete haddle Detail",
            notes = "Only can delete haddle Detail for only Admins .."
    )
    public WriteResult deleteHadleDetail(@QueryParam("username") String username, @QueryParam("password") String password, @QueryParam("appId") String appId) {
        return haddleService.deleteHaddleDetail(username, password, appId);
    }

    @GET
    @Path("/viewallhadel")
    @ApiOperation(
            value = "view all HaddleDetails ",
            notes = " View All  Handdle Details "
    )
    public Object viewUserHaddleApp() {
        return haddleService.allHadelDetail();
    }

}
