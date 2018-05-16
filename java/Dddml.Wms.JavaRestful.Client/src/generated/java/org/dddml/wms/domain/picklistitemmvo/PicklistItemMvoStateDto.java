package org.dddml.wms.domain.picklistitemmvo;

import java.util.*;
import org.dddml.wms.domain.picklistbin.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;


public class PicklistItemMvoStateDto
{

    private PicklistBinPicklistItemId picklistBinPicklistItemId;

    public PicklistBinPicklistItemId getPicklistBinPicklistItemId()
    {
        return this.picklistBinPicklistItemId;
    }

    public void setPicklistBinPicklistItemId(PicklistBinPicklistItemId picklistBinPicklistItemId)
    {
        this.picklistBinPicklistItemId = picklistBinPicklistItemId;
    }

    private String itemStatusId;

    public String getItemStatusId()
    {
        return this.itemStatusId;
    }

    public void setItemStatusId(String itemStatusId)
    {
        this.itemStatusId = itemStatusId;
    }

    private java.math.BigDecimal quantity;

    public java.math.BigDecimal getQuantity()
    {
        return this.quantity;
    }

    public void setQuantity(java.math.BigDecimal quantity)
    {
        this.quantity = quantity;
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

    private Boolean active;

    public Boolean getActive()
    {
        return this.active;
    }

    public void setActive(Boolean active)
    {
        this.active = active;
    }

    private String picklistBinPicklistId;

    public String getPicklistBinPicklistId()
    {
        return this.picklistBinPicklistId;
    }

    public void setPicklistBinPicklistId(String picklistBinPicklistId)
    {
        this.picklistBinPicklistId = picklistBinPicklistId;
    }

    private Long picklistBinBinLocationNumber;

    public Long getPicklistBinBinLocationNumber()
    {
        return this.picklistBinBinLocationNumber;
    }

    public void setPicklistBinBinLocationNumber(Long picklistBinBinLocationNumber)
    {
        this.picklistBinBinLocationNumber = picklistBinBinLocationNumber;
    }

    private String picklistBinPrimaryOrderId;

    public String getPicklistBinPrimaryOrderId()
    {
        return this.picklistBinPrimaryOrderId;
    }

    public void setPicklistBinPrimaryOrderId(String picklistBinPrimaryOrderId)
    {
        this.picklistBinPrimaryOrderId = picklistBinPrimaryOrderId;
    }

    private Long picklistBinPrimaryShipGroupSeqId;

    public Long getPicklistBinPrimaryShipGroupSeqId()
    {
        return this.picklistBinPrimaryShipGroupSeqId;
    }

    public void setPicklistBinPrimaryShipGroupSeqId(Long picklistBinPrimaryShipGroupSeqId)
    {
        this.picklistBinPrimaryShipGroupSeqId = picklistBinPrimaryShipGroupSeqId;
    }

    private String picklistBinCreatedBy;

    public String getPicklistBinCreatedBy()
    {
        return this.picklistBinCreatedBy;
    }

    public void setPicklistBinCreatedBy(String picklistBinCreatedBy)
    {
        this.picklistBinCreatedBy = picklistBinCreatedBy;
    }

    private Date picklistBinCreatedAt;

    public Date getPicklistBinCreatedAt()
    {
        return this.picklistBinCreatedAt;
    }

    public void setPicklistBinCreatedAt(Date picklistBinCreatedAt)
    {
        this.picklistBinCreatedAt = picklistBinCreatedAt;
    }

    private String picklistBinUpdatedBy;

    public String getPicklistBinUpdatedBy()
    {
        return this.picklistBinUpdatedBy;
    }

    public void setPicklistBinUpdatedBy(String picklistBinUpdatedBy)
    {
        this.picklistBinUpdatedBy = picklistBinUpdatedBy;
    }

    private Date picklistBinUpdatedAt;

    public Date getPicklistBinUpdatedAt()
    {
        return this.picklistBinUpdatedAt;
    }

    public void setPicklistBinUpdatedAt(Date picklistBinUpdatedAt)
    {
        this.picklistBinUpdatedAt = picklistBinUpdatedAt;
    }

    private Boolean picklistBinActive;

    public Boolean getPicklistBinActive()
    {
        return this.picklistBinActive;
    }

    public void setPicklistBinActive(Boolean picklistBinActive)
    {
        this.picklistBinActive = picklistBinActive;
    }

    private Boolean picklistBinDeleted;

    public Boolean getPicklistBinDeleted()
    {
        return this.picklistBinDeleted;
    }

    public void setPicklistBinDeleted(Boolean picklistBinDeleted)
    {
        this.picklistBinDeleted = picklistBinDeleted;
    }

    private Long picklistBinVersion;

    public Long getPicklistBinVersion()
    {
        return this.picklistBinVersion;
    }

    public void setPicklistBinVersion(Long picklistBinVersion)
    {
        this.picklistBinVersion = picklistBinVersion;
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

