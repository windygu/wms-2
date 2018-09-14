package org.dddml.wms.domain.inoutnotice;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;


public class InOutNoticeStateDto
{

    private String inOutNoticeId;

    public String getInOutNoticeId()
    {
        return this.inOutNoticeId;
    }

    public void setInOutNoticeId(String inOutNoticeId)
    {
        this.inOutNoticeId = inOutNoticeId;
    }

    private String warehouseId;

    public String getWarehouseId()
    {
        return this.warehouseId;
    }

    public void setWarehouseId(String warehouseId)
    {
        this.warehouseId = warehouseId;
    }

    private String inOutNoticeType;

    public String getInOutNoticeType()
    {
        return this.inOutNoticeType;
    }

    public void setInOutNoticeType(String inOutNoticeType)
    {
        this.inOutNoticeType = inOutNoticeType;
    }

    private String telecomContactMechId;

    public String getTelecomContactMechId()
    {
        return this.telecomContactMechId;
    }

    public void setTelecomContactMechId(String telecomContactMechId)
    {
        this.telecomContactMechId = telecomContactMechId;
    }

    private String trackingNumber;

    public String getTrackingNumber()
    {
        return this.trackingNumber;
    }

    public void setTrackingNumber(String trackingNumber)
    {
        this.trackingNumber = trackingNumber;
    }

    private String contactPartyId;

    public String getContactPartyId()
    {
        return this.contactPartyId;
    }

    public void setContactPartyId(String contactPartyId)
    {
        this.contactPartyId = contactPartyId;
    }

    private String vehiclePlateNumber;

    public String getVehiclePlateNumber()
    {
        return this.vehiclePlateNumber;
    }

    public void setVehiclePlateNumber(String vehiclePlateNumber)
    {
        this.vehiclePlateNumber = vehiclePlateNumber;
    }

    private String shippingInstructions;

    public String getShippingInstructions()
    {
        return this.shippingInstructions;
    }

    public void setShippingInstructions(String shippingInstructions)
    {
        this.shippingInstructions = shippingInstructions;
    }

    private java.sql.Timestamp estimatedShipDate;

    public java.sql.Timestamp getEstimatedShipDate()
    {
        return this.estimatedShipDate;
    }

    public void setEstimatedShipDate(java.sql.Timestamp estimatedShipDate)
    {
        this.estimatedShipDate = estimatedShipDate;
    }

    private java.sql.Timestamp estimatedDeliveryDate;

    public java.sql.Timestamp getEstimatedDeliveryDate()
    {
        return this.estimatedDeliveryDate;
    }

    public void setEstimatedDeliveryDate(java.sql.Timestamp estimatedDeliveryDate)
    {
        this.estimatedDeliveryDate = estimatedDeliveryDate;
    }

    private String statusId;

    public String getStatusId()
    {
        return this.statusId;
    }

    public void setStatusId(String statusId)
    {
        this.statusId = statusId;
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


    public static class DtoConverter extends AbstractStateDtoConverter
    {
        public static Collection<String> collectionFieldNames = Arrays.asList(new String[]{});

        @Override
        protected boolean isCollectionField(String fieldName) {
            return CollectionUtils.collectionContainsIgnoringCase(collectionFieldNames, fieldName);
        }

        public InOutNoticeStateDto[] toInOutNoticeStateDtoArray(Iterable<InOutNoticeState> states) {
            return toInOutNoticeStateDtoList(states).toArray(new InOutNoticeStateDto[0]);
        }

        public List<InOutNoticeStateDto> toInOutNoticeStateDtoList(Iterable<InOutNoticeState> states) {
            ArrayList<InOutNoticeStateDto> stateDtos = new ArrayList();
            for (InOutNoticeState s : states) {
                InOutNoticeStateDto dto = toInOutNoticeStateDto(s);
                stateDtos.add(dto);
            }
            return stateDtos;
        }

        public InOutNoticeStateDto toInOutNoticeStateDto(InOutNoticeState state)
        {
            if(state == null) {
                return null;
            }
            InOutNoticeStateDto dto = new InOutNoticeStateDto();
            if (returnedFieldsContains("InOutNoticeId")) {
                dto.setInOutNoticeId(state.getInOutNoticeId());
            }
            if (returnedFieldsContains("WarehouseId")) {
                dto.setWarehouseId(state.getWarehouseId());
            }
            if (returnedFieldsContains("InOutNoticeType")) {
                dto.setInOutNoticeType(state.getInOutNoticeType());
            }
            if (returnedFieldsContains("TelecomContactMechId")) {
                dto.setTelecomContactMechId(state.getTelecomContactMechId());
            }
            if (returnedFieldsContains("TrackingNumber")) {
                dto.setTrackingNumber(state.getTrackingNumber());
            }
            if (returnedFieldsContains("ContactPartyId")) {
                dto.setContactPartyId(state.getContactPartyId());
            }
            if (returnedFieldsContains("VehiclePlateNumber")) {
                dto.setVehiclePlateNumber(state.getVehiclePlateNumber());
            }
            if (returnedFieldsContains("ShippingInstructions")) {
                dto.setShippingInstructions(state.getShippingInstructions());
            }
            if (returnedFieldsContains("EstimatedShipDate")) {
                dto.setEstimatedShipDate(state.getEstimatedShipDate());
            }
            if (returnedFieldsContains("EstimatedDeliveryDate")) {
                dto.setEstimatedDeliveryDate(state.getEstimatedDeliveryDate());
            }
            if (returnedFieldsContains("StatusId")) {
                dto.setStatusId(state.getStatusId());
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
            return dto;
        }

    }
}

