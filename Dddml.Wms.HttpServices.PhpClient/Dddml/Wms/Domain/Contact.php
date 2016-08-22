<?php

namespace Dddml\Wms\Domain;

use JMS\Serializer\Annotation\Type;
use Dddml\StringIdInterface;

class Contact
{
    /**
     * @Type("Dddml\Wms\Domain\PersonalName")
     */
    private $personalName;

    /**
     * @return PersonalName
     */
    public function getPersonalName()
    {
        if(!$this->personalName) {
            $this->personalName = new PersonalName(); 
        }
        return $this->personalName;
    }

    /**
     * @param PersonalName $personalName
     */
    public function setPersonalName($personalName)
    {
        $this->personalName = $personalName;
    }

    /**
     * @Type("string")
     */
    private $phoneNumber;

    /**
     * @return string
     */
    public function getPhoneNumber()
    {
        return $this->phoneNumber;
    }

    /**
     * @param string $phoneNumber
     */
    public function setPhoneNumber($phoneNumber)
    {
        $this->phoneNumber = $phoneNumber;
    }

    /**
     * @Type("string")
     */
    private $address;

    /**
     * @return string
     */
    public function getAddress()
    {
        return $this->address;
    }

    /**
     * @param string $address
     */
    public function setAddress($address)
    {
        $this->address = $address;
    }


}

