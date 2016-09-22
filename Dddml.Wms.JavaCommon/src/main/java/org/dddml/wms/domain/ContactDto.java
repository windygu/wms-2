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
            && (personalName == other.personalName || (personalName != null && personalName.equals(other.personalName)))
            && (phoneNumber == other.phoneNumber || (phoneNumber != null && phoneNumber.equals(other.phoneNumber)))
            && (address == other.address || (address != null && address.equals(other.address)))
            ;

    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        if (this.personalName != null) {
            hash += 13 * this.personalName.hashCode();
        }
        if (this.phoneNumber != null) {
            hash += 13 * this.phoneNumber.hashCode();
        }
        if (this.address != null) {
            hash += 13 * this.address.hashCode();
        }
        return hash;
    }

}

