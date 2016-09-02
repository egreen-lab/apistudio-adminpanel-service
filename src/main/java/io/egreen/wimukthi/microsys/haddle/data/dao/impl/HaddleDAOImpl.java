package io.egreen.wimukthi.microsys.haddle.data.dao.impl;

import com.mongodb.WriteResult;
import io.egreen.apistudio.datalayer.mongodb.dao.impl.AbstractDAOController;
import io.egreen.wimukthi.microsys.account.data.dto.AccountModel;
import io.egreen.wimukthi.microsys.haddle.data.dao.HaddleDAO;
import io.egreen.wimukthi.microsys.haddle.data.dto.HaddleModel;
import org.mongodb.morphia.query.Query;

import java.util.List;

/**
 * Created by Pramode Wimukthi on 9/1/2016.
 */
public class HaddleDAOImpl extends AbstractDAOController<HaddleModel> implements HaddleDAO {

    public HaddleDAOImpl() {
        super(HaddleModel.class);
    }


    @Override
    public WriteResult deleteHaddleDetail(String accId, String appId) {
        Query<HaddleModel> query = getQuery();
        query.filter("accId", accId);
        query.filter("appId", appId);
        return getDatastore().delete(query);
    }

    @Override
    public List<HaddleModel> allHadelDetail() {
        Query<HaddleModel> query = getQuery();
        return query.asList();
    }
}
