package org.dddml.wms.domain;

import java.util.*;
import java.util.Date;
import org.dddml.wms.specialization.*;

public abstract class AbstractMonthPlanMvoStateEvent extends AbstractStateEvent implements MonthPlanMvoStateEvent 
{
    private MonthPlanMvoStateEventId stateEventId;

    public MonthPlanMvoStateEventId getStateEventId() {
        return this.stateEventId;
    }

    public void setStateEventId(MonthPlanMvoStateEventId stateEventId) {
        this.stateEventId = stateEventId;
    }
    
    private boolean stateEventReadOnly;

    public boolean getStateEventReadOnly() { return this.stateEventReadOnly; }

    public void setStateEventReadOnly(boolean readOnly) { this.stateEventReadOnly = readOnly; }

    private String description;

    public String getDescription()
    {
        return this.description;
    }

    public void setDescription(String description)
    {
        this.description = description;
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

    private Boolean active;

    public Boolean getActive()
    {
        return this.active;
    }

    public void setActive(Boolean active)
    {
        this.active = active;
    }

    private String yearPlanDescription;

    public String getYearPlanDescription()
    {
        return this.yearPlanDescription;
    }

    public void setYearPlanDescription(String yearPlanDescription)
    {
        this.yearPlanDescription = yearPlanDescription;
    }

    private Long yearPlanVersion;

    public Long getYearPlanVersion()
    {
        return this.yearPlanVersion;
    }

    public void setYearPlanVersion(Long yearPlanVersion)
    {
        this.yearPlanVersion = yearPlanVersion;
    }

    private String yearPlanCreatedBy;

    public String getYearPlanCreatedBy()
    {
        return this.yearPlanCreatedBy;
    }

    public void setYearPlanCreatedBy(String yearPlanCreatedBy)
    {
        this.yearPlanCreatedBy = yearPlanCreatedBy;
    }

    private Date yearPlanCreatedAt;

    public Date getYearPlanCreatedAt()
    {
        return this.yearPlanCreatedAt;
    }

    public void setYearPlanCreatedAt(Date yearPlanCreatedAt)
    {
        this.yearPlanCreatedAt = yearPlanCreatedAt;
    }

    private String yearPlanUpdatedBy;

    public String getYearPlanUpdatedBy()
    {
        return this.yearPlanUpdatedBy;
    }

    public void setYearPlanUpdatedBy(String yearPlanUpdatedBy)
    {
        this.yearPlanUpdatedBy = yearPlanUpdatedBy;
    }

    private Date yearPlanUpdatedAt;

    public Date getYearPlanUpdatedAt()
    {
        return this.yearPlanUpdatedAt;
    }

    public void setYearPlanUpdatedAt(Date yearPlanUpdatedAt)
    {
        this.yearPlanUpdatedAt = yearPlanUpdatedAt;
    }

    private Boolean yearPlanActive;

    public Boolean getYearPlanActive()
    {
        return this.yearPlanActive;
    }

    public void setYearPlanActive(Boolean yearPlanActive)
    {
        this.yearPlanActive = yearPlanActive;
    }

    private Boolean yearPlanDeleted;

    public Boolean getYearPlanDeleted()
    {
        return this.yearPlanDeleted;
    }

    public void setYearPlanDeleted(Boolean yearPlanDeleted)
    {
        this.yearPlanDeleted = yearPlanDeleted;
    }

    private Date personBirthDate;

    public Date getPersonBirthDate()
    {
        return this.personBirthDate;
    }

    public void setPersonBirthDate(Date personBirthDate)
    {
        this.personBirthDate = personBirthDate;
    }

    private PersonalName personLoves;

    public PersonalName getPersonLoves()
    {
        return this.personLoves;
    }

    public void setPersonLoves(PersonalName personLoves)
    {
        this.personLoves = personLoves;
    }

    private Contact personEmergencyContact;

    public Contact getPersonEmergencyContact()
    {
        return this.personEmergencyContact;
    }

    public void setPersonEmergencyContact(Contact personEmergencyContact)
    {
        this.personEmergencyContact = personEmergencyContact;
    }

    private String personCreatedBy;

    public String getPersonCreatedBy()
    {
        return this.personCreatedBy;
    }

    public void setPersonCreatedBy(String personCreatedBy)
    {
        this.personCreatedBy = personCreatedBy;
    }

    private Date personCreatedAt;

    public Date getPersonCreatedAt()
    {
        return this.personCreatedAt;
    }

    public void setPersonCreatedAt(Date personCreatedAt)
    {
        this.personCreatedAt = personCreatedAt;
    }

    private String personUpdatedBy;

    public String getPersonUpdatedBy()
    {
        return this.personUpdatedBy;
    }

    public void setPersonUpdatedBy(String personUpdatedBy)
    {
        this.personUpdatedBy = personUpdatedBy;
    }

    private Date personUpdatedAt;

    public Date getPersonUpdatedAt()
    {
        return this.personUpdatedAt;
    }

    public void setPersonUpdatedAt(Date personUpdatedAt)
    {
        this.personUpdatedAt = personUpdatedAt;
    }

    private Boolean personActive;

    public Boolean getPersonActive()
    {
        return this.personActive;
    }

    public void setPersonActive(Boolean personActive)
    {
        this.personActive = personActive;
    }

    private Boolean personDeleted;

    public Boolean getPersonDeleted()
    {
        return this.personDeleted;
    }

    public void setPersonDeleted(Boolean personDeleted)
    {
        this.personDeleted = personDeleted;
    }


    private String commandId;

    public String getCommandId() {
        return commandId;
    }

    public void setCommandId(String commandId) {
        this.commandId = commandId;
    }

    protected AbstractMonthPlanMvoStateEvent() {
    }

    protected AbstractMonthPlanMvoStateEvent(MonthPlanMvoStateEventId stateEventId) {
        this.stateEventId = stateEventId;
    }


    public abstract String getStateEventType();


    public static abstract class AbstractMonthPlanMvoStateCreated extends AbstractMonthPlanMvoStateEvent implements MonthPlanMvoStateCreated
    {
        public AbstractMonthPlanMvoStateCreated() {
        }

        public AbstractMonthPlanMvoStateCreated(MonthPlanMvoStateEventId stateEventId) {
            super(stateEventId);
        }

        public String getStateEventType() {
            return StateEventType.CREATED;
        }

    }


    public static abstract class AbstractMonthPlanMvoStateMergePatched extends AbstractMonthPlanMvoStateEvent implements MonthPlanMvoStateMergePatched
    {
        public AbstractMonthPlanMvoStateMergePatched() {
        }

        public AbstractMonthPlanMvoStateMergePatched(MonthPlanMvoStateEventId stateEventId) {
            super(stateEventId);
        }

        public String getStateEventType() {
            return StateEventType.MERGE_PATCHED;
        }

        private Boolean isPropertyDescriptionRemoved;

        public Boolean getIsPropertyDescriptionRemoved() {
            return this.isPropertyDescriptionRemoved;
        }

        public void setIsPropertyDescriptionRemoved(Boolean removed) {
            this.isPropertyDescriptionRemoved = removed;
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

        private Boolean isPropertyYearPlanDescriptionRemoved;

        public Boolean getIsPropertyYearPlanDescriptionRemoved() {
            return this.isPropertyYearPlanDescriptionRemoved;
        }

        public void setIsPropertyYearPlanDescriptionRemoved(Boolean removed) {
            this.isPropertyYearPlanDescriptionRemoved = removed;
        }

        private Boolean isPropertyYearPlanVersionRemoved;

        public Boolean getIsPropertyYearPlanVersionRemoved() {
            return this.isPropertyYearPlanVersionRemoved;
        }

        public void setIsPropertyYearPlanVersionRemoved(Boolean removed) {
            this.isPropertyYearPlanVersionRemoved = removed;
        }

        private Boolean isPropertyYearPlanCreatedByRemoved;

        public Boolean getIsPropertyYearPlanCreatedByRemoved() {
            return this.isPropertyYearPlanCreatedByRemoved;
        }

        public void setIsPropertyYearPlanCreatedByRemoved(Boolean removed) {
            this.isPropertyYearPlanCreatedByRemoved = removed;
        }

        private Boolean isPropertyYearPlanCreatedAtRemoved;

        public Boolean getIsPropertyYearPlanCreatedAtRemoved() {
            return this.isPropertyYearPlanCreatedAtRemoved;
        }

        public void setIsPropertyYearPlanCreatedAtRemoved(Boolean removed) {
            this.isPropertyYearPlanCreatedAtRemoved = removed;
        }

        private Boolean isPropertyYearPlanUpdatedByRemoved;

        public Boolean getIsPropertyYearPlanUpdatedByRemoved() {
            return this.isPropertyYearPlanUpdatedByRemoved;
        }

        public void setIsPropertyYearPlanUpdatedByRemoved(Boolean removed) {
            this.isPropertyYearPlanUpdatedByRemoved = removed;
        }

        private Boolean isPropertyYearPlanUpdatedAtRemoved;

        public Boolean getIsPropertyYearPlanUpdatedAtRemoved() {
            return this.isPropertyYearPlanUpdatedAtRemoved;
        }

        public void setIsPropertyYearPlanUpdatedAtRemoved(Boolean removed) {
            this.isPropertyYearPlanUpdatedAtRemoved = removed;
        }

        private Boolean isPropertyYearPlanActiveRemoved;

        public Boolean getIsPropertyYearPlanActiveRemoved() {
            return this.isPropertyYearPlanActiveRemoved;
        }

        public void setIsPropertyYearPlanActiveRemoved(Boolean removed) {
            this.isPropertyYearPlanActiveRemoved = removed;
        }

        private Boolean isPropertyYearPlanDeletedRemoved;

        public Boolean getIsPropertyYearPlanDeletedRemoved() {
            return this.isPropertyYearPlanDeletedRemoved;
        }

        public void setIsPropertyYearPlanDeletedRemoved(Boolean removed) {
            this.isPropertyYearPlanDeletedRemoved = removed;
        }

        private Boolean isPropertyPersonBirthDateRemoved;

        public Boolean getIsPropertyPersonBirthDateRemoved() {
            return this.isPropertyPersonBirthDateRemoved;
        }

        public void setIsPropertyPersonBirthDateRemoved(Boolean removed) {
            this.isPropertyPersonBirthDateRemoved = removed;
        }

        private Boolean isPropertyPersonLovesRemoved;

        public Boolean getIsPropertyPersonLovesRemoved() {
            return this.isPropertyPersonLovesRemoved;
        }

        public void setIsPropertyPersonLovesRemoved(Boolean removed) {
            this.isPropertyPersonLovesRemoved = removed;
        }

        private Boolean isPropertyPersonEmergencyContactRemoved;

        public Boolean getIsPropertyPersonEmergencyContactRemoved() {
            return this.isPropertyPersonEmergencyContactRemoved;
        }

        public void setIsPropertyPersonEmergencyContactRemoved(Boolean removed) {
            this.isPropertyPersonEmergencyContactRemoved = removed;
        }

        private Boolean isPropertyPersonCreatedByRemoved;

        public Boolean getIsPropertyPersonCreatedByRemoved() {
            return this.isPropertyPersonCreatedByRemoved;
        }

        public void setIsPropertyPersonCreatedByRemoved(Boolean removed) {
            this.isPropertyPersonCreatedByRemoved = removed;
        }

        private Boolean isPropertyPersonCreatedAtRemoved;

        public Boolean getIsPropertyPersonCreatedAtRemoved() {
            return this.isPropertyPersonCreatedAtRemoved;
        }

        public void setIsPropertyPersonCreatedAtRemoved(Boolean removed) {
            this.isPropertyPersonCreatedAtRemoved = removed;
        }

        private Boolean isPropertyPersonUpdatedByRemoved;

        public Boolean getIsPropertyPersonUpdatedByRemoved() {
            return this.isPropertyPersonUpdatedByRemoved;
        }

        public void setIsPropertyPersonUpdatedByRemoved(Boolean removed) {
            this.isPropertyPersonUpdatedByRemoved = removed;
        }

        private Boolean isPropertyPersonUpdatedAtRemoved;

        public Boolean getIsPropertyPersonUpdatedAtRemoved() {
            return this.isPropertyPersonUpdatedAtRemoved;
        }

        public void setIsPropertyPersonUpdatedAtRemoved(Boolean removed) {
            this.isPropertyPersonUpdatedAtRemoved = removed;
        }

        private Boolean isPropertyPersonActiveRemoved;

        public Boolean getIsPropertyPersonActiveRemoved() {
            return this.isPropertyPersonActiveRemoved;
        }

        public void setIsPropertyPersonActiveRemoved(Boolean removed) {
            this.isPropertyPersonActiveRemoved = removed;
        }

        private Boolean isPropertyPersonDeletedRemoved;

        public Boolean getIsPropertyPersonDeletedRemoved() {
            return this.isPropertyPersonDeletedRemoved;
        }

        public void setIsPropertyPersonDeletedRemoved(Boolean removed) {
            this.isPropertyPersonDeletedRemoved = removed;
        }

    }


    public static abstract class AbstractMonthPlanMvoStateDeleted extends AbstractMonthPlanMvoStateEvent implements MonthPlanMvoStateDeleted
    {
        public AbstractMonthPlanMvoStateDeleted() {
        }

        public AbstractMonthPlanMvoStateDeleted(MonthPlanMvoStateEventId stateEventId) {
            super(stateEventId);
        }

        public String getStateEventType() {
            return StateEventType.DELETED;
        }

    }
        public static class SimpleMonthPlanMvoStateCreated extends AbstractMonthPlanMvoStateCreated
        {
			public SimpleMonthPlanMvoStateCreated() {
			}

			public SimpleMonthPlanMvoStateCreated(MonthPlanMvoStateEventId stateEventId) {
				super(stateEventId);
			}
        }

        public static class SimpleMonthPlanMvoStateMergePatched extends AbstractMonthPlanMvoStateMergePatched
        {
			public SimpleMonthPlanMvoStateMergePatched() {
			}

			public SimpleMonthPlanMvoStateMergePatched(MonthPlanMvoStateEventId stateEventId) {
				super(stateEventId);
			}
        }

        public static class SimpleMonthPlanMvoStateDeleted extends AbstractMonthPlanMvoStateDeleted
        {
			public SimpleMonthPlanMvoStateDeleted() {
			}

			public SimpleMonthPlanMvoStateDeleted(MonthPlanMvoStateEventId stateEventId) {
				super(stateEventId);
			}
        }

}
