<?php
namespace Dddml\Wms\HttpClient;

class OrganizationTreesQueryRequest extends AbstractQueryRequest
{
    use OrganizationFilteringFieldsTrait;

    protected $routePath = 'OrganizationTrees';

    public function getReturnType()
    {
        return 'array<Dddml\Wms\Domain\Organization>';
    }
}

