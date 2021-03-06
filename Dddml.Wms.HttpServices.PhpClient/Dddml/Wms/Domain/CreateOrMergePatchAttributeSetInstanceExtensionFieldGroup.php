<?php

namespace Dddml\Wms\Domain;

use JMS\Serializer\Annotation\Type;
use Dddml\Serializer\Type\Long;
use Dddml\Wms\Domain\CommandTrait;

class CreateOrMergePatchAttributeSetInstanceExtensionFieldGroup extends AbstractAttributeSetInstanceExtensionFieldGroupCommand
{

    use AttributeSetInstanceExtensionFieldGroupIsPropertyRemovedTrait;

    /**
     * @Type("string")
     */
    private $fieldType;

    /**
     * @return string
     */
    public function getFieldType()
    {
        return $this->fieldType;
    }

    /**
     * @param string $fieldType
     */
    public function setFieldType($fieldType)
    {
        $this->fieldType = $fieldType;
    }

    /**
     * @Type("integer")
     */
    private $fieldLength;

    /**
     * @return integer
     */
    public function getFieldLength()
    {
        return $this->fieldLength;
    }

    /**
     * @param integer $fieldLength
     */
    public function setFieldLength($fieldLength)
    {
        $this->fieldLength = $fieldLength;
    }

    /**
     * @Type("integer")
     */
    private $fieldCount;

    /**
     * @return integer
     */
    public function getFieldCount()
    {
        return $this->fieldCount;
    }

    /**
     * @param integer $fieldCount
     */
    public function setFieldCount($fieldCount)
    {
        $this->fieldCount = $fieldCount;
    }

    /**
     * @Type("string")
     */
    private $nameFormat;

    /**
     * @return string
     */
    public function getNameFormat()
    {
        return $this->nameFormat;
    }

    /**
     * @param string $nameFormat
     */
    public function setNameFormat($nameFormat)
    {
        $this->nameFormat = $nameFormat;
    }

    /**
     * @Type("string")
     */
    private $description;

    /**
     * @return string
     */
    public function getDescription()
    {
        return $this->description;
    }

    /**
     * @param string $description
     */
    public function setDescription($description)
    {
        $this->description = $description;
    }

    /**
     * @Type("boolean")
     */
    private $active;

    /**
     * @return boolean
     */
    public function getActive()
    {
        return $this->active;
    }

    /**
     * @param boolean $active
     */
    public function setActive($active)
    {
        $this->active = $active;
    }

    /**
     * @Type("array<Dddml\Wms\Domain\CreateOrMergePatchAttributeSetInstanceExtensionField>")
     * @var CreateOrMergePatchAttributeSetInstanceExtensionField[]
     */
    private $fields;

    /**
     * @return CreateOrMergePatchAttributeSetInstanceExtensionField[]
     */
    public function getFields()
    {
        return $this->fields;
    }	

    /**
     * @param CreateOrMergePatchAttributeSetInstanceExtensionField[] $fields
     */
    public function setFields($fields)
    {
        $this->fields = $fields;
    }


}

