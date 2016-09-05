package io.egreen.wimukthi.microsys.account.server;

import com.mongodb.WriteResult;
import io.egreen.wimukthi.microsys.account.data.dao.AccountDAO;
import io.egreen.wimukthi.microsys.account.data.dto.AccountModel;
import io.egreen.wimukthi.microsys.application.data.dao.ApplicationDAO;
import io.egreen.wimukthi.microsys.application.data.dto.ApplicationModel;
import io.egreen.wimukthi.microsys.haddle.data.dao.HaddleDAO;
import io.egreen.wimukthi.microsys.haddle.data.dto.HaddleModel;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Pramode Wimukthi on 9/1/2016.
 */
public class AccountServer {

    @Inject
    private AccountDAO accountDAO;
    @Inject
    private HaddleDAO haddleDAO;

    public boolean newAccount(AccountModel accountModel) {
        accountDAO.create(accountModel);
        return true;
    }

    public AccountModel userCheck(String username, String password) {
        List<AccountModel> accountList = accountDAO.getUserModel(username, password);
        if (accountList.size() > 0) {
            for (AccountModel accountModel : accountList) {
                return accountModel;
            }
        }
        return null;
    }

    public List<AccountModel> searchAccountById(String accId) {
        return accountDAO.searchAccounyById(accId);
    }

    public List<AccountModel> viewAccount(String username, String password) {
        List<AccountModel> list = accountDAO.getUserModel(username, password);
        for (AccountModel accountModel : list) {
            String accType = accountModel.getAccType();
            if (accType.equals("admin")) {
                return accountDAO.viewAccount();
            } else if (accType.equals("customer")) {
                return accountDAO.viewAccount(accountModel.getAccId());
            }
        }
        return null;
    }

    public WriteResult deleteAcc(String username, String password, String accId) {
        List<AccountModel> list = accountDAO.getUserModel(username, password);
        for (AccountModel accountModel : list) {
            String accType = accountModel.getAccType();
            if (accType.equals("admin")) {
                return accountDAO.deleteAcc(accId);
            } else {
                if (accType.equals("customer")) {
                    if (accountModel.getAccId().equals(accId)) {
                        return accountDAO.deleteAccCust(accountModel.getAccId());
                    }
                }
            }
        }
        return null;
    }

    public boolean updateAcc(AccountModel accountModel, String username, String password) {
        if (accountModel != null) {
            return accountDAO.updateAcc(accountModel, username, password);
        }
        return false;
    }

    public List<Object> getAppUsers(String appId) {
        List<HaddleModel> list = haddleDAO.getAccountIdByapp(appId);
        List<Object> ob = new ArrayList<>();
        for (HaddleModel model : list) {
            ob.add(accountDAO.getAppUsers(model.getAccId()));
        }
        return ob;
    }
}
