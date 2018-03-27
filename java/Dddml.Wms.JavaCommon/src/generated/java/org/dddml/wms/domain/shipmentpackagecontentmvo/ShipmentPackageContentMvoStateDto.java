package org.dddml.wms.domain.shipmentpackagecontentmvo;

import java.util.*;
import org.dddml.wms.domain.shipmentpackage.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;


public class ShipmentPackageContentMvoStateDto
{

    private ShipmentPackageContentId shipmentPackageContentId;

    public ShipmentPackageContentId getShipmentPackageContentId()
    {
        return this.shipmentPackageContentId;
    }

    public void setShipmentPackageContentId(ShipmentPackageContentId shipmentPackageContentId)
    {
        this.shipmentPackageContentId = shipmentPackageContentId;
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

    private String subProductId;

    public String getSubProductId()
    {
        return this.subProductId;
    }

    public void setSubProductId(String subProductId)
    {
        this.subProductId = subProductId;
    }

    private java.math.BigDecimal subProductQuantity;

    public java.math.BigDecimal getSubProductQuantity()
    {
        return this.subProductQuantity;
    }

    public void setSubProductQuantity(java.math.BigDecimal subProductQuantity)
    {
        this.subProductQuantity = subProductQuantity;
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

    private String shipmentPackageShipmentBoxTypeId;

    public String getShipmentPackageShipmentBoxTypeId()
    {
        return this.shipmentPackageShipmentBoxTypeId;
    }

    public void setShipmentPackageShipmentBoxTypeId(String shipmentPackageShipmentBoxTypeId)
    {
        this.shipmentPackageShipmentBoxTypeId = shipmentPackageShipmentBoxTypeId;
    }

    private java.sql.Timestamp shipmentPackageDateCreated;

    public java.sql.Timestamp getShipmentPackageDateCreated()
    {
        return this.shipmentPackageDateCreated;
    }

    public void setShipmentPackageDateCreated(java.sql.Timestamp shipmentPackageDateCreated)
    {
        this.shipmentPackageDateCreated = shipmentPackageDateCreated;
    }

    private java.math.BigDecimal shipmentPackageBoxLength;

    public java.math.BigDecimal getShipmentPackageBoxLength()
    {
        return this.shipmentPackageBoxLength;
    }

    public void setShipmentPackageBoxLength(java.math.BigDecimal shipmentPackageBoxLength)
    {
        this.shipmentPackageBoxLength = shipmentPackageBoxLength;
    }

    private java.math.BigDecimal shipmentPackageBoxHeight;

    public java.math.BigDecimal getShipmentPackageBoxHeight()
    {
        return this.shipmentPackageBoxHeight;
    }

    public void setShipmentPackageBoxHeight(java.math.BigDecimal shipmentPackageBoxHeight)
    {
        this.shipmentPackageBoxHeight = shipmentPackageBoxHeight;
    }

    private java.math.BigDecimal shipmentPackageBoxWidth;

    public java.math.BigDecimal getShipmentPackageBoxWidth()
    {
        return this.shipmentPackageBoxWidth;
    }

    public void setShipmentPackageBoxWidth(java.math.BigDecimal shipmentPackageBoxWidth)
    {
        this.shipmentPackageBoxWidth = shipmentPackageBoxWidth;
    }

    private String shipmentPackageDimensionUomId;

    public String getShipmentPackageDimensionUomId()
    {
        return this.shipmentPackageDimensionUomId;
    }

    public void setShipmentPackageDimensionUomId(String shipmentPackageDimensionUomId)
    {
        this.shipmentPackageDimensionUomId = shipmentPackageDimensionUomId;
    }

    private java.math.BigDecimal shipmentPackageWeight;

    public java.math.BigDecimal getShipmentPackageWeight()
    {
        return this.shipmentPackageWeight;
    }

    public void setShipmentPackageWeight(java.math.BigDecimal shipmentPackageWeight)
    {
        this.shipmentPackageWeight = shipmentPackageWeight;
    }

    private String shipmentPackageWeightUomId;

    public String getShipmentPackageWeightUomId()
    {
        return this.shipmentPackageWeightUomId;
    }

    public void setShipmentPackageWeightUomId(String shipmentPackageWeightUomId)
    {
        this.shipmentPackageWeightUomId = shipmentPackageWeightUomId;
    }

    private java.math.BigDecimal shipmentPackageInsuredValue;

    public java.math.BigDecimal getShipmentPackageInsuredValue()
    {
        return this.shipmentPackageInsuredValue;
    }

    public void setShipmentPackageInsuredValue(java.math.BigDecimal shipmentPackageInsuredValue)
    {
        this.shipmentPackageInsuredValue = shipmentPackageInsuredValue;
    }

    private String shipmentPackageCreatedBy;

    public String getShipmentPackageCreatedBy()
    {
        return this.shipmentPackageCreatedBy;
    }

    public void setShipmentPackageCreatedBy(String shipmentPackageCreatedBy)
    {
        this.shipmentPackageCreatedBy = shipmentPackageCreatedBy;
    }

    private Date shipmentPackageCreatedAt;

    public Date getShipmentPackageCreatedAt()
    {
        return this.shipmentPackageCreatedAt;
    }

    public void setShipmentPackageCreatedAt(Date shipmentPackageCreatedAt)
    {
        this.shipmentPackageCreatedAt = shipmentPackageCreatedAt;
    }

    private String shipmentPackageUpdatedBy;

    public String getShipmentPackageUpdatedBy()
    {
        return this.shipmentPackageUpdatedBy;
    }

    public void setShipmentPackageUpdatedBy(String shipmentPackageUpdatedBy)
    {
        this.shipmentPackageUpdatedBy = shipmentPackageUpdatedBy;
    }

    private Date shipmentPackageUpdatedAt;

    public Date getShipmentPackageUpdatedAt()
    {
        return this.shipmentPackageUpdatedAt;
    }

    public void setShipmentPackageUpdatedAt(Date shipmentPackageUpdatedAt)
    {
        this.shipmentPackageUpdatedAt = shipmentPackageUpdatedAt;
    }

    private Boolean shipmentPackageActive;

    public Boolean getShipmentPackageActive()
    {
        return this.shipmentPackageActive;
    }

    public void setShipmentPackageActive(Boolean shipmentPackageActive)
    {
        this.shipmentPackageActive = shipmentPackageActive;
    }

    private Boolean shipmentPackageDeleted;

    public Boolean getShipmentPackageDeleted()
    {
        return this.shipmentPackageDeleted;
    }

    public void setShipmentPackageDeleted(Boolean shipmentPackageDeleted)
    {
        this.shipmentPackageDeleted = shipmentPackageDeleted;
    }

    private Long shipmentPackageVersion;

    public Long getShipmentPackageVersion()
    {
        return this.shipmentPackageVersion;
    }

    public void setShipmentPackageVersion(Long shipmentPackageVersion)
    {
        this.shipmentPackageVersion = shipmentPackageVersion;
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


    public static class DtoConverter extends AbstractStateDtoConverter
    {
        public static Collection<String> collectionFieldNames = Arrays.asList(new String[]{});

        @Override
        protected boolean isCollectionField(String fieldName) {
            return CollectionUtils.collectionContainsIgnoringCase(collectionFieldNames, fieldName);
        }

        public ShipmentPackageContentMvoStateDto[] toShipmentPackageContentMvoStateDtoArray(Iterable<ShipmentPackageContentMvoState> states) 
        {
            ArrayList<ShipmentPackageContentMvoStateDto> stateDtos = new ArrayList();
            for (ShipmentPackageContentMvoState s : states) {
                ShipmentPackageContentMvoStateDto dto = toShipmentPackageContentMvoStateDto(s);
                stateDtos.add(dto);
            }
            return stateDtos.toArray(new ShipmentPackageContentMvoStateDto[0]);
        }

        public ShipmentPackageContentMvoStateDto toShipmentPackageContentMvoStateDto(ShipmentPackageContentMvoState state)
        {
            if(state == null) {
                return null;
            }
            ShipmentPackageContentMvoStateDto dto = new ShipmentPackageContentMvoStateDto();
            if (returnedFieldsContains("ShipmentPackageContentId")) {
                dto.setShipmentPackageContentId(state.getShipmentPackageContentId());
            }
            if (returnedFieldsContains("Quantity")) {
                dto.setQuantity(state.getQuantity());
            }
            if (returnedFieldsContains("SubProductId")) {
                dto.setSubProductId(state.getSubProductId());
            }
            if (returnedFieldsContains("SubProductQuantity")) {
                dto.setSubProductQuantity(state.getSubProductQuantity());
            }
            if (returnedFieldsContains("Version")) {
                dto.setVersion(state.getVersion());
            }
            if (returnedFieldsContains("Active")) {
                dto.setActive(state.getActive());
            }
            if (returnedFieldsContains("ShipmentPackageShipmentBoxTypeId")) {
                dto.setShipmentPackageShipmentBoxTypeId(state.getShipmentPackageShipmentBoxTypeId());
            }
            if (returnedFieldsContains("ShipmentPackageDateCreated")) {
                dto.setShipmentPackageDateCreated(state.getShipmentPackageDateCreated());
            }
            if (returnedFieldsContains("ShipmentPackageBoxLength")) {
                dto.setShipmentPackageBoxLength(state.getShipmentPackageBoxLength());
            }
            if (returnedFieldsContains("ShipmentPackageBoxHeight")) {
                dto.setShipmentPackageBoxHeight(state.getShipmentPackageBoxHeight());
            }
            if (returnedFieldsContains("ShipmentPackageBoxWidth")) {
                dto.setShipmentPackageBoxWidth(state.getShipmentPackageBoxWidth());
            }
            if (returnedFieldsContains("ShipmentPackageDimensionUomId")) {
                dto.setShipmentPackageDimensionUomId(state.getShipmentPackageDimensionUomId());
            }
            if (returnedFieldsContains("ShipmentPackageWeight")) {
                dto.setShipmentPackageWeight(state.getShipmentPackageWeight());
            }
            if (returnedFieldsContains("ShipmentPackageWeightUomId")) {
                dto.setShipmentPackageWeightUomId(state.getShipmentPackageWeightUomId());
            }
            if (returnedFieldsContains("ShipmentPackageInsuredValue")) {
                dto.setShipmentPackageInsuredValue(state.getShipmentPackageInsuredValue());
            }
            if (returnedFieldsContains("ShipmentPackageCreatedBy")) {
                dto.setShipmentPackageCreatedBy(state.getShipmentPackageCreatedBy());
            }
            if (returnedFieldsContains("ShipmentPackageCreatedAt")) {
                dto.setShipmentPackageCreatedAt(state.getShipmentPackageCreatedAt());
            }
            if (returnedFieldsContains("ShipmentPackageUpdatedBy")) {
                dto.setShipmentPackageUpdatedBy(state.getShipmentPackageUpdatedBy());
            }
            if (returnedFieldsContains("ShipmentPackageUpdatedAt")) {
                dto.setShipmentPackageUpdatedAt(state.getShipmentPackageUpdatedAt());
            }
            if (returnedFieldsContains("ShipmentPackageActive")) {
                dto.setShipmentPackageActive(state.getShipmentPackageActive());
            }
            if (returnedFieldsContains("ShipmentPackageDeleted")) {
                dto.setShipmentPackageDeleted(state.getShipmentPackageDeleted());
            }
            if (returnedFieldsContains("ShipmentPackageVersion")) {
                dto.setShipmentPackageVersion(state.getShipmentPackageVersion());
            }
            if (returnedFieldsContains("CreatedBy")) {
                dto.setCreatedBy(state.getCreatedBy());
            }
            if (returnedFieldsContains("CreatedAt")) {
                dto.setCreatedAt(state.getCreatedAt());
            }
            if (returnedFieldsContains("UpdatedBy")) {
                dto.setUpdatedBy(state.getUpdatedBy());
            }
            if (returnedFieldsContains("UpdatedAt")) {
                dto.setUpdatedAt(state.getUpdatedAt());
            }
            return dto;
        }

    }
}

