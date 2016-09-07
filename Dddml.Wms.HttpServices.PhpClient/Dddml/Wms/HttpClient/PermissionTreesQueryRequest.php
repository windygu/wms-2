<?php
namespace Dddml\Wms\HttpClient;

class PermissionTreesQueryRequest extends AbstractQueryRequest
{
    use PermissionFilteringFieldsTrait;

    protected $routePath = 'PermissionTrees';

    public function getReturnType()
    {
        return 'array<Dddml\Wms\Domain\Permission>';
    }
}

