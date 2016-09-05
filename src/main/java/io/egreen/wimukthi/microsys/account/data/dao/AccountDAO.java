package io.egreen.wimukthi.microsys.account.data.dao;

import com.mongodb.WriteResult;
import io.egreen.apistudio.datalayer.mongodb.dao.DAOController;
import io.egreen.wimukthi.microsys.account.data.dto.AccountModel;

import java.util.List;

/**
 * Created by Pramode Wimukthi on 9/1/2016.
 */
public interface AccountDAO extends DAOController<AccountModel> {

    List<AccountModel> getUserModel(String username, String password);

    List<AccountModel> searchAccounyById(String accId);

    List<AccountModel> viewAccount();

    List<AccountModel> viewAccount(String accId);

    WriteResult deleteAcc(String accId);


    WriteResult deleteAccCust(String accId);

    boolean updateAcc(AccountModel accountModel,String username, String password);


    List<AccountModel> getAppUsers(String accId);
}
