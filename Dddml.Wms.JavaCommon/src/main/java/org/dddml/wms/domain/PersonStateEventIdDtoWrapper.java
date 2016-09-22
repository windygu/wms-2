package org.dddml.wms.domain;


public class PersonStateEventIdDtoWrapper extends PersonStateEventIdDto
{
	
    private PersonStateEventId value;

    public PersonStateEventIdDtoWrapper()
    {
        this(new PersonStateEventId());
    }

    public PersonStateEventIdDtoWrapper(PersonStateEventId value)
    {
        this.value = value;
    }

    public PersonStateEventId toPersonStateEventId()
    {
        return this.value;
    }

    @Override
    public PersonalNameDto getPersonalName()
    {
        return new PersonalNameDtoWrapper(this.value.getPersonalName());
    }

    @Override
    public void setPersonalName(PersonalNameDto personalName)
    {
        this.value.setPersonalName(personalName.toPersonalName());
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
        if (obj.getClass() == PersonStateEventIdDto.class) {
            return super.equals(obj);
        }
        if (obj.getClass() != this.getClass()) {
            return false;
        }

        PersonStateEventIdDtoWrapper other = (PersonStateEventIdDtoWrapper)obj;
        return value.equals(other.value);
    }

    //@Override
    //public int hashCode()
    //{
    //    return value.hashCode();
    //}

}

