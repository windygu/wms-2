package org.dddml.wms.domain.facility;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;


public class FacilityStateDto
{

    private String facilityId;

    public String getFacilityId()
    {
        return this.facilityId;
    }

    public void setFacilityId(String facilityId)
    {
        this.facilityId = facilityId;
    }

    private String facilityTypeId;

    public String getFacilityTypeId()
    {
        return this.facilityTypeId;
    }

    public void setFacilityTypeId(String facilityTypeId)
    {
        this.facilityTypeId = facilityTypeId;
    }

    private String parentFacilityId;

    public String getParentFacilityId()
    {
        return this.parentFacilityId;
    }

    public void setParentFacilityId(String parentFacilityId)
    {
        this.parentFacilityId = parentFacilityId;
    }

    private String ownerPartyId;

    public String getOwnerPartyId()
    {
        return this.ownerPartyId;
    }

    public void setOwnerPartyId(String ownerPartyId)
    {
        this.ownerPartyId = ownerPartyId;
    }

    private String defaultInventoryItemTypeId;

    public String getDefaultInventoryItemTypeId()
    {
        return this.defaultInventoryItemTypeId;
    }

    public void setDefaultInventoryItemTypeId(String defaultInventoryItemTypeId)
    {
        this.defaultInventoryItemTypeId = defaultInventoryItemTypeId;
    }

    private String facilityName;

    public String getFacilityName()
    {
        return this.facilityName;
    }

    public void setFacilityName(String facilityName)
    {
        this.facilityName = facilityName;
    }

    private String primaryFacilityGroupId;

    public String getPrimaryFacilityGroupId()
    {
        return this.primaryFacilityGroupId;
    }

    public void setPrimaryFacilityGroupId(String primaryFacilityGroupId)
    {
        this.primaryFacilityGroupId = primaryFacilityGroupId;
    }

    private Long oldSquareFootage;

    public Long getOldSquareFootage()
    {
        return this.oldSquareFootage;
    }

    public void setOldSquareFootage(Long oldSquareFootage)
    {
        this.oldSquareFootage = oldSquareFootage;
    }

    private java.math.BigDecimal facilitySize;

    public java.math.BigDecimal getFacilitySize()
    {
        return this.facilitySize;
    }

    public void setFacilitySize(java.math.BigDecimal facilitySize)
    {
        this.facilitySize = facilitySize;
    }

    private String facilitySizeUomId;

    public String getFacilitySizeUomId()
    {
        return this.facilitySizeUomId;
    }

    public void setFacilitySizeUomId(String facilitySizeUomId)
    {
        this.facilitySizeUomId = facilitySizeUomId;
    }

    private String productStoreId;

    public String getProductStoreId()
    {
        return this.productStoreId;
    }

    public void setProductStoreId(String productStoreId)
    {
        this.productStoreId = productStoreId;
    }

    private Long defaultDaysToShip;

    public Long getDefaultDaysToShip()
    {
        return this.defaultDaysToShip;
    }

    public void setDefaultDaysToShip(Long defaultDaysToShip)
    {
        this.defaultDaysToShip = defaultDaysToShip;
    }

    private java.sql.Timestamp openedDate;

    public java.sql.Timestamp getOpenedDate()
    {
        return this.openedDate;
    }

    public void setOpenedDate(java.sql.Timestamp openedDate)
    {
        this.openedDate = openedDate;
    }

    private java.sql.Timestamp closedDate;

    public java.sql.Timestamp getClosedDate()
    {
        return this.closedDate;
    }

    public void setClosedDate(java.sql.Timestamp closedDate)
    {
        this.closedDate = closedDate;
    }

    private String description;

    public String getDescription()
    {
        return this.description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    private String defaultDimensionUomId;

    public String getDefaultDimensionUomId()
    {
        return this.defaultDimensionUomId;
    }

    public void setDefaultDimensionUomId(String defaultDimensionUomId)
    {
        this.defaultDimensionUomId = defaultDimensionUomId;
    }

    private String defaultWeightUomId;

    public String getDefaultWeightUomId()
    {
        return this.defaultWeightUomId;
    }

    public void setDefaultWeightUomId(String defaultWeightUomId)
    {
        this.defaultWeightUomId = defaultWeightUomId;
    }

    private String geoPointId;

    public String getGeoPointId()
    {
        return this.geoPointId;
    }

    public void setGeoPointId(String geoPointId)
    {
        this.geoPointId = geoPointId;
    }

    private Boolean active;

    public Boolean getActive()
    {
        return this.active;
    }

    public void setActive(Boolean active)
    {
        this.active = active;
    }

    private Long version;

    public Long getVersion()
    {
        return this.version;
    }

    public void setVersion(Long version)
    {
        this.version = version;
    }

    private String createdBy;

    public String getCreatedBy()
    {
        return this.createdBy;
    }

    public void setCreatedBy(String createdBy)
    {
        this.createdBy = createdBy;
    }

    private Date createdAt;

    public Date getCreatedAt()
    {
        return this.createdAt;
    }

    public void setCreatedAt(Date createdAt)
    {
        this.createdAt = createdAt;
    }

    private String updatedBy;

    public String getUpdatedBy()
    {
        return this.updatedBy;
    }

    public void setUpdatedBy(String updatedBy)
    {
        this.updatedBy = updatedBy;
    }

    private Date updatedAt;

    public Date getUpdatedAt()
    {
        return this.updatedAt;
    }

    public void setUpdatedAt(Date updatedAt)
    {
        this.updatedAt = updatedAt;
    }

}

