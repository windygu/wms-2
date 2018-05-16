package org.dddml.wms.domain.movementlinemvo;

import java.util.*;
import org.dddml.wms.domain.movement.*;
import java.math.BigDecimal;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;


public class MovementLineMvoStateDto
{

    private MovementLineId movementLineId;

    public MovementLineId getMovementLineId()
    {
        return this.movementLineId;
    }

    public void setMovementLineId(MovementLineId movementLineId)
    {
        this.movementLineId = movementLineId;
    }

    private BigDecimal movementQuantity;

    public BigDecimal getMovementQuantity()
    {
        return this.movementQuantity;
    }

    public void setMovementQuantity(BigDecimal movementQuantity)
    {
        this.movementQuantity = movementQuantity;
    }

    private String productId;

    public String getProductId()
    {
        return this.productId;
    }

    public void setProductId(String productId)
    {
        this.productId = productId;
    }

    private String locatorIdFrom;

    public String getLocatorIdFrom()
    {
        return this.locatorIdFrom;
    }

    public void setLocatorIdFrom(String locatorIdFrom)
    {
        this.locatorIdFrom = locatorIdFrom;
    }

    private String locatorIdTo;

    public String getLocatorIdTo()
    {
        return this.locatorIdTo;
    }

    public void setLocatorIdTo(String locatorIdTo)
    {
        this.locatorIdTo = locatorIdTo;
    }

    private String attributeSetInstanceId;

    public String getAttributeSetInstanceId()
    {
        return this.attributeSetInstanceId;
    }

    public void setAttributeSetInstanceId(String attributeSetInstanceId)
    {
        this.attributeSetInstanceId = attributeSetInstanceId;
    }

    private Boolean processed;

    public Boolean getProcessed()
    {
        return this.processed;
    }

    public void setProcessed(Boolean processed)
    {
        this.processed = processed;
    }

    private String reversalLineNumber;

    public String getReversalLineNumber()
    {
        return this.reversalLineNumber;
    }

    public void setReversalLineNumber(String reversalLineNumber)
    {
        this.reversalLineNumber = reversalLineNumber;
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

    private String movementDocumentStatusId;

    public String getMovementDocumentStatusId()
    {
        return this.movementDocumentStatusId;
    }

    public void setMovementDocumentStatusId(String movementDocumentStatusId)
    {
        this.movementDocumentStatusId = movementDocumentStatusId;
    }

    private Date movementMovementDate;

    public Date getMovementMovementDate()
    {
        return this.movementMovementDate;
    }

    public void setMovementMovementDate(Date movementMovementDate)
    {
        this.movementMovementDate = movementMovementDate;
    }

    private Boolean movementPosted;

    public Boolean getMovementPosted()
    {
        return this.movementPosted;
    }

    public void setMovementPosted(Boolean movementPosted)
    {
        this.movementPosted = movementPosted;
    }

    private Boolean movementProcessed;

    public Boolean getMovementProcessed()
    {
        return this.movementProcessed;
    }

    public void setMovementProcessed(Boolean movementProcessed)
    {
        this.movementProcessed = movementProcessed;
    }

    private String movementProcessing;

    public String getMovementProcessing()
    {
        return this.movementProcessing;
    }

    public void setMovementProcessing(String movementProcessing)
    {
        this.movementProcessing = movementProcessing;
    }

    private Date movementDateReceived;

    public Date getMovementDateReceived()
    {
        return this.movementDateReceived;
    }

    public void setMovementDateReceived(Date movementDateReceived)
    {
        this.movementDateReceived = movementDateReceived;
    }

    private String movementDocumentTypeId;

    public String getMovementDocumentTypeId()
    {
        return this.movementDocumentTypeId;
    }

    public void setMovementDocumentTypeId(String movementDocumentTypeId)
    {
        this.movementDocumentTypeId = movementDocumentTypeId;
    }

    private Boolean movementIsInTransit;

    public Boolean getMovementIsInTransit()
    {
        return this.movementIsInTransit;
    }

    public void setMovementIsInTransit(Boolean movementIsInTransit)
    {
        this.movementIsInTransit = movementIsInTransit;
    }

    private Boolean movementIsApproved;

    public Boolean getMovementIsApproved()
    {
        return this.movementIsApproved;
    }

    public void setMovementIsApproved(Boolean movementIsApproved)
    {
        this.movementIsApproved = movementIsApproved;
    }

    private BigDecimal movementApprovalAmount;

    public BigDecimal getMovementApprovalAmount()
    {
        return this.movementApprovalAmount;
    }

    public void setMovementApprovalAmount(BigDecimal movementApprovalAmount)
    {
        this.movementApprovalAmount = movementApprovalAmount;
    }

    private String movementShipperId;

    public String getMovementShipperId()
    {
        return this.movementShipperId;
    }

    public void setMovementShipperId(String movementShipperId)
    {
        this.movementShipperId = movementShipperId;
    }

    private String movementSalesRepresentativeId;

    public String getMovementSalesRepresentativeId()
    {
        return this.movementSalesRepresentativeId;
    }

    public void setMovementSalesRepresentativeId(String movementSalesRepresentativeId)
    {
        this.movementSalesRepresentativeId = movementSalesRepresentativeId;
    }

    private String movementBusinessPartnerId;

    public String getMovementBusinessPartnerId()
    {
        return this.movementBusinessPartnerId;
    }

    public void setMovementBusinessPartnerId(String movementBusinessPartnerId)
    {
        this.movementBusinessPartnerId = movementBusinessPartnerId;
    }

    private BigDecimal movementChargeAmount;

    public BigDecimal getMovementChargeAmount()
    {
        return this.movementChargeAmount;
    }

    public void setMovementChargeAmount(BigDecimal movementChargeAmount)
    {
        this.movementChargeAmount = movementChargeAmount;
    }

    private String movementCreateFrom;

    public String getMovementCreateFrom()
    {
        return this.movementCreateFrom;
    }

    public void setMovementCreateFrom(String movementCreateFrom)
    {
        this.movementCreateFrom = movementCreateFrom;
    }

    private BigDecimal movementFreightAmount;

    public BigDecimal getMovementFreightAmount()
    {
        return this.movementFreightAmount;
    }

    public void setMovementFreightAmount(BigDecimal movementFreightAmount)
    {
        this.movementFreightAmount = movementFreightAmount;
    }

    private String movementReversalDocumentNumber;

    public String getMovementReversalDocumentNumber()
    {
        return this.movementReversalDocumentNumber;
    }

    public void setMovementReversalDocumentNumber(String movementReversalDocumentNumber)
    {
        this.movementReversalDocumentNumber = movementReversalDocumentNumber;
    }

    private String movementWarehouseIdFrom;

    public String getMovementWarehouseIdFrom()
    {
        return this.movementWarehouseIdFrom;
    }

    public void setMovementWarehouseIdFrom(String movementWarehouseIdFrom)
    {
        this.movementWarehouseIdFrom = movementWarehouseIdFrom;
    }

    private String movementWarehouseIdTo;

    public String getMovementWarehouseIdTo()
    {
        return this.movementWarehouseIdTo;
    }

    public void setMovementWarehouseIdTo(String movementWarehouseIdTo)
    {
        this.movementWarehouseIdTo = movementWarehouseIdTo;
    }

    private String movementDescription;

    public String getMovementDescription()
    {
        return this.movementDescription;
    }

    public void setMovementDescription(String movementDescription)
    {
        this.movementDescription = movementDescription;
    }

    private String movementCreatedBy;

    public String getMovementCreatedBy()
    {
        return this.movementCreatedBy;
    }

    public void setMovementCreatedBy(String movementCreatedBy)
    {
        this.movementCreatedBy = movementCreatedBy;
    }

    private Date movementCreatedAt;

    public Date getMovementCreatedAt()
    {
        return this.movementCreatedAt;
    }

    public void setMovementCreatedAt(Date movementCreatedAt)
    {
        this.movementCreatedAt = movementCreatedAt;
    }

    private String movementUpdatedBy;

    public String getMovementUpdatedBy()
    {
        return this.movementUpdatedBy;
    }

    public void setMovementUpdatedBy(String movementUpdatedBy)
    {
        this.movementUpdatedBy = movementUpdatedBy;
    }

    private Date movementUpdatedAt;

    public Date getMovementUpdatedAt()
    {
        return this.movementUpdatedAt;
    }

    public void setMovementUpdatedAt(Date movementUpdatedAt)
    {
        this.movementUpdatedAt = movementUpdatedAt;
    }

    private Boolean movementActive;

    public Boolean getMovementActive()
    {
        return this.movementActive;
    }

    public void setMovementActive(Boolean movementActive)
    {
        this.movementActive = movementActive;
    }

    private Boolean movementDeleted;

    public Boolean getMovementDeleted()
    {
        return this.movementDeleted;
    }

    public void setMovementDeleted(Boolean movementDeleted)
    {
        this.movementDeleted = movementDeleted;
    }

    private Long movementVersion;

    public Long getMovementVersion()
    {
        return this.movementVersion;
    }

    public void setMovementVersion(Long movementVersion)
    {
        this.movementVersion = movementVersion;
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

