﻿<?php

namespace Wms\HttpClient;

use Wms\Domain\AttributeSetInstanceExtensionField;

class AttributeSetInstanceExtensionFieldGroupQueryRequest extends AbstractQueryRequest
{
    use AttributeSetInstanceExtensionFieldGroupFilteringFieldsTrait;

    protected $routePath = 'AttributeSetInstanceExtensionFieldGroups/{id}';

    public function getReturnType()
    {
        return 'Wms\Domain\AttributeSetInstanceExtensionFieldGroup';
    }
}
