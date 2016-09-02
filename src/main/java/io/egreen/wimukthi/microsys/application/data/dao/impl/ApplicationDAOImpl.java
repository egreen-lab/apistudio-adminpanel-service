package io.egreen.wimukthi.microsys.application.data.dao.impl;

import com.mongodb.WriteResult;
import com.mongodb.client.result.UpdateResult;
import io.egreen.apistudio.datalayer.mongodb.dao.impl.AbstractDAOController;
import io.egreen.wimukthi.microsys.application.data.dao.ApplicationDAO;
import io.egreen.wimukthi.microsys.application.data.dto.ApplicationModel;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.mongodb.morphia.query.Query;
import org.mongodb.morphia.query.UpdateOperations;
import org.mongodb.morphia.query.UpdateResults;

import java.util.List;

/**
 * Created by Pramode Wimukthi on 9/1/2016.
 */
public class ApplicationDAOImpl extends AbstractDAOController<ApplicationModel> implements ApplicationDAO {

    private static final Logger LOGGER= LogManager.getLogger(ApplicationDAOImpl.class);

    public ApplicationDAOImpl() {
        super(ApplicationModel.class);
    }

    @Override
    public List<ApplicationModel> viewApplicationDetailbyUserType(String accId) {
        Query<ApplicationModel> query = getQuery();
        query.filter("accId", accId);
        return query.asList();
    }

    @Override
    public WriteResult deleteApp(String appId) {
        Query<ApplicationModel> query = getQuery();
        query.filter("appId", appId);
        return getDatastore().delete(query);

    }

    @Override
    public WriteResult deleteApp(String accId, String appId) {
        Query<ApplicationModel> query = getQuery();
        query.filter("accId", accId);
        query.filter("appId", appId);
        return getDatastore().delete(query);

    }

    @Override
    public boolean updateApp(String accId, ApplicationModel applicationModel) {
        Query<ApplicationModel> query = getQuery();
        query.filter("appId =", applicationModel.getAppId());
        query.filter("accId =", accId);
        UpdateOperations<ApplicationModel> list = getDatastore().createUpdateOperations(ApplicationModel.class);
        list.set("appName", applicationModel.getAppName());
        list.set("appDate", applicationModel.getAppDate());
        list.set("appFile", applicationModel.getAppFile());
        list.set("status", applicationModel.getStatus());
        getDatastore().update(query, list);
        return true;
    }

    @Override
    public boolean updateApp(ApplicationModel applicationModel) {
        Query<ApplicationModel> query = getQuery();
        query.filter("appId =", applicationModel.getAppId());
        UpdateOperations<ApplicationModel> list = getDatastore().createUpdateOperations(ApplicationModel.class);
        list.set("appId", applicationModel.getAppId());
        list.set("accId", applicationModel.getAccId());
        list.set("appName", applicationModel.getAppName());
        list.set("appDate", applicationModel.getAppDate());
        list.set("appFile", applicationModel.getAppFile());
        list.set("status", applicationModel.getStatus());
        UpdateResults update = getDatastore().update(query, list);
        LOGGER.info(update);
        LOGGER.info(update.getInsertedCount());
        LOGGER.info(update.getWriteResult().getUpsertedId());
        LOGGER.info(update.getNewId());
        return true;
    }

    @Override
    public List<ApplicationModel> viewApplicationDetailbyUserType() {
        Query<ApplicationModel> query = getQuery();
        return query.asList();
    }
}

