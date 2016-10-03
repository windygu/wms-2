package org.dddml.wms.domain;

import java.util.*;
import java.util.Date;
import org.dddml.wms.specialization.*;
import org.dddml.wms.domain.MonthPlanMvoStateEvent.*;

public abstract class AbstractMonthPlanMvoState implements MonthPlanMvoState
{

    private MonthPlanId monthPlanId;

    public MonthPlanId getMonthPlanId()
    {
        return this.monthPlanId;
    }

    public void setMonthPlanId(MonthPlanId monthPlanId)
    {
        this.monthPlanId = monthPlanId;
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

    private String createdBy;

    public String getCreatedBy()
    {
        return this.createdBy;
    }

    public void setCreatedBy(String createdBy)
    {
        this.createdBy = createdBy;
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

    private Date updatedAt;

    public Date getUpdatedAt()
    {
        return this.updatedAt;
    }

    public void setUpdatedAt(Date updatedAt)
    {
        this.updatedAt = updatedAt;
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

    private Boolean deleted;

    public Boolean getDeleted()
    {
        return this.deleted;
    }

    public void setDeleted(Boolean deleted)
    {
        this.deleted = deleted;
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

    private String yearPlanCreatedBy;

    public String getYearPlanCreatedBy()
    {
        return this.yearPlanCreatedBy;
    }

    public void setYearPlanCreatedBy(String yearPlanCreatedBy)
    {
        this.yearPlanCreatedBy = yearPlanCreatedBy;
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

    private Long yearPlanVersion;

    public Long getYearPlanVersion()
    {
        return this.yearPlanVersion;
    }

    public void setYearPlanVersion(Long yearPlanVersion)
    {
        this.yearPlanVersion = yearPlanVersion;
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

    private String personEmail;

    public String getPersonEmail()
    {
        return this.personEmail;
    }

    public void setPersonEmail(String personEmail)
    {
        this.personEmail = personEmail;
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

    private String personUpdatedBy;

    public String getPersonUpdatedBy()
    {
        return this.personUpdatedBy;
    }

    public void setPersonUpdatedBy(String personUpdatedBy)
    {
        this.personUpdatedBy = personUpdatedBy;
    }

    private Long personVersion;

    public Long getPersonVersion()
    {
        return this.personVersion;
    }

    public void setPersonVersion(Long personVersion)
    {
        this.personVersion = personVersion;
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

    public boolean isStateUnsaved() 
    {
        return this.getPersonVersion() == null;
    }


    private boolean forReapplying;

    public boolean getForReapplying() {
        return forReapplying;
    }

    public void setForReapplying(boolean forReapplying) {
        this.forReapplying = forReapplying;
    }

    public AbstractMonthPlanMvoState(List<Event> events) {
        this(true);
        if (events != null && events.size() > 0) {
            this.setMonthPlanId(((MonthPlanMvoStateEvent) events.get(0)).getStateEventId().getMonthPlanId());
            for (Event e : events) {
                mutate(e);
                this.setPersonVersion(this.getPersonVersion() + 1);
            }
        }
    }


    public AbstractMonthPlanMvoState() {
        this(false);
    }

    public AbstractMonthPlanMvoState(boolean forReapplying) {
        this.forReapplying = forReapplying;
        initializeProperties();
    }
    
    protected void initializeProperties() {
    }


    public void mutate(Event e) {
        if (e instanceof MonthPlanMvoStateCreated) {
            when((MonthPlanMvoStateCreated) e);
        } else if (e instanceof MonthPlanMvoStateMergePatched) {
            when((MonthPlanMvoStateMergePatched) e);
        } else if (e instanceof MonthPlanMvoStateDeleted) {
            when((MonthPlanMvoStateDeleted) e);
        }
    }

    public void when(MonthPlanMvoStateCreated e)
    {
        throwOnWrongEvent(e);
        this.setDescription(e.getDescription());
        this.setVersion(e.getVersion());
        this.setActive(e.getActive());
        this.setYearPlanDescription(e.getYearPlanDescription());
        this.setYearPlanCreatedBy(e.getYearPlanCreatedBy());
        this.setYearPlanUpdatedBy(e.getYearPlanUpdatedBy());
        this.setYearPlanVersion(e.getYearPlanVersion());
        this.setYearPlanCreatedAt(e.getYearPlanCreatedAt());
        this.setYearPlanUpdatedAt(e.getYearPlanUpdatedAt());
        this.setYearPlanActive(e.getYearPlanActive());
        this.setYearPlanDeleted(e.getYearPlanDeleted());
        this.setPersonBirthDate(e.getPersonBirthDate());
        this.setPersonLoves(e.getPersonLoves());
        this.setPersonEmergencyContact(e.getPersonEmergencyContact());
        this.setPersonEmail(e.getPersonEmail());
        this.setPersonCreatedBy(e.getPersonCreatedBy());
        this.setPersonUpdatedBy(e.getPersonUpdatedBy());
        this.setPersonCreatedAt(e.getPersonCreatedAt());
        this.setPersonUpdatedAt(e.getPersonUpdatedAt());
        this.setPersonActive(e.getPersonActive());
        this.setPersonDeleted(e.getPersonDeleted());

        this.setDeleted(false);

        this.setCreatedBy(e.getCreatedBy());
        this.setCreatedAt(e.getCreatedAt());

    }

    public void when(MonthPlanMvoStateMergePatched e)
    {
        throwOnWrongEvent(e);

        if (e.getDescription() == null)
        {
            if (e.getIsPropertyDescriptionRemoved() != null && e.getIsPropertyDescriptionRemoved())
            {
                this.setDescription(null);
            }
        }
        else
        {
            this.setDescription(e.getDescription());
        }
        if (e.getVersion() == null)
        {
            if (e.getIsPropertyVersionRemoved() != null && e.getIsPropertyVersionRemoved())
            {
                this.setVersion(null);
            }
        }
        else
        {
            this.setVersion(e.getVersion());
        }
        if (e.getActive() == null)
        {
            if (e.getIsPropertyActiveRemoved() != null && e.getIsPropertyActiveRemoved())
            {
                this.setActive(null);
            }
        }
        else
        {
            this.setActive(e.getActive());
        }
        if (e.getYearPlanDescription() == null)
        {
            if (e.getIsPropertyYearPlanDescriptionRemoved() != null && e.getIsPropertyYearPlanDescriptionRemoved())
            {
                this.setYearPlanDescription(null);
            }
        }
        else
        {
            this.setYearPlanDescription(e.getYearPlanDescription());
        }
        if (e.getYearPlanCreatedBy() == null)
        {
            if (e.getIsPropertyYearPlanCreatedByRemoved() != null && e.getIsPropertyYearPlanCreatedByRemoved())
            {
                this.setYearPlanCreatedBy(null);
            }
        }
        else
        {
            this.setYearPlanCreatedBy(e.getYearPlanCreatedBy());
        }
        if (e.getYearPlanUpdatedBy() == null)
        {
            if (e.getIsPropertyYearPlanUpdatedByRemoved() != null && e.getIsPropertyYearPlanUpdatedByRemoved())
            {
                this.setYearPlanUpdatedBy(null);
            }
        }
        else
        {
            this.setYearPlanUpdatedBy(e.getYearPlanUpdatedBy());
        }
        if (e.getYearPlanVersion() == null)
        {
            if (e.getIsPropertyYearPlanVersionRemoved() != null && e.getIsPropertyYearPlanVersionRemoved())
            {
                this.setYearPlanVersion(null);
            }
        }
        else
        {
            this.setYearPlanVersion(e.getYearPlanVersion());
        }
        if (e.getYearPlanCreatedAt() == null)
        {
            if (e.getIsPropertyYearPlanCreatedAtRemoved() != null && e.getIsPropertyYearPlanCreatedAtRemoved())
            {
                this.setYearPlanCreatedAt(null);
            }
        }
        else
        {
            this.setYearPlanCreatedAt(e.getYearPlanCreatedAt());
        }
        if (e.getYearPlanUpdatedAt() == null)
        {
            if (e.getIsPropertyYearPlanUpdatedAtRemoved() != null && e.getIsPropertyYearPlanUpdatedAtRemoved())
            {
                this.setYearPlanUpdatedAt(null);
            }
        }
        else
        {
            this.setYearPlanUpdatedAt(e.getYearPlanUpdatedAt());
        }
        if (e.getYearPlanActive() == null)
        {
            if (e.getIsPropertyYearPlanActiveRemoved() != null && e.getIsPropertyYearPlanActiveRemoved())
            {
                this.setYearPlanActive(null);
            }
        }
        else
        {
            this.setYearPlanActive(e.getYearPlanActive());
        }
        if (e.getYearPlanDeleted() == null)
        {
            if (e.getIsPropertyYearPlanDeletedRemoved() != null && e.getIsPropertyYearPlanDeletedRemoved())
            {
                this.setYearPlanDeleted(null);
            }
        }
        else
        {
            this.setYearPlanDeleted(e.getYearPlanDeleted());
        }
        if (e.getPersonBirthDate() == null)
        {
            if (e.getIsPropertyPersonBirthDateRemoved() != null && e.getIsPropertyPersonBirthDateRemoved())
            {
                this.setPersonBirthDate(null);
            }
        }
        else
        {
            this.setPersonBirthDate(e.getPersonBirthDate());
        }
        if (e.getPersonLoves() == null)
        {
            if (e.getIsPropertyPersonLovesRemoved() != null && e.getIsPropertyPersonLovesRemoved())
            {
                this.setPersonLoves(null);
            }
        }
        else
        {
            this.setPersonLoves(e.getPersonLoves());
        }
        if (e.getPersonEmergencyContact() == null)
        {
            if (e.getIsPropertyPersonEmergencyContactRemoved() != null && e.getIsPropertyPersonEmergencyContactRemoved())
            {
                this.setPersonEmergencyContact(null);
            }
        }
        else
        {
            this.setPersonEmergencyContact(e.getPersonEmergencyContact());
        }
        if (e.getPersonEmail() == null)
        {
            if (e.getIsPropertyPersonEmailRemoved() != null && e.getIsPropertyPersonEmailRemoved())
            {
                this.setPersonEmail(null);
            }
        }
        else
        {
            this.setPersonEmail(e.getPersonEmail());
        }
        if (e.getPersonCreatedBy() == null)
        {
            if (e.getIsPropertyPersonCreatedByRemoved() != null && e.getIsPropertyPersonCreatedByRemoved())
            {
                this.setPersonCreatedBy(null);
            }
        }
        else
        {
            this.setPersonCreatedBy(e.getPersonCreatedBy());
        }
        if (e.getPersonUpdatedBy() == null)
        {
            if (e.getIsPropertyPersonUpdatedByRemoved() != null && e.getIsPropertyPersonUpdatedByRemoved())
            {
                this.setPersonUpdatedBy(null);
            }
        }
        else
        {
            this.setPersonUpdatedBy(e.getPersonUpdatedBy());
        }
        if (e.getPersonCreatedAt() == null)
        {
            if (e.getIsPropertyPersonCreatedAtRemoved() != null && e.getIsPropertyPersonCreatedAtRemoved())
            {
                this.setPersonCreatedAt(null);
            }
        }
        else
        {
            this.setPersonCreatedAt(e.getPersonCreatedAt());
        }
        if (e.getPersonUpdatedAt() == null)
        {
            if (e.getIsPropertyPersonUpdatedAtRemoved() != null && e.getIsPropertyPersonUpdatedAtRemoved())
            {
                this.setPersonUpdatedAt(null);
            }
        }
        else
        {
            this.setPersonUpdatedAt(e.getPersonUpdatedAt());
        }
        if (e.getPersonActive() == null)
        {
            if (e.getIsPropertyPersonActiveRemoved() != null && e.getIsPropertyPersonActiveRemoved())
            {
                this.setPersonActive(null);
            }
        }
        else
        {
            this.setPersonActive(e.getPersonActive());
        }
        if (e.getPersonDeleted() == null)
        {
            if (e.getIsPropertyPersonDeletedRemoved() != null && e.getIsPropertyPersonDeletedRemoved())
            {
                this.setPersonDeleted(null);
            }
        }
        else
        {
            this.setPersonDeleted(e.getPersonDeleted());
        }

        this.setUpdatedBy(e.getCreatedBy());
        this.setUpdatedAt(e.getCreatedAt());

    }

    public void when(MonthPlanMvoStateDeleted e)
    {
        throwOnWrongEvent(e);

        this.setDeleted(true);
        this.setUpdatedBy(e.getCreatedBy());
        this.setUpdatedAt(e.getCreatedAt());

    }

    public void save()
    {
    }

    protected void throwOnWrongEvent(MonthPlanMvoStateEvent stateEvent)
    {
        MonthPlanId stateEntityId = this.getMonthPlanId(); // Aggregate Id
        MonthPlanId eventEntityId = stateEvent.getStateEventId().getMonthPlanId(); // EntityBase.Aggregate.GetStateEventIdPropertyIdName();
        if (!stateEntityId.equals(eventEntityId))
        {
            throw DomainError.named("mutateWrongEntity", "Entity Id %1$s in state but entity id %2$s in event", stateEntityId, eventEntityId);
        }

        Long stateVersion = this.getPersonVersion();
        Long eventVersion = stateEvent.getStateEventId().getPersonVersion();// Aggregate Version
        if (eventVersion == null) {
            throw new NullPointerException("stateEvent.getStateEventId().getPersonVersion() == null");
        }
        if (!(stateVersion == null && eventVersion.equals(MonthPlanMvoState.VERSION_NULL)) && !eventVersion.equals(stateVersion))
        {
            throw DomainError.named("concurrencyConflict", "Conflict between state version (%1$s) and event version (%2$s)", stateVersion, eventVersion);
        }

    }

    public static class SimpleMonthPlanMvoState extends AbstractMonthPlanMvoState
    {

        public SimpleMonthPlanMvoState() {
        }

        public SimpleMonthPlanMvoState(boolean forReapplying) {
            super(forReapplying);
        }

    }


}

