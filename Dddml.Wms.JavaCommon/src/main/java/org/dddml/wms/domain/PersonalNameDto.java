package org.dddml.wms.domain;


public class PersonalNameDto
{

    public PersonalNameDto()
    {
    }

    public PersonalName toPersonalName()
    {
        PersonalName v = new PersonalName();
        v.setFirstName(this.getFirstName());
        v.setLastName(this.getLastName());
        return v;
    }

    private String firstName;

    public String getFirstName()
    {
        return this.firstName;
    }

    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }

    private String lastName;

    public String getLastName()
    {
        return this.lastName;
    }

    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }


    @Override
    public boolean equals(Object obj)
    {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != PersonalNameDto.class) {
            return false;
        }

        PersonalNameDto other = (PersonalNameDto)obj;
        return true 
            && (firstName == other.firstName || (firstName != null && firstName.equals(other.firstName)))
            && (lastName == other.lastName || (lastName != null && lastName.equals(other.lastName)))
            ;

    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        if (this.firstName != null) {
            hash += 13 * this.firstName.hashCode();
        }
        if (this.lastName != null) {
            hash += 13 * this.lastName.hashCode();
        }
        return hash;
    }

}

