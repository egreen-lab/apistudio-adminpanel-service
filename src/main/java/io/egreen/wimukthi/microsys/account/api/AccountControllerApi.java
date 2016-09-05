package io.egreen.wimukthi.microsys.account.api;

import com.mongodb.WriteResult;
import io.egreen.wimukthi.microsys.account.data.dto.AccountModel;
import io.egreen.wimukthi.microsys.account.server.AccountServer;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Authorization;

import javax.annotation.security.RolesAllowed;
import javax.inject.Inject;
import javax.ws.rs.*;
import java.util.List;

/**
 * Created by Pramode Wimukthi on 9/1/2016.
 */
@Path("/account")
@Api(value = "account", authorizations = {
        @Authorization(value = "account", scopes = {})
})
@Produces("application/json")
@Consumes("application/json")
public class AccountControllerApi {

    @Inject
    private AccountServer accountServer;


    @POST
    @Path("/save")
    @ApiOperation(
            value = "save account",
            notes = "Save New Account to the Database ..."
    )
    public boolean newAccount(AccountModel accountModel) {
        return accountServer.newAccount(accountModel);
    }

    @GET
    @Path("/logincheck")
    @ApiOperation(
            value = "check login ...",
            notes = "Check user Name , Password and Check User Type And then Login ..."
    )
    public AccountModel userLogin(@QueryParam("username") String username, @QueryParam("password") String password) {
        AccountModel accountModel = accountServer.userCheck(username, password);
        String accType = accountModel.getAccType();
        if (accType.equals("admin")) {
            System.out.println("Your login as a admin of this # MICRO SYSTEM # .. Thank You ..");
        } else if (accType.equals("customer")) {
            System.out.println("Your login as a Customer of this # MICRO SYSTEM # .. Thank You ..");
        }
        return accountModel;

    }

    @GET
    @Path("/searchbyid")
    @ApiOperation(
            value = "get account from id",
            notes = "Get Sutable Acount using Account Id"
    )
    public Object searchAccountById(@QueryParam("accId")String accId){
       return accountServer.searchAccountById(accId);
    }

    @GET
    @Path("/viewaccount")
    @ApiOperation(
            value = "view account",
            notes = "view Account in it's user Type "
    )
    public Object viewAccount(@QueryParam("username") String username, @QueryParam("password") String password){
        return accountServer.viewAccount(username,password);
    }


    @DELETE
    @Path("/deleteaccount")
    @ApiOperation(
            value = "delete Account Detail",
            notes = "Delete Account detail,... If You are a Admin you can # Delete # all Account" +
                    " ... but your a customer You can # Delete # only your own Account"
    )
    public WriteResult deleteAcc(@QueryParam("username") String username, @QueryParam("password") String password, @QueryParam("accIdId") String accId) {
        return accountServer.deleteAcc(username, password, accId);
    }

    @POST
    @Path("/update")
    @ApiOperation(
            value = "change username,password and Other Detail",
            notes = "change username,password and Other Detail"
    )
    public boolean updateAcc(AccountModel accountModel,@QueryParam("username") String username, @QueryParam("password") String password) {
        return accountServer.updateAcc(accountModel,username,password);
    }

    @GET
    @Path("/getappusers")
    @ApiOperation(
            value = "get App Users : admins",
            notes = "View admins are working with the App"
    )
    public Object getAppUsers(@QueryParam("appId")String appId){
        return accountServer.getAppUsers(appId);
    }



}
