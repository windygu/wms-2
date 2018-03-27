package org.dddml.wms.domain.picklistrolemvo;

import java.util.*;
import org.dddml.wms.domain.picklist.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;
import org.dddml.wms.domain.AbstractStateEvent;

public abstract class AbstractPicklistRoleMvoStateEvent extends AbstractStateEvent implements PicklistRoleMvoStateEvent 
{
    private PicklistRoleMvoEventId picklistRoleMvoEventId;

    public PicklistRoleMvoEventId getPicklistRoleMvoEventId() {
        return this.picklistRoleMvoEventId;
    }

    public void setPicklistRoleMvoEventId(PicklistRoleMvoEventId eventId) {
        this.picklistRoleMvoEventId = eventId;
    }
    
    public PicklistRoleId getPicklistRoleId() {
        return getPicklistRoleMvoEventId().getPicklistRoleId();
    }

    public void setPicklistRoleId(PicklistRoleId picklistRoleId) {
        getPicklistRoleMvoEventId().setPicklistRoleId(picklistRoleId);
    }

    private boolean stateEventReadOnly;

    public boolean getStateEventReadOnly() { return this.stateEventReadOnly; }

    public void setStateEventReadOnly(boolean readOnly) { this.stateEventReadOnly = readOnly; }

    private String createdByUserLogin;

    public String getCreatedByUserLogin()
    {
        return this.createdByUserLogin;
    }

    public void setCreatedByUserLogin(String createdByUserLogin)
    {
        this.createdByUserLogin = createdByUserLogin;
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

    private Date createdAt;

    public Date getCreatedAt()
    {
        return this.createdAt;
    }

    public void setCreatedAt(Date createdAt)
    {
        this.createdAt = createdAt;
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


    private String commandId;

    public String getCommandId() {
        return commandId;
    }

    public void setCommandId(String commandId) {
        this.commandId = commandId;
    }

    protected AbstractPicklistRoleMvoStateEvent() {
    }

    protected AbstractPicklistRoleMvoStateEvent(PicklistRoleMvoEventId eventId) {
        this.picklistRoleMvoEventId = eventId;
    }


    public abstract String getStateEventType();


    public static abstract class AbstractPicklistRoleMvoStateCreated extends AbstractPicklistRoleMvoStateEvent implements PicklistRoleMvoStateEvent.PicklistRoleMvoStateCreated
    {
        public AbstractPicklistRoleMvoStateCreated() {
            this(new PicklistRoleMvoEventId());
        }

        public AbstractPicklistRoleMvoStateCreated(PicklistRoleMvoEventId eventId) {
            super(eventId);
        }

        public String getStateEventType() {
            return StateEventType.CREATED;
        }

    }


    public static abstract class AbstractPicklistRoleMvoStateMergePatched extends AbstractPicklistRoleMvoStateEvent implements PicklistRoleMvoStateEvent.PicklistRoleMvoStateMergePatched
    {
        public AbstractPicklistRoleMvoStateMergePatched() {
            this(new PicklistRoleMvoEventId());
        }

        public AbstractPicklistRoleMvoStateMergePatched(PicklistRoleMvoEventId eventId) {
            super(eventId);
        }

        public String getStateEventType() {
            return StateEventType.MERGE_PATCHED;
        }

        private Boolean isPropertyVersionRemoved;

        public Boolean getIsPropertyVersionRemoved() {
            return this.isPropertyVersionRemoved;
        }

        public void setIsPropertyVersionRemoved(Boolean removed) {
            this.isPropertyVersionRemoved = removed;
        }

        private Boolean isPropertyActiveRemoved;

        public Boolean getIsPropertyActiveRemoved() {
            return this.isPropertyActiveRemoved;
        }

        public void setIsPropertyActiveRemoved(Boolean removed) {
            this.isPropertyActiveRemoved = removed;
        }

        private Boolean isPropertyPicklistDescriptionRemoved;

        public Boolean getIsPropertyPicklistDescriptionRemoved() {
            return this.isPropertyPicklistDescriptionRemoved;
        }

        public void setIsPropertyPicklistDescriptionRemoved(Boolean removed) {
            this.isPropertyPicklistDescriptionRemoved = removed;
        }

        private Boolean isPropertyPicklistFacilityIdRemoved;

        public Boolean getIsPropertyPicklistFacilityIdRemoved() {
            return this.isPropertyPicklistFacilityIdRemoved;
        }

        public void setIsPropertyPicklistFacilityIdRemoved(Boolean removed) {
            this.isPropertyPicklistFacilityIdRemoved = removed;
        }

        private Boolean isPropertyPicklistShipmentMethodTypeIdRemoved;

        public Boolean getIsPropertyPicklistShipmentMethodTypeIdRemoved() {
            return this.isPropertyPicklistShipmentMethodTypeIdRemoved;
        }

        public void setIsPropertyPicklistShipmentMethodTypeIdRemoved(Boolean removed) {
            this.isPropertyPicklistShipmentMethodTypeIdRemoved = removed;
        }

        private Boolean isPropertyPicklistStatusIdRemoved;

        public Boolean getIsPropertyPicklistStatusIdRemoved() {
            return this.isPropertyPicklistStatusIdRemoved;
        }

        public void setIsPropertyPicklistStatusIdRemoved(Boolean removed) {
            this.isPropertyPicklistStatusIdRemoved = removed;
        }

        private Boolean isPropertyPicklistPicklistDateRemoved;

        public Boolean getIsPropertyPicklistPicklistDateRemoved() {
            return this.isPropertyPicklistPicklistDateRemoved;
        }

        public void setIsPropertyPicklistPicklistDateRemoved(Boolean removed) {
            this.isPropertyPicklistPicklistDateRemoved = removed;
        }

        private Boolean isPropertyPicklistCreatedByUserLoginRemoved;

        public Boolean getIsPropertyPicklistCreatedByUserLoginRemoved() {
            return this.isPropertyPicklistCreatedByUserLoginRemoved;
        }

        public void setIsPropertyPicklistCreatedByUserLoginRemoved(Boolean removed) {
            this.isPropertyPicklistCreatedByUserLoginRemoved = removed;
        }

        private Boolean isPropertyPicklistLastModifiedByUserLoginRemoved;

        public Boolean getIsPropertyPicklistLastModifiedByUserLoginRemoved() {
            return this.isPropertyPicklistLastModifiedByUserLoginRemoved;
        }

        public void setIsPropertyPicklistLastModifiedByUserLoginRemoved(Boolean removed) {
            this.isPropertyPicklistLastModifiedByUserLoginRemoved = removed;
        }

        private Boolean isPropertyPicklistCreatedAtRemoved;

        public Boolean getIsPropertyPicklistCreatedAtRemoved() {
            return this.isPropertyPicklistCreatedAtRemoved;
        }

        public void setIsPropertyPicklistCreatedAtRemoved(Boolean removed) {
            this.isPropertyPicklistCreatedAtRemoved = removed;
        }

        private Boolean isPropertyPicklistUpdatedAtRemoved;

        public Boolean getIsPropertyPicklistUpdatedAtRemoved() {
            return this.isPropertyPicklistUpdatedAtRemoved;
        }

        public void setIsPropertyPicklistUpdatedAtRemoved(Boolean removed) {
            this.isPropertyPicklistUpdatedAtRemoved = removed;
        }

        private Boolean isPropertyPicklistActiveRemoved;

        public Boolean getIsPropertyPicklistActiveRemoved() {
            return this.isPropertyPicklistActiveRemoved;
        }

        public void setIsPropertyPicklistActiveRemoved(Boolean removed) {
            this.isPropertyPicklistActiveRemoved = removed;
        }

        private Boolean isPropertyPicklistDeletedRemoved;

        public Boolean getIsPropertyPicklistDeletedRemoved() {
            return this.isPropertyPicklistDeletedRemoved;
        }

        public void setIsPropertyPicklistDeletedRemoved(Boolean removed) {
            this.isPropertyPicklistDeletedRemoved = removed;
        }

    }


    public static abstract class AbstractPicklistRoleMvoStateDeleted extends AbstractPicklistRoleMvoStateEvent implements PicklistRoleMvoStateEvent.PicklistRoleMvoStateDeleted
    {
        public AbstractPicklistRoleMvoStateDeleted() {
            this(new PicklistRoleMvoEventId());
        }

        public AbstractPicklistRoleMvoStateDeleted(PicklistRoleMvoEventId eventId) {
            super(eventId);
        }

        public String getStateEventType() {
            return StateEventType.DELETED;
        }

    }
    public static class SimplePicklistRoleMvoStateCreated extends AbstractPicklistRoleMvoStateCreated
    {
        public SimplePicklistRoleMvoStateCreated() {
        }

        public SimplePicklistRoleMvoStateCreated(PicklistRoleMvoEventId eventId) {
            super(eventId);
        }
    }

    public static class SimplePicklistRoleMvoStateMergePatched extends AbstractPicklistRoleMvoStateMergePatched
    {
        public SimplePicklistRoleMvoStateMergePatched() {
        }

        public SimplePicklistRoleMvoStateMergePatched(PicklistRoleMvoEventId eventId) {
            super(eventId);
        }
    }

    public static class SimplePicklistRoleMvoStateDeleted extends AbstractPicklistRoleMvoStateDeleted
    {
        public SimplePicklistRoleMvoStateDeleted() {
        }

        public SimplePicklistRoleMvoStateDeleted(PicklistRoleMvoEventId eventId) {
            super(eventId);
        }
    }

}

