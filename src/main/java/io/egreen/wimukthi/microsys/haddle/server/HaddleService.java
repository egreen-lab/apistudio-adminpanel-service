package io.egreen.wimukthi.microsys.haddle.server;

import com.mongodb.WriteResult;
import io.egreen.wimukthi.microsys.account.data.dao.AccountDAO;
import io.egreen.wimukthi.microsys.account.data.dto.AccountModel;
import io.egreen.wimukthi.microsys.haddle.data.dao.HaddleDAO;
import io.egreen.wimukthi.microsys.haddle.data.dto.HaddleModel;

import javax.inject.Inject;
import java.util.List;

/**
 * Created by Pramode Wimukthi on 9/1/2016.
 */
public class HaddleService {

    @Inject
    private HaddleDAO haddleDAO;
    @Inject
    private AccountDAO accountDAO;


    public boolean newHaddleDetail(String username, String password, HaddleModel haddleModel) {
        List<AccountModel> list = accountDAO.getUserModel(username, password);
        for (AccountModel accountModel : list) {
            String accType = accountModel.getAccType();
            if (accType.equals("admin")) {
                if (haddleModel != null) {
                    haddleDAO.create(haddleModel);
                    return true;
                }
            } else if (accType.equals("customer")) {
                return false;
            }
        }
        return false;
    }

    public WriteResult deleteHaddleDetail(String username, String password, String appId) {
        List<AccountModel> list = accountDAO.getUserModel(username, password);
        for (AccountModel accountModel : list) {
            String accType = accountModel.getAccType();
            if (accType.equals("admin")) {
                return haddleDAO.deleteHaddleDetail(accountModel.getAccId(), appId);
            } else if (accType.equals("customer")) {
                return null;
            }
        }
        return null;
    }

    public List<HaddleModel> allHadelDetail() {
        return haddleDAO.allHadelDetail();
    }
}
