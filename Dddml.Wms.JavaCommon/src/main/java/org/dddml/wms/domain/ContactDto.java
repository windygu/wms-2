package org.dddml.wms.domain;


public class ContactDto
{

    public ContactDto()
    {
    }

    public Contact toContact()
    {
        Contact v = new Contact();
        v.setPersonalName(this.getPersonalName().toPersonalName());
        v.setPhoneNumber(this.getPhoneNumber());
        v.setAddress(this.getAddress());
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

    private String phoneNumber;

    public String getPhoneNumber()
    {
        return this.phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber)
    {
        this.phoneNumber = phoneNumber;
    }

    private String address;

    public String getAddress()
    {
        return this.address;
    }

    public void setAddress(String address)
    {
        this.address = address;
    }


    @Override
    public boolean equals(Object obj)
    {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != ContactDto.class) {
            return false;
        }

        ContactDto other = (ContactDto)obj;
        return true 
            && (getPersonalName() == other.getPersonalName() || (getPersonalName() != null && getPersonalName().equals(other.getPersonalName())))
            && (getPhoneNumber() == other.getPhoneNumber() || (getPhoneNumber() != null && getPhoneNumber().equals(other.getPhoneNumber())))
            && (getAddress() == other.getAddress() || (getAddress() != null && getAddress().equals(other.getAddress())))
            ;

    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        if (this.getPersonalName() != null) {
            hash += 13 * this.getPersonalName().hashCode();
        }
        if (this.getPhoneNumber() != null) {
            hash += 13 * this.getPhoneNumber().hashCode();
        }
        if (this.getAddress() != null) {
            hash += 13 * this.getAddress().hashCode();
        }
        return hash;
    }

}

