package com.digiwin.bpm.ntko.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @author：zhupeng
 * @Date：2020/8/18 23:10
 * @Desc：TODO
 */
@Entity
@Table(name = "NoCmDocument")
public class NoCmDocumentEntity implements Serializable {
    @Id
    @Column(name = "OID")
    private String oid;

    @Column(name = "id")
    private String id;

    @Column(name = "logicalName")
    private String logicalName;

    @Column(name = "physicalName")
    private String physicalName;

    @Column(name = "extentionName")
    private String extentionName;

    @Column(name = "typeOID")
    private String typeOID;

    @Column(name = "formInstanceOID")
    private String formInstanceOID;

    @Column(name = "processInstanceOID")
    private String processInstanceOID;

    @Column(name = "creatorOID")
    private String creatorOID;

    @Column(name = "createdTime")
    private Date createdTime;

    @Column(name = "objectVersion")
    private Integer objectVersion;

    @Column(name = "description")
    private String description;

    public String getOid() {
        return oid;
    }

    public void setOid(String oid) {
        this.oid = oid;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLogicalName() {
        return logicalName;
    }

    public void setLogicalName(String logicalName) {
        this.logicalName = logicalName;
    }

    public String getPhysicalName() {
        return physicalName;
    }

    public void setPhysicalName(String physicalName) {
        this.physicalName = physicalName;
    }

    public String getExtentionName() {
        return extentionName;
    }

    public void setExtentionName(String extentionName) {
        this.extentionName = extentionName;
    }

    public String getTypeOID() {
        return typeOID;
    }

    public void setTypeOID(String typeOID) {
        this.typeOID = typeOID;
    }

    public String getFormInstanceOID() {
        return formInstanceOID;
    }

    public void setFormInstanceOID(String formInstanceOID) {
        this.formInstanceOID = formInstanceOID;
    }

    public String getProcessInstanceOID() {
        return processInstanceOID;
    }

    public void setProcessInstanceOID(String processInstanceOID) {
        this.processInstanceOID = processInstanceOID;
    }

    public String getCreatorOID() {
        return creatorOID;
    }

    public void setCreatorOID(String creatorOID) {
        this.creatorOID = creatorOID;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    public Integer getObjectVersion() {
        return objectVersion;
    }

    public void setObjectVersion(Integer objectVersion) {
        this.objectVersion = objectVersion;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "NoCmDocumentEntity{" +
                "oid='" + oid + '\'' +
                ", id='" + id + '\'' +
                ", logicalName='" + logicalName + '\'' +
                ", physicalName='" + physicalName + '\'' +
                ", extentionName='" + extentionName + '\'' +
                ", typeOID='" + typeOID + '\'' +
                ", formInstanceOID='" + formInstanceOID + '\'' +
                ", processInstanceOID='" + processInstanceOID + '\'' +
                ", creatorOID='" + creatorOID + '\'' +
                ", createdTime=" + createdTime +
                ", objectVersion=" + objectVersion +
                ", description='" + description + '\'' +
                '}';
    }
}
