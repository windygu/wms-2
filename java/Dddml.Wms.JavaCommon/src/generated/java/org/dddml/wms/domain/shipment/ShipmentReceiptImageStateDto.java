package org.dddml.wms.domain.shipment;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;


public class ShipmentReceiptImageStateDto
{

    private String sequenceId;

    public String getSequenceId()
    {
        return this.sequenceId;
    }

    public void setSequenceId(String sequenceId)
    {
        this.sequenceId = sequenceId;
    }

    private String url;

    public String getUrl()
    {
        return this.url;
    }

    public void setUrl(String url)
    {
        this.url = url;
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

    private String shipmentId;

    public String getShipmentId()
    {
        return this.shipmentId;
    }

    public void setShipmentId(String shipmentId)
    {
        this.shipmentId = shipmentId;
    }

    private String shipmentReceiptReceiptSeqId;

    public String getShipmentReceiptReceiptSeqId()
    {
        return this.shipmentReceiptReceiptSeqId;
    }

    public void setShipmentReceiptReceiptSeqId(String shipmentReceiptReceiptSeqId)
    {
        this.shipmentReceiptReceiptSeqId = shipmentReceiptReceiptSeqId;
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

        public ShipmentReceiptImageStateDto[] toShipmentReceiptImageStateDtoArray(Iterable<ShipmentReceiptImageState> states) {
            return toShipmentReceiptImageStateDtoList(states).toArray(new ShipmentReceiptImageStateDto[0]);
        }

        public List<ShipmentReceiptImageStateDto> toShipmentReceiptImageStateDtoList(Iterable<ShipmentReceiptImageState> states) {
            ArrayList<ShipmentReceiptImageStateDto> stateDtos = new ArrayList();
            for (ShipmentReceiptImageState s : states) {
                ShipmentReceiptImageStateDto dto = toShipmentReceiptImageStateDto(s);
                stateDtos.add(dto);
            }
            return stateDtos;
        }

        public ShipmentReceiptImageStateDto toShipmentReceiptImageStateDto(ShipmentReceiptImageState state)
        {
            if(state == null) {
                return null;
            }
            ShipmentReceiptImageStateDto dto = new ShipmentReceiptImageStateDto();
            if (returnedFieldsContains("SequenceId")) {
                dto.setSequenceId(state.getSequenceId());
            }
            if (returnedFieldsContains("Url")) {
                dto.setUrl(state.getUrl());
            }
            if (returnedFieldsContains("Active")) {
                dto.setActive(state.getActive());
            }
            if (returnedFieldsContains("Version")) {
                dto.setVersion(state.getVersion());
            }
            if (returnedFieldsContains("ShipmentId")) {
                dto.setShipmentId(state.getShipmentId());
            }
            if (returnedFieldsContains("ShipmentReceiptReceiptSeqId")) {
                dto.setShipmentReceiptReceiptSeqId(state.getShipmentReceiptReceiptSeqId());
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

