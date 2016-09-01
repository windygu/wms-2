<?php
/**
 * User: dongww
 * Date: 2016/7/27
 * Time: 15:21
 */
namespace Dddml\Silex;

use Doctrine\Common\Inflector\Inflector;
use Silex\Api\ControllerProviderInterface;
use Silex\Application;
use Silex\ControllerCollection;
use Symfony\Component\HttpFoundation\Request;

class ApiControllerProvider implements ControllerProviderInterface
{
    public function connect(Application $app)
    {
        /** @var ControllerCollection $controllers */
        $controllers = $app['controllers_factory'];

        $controllers->get('{entities}/_count', [$this, 'getCount'])->bind('api_get_entities_count');
        $controllers->get('{entities}/{id}', [$this, 'getEntity'])->bind('api_get_entity');
        $controllers->get('{entities}', [$this, 'getEntities'])->bind('api_get_entities');
        $controllers->put('{entities}/{id}', [$this, 'createEntity'])->bind('api_create_entity');
        $controllers->patch('{entities}/{id}', [$this, 'mergePatchEntity'])->bind('api_merge_patch_entity');
        $controllers->get('{a}/{b}/{c}/{d}/{e}/{f}/{g}/{h}/{i}/{j}/{k}', [$this, 'freeRoute'])
            ->bind('free_route')
            ->value('a', null)
            ->value('b', null)
            ->value('c', null)
            ->value('d', null)
            ->value('e', null)
            ->value('f', null)
            ->value('g', null)
            ->value('h', null)
            ->value('i', null)
            ->value('j', null)
            ->value('k', null);

        return $controllers;
    }

    public function getEntity(Application $app, Request $request, $entities, $id)
    {
        $entity    = Inflector::singularize($entities);
        $className = 'Dddml\Wms\HttpClient\\' . $entity . 'QueryRequest';

        $response = $app['api.proxy']->get(new $className(), $request, ['id' => $id,]);

        return $response;
    }

    public function getEntities(Application $app, Request $request, $entities)
    {
        $className = 'Dddml\Wms\HttpClient\\' . $entities . 'QueryRequest';

        $response = $app['api.proxy']->get(new $className(), $request);

        return $response;
    }

    public function getCount(Application $app, Request $request, $entities)
    {
        $className = 'Dddml\Wms\HttpClient\\' . $entities . 'QueryRequest';

        $response = $app['api.proxy']->count(new $className(), $request);

        return $response;
    }

    public function createEntity(Application $app, Request $request, $entities, $id)
    {
        $entityName = Inflector::singularize($entities);

        $response = $app['api.proxy']->create($entityName, $id, $request);

        return $response;
    }

    public function mergePatchEntity(Application $app, Request $request, $entities, $id)
    {
        $entityName = Inflector::singularize($entities);

        $response = $app['api.proxy']->mergePatch($entityName, $id, $request);

        return $response;
    }

    public function deleteRole(Application $app, Request $request, $entities, $id)
    {

    }

    public function freeRoute(Application $app, Request $request)
    {
        $params = $request->attributes->all();
        $url    = '';

        foreach (range('a', 'k') as $key) {
            if ($params[$key]) {
                $url .= '/' . $params[$key];
            }
        }

        $response = $app['api.proxy']->request($url, $request);

        return $response;
    }
}