package org.dddml.wms.domain;


public class PersonalNameDtoWrapper extends PersonalNameDto
{
	
    private PersonalName value;

    public PersonalNameDtoWrapper()
    {
        this(new PersonalName());
    }

    public PersonalNameDtoWrapper(PersonalName value)
    {
        if (value == null) { throw new IllegalArgumentException("value == null"); }
        this.value = value;
    }

    public PersonalName toPersonalName()
    {
        return this.value;
    }

    @Override
    public String getFirstName()
    {
        return this.value.getFirstName();
    }

    @Override
    public void setFirstName(String firstName)
    {
        this.value.setFirstName(firstName);
    }

    @Override
    public String getLastName()
    {
        return this.value.getLastName();
    }

    @Override
    public void setLastName(String lastName)
    {
        this.value.setLastName(lastName);
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
        if (obj.getClass() == PersonalNameDto.class) {
            return super.equals(obj);
        }
        if (obj.getClass() != this.getClass()) {
            return false;
        }

        PersonalNameDtoWrapper other = (PersonalNameDtoWrapper)obj;
        return value.equals(other.value);
    }

}

