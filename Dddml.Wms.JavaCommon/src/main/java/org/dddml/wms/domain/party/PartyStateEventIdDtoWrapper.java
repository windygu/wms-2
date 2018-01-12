package org.dddml.wms.domain.party;

import org.dddml.wms.domain.*;

public class PartyStateEventIdDtoWrapper extends PartyStateEventIdDto
{
	
    private PartyStateEventId value;

    public PartyStateEventIdDtoWrapper()
    {
        this(new PartyStateEventId());
    }

    public PartyStateEventIdDtoWrapper(PartyStateEventId value)
    {
        if (value == null) { throw new IllegalArgumentException("value == null"); }
        this.value = value;
    }

    public PartyStateEventId toPartyStateEventId()
    {
        return this.value;
    }

    @Override
    public String getPartyId()
    {
        return this.value.getPartyId();
    }

    @Override
    public void setPartyId(String partyId)
    {
        this.value.setPartyId(partyId);
    }

    @Override
    public Long getVersion()
    {
        return this.value.getVersion();
    }

    @Override
    public void setVersion(Long version)
    {
        this.value.setVersion(version);
    }


    @Override
    public boolean equals(Object obj)
    {
        if (obj == this) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (obj.getClass() == PartyStateEventIdDto.class) {
            return super.equals(obj);
        }
        if (obj.getClass() != this.getClass()) {
            return false;
        }

        PartyStateEventIdDtoWrapper other = (PartyStateEventIdDtoWrapper)obj;
        return value.equals(other.value);
    }

}

