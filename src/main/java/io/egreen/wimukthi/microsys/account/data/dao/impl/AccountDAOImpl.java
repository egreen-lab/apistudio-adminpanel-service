package io.egreen.wimukthi.microsys.account.data.dao.impl;

import com.mongodb.WriteResult;
import io.egreen.apistudio.datalayer.mongodb.dao.impl.AbstractDAOController;
import io.egreen.wimukthi.microsys.account.data.dao.AccountDAO;
import io.egreen.wimukthi.microsys.account.data.dto.AccountModel;
import org.mongodb.morphia.query.Query;
import org.mongodb.morphia.query.UpdateOperations;

import java.util.List;

/**
 * Created by Pramode Wimukthi on 9/1/2016.
 */
public class AccountDAOImpl extends AbstractDAOController<AccountModel> implements AccountDAO {

    public AccountDAOImpl() {
        super(AccountModel.class);
    }

    @Override
    public List<AccountModel> getUserModel(String username, String password) {
        Query<AccountModel> query = getQuery();
        query.filter("username", username);
        query.filter("password", password);
        return query.asList();
    }

    @Override
    public List<AccountModel> searchAccounyById(String accId) {
        Query<AccountModel> query = getQuery();
        query.filter("accId", accId);
        return query.asList();
    }

    @Override
    public List<AccountModel> viewAccount() {
        Query<AccountModel> query = getQuery();
        return query.asList();
    }

    @Override
    public List<AccountModel> viewAccount(String accId) {
        Query<AccountModel> query = getQuery();
        query.filter("accId", accId);
        return query.asList();
    }

    @Override
    public WriteResult deleteAcc(String accId) {
        Query<AccountModel> query = getQuery();
        query.filter("accId", accId);
        return getDatastore().delete(query);
    }

    @Override
    public WriteResult deleteAccCust(String accId) {
        Query<AccountModel> query = getQuery();
        query.filter("accId", accId);
        return getDatastore().delete(query);
    }

    @Override
    public boolean updateAcc(AccountModel accountModel, String username, String password) {
        Query<AccountModel> query = getQuery();
        query.filter("accId", accountModel.getAccId());
        query.filter("username", username);
        query.filter("password", password);
        UpdateOperations<AccountModel> updateOperations = getDatastore().createUpdateOperations(AccountModel.class);
        updateOperations.set("accName", accountModel.getAccName());
        updateOperations.set("accNic", accountModel.getAccNic());
        updateOperations.set("accPhone", accountModel.getAccPhone());
        updateOperations.set("username", accountModel.getUsername());
        updateOperations.set("password", accountModel.getPassword());
        updateOperations.set("accType", accountModel.getAccType());
        getDatastore().update(query, updateOperations);
        return true;
    }

    @Override
    public List<AccountModel> getAppUsers(String accId) {
        Query<AccountModel> query = getQuery();
        query.filter("accId",accId);
        return query.asList();
    }


}
