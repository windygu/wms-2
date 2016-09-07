<?php
namespace Dddml\Wms\HttpClient;

class LocatorTreesQueryRequest extends AbstractQueryRequest
{
    use LocatorFilteringFieldsTrait;

    protected $routePath = 'LocatorTrees';

    public function getReturnType()
    {
        return 'array<Dddml\Wms\Domain\Locator>';
    }
}

