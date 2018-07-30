package org.dddml.wms.domain.shipmentpackage;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;


public class ShipmentPackageStateDto
{

    private ShipmentPackageId shipmentPackageId;

    public ShipmentPackageId getShipmentPackageId()
    {
        return this.shipmentPackageId;
    }

    public void setShipmentPackageId(ShipmentPackageId shipmentPackageId)
    {
        this.shipmentPackageId = shipmentPackageId;
    }

    private String shipmentBoxTypeId;

    public String getShipmentBoxTypeId()
    {
        return this.shipmentBoxTypeId;
    }

    public void setShipmentBoxTypeId(String shipmentBoxTypeId)
    {
        this.shipmentBoxTypeId = shipmentBoxTypeId;
    }

    private java.sql.Timestamp dateCreated;

    public java.sql.Timestamp getDateCreated()
    {
        return this.dateCreated;
    }

    public void setDateCreated(java.sql.Timestamp dateCreated)
    {
        this.dateCreated = dateCreated;
    }

    private java.math.BigDecimal boxLength;

    public java.math.BigDecimal getBoxLength()
    {
        return this.boxLength;
    }

    public void setBoxLength(java.math.BigDecimal boxLength)
    {
        this.boxLength = boxLength;
    }

    private java.math.BigDecimal boxHeight;

    public java.math.BigDecimal getBoxHeight()
    {
        return this.boxHeight;
    }

    public void setBoxHeight(java.math.BigDecimal boxHeight)
    {
        this.boxHeight = boxHeight;
    }

    private java.math.BigDecimal boxWidth;

    public java.math.BigDecimal getBoxWidth()
    {
        return this.boxWidth;
    }

    public void setBoxWidth(java.math.BigDecimal boxWidth)
    {
        this.boxWidth = boxWidth;
    }

    private String dimensionUomId;

    public String getDimensionUomId()
    {
        return this.dimensionUomId;
    }

    public void setDimensionUomId(String dimensionUomId)
    {
        this.dimensionUomId = dimensionUomId;
    }

    private java.math.BigDecimal weight;

    public java.math.BigDecimal getWeight()
    {
        return this.weight;
    }

    public void setWeight(java.math.BigDecimal weight)
    {
        this.weight = weight;
    }

    private String weightUomId;

    public String getWeightUomId()
    {
        return this.weightUomId;
    }

    public void setWeightUomId(String weightUomId)
    {
        this.weightUomId = weightUomId;
    }

    private java.math.BigDecimal insuredValue;

    public java.math.BigDecimal getInsuredValue()
    {
        return this.insuredValue;
    }

    public void setInsuredValue(java.math.BigDecimal insuredValue)
    {
        this.insuredValue = insuredValue;
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

    private ShipmentPackageContentStateDto[] shipmentPackageContents;

    public ShipmentPackageContentStateDto[] getShipmentPackageContents()
    {
        return this.shipmentPackageContents;
    }	

    public void setShipmentPackageContents(ShipmentPackageContentStateDto[] shipmentPackageContents)
    {
        this.shipmentPackageContents = shipmentPackageContents;
    }


    public static class DtoConverter extends AbstractStateDtoConverter
    {
        public static Collection<String> collectionFieldNames = Arrays.asList(new String[]{"ShipmentPackageContents"});

        @Override
        protected boolean isCollectionField(String fieldName) {
            return CollectionUtils.collectionContainsIgnoringCase(collectionFieldNames, fieldName);
        }

        public ShipmentPackageStateDto[] toShipmentPackageStateDtoArray(Iterable<ShipmentPackageState> states) {
            return toShipmentPackageStateDtoList(states).toArray(new ShipmentPackageStateDto[0]);
        }

        public List<ShipmentPackageStateDto> toShipmentPackageStateDtoList(Iterable<ShipmentPackageState> states) {
            ArrayList<ShipmentPackageStateDto> stateDtos = new ArrayList();
            for (ShipmentPackageState s : states) {
                ShipmentPackageStateDto dto = toShipmentPackageStateDto(s);
                stateDtos.add(dto);
            }
            return stateDtos;
        }

        public ShipmentPackageStateDto toShipmentPackageStateDto(ShipmentPackageState state)
        {
            if(state == null) {
                return null;
            }
            ShipmentPackageStateDto dto = new ShipmentPackageStateDto();
            if (returnedFieldsContains("ShipmentPackageId")) {
                dto.setShipmentPackageId(state.getShipmentPackageId());
            }
            if (returnedFieldsContains("ShipmentBoxTypeId")) {
                dto.setShipmentBoxTypeId(state.getShipmentBoxTypeId());
            }
            if (returnedFieldsContains("DateCreated")) {
                dto.setDateCreated(state.getDateCreated());
            }
            if (returnedFieldsContains("BoxLength")) {
                dto.setBoxLength(state.getBoxLength());
            }
            if (returnedFieldsContains("BoxHeight")) {
                dto.setBoxHeight(state.getBoxHeight());
            }
            if (returnedFieldsContains("BoxWidth")) {
                dto.setBoxWidth(state.getBoxWidth());
            }
            if (returnedFieldsContains("DimensionUomId")) {
                dto.setDimensionUomId(state.getDimensionUomId());
            }
            if (returnedFieldsContains("Weight")) {
                dto.setWeight(state.getWeight());
            }
            if (returnedFieldsContains("WeightUomId")) {
                dto.setWeightUomId(state.getWeightUomId());
            }
            if (returnedFieldsContains("InsuredValue")) {
                dto.setInsuredValue(state.getInsuredValue());
            }
            if (returnedFieldsContains("Active")) {
                dto.setActive(state.getActive());
            }
            if (returnedFieldsContains("Version")) {
                dto.setVersion(state.getVersion());
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
            if (returnedFieldsContains("ShipmentPackageContents")) {
                ArrayList<ShipmentPackageContentStateDto> arrayList = new ArrayList();
                if (state.getShipmentPackageContents() != null) {
                    ShipmentPackageContentStateDto.DtoConverter conv = new ShipmentPackageContentStateDto.DtoConverter();
                    String returnFS = CollectionUtils.mapGetValueIgnoringCase(getReturnedFields(), "ShipmentPackageContents");
                    if(returnFS != null) { conv.setReturnedFieldsString(returnFS); } else { conv.setAllFieldsReturned(this.getAllFieldsReturned()); }
                    for (ShipmentPackageContentState s : state.getShipmentPackageContents()) {
                        arrayList.add(conv.toShipmentPackageContentStateDto(s));
                    }
                }
                dto.setShipmentPackageContents(arrayList.toArray(new ShipmentPackageContentStateDto[0]));
            }
            return dto;
        }

    }
}

