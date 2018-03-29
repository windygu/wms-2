package org.dddml.wms.domain.picklist;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.partyrole.*;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;


public class PicklistStateDto
{

    private String picklistId;

    public String getPicklistId()
    {
        return this.picklistId;
    }

    public void setPicklistId(String picklistId)
    {
        this.picklistId = picklistId;
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

    private String facilityId;

    public String getFacilityId()
    {
        return this.facilityId;
    }

    public void setFacilityId(String facilityId)
    {
        this.facilityId = facilityId;
    }

    private String shipmentMethodTypeId;

    public String getShipmentMethodTypeId()
    {
        return this.shipmentMethodTypeId;
    }

    public void setShipmentMethodTypeId(String shipmentMethodTypeId)
    {
        this.shipmentMethodTypeId = shipmentMethodTypeId;
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

    private java.sql.Timestamp picklistDate;

    public java.sql.Timestamp getPicklistDate()
    {
        return this.picklistDate;
    }

    public void setPicklistDate(java.sql.Timestamp picklistDate)
    {
        this.picklistDate = picklistDate;
    }

    private Long pickwaveId;

    public Long getPickwaveId()
    {
        return this.pickwaveId;
    }

    public void setPickwaveId(Long pickwaveId)
    {
        this.pickwaveId = pickwaveId;
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

    private PicklistRoleStateDto[] picklistRoles;

    public PicklistRoleStateDto[] getPicklistRoles()
    {
        return this.picklistRoles;
    }	

    public void setPicklistRoles(PicklistRoleStateDto[] picklistRoles)
    {
        this.picklistRoles = picklistRoles;
    }


    public static class DtoConverter extends AbstractStateDtoConverter
    {
        public static Collection<String> collectionFieldNames = Arrays.asList(new String[]{"PicklistRoles"});

        @Override
        protected boolean isCollectionField(String fieldName) {
            return CollectionUtils.collectionContainsIgnoringCase(collectionFieldNames, fieldName);
        }

        public PicklistStateDto[] toPicklistStateDtoArray(Iterable<PicklistState> states) 
        {
            ArrayList<PicklistStateDto> stateDtos = new ArrayList();
            for (PicklistState s : states) {
                PicklistStateDto dto = toPicklistStateDto(s);
                stateDtos.add(dto);
            }
            return stateDtos.toArray(new PicklistStateDto[0]);
        }

        public PicklistStateDto toPicklistStateDto(PicklistState state)
        {
            if(state == null) {
                return null;
            }
            PicklistStateDto dto = new PicklistStateDto();
            if (returnedFieldsContains("PicklistId")) {
                dto.setPicklistId(state.getPicklistId());
            }
            if (returnedFieldsContains("Description")) {
                dto.setDescription(state.getDescription());
            }
            if (returnedFieldsContains("FacilityId")) {
                dto.setFacilityId(state.getFacilityId());
            }
            if (returnedFieldsContains("ShipmentMethodTypeId")) {
                dto.setShipmentMethodTypeId(state.getShipmentMethodTypeId());
            }
            if (returnedFieldsContains("StatusId")) {
                dto.setStatusId(state.getStatusId());
            }
            if (returnedFieldsContains("PicklistDate")) {
                dto.setPicklistDate(state.getPicklistDate());
            }
            if (returnedFieldsContains("PickwaveId")) {
                dto.setPickwaveId(state.getPickwaveId());
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
            if (returnedFieldsContains("PicklistRoles")) {
                ArrayList<PicklistRoleStateDto> arrayList = new ArrayList();
                if (state.getPicklistRoles() != null) {
                    PicklistRoleStateDto.DtoConverter conv = new PicklistRoleStateDto.DtoConverter();
                    String returnFS = CollectionUtils.mapGetValueIgnoringCase(getReturnedFields(), "PicklistRoles");
                    if(returnFS != null) { conv.setReturnedFieldsString(returnFS); } else { conv.setAllFieldsReturned(this.getAllFieldsReturned()); }
                    for (PicklistRoleState s : state.getPicklistRoles()) {
                        arrayList.add(conv.toPicklistRoleStateDto(s));
                    }
                }
                dto.setPicklistRoles(arrayList.toArray(new PicklistRoleStateDto[0]));
            }
            return dto;
        }

    }
}

