package io.egreen.wimukthi.microsys.application.data.dao;

import com.mongodb.WriteResult;
import com.mongodb.client.result.UpdateResult;
import io.egreen.apistudio.datalayer.mongodb.dao.DAOController;
import io.egreen.wimukthi.microsys.account.data.dto.AccountModel;
import io.egreen.wimukthi.microsys.application.data.dto.ApplicationModel;

import java.util.List;

/**
 * Created by Pramode Wimukthi on 9/1/2016.
 */
public interface ApplicationDAO extends DAOController<ApplicationModel> {


    List<ApplicationModel> viewApplicationDetailbyUserType();

    List<ApplicationModel> viewApplicationDetailbyUserType(String accId);

    WriteResult deleteApp(String appId);

    WriteResult deleteApp(String accId, String appId);

    boolean updateApp(String accId, ApplicationModel applicationModel);

    boolean updateApp(ApplicationModel applicationModel);

}
