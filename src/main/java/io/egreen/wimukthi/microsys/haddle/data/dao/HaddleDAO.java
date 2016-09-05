package io.egreen.wimukthi.microsys.haddle.data.dao;

import com.mongodb.WriteResult;
import io.egreen.apistudio.datalayer.mongodb.dao.DAOController;
import io.egreen.wimukthi.microsys.account.data.dto.AccountModel;
import io.egreen.wimukthi.microsys.application.data.dto.ApplicationModel;
import io.egreen.wimukthi.microsys.haddle.data.dto.HaddleModel;

import java.util.List;

/**
 * Created by Pramode Wimukthi on 9/1/2016.
 */
public interface HaddleDAO extends DAOController<HaddleModel> {

    WriteResult deleteHaddleDetail(String accId, String appId);

    List<HaddleModel> allHadelDetail();

    List<HaddleModel> getAccountIdByapp(String appId);
}
