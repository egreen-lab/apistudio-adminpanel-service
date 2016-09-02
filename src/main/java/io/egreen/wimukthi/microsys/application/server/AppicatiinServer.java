package io.egreen.wimukthi.microsys.application.server;

import com.mongodb.WriteResult;
import com.mongodb.client.result.UpdateResult;
import io.egreen.wimukthi.microsys.account.data.dao.AccountDAO;
import io.egreen.wimukthi.microsys.account.data.dto.AccountModel;
import io.egreen.wimukthi.microsys.application.data.dao.ApplicationDAO;
import io.egreen.wimukthi.microsys.application.data.dto.ApplicationModel;

import javax.inject.Inject;
import java.util.List;

/**
 * Created by Pramode Wimukthi on 9/1/2016.
 */
public class AppicatiinServer {

    @Inject
    private ApplicationDAO applicationDAO;
    @Inject
    private AccountDAO accountDAO;

    public boolean newApplication(ApplicationModel applicationModel) {
        List<AccountModel> list = accountDAO.searchAccounyById(applicationModel.getAccId());
        if (list.size() > 0) {
            applicationDAO.create(applicationModel);
            return true;
        }
        return false;
    }


    public List<ApplicationModel> viewApplicationDetailbyUserType(String username, String password) {
        List<AccountModel> list = accountDAO.getUserModel(username, password);
        for (AccountModel accountModel : list) {
            String accType = accountModel.getAccType();
            if (accType.equals("admin")) {
                return applicationDAO.viewApplicationDetailbyUserType();
            } else if (accType.equals("customer")) {
                return applicationDAO.viewApplicationDetailbyUserType(accountModel.getAccId());
            }
        }
        return null;
    }

    public WriteResult deleteApp(String username, String password, String appId) {
        List<AccountModel> list = accountDAO.getUserModel(username, password);
        for (AccountModel accountModel : list) {
            String accType = accountModel.getAccType();
            if (accType.equals("admin")) {
                return applicationDAO.deleteApp(appId);
            } else if (accType.equals("customer")) {
                return applicationDAO.deleteApp(accountModel.getAccId(), appId);
            }
        }
        return null;
    }


    public boolean updateApplication(String username, String password, ApplicationModel applicationModel) {
        List<AccountModel> list = accountDAO.getUserModel(username, password);
        for (AccountModel accountModel : list) {
            String accType = accountModel.getAccType();
            if (accType.equals("admin")) {
                if (accountModel != null) {
                    return applicationDAO.updateApp(applicationModel);
                }
            } else if (accType.equals("customer")) {
                if (accountModel != null) {
                    return applicationDAO.updateApp(accountModel.getAccId(), applicationModel);
                }
            }
        }
        return false;
    }
}
