package io.egreen.wimukthi.microsys.haddle.data.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;

/**
 * Created by Pramode Wimukthi on 9/1/2016.
 */
@Entity
public class HaddleModel {

    @Id
    @JsonIgnore
    private ObjectId objectId;


    private String appId;
    private String accId;
    private String hadDate;
    private String giveDate;
    private String status;

    public HaddleModel() {

    }

    public ObjectId getObjectId() {
        return objectId;
    }

    public void setObjectId(ObjectId objectId) {
        this.objectId = objectId;
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getAccId() {
        return accId;
    }

    public void setAccId(String accId) {
        this.accId = accId;
    }

    public String getHadDate() {
        return hadDate;
    }

    public void setHadDate(String hadDate) {
        this.hadDate = hadDate;
    }

    public String getGiveDate() {
        return giveDate;
    }

    public void setGiveDate(String giveDate) {
        this.giveDate = giveDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
