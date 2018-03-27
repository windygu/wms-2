package org.dddml.wms.domain.picklist;

import java.util.*;
import org.dddml.wms.domain.partyrole.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;


public class PicklistRoleStateDto
{

    private PartyRoleId partyRoleId;

    public PartyRoleId getPartyRoleId()
    {
        return this.partyRoleId;
    }

    public void setPartyRoleId(PartyRoleId partyRoleId)
    {
        this.partyRoleId = partyRoleId;
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

    private String picklistId;

    public String getPicklistId()
    {
        return this.picklistId;
    }

    public void setPicklistId(String picklistId)
    {
        this.picklistId = picklistId;
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

        public PicklistRoleStateDto[] toPicklistRoleStateDtoArray(Iterable<PicklistRoleState> states) 
        {
            ArrayList<PicklistRoleStateDto> stateDtos = new ArrayList();
            for (PicklistRoleState s : states) {
                PicklistRoleStateDto dto = toPicklistRoleStateDto(s);
                stateDtos.add(dto);
            }
            return stateDtos.toArray(new PicklistRoleStateDto[0]);
        }

        public PicklistRoleStateDto toPicklistRoleStateDto(PicklistRoleState state)
        {
            if(state == null) {
                return null;
            }
            PicklistRoleStateDto dto = new PicklistRoleStateDto();
            if (returnedFieldsContains("PartyRoleId")) {
                dto.setPartyRoleId(state.getPartyRoleId());
            }
            if (returnedFieldsContains("Active")) {
                dto.setActive(state.getActive());
            }
            if (returnedFieldsContains("Version")) {
                dto.setVersion(state.getVersion());
            }
            if (returnedFieldsContains("PicklistId")) {
                dto.setPicklistId(state.getPicklistId());
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

