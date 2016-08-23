package org.dddml.wms.domain;


public class ContactDto
{
	
    private Contact value;

    public ContactDto()
    {
        this(new Contact());
    }

    public ContactDto(Contact value)
    {
        this.value = value;
    }

    public Contact toContact()
    {
        return this.value;
    }

    public PersonalNameDto getPersonalName()
    {
        return new PersonalNameDto(this.value.getPersonalName());
    }

    public void setPersonalName(PersonalNameDto personalName)
    {
        this.value.setPersonalName(personalName.toPersonalName());
    }

    public String getPhoneNumber()
    {
        return this.value.getPhoneNumber();
    }

    public void setPhoneNumber(String phoneNumber)
    {
        this.value.setPhoneNumber(phoneNumber);
    }

    public String getAddress()
    {
        return this.value.getAddress();
    }

    public void setAddress(String address)
    {
        this.value.setAddress(address);
    }


    @Override
    public boolean equals(Object obj)
    {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }

        ContactDto other = (ContactDto)obj;
        return value.equals(other.value);
    }

    @Override
    public int hashCode()
    {
        return value.hashCode();
    }

}

