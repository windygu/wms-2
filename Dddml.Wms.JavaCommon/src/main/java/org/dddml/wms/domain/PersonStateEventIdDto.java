package org.dddml.wms.domain;


public class PersonStateEventIdDto
{

    public PersonStateEventIdDto()
    {
    }

    public PersonStateEventId toPersonStateEventId()
    {
        PersonStateEventId v = new PersonStateEventId();
        v.setPersonalName(this.getPersonalName().toPersonalName());
        v.setVersion(this.getVersion());
        return v;
    }

    private PersonalNameDto personalName = new PersonalNameDto();

    public PersonalNameDto getPersonalName()
    {
        return this.personalName;
    }

    public void setPersonalName(PersonalNameDto personalName)
    {
        this.personalName = personalName;
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


    @Override
    public boolean equals(Object obj)
    {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != PersonStateEventIdDto.class) {
            return false;
        }

        PersonStateEventIdDto other = (PersonStateEventIdDto)obj;
        return true 
            && (getPersonalName() == other.getPersonalName() || (getPersonalName() != null && getPersonalName().equals(other.getPersonalName())))
            && (getVersion() == other.getVersion() || (getVersion() != null && getVersion().equals(other.getVersion())))
            ;

    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        if (this.getPersonalName() != null) {
            hash += 13 * this.getPersonalName().hashCode();
        }
        if (this.getVersion() != null) {
            hash += 13 * this.getVersion().hashCode();
        }
        return hash;
    }

}

