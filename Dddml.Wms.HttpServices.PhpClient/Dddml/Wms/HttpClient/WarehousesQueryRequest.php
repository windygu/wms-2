<?php

namespace Dddml\Wms\HttpClient;

use Dddml\Serializer\Type\Long;
use Dddml\Executor\Http\QueryCountRequestInterface;

class WarehousesQueryRequest extends AbstractQueryRequest implements QueryCountRequestInterface
{
    use WarehouseFilteringFieldsTrait;

    protected $routePath = 'Warehouses';

    public function getReturnType()
    {
        return 'array<Dddml\Wms\Domain\Warehouse>';
    }
}

