<?php

namespace Dddml\Wms\Domain;

use JMS\Serializer\Annotation\Type;

trait AttributeValueIsPropertyRemovedTrait
{
    /**
     * @Type("boolean")
     *
     * @var boolean
     */
    private $isPropertyNameRemoved = false;

    /**
     * @return boolean
     */
    public function getIsPropertyNameRemoved()
    {
        return $this->isPropertyNameRemoved;
    }

    /**
     * @param boolean $isPropertyNameRemoved
     */
    public function setIsPropertyNameRemoved($isPropertyNameRemoved)
    {
        $this->isPropertyNameRemoved = $isPropertyNameRemoved;
    }

    /**
     * @Type("boolean")
     *
     * @var boolean
     */
    private $isPropertyDescriptionRemoved = false;

    /**
     * @return boolean
     */
    public function getIsPropertyDescriptionRemoved()
    {
        return $this->isPropertyDescriptionRemoved;
    }

    /**
     * @param boolean $isPropertyDescriptionRemoved
     */
    public function setIsPropertyDescriptionRemoved($isPropertyDescriptionRemoved)
    {
        $this->isPropertyDescriptionRemoved = $isPropertyDescriptionRemoved;
    }

    /**
     * @Type("boolean")
     *
     * @var boolean
     */
    private $isPropertyReferenceIdRemoved = false;

    /**
     * @return boolean
     */
    public function getIsPropertyReferenceIdRemoved()
    {
        return $this->isPropertyReferenceIdRemoved;
    }

    /**
     * @param boolean $isPropertyReferenceIdRemoved
     */
    public function setIsPropertyReferenceIdRemoved($isPropertyReferenceIdRemoved)
    {
        $this->isPropertyReferenceIdRemoved = $isPropertyReferenceIdRemoved;
    }

    /**
     * @Type("boolean")
     *
     * @var boolean
     */
    private $isPropertyActiveRemoved = false;

    /**
     * @return boolean
     */
    public function getIsPropertyActiveRemoved()
    {
        return $this->isPropertyActiveRemoved;
    }

    /**
     * @param boolean $isPropertyActiveRemoved
     */
    public function setIsPropertyActiveRemoved($isPropertyActiveRemoved)
    {
        $this->isPropertyActiveRemoved = $isPropertyActiveRemoved;
    }


}

