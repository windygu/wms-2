package org.dddml.wms.domain;


public class ContactDtoWrapper extends ContactDto
{
	
    private Contact value;

    public ContactDtoWrapper()
    {
        this(new Contact());
    }

    public ContactDtoWrapper(Contact value)
    {
        if (value == null) { throw new IllegalArgumentException("value == null"); }
        this.value = value;
    }

    public Contact toContact()
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
    public String getPhoneNumber()
    {
        return this.value.getPhoneNumber();
    }

    @Override
    public void setPhoneNumber(String phoneNumber)
    {
        this.value.setPhoneNumber(phoneNumber);
    }

    @Override
    public String getAddress()
    {
        return this.value.getAddress();
    }

    @Override
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
        if (obj == null) {
            return false;
        }
        if (obj.getClass() == ContactDto.class) {
            return super.equals(obj);
        }
        if (obj.getClass() != this.getClass()) {
            return false;
        }

        ContactDtoWrapper other = (ContactDtoWrapper)obj;
        return value.equals(other.value);
    }

}

