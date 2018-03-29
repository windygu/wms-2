package org.dddml.wms.domain.picklistrolemvo;

import java.util.*;
import org.dddml.wms.domain.picklist.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.domain.AbstractCommand;

public abstract class AbstractPicklistRoleMvoCommand extends AbstractCommand implements PicklistRoleMvoCommand
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

    private Long picklistVersion;

    public Long getPicklistVersion()
    {
        return this.picklistVersion;
    }

    public void setPicklistVersion(Long picklistVersion)
    {
        this.picklistVersion = picklistVersion;
    }


    public static abstract class AbstractCreateOrMergePatchPicklistRoleMvo extends AbstractPicklistRoleMvoCommand implements CreateOrMergePatchPicklistRoleMvo
    {
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

        private Long picklistPickwaveId;

        public Long getPicklistPickwaveId()
        {
            return this.picklistPickwaveId;
        }

        public void setPicklistPickwaveId(Long picklistPickwaveId)
        {
            this.picklistPickwaveId = picklistPickwaveId;
        }

        private String picklistCreatedBy;

        public String getPicklistCreatedBy()
        {
            return this.picklistCreatedBy;
        }

        public void setPicklistCreatedBy(String picklistCreatedBy)
        {
            this.picklistCreatedBy = picklistCreatedBy;
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

        private String picklistUpdatedBy;

        public String getPicklistUpdatedBy()
        {
            return this.picklistUpdatedBy;
        }

        public void setPicklistUpdatedBy(String picklistUpdatedBy)
        {
            this.picklistUpdatedBy = picklistUpdatedBy;
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

    }

    public static abstract class AbstractCreatePicklistRoleMvo extends AbstractCreateOrMergePatchPicklistRoleMvo implements CreatePicklistRoleMvo
    {
        @Override
        public String getCommandType() {
            return COMMAND_TYPE_CREATE;
        }

    }

    public static abstract class AbstractMergePatchPicklistRoleMvo extends AbstractCreateOrMergePatchPicklistRoleMvo implements MergePatchPicklistRoleMvo
    {
        @Override
        public String getCommandType() {
            return COMMAND_TYPE_MERGE_PATCH;
        }

        private Boolean isPropertyVersionRemoved;

        public Boolean getIsPropertyVersionRemoved()
        {
            return this.isPropertyVersionRemoved;
        }

        public void setIsPropertyVersionRemoved(Boolean removed)
        {
            this.isPropertyVersionRemoved = removed;
        }

        private Boolean isPropertyActiveRemoved;

        public Boolean getIsPropertyActiveRemoved()
        {
            return this.isPropertyActiveRemoved;
        }

        public void setIsPropertyActiveRemoved(Boolean removed)
        {
            this.isPropertyActiveRemoved = removed;
        }

        private Boolean isPropertyPicklistDescriptionRemoved;

        public Boolean getIsPropertyPicklistDescriptionRemoved()
        {
            return this.isPropertyPicklistDescriptionRemoved;
        }

        public void setIsPropertyPicklistDescriptionRemoved(Boolean removed)
        {
            this.isPropertyPicklistDescriptionRemoved = removed;
        }

        private Boolean isPropertyPicklistFacilityIdRemoved;

        public Boolean getIsPropertyPicklistFacilityIdRemoved()
        {
            return this.isPropertyPicklistFacilityIdRemoved;
        }

        public void setIsPropertyPicklistFacilityIdRemoved(Boolean removed)
        {
            this.isPropertyPicklistFacilityIdRemoved = removed;
        }

        private Boolean isPropertyPicklistShipmentMethodTypeIdRemoved;

        public Boolean getIsPropertyPicklistShipmentMethodTypeIdRemoved()
        {
            return this.isPropertyPicklistShipmentMethodTypeIdRemoved;
        }

        public void setIsPropertyPicklistShipmentMethodTypeIdRemoved(Boolean removed)
        {
            this.isPropertyPicklistShipmentMethodTypeIdRemoved = removed;
        }

        private Boolean isPropertyPicklistStatusIdRemoved;

        public Boolean getIsPropertyPicklistStatusIdRemoved()
        {
            return this.isPropertyPicklistStatusIdRemoved;
        }

        public void setIsPropertyPicklistStatusIdRemoved(Boolean removed)
        {
            this.isPropertyPicklistStatusIdRemoved = removed;
        }

        private Boolean isPropertyPicklistPicklistDateRemoved;

        public Boolean getIsPropertyPicklistPicklistDateRemoved()
        {
            return this.isPropertyPicklistPicklistDateRemoved;
        }

        public void setIsPropertyPicklistPicklistDateRemoved(Boolean removed)
        {
            this.isPropertyPicklistPicklistDateRemoved = removed;
        }

        private Boolean isPropertyPicklistPickwaveIdRemoved;

        public Boolean getIsPropertyPicklistPickwaveIdRemoved()
        {
            return this.isPropertyPicklistPickwaveIdRemoved;
        }

        public void setIsPropertyPicklistPickwaveIdRemoved(Boolean removed)
        {
            this.isPropertyPicklistPickwaveIdRemoved = removed;
        }

        private Boolean isPropertyPicklistCreatedByRemoved;

        public Boolean getIsPropertyPicklistCreatedByRemoved()
        {
            return this.isPropertyPicklistCreatedByRemoved;
        }

        public void setIsPropertyPicklistCreatedByRemoved(Boolean removed)
        {
            this.isPropertyPicklistCreatedByRemoved = removed;
        }

        private Boolean isPropertyPicklistCreatedAtRemoved;

        public Boolean getIsPropertyPicklistCreatedAtRemoved()
        {
            return this.isPropertyPicklistCreatedAtRemoved;
        }

        public void setIsPropertyPicklistCreatedAtRemoved(Boolean removed)
        {
            this.isPropertyPicklistCreatedAtRemoved = removed;
        }

        private Boolean isPropertyPicklistUpdatedByRemoved;

        public Boolean getIsPropertyPicklistUpdatedByRemoved()
        {
            return this.isPropertyPicklistUpdatedByRemoved;
        }

        public void setIsPropertyPicklistUpdatedByRemoved(Boolean removed)
        {
            this.isPropertyPicklistUpdatedByRemoved = removed;
        }

        private Boolean isPropertyPicklistUpdatedAtRemoved;

        public Boolean getIsPropertyPicklistUpdatedAtRemoved()
        {
            return this.isPropertyPicklistUpdatedAtRemoved;
        }

        public void setIsPropertyPicklistUpdatedAtRemoved(Boolean removed)
        {
            this.isPropertyPicklistUpdatedAtRemoved = removed;
        }

        private Boolean isPropertyPicklistActiveRemoved;

        public Boolean getIsPropertyPicklistActiveRemoved()
        {
            return this.isPropertyPicklistActiveRemoved;
        }

        public void setIsPropertyPicklistActiveRemoved(Boolean removed)
        {
            this.isPropertyPicklistActiveRemoved = removed;
        }

        private Boolean isPropertyPicklistDeletedRemoved;

        public Boolean getIsPropertyPicklistDeletedRemoved()
        {
            return this.isPropertyPicklistDeletedRemoved;
        }

        public void setIsPropertyPicklistDeletedRemoved(Boolean removed)
        {
            this.isPropertyPicklistDeletedRemoved = removed;
        }

    }

    public static class SimpleCreatePicklistRoleMvo extends AbstractCreatePicklistRoleMvo
    {
    }

    
    public static class SimpleMergePatchPicklistRoleMvo extends AbstractMergePatchPicklistRoleMvo
    {
    }

    
	public static class SimpleDeletePicklistRoleMvo extends AbstractPicklistRoleMvoCommand implements DeletePicklistRoleMvo
	{
        @Override
        public String getCommandType() {
            return COMMAND_TYPE_DELETE;
        }
	}

    

}

