package org.dddml.wms.domain.picklistrolemvo;

import java.util.*;
import org.dddml.wms.domain.picklist.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;


public class PicklistRoleMvoStateDto
{

    private PicklistRoleId picklistRoleId;

    public PicklistRoleId getPicklistRoleId()
    {
        return this.picklistRoleId;
    }

    public void setPicklistRoleId(PicklistRoleId picklistRoleId)
    {
        this.picklistRoleId = picklistRoleId;
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

    private String picklistDescription;

    public String getPicklistDescription()
    {
        return this.picklistDescription;
    }

    public void setPicklistDescription(String picklistDescription)
    {
        this.picklistDescription = picklistDescription;
    }

    private String picklistFacilityId;

    public String getPicklistFacilityId()
    {
        return this.picklistFacilityId;
    }

    public void setPicklistFacilityId(String picklistFacilityId)
    {
        this.picklistFacilityId = picklistFacilityId;
    }

    private String picklistShipmentMethodTypeId;

    public String getPicklistShipmentMethodTypeId()
    {
        return this.picklistShipmentMethodTypeId;
    }

    public void setPicklistShipmentMethodTypeId(String picklistShipmentMethodTypeId)
    {
        this.picklistShipmentMethodTypeId = picklistShipmentMethodTypeId;
    }

    private String picklistStatusId;

    public String getPicklistStatusId()
    {
        return this.picklistStatusId;
    }

    public void setPicklistStatusId(String picklistStatusId)
    {
        this.picklistStatusId = picklistStatusId;
    }

    private java.sql.Timestamp picklistPicklistDate;

    public java.sql.Timestamp getPicklistPicklistDate()
    {
        return this.picklistPicklistDate;
    }

    public void setPicklistPicklistDate(java.sql.Timestamp picklistPicklistDate)
    {
        this.picklistPicklistDate = picklistPicklistDate;
    }

    private String picklistCreatedByUserLogin;

    public String getPicklistCreatedByUserLogin()
    {
        return this.picklistCreatedByUserLogin;
    }

    public void setPicklistCreatedByUserLogin(String picklistCreatedByUserLogin)
    {
        this.picklistCreatedByUserLogin = picklistCreatedByUserLogin;
    }

    private String picklistLastModifiedByUserLogin;

    public String getPicklistLastModifiedByUserLogin()
    {
        return this.picklistLastModifiedByUserLogin;
    }

    public void setPicklistLastModifiedByUserLogin(String picklistLastModifiedByUserLogin)
    {
        this.picklistLastModifiedByUserLogin = picklistLastModifiedByUserLogin;
    }

    private Long picklistPickwaveId;

    public Long getPicklistPickwaveId()
    {
        return this.picklistPickwaveId;
    }

    public void setPicklistPickwaveId(Long picklistPickwaveId)
    {
        this.picklistPickwaveId = picklistPickwaveId;
    }

    private Date picklistCreatedAt;

    public Date getPicklistCreatedAt()
    {
        return this.picklistCreatedAt;
    }

    public void setPicklistCreatedAt(Date picklistCreatedAt)
    {
        this.picklistCreatedAt = picklistCreatedAt;
    }

    private Date picklistUpdatedAt;

    public Date getPicklistUpdatedAt()
    {
        return this.picklistUpdatedAt;
    }

    public void setPicklistUpdatedAt(Date picklistUpdatedAt)
    {
        this.picklistUpdatedAt = picklistUpdatedAt;
    }

    private Boolean picklistActive;

    public Boolean getPicklistActive()
    {
        return this.picklistActive;
    }

    public void setPicklistActive(Boolean picklistActive)
    {
        this.picklistActive = picklistActive;
    }

    private Boolean picklistDeleted;

    public Boolean getPicklistDeleted()
    {
        return this.picklistDeleted;
    }

    public void setPicklistDeleted(Boolean picklistDeleted)
    {
        this.picklistDeleted = picklistDeleted;
    }

    private Long picklistVersion;

    public Long getPicklistVersion()
    {
        return this.picklistVersion;
    }

    public void setPicklistVersion(Long picklistVersion)
    {
        this.picklistVersion = picklistVersion;
    }

    private String createdByUserLogin;

    public String getCreatedByUserLogin()
    {
        return this.createdByUserLogin;
    }

    public void setCreatedByUserLogin(String createdByUserLogin)
    {
        this.createdByUserLogin = createdByUserLogin;
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

    private String lastModifiedByUserLogin;

    public String getLastModifiedByUserLogin()
    {
        return this.lastModifiedByUserLogin;
    }

    public void setLastModifiedByUserLogin(String lastModifiedByUserLogin)
    {
        this.lastModifiedByUserLogin = lastModifiedByUserLogin;
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

        public PicklistRoleMvoStateDto[] toPicklistRoleMvoStateDtoArray(Iterable<PicklistRoleMvoState> states) 
        {
            ArrayList<PicklistRoleMvoStateDto> stateDtos = new ArrayList();
            for (PicklistRoleMvoState s : states) {
                PicklistRoleMvoStateDto dto = toPicklistRoleMvoStateDto(s);
                stateDtos.add(dto);
            }
            return stateDtos.toArray(new PicklistRoleMvoStateDto[0]);
        }

        public PicklistRoleMvoStateDto toPicklistRoleMvoStateDto(PicklistRoleMvoState state)
        {
            if(state == null) {
                return null;
            }
            PicklistRoleMvoStateDto dto = new PicklistRoleMvoStateDto();
            if (returnedFieldsContains("PicklistRoleId")) {
                dto.setPicklistRoleId(state.getPicklistRoleId());
            }
            if (returnedFieldsContains("Version")) {
                dto.setVersion(state.getVersion());
            }
            if (returnedFieldsContains("Active")) {
                dto.setActive(state.getActive());
            }
            if (returnedFieldsContains("PicklistDescription")) {
                dto.setPicklistDescription(state.getPicklistDescription());
            }
            if (returnedFieldsContains("PicklistFacilityId")) {
                dto.setPicklistFacilityId(state.getPicklistFacilityId());
            }
            if (returnedFieldsContains("PicklistShipmentMethodTypeId")) {
                dto.setPicklistShipmentMethodTypeId(state.getPicklistShipmentMethodTypeId());
            }
            if (returnedFieldsContains("PicklistStatusId")) {
                dto.setPicklistStatusId(state.getPicklistStatusId());
            }
            if (returnedFieldsContains("PicklistPicklistDate")) {
                dto.setPicklistPicklistDate(state.getPicklistPicklistDate());
            }
            if (returnedFieldsContains("PicklistCreatedByUserLogin")) {
                dto.setPicklistCreatedByUserLogin(state.getPicklistCreatedByUserLogin());
            }
            if (returnedFieldsContains("PicklistLastModifiedByUserLogin")) {
                dto.setPicklistLastModifiedByUserLogin(state.getPicklistLastModifiedByUserLogin());
            }
            if (returnedFieldsContains("PicklistPickwaveId")) {
                dto.setPicklistPickwaveId(state.getPicklistPickwaveId());
            }
            if (returnedFieldsContains("PicklistCreatedAt")) {
                dto.setPicklistCreatedAt(state.getPicklistCreatedAt());
            }
            if (returnedFieldsContains("PicklistUpdatedAt")) {
                dto.setPicklistUpdatedAt(state.getPicklistUpdatedAt());
            }
            if (returnedFieldsContains("PicklistActive")) {
                dto.setPicklistActive(state.getPicklistActive());
            }
            if (returnedFieldsContains("PicklistDeleted")) {
                dto.setPicklistDeleted(state.getPicklistDeleted());
            }
            if (returnedFieldsContains("PicklistVersion")) {
                dto.setPicklistVersion(state.getPicklistVersion());
            }
            if (returnedFieldsContains("CreatedByUserLogin")) {
                dto.setCreatedByUserLogin(state.getCreatedByUserLogin());
            }
            if (returnedFieldsContains("CreatedAt")) {
                dto.setCreatedAt(state.getCreatedAt());
            }
            if (returnedFieldsContains("LastModifiedByUserLogin")) {
                dto.setLastModifiedByUserLogin(state.getLastModifiedByUserLogin());
            }
            if (returnedFieldsContains("UpdatedAt")) {
                dto.setUpdatedAt(state.getUpdatedAt());
            }
            return dto;
        }

    }
}

