import IndexComponent from './components/Index.component';
import AggregateRootComponent from './components/AggregateRoot.component';
import EntityComponent from './components/Entity.component';
import CreateEntityComponent from './components/CreateEntity.component';
import MergePatchEntityComponent from './components/MergePatchEntity.component';
import EntityTree from './components/EntityTree.component';

export default {
    '/': {
        name: 'index',
        component: IndexComponent
    },
    '/entities/:name/': {
        name: 'entities',
        component: AggregateRootComponent
    },
    '/entity/:chainingName/': {
        name: 'entity',
        component: EntityComponent
    },
    '/create/:name/': {
        name: 'createEntity',
        component: CreateEntityComponent
    },
    '/mergePatch/:chainingName': {
        name: 'mergePatchEntity',
        component: MergePatchEntityComponent
    },
    '/tree/:name': {
        name: 'tree',
        component: EntityTree
    }
};