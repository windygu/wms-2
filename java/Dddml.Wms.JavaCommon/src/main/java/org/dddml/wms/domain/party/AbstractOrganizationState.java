package org.dddml.wms.domain.party;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;
import org.dddml.wms.domain.party.OrganizationStateEvent.*;

public abstract class AbstractOrganizationState extends AbstractPartyState implements OrganizationState
{

    private String organizationName;

    public String getOrganizationName()
    {
        return this.organizationName;
    }

    public void setOrganizationName(String organizationName)
    {
        this.organizationName = organizationName;
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

    private String type;

    public String getType()
    {
        return this.type;
    }

    public void setType(String type)
    {
        this.type = type;
    }

    private Boolean isSummary;

    public Boolean getIsSummary()
    {
        return this.isSummary;
    }

    public void setIsSummary(Boolean isSummary)
    {
        this.isSummary = isSummary;
    }

    public AbstractOrganizationState(List<Event> events) {
        this(true);
        if (events != null && events.size() > 0) {
            this.setPartyId(((OrganizationStateEvent) events.get(0)).getStateEventId().getPartyId());
            for (Event e : events) {
                mutate(e);
                this.setVersion(this.getVersion() + 1);
            }
        }
    }


    public AbstractOrganizationState() {
        this(false);
    }

    public AbstractOrganizationState(boolean forReapplying) {
        super.setForReapplying(forReapplying);

        initializeProperties();
    }
    
    protected void initializeProperties() {
        super.initializeProperties();
    }


    public void mutate(Event e) {
        setStateReadOnly(false);
        if (e instanceof OrganizationStateCreated) {
            when((OrganizationStateCreated) e);
        } else if (e instanceof OrganizationStateMergePatched) {
            when((OrganizationStateMergePatched) e);
        } else if (e instanceof OrganizationStateDeleted) {
            when((OrganizationStateDeleted) e);
        } else if (e instanceof PartyStateEvent.PartyStateDeleted) {
            when((PartyStateEvent.PartyStateDeleted) e);
        } else {
            throw new UnsupportedOperationException(String.format("Unsupported event type: %1$s", e.getClass().getName()));
        }
    }

    public void when(OrganizationStateCreated e)
    {
        throwOnWrongEvent(e);

        this.setPartyTypeId(e.getPartyTypeId());
        this.setActive(e.getActive());
        this.setOrganizationName(e.getOrganizationName());
        this.setDescription(e.getDescription());
        this.setType(e.getType());
        this.setIsSummary(e.getIsSummary());

        this.setDeleted(false);

        this.setCreatedBy(e.getCreatedBy());
        this.setCreatedAt(e.getCreatedAt());

    }

    public void when(OrganizationStateMergePatched e)
    {
        throwOnWrongEvent(e);

        if (e.getPartyTypeId() == null)
        {
            if (e.getIsPropertyPartyTypeIdRemoved() != null && e.getIsPropertyPartyTypeIdRemoved())
            {
                this.setPartyTypeId(null);
            }
        }
        else
        {
            this.setPartyTypeId(e.getPartyTypeId());
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
        if (e.getOrganizationName() == null)
        {
            if (e.getIsPropertyOrganizationNameRemoved() != null && e.getIsPropertyOrganizationNameRemoved())
            {
                this.setOrganizationName(null);
            }
        }
        else
        {
            this.setOrganizationName(e.getOrganizationName());
        }
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
        if (e.getType() == null)
        {
            if (e.getIsPropertyTypeRemoved() != null && e.getIsPropertyTypeRemoved())
            {
                this.setType(null);
            }
        }
        else
        {
            this.setType(e.getType());
        }
        if (e.getIsSummary() == null)
        {
            if (e.getIsPropertyIsSummaryRemoved() != null && e.getIsPropertyIsSummaryRemoved())
            {
                this.setIsSummary(null);
            }
        }
        else
        {
            this.setIsSummary(e.getIsSummary());
        }

        this.setUpdatedBy(e.getCreatedBy());
        this.setUpdatedAt(e.getCreatedAt());

    }

    public void when(OrganizationStateDeleted e)
    {
        throwOnWrongEvent(e);

        this.setDeleted(true);
        this.setUpdatedBy(e.getCreatedBy());
        this.setUpdatedAt(e.getCreatedAt());

    }

    public void save()
    {
       super.save();
    }

    public static class SimpleOrganizationState extends AbstractOrganizationState
    {

        public SimpleOrganizationState() {
        }

        public SimpleOrganizationState(boolean forReapplying) {
            super(forReapplying);
        }

        public SimpleOrganizationState(List<Event> events) {
            super(events);
        }

    }


}

