import IndexPage from './vue/Index.page';
import AggregateRootPage from './vue/AggregateRoot.page';
import EntityPage from './vue/Entity.page';
import CreateEntityPage from './vue/CreateEntity.page';
import MergePatchEntityPage from './vue/MergePatchEntity.page';
import EntityTree from './components/EntityTree.component';

export default {
    '/': {
        name: 'index',
        component: IndexPage
    },
    '/entities/:name/': {
        name: 'entities',
        component: AggregateRootPage
    },
    '/entity/:chainingName/': {
        name: 'entity',
        component: EntityPage
    },
    '/create/:name/': {
        name: 'createEntity',
        component: CreateEntityPage
    },
    '/mergePatch/:chainingName': {
        name: 'mergePatchEntity',
        component: MergePatchEntityPage
    },
    '/tree/:name': {
        name: 'tree',
        component: EntityTree
};

