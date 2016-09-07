<?php
namespace Dddml\Wms\HttpClient;

class OrganizationTreeQueryRequest extends AbstractQueryRequest
{
    use OrganizationFilteringFieldsTrait;

    protected $routePath = 'OrganizationTrees';

    public function getReturnType()
    {
        return 'array<Dddml\Wms\Domain\Organization>';
    }
}

