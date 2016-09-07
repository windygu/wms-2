<?php
namespace Dddml\Wms\HttpClient;

class LocatorTreeQueryRequest extends AbstractQueryRequest
{
    use LocatorFilteringFieldsTrait;

    protected $routePath = 'LocatorTrees';

    public function getReturnType()
    {
        return 'array<Dddml\Wms\Domain\Locator>';
    }
}

