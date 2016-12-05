<?php

namespace Dddml\Wms\Domain;

use JMS\Serializer\Annotation\Type;
use Dddml\StringIdInterface;

class LoginKey implements StringIdInterface
{
    /**
     * @Type("string")
     */
    private $loginProvider;

    /**
     * @return string
     */
    public function getLoginProvider()
    {
        return $this->loginProvider;
    }

    /**
     * @param string $loginProvider
     */
    public function setLoginProvider($loginProvider)
    {
        $this->loginProvider = $loginProvider;
    }

    /**
     * @Type("string")
     */
    private $providerKey;

    /**
     * @return string
     */
    public function getProviderKey()
    {
        return $this->providerKey;
    }

    /**
     * @param string $providerKey
     */
    public function setProviderKey($providerKey)
    {
        $this->providerKey = $providerKey;
    }



    /**
     * @var LoginKeyFlattenedDto
     */
    private $idFlattenedDto;

    /**
     * @return string
     */
    public function toString()
    {
        if (!$this->idFlattenedDto) {
            $this->idFlattenedDto = new LoginKeyFlattenedDto($this);
        }

        return $this->idFlattenedDto->toString();
    }

    /**
     * @param string $idStr
     *
     * @return LoginKey
     */
    public static function createFromString($idStr)
    {
        return (new LoginKeyFlattenedDto())
            ->fromString($idStr)
            ->toLoginKey();
    }


}

