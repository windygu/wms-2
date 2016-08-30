import Index from './components/Index';
import AggregateRoot from './components/AggregateRoot';
import Entity from './components/Entity';
import CreateEntity from './components/CreateEntity';
import MergePatchEntity from './components/MergePatchEntity';

export default {
    '/': {
        name: 'index',
        component: Index
    },
    '/entities/:name/': {
        name: 'entities',
        component: AggregateRoot
    },
    '/entity/:chainingName/': {
        name: 'entity',
        component: Entity
    },
    '/create/:name/': {
        name: 'createEntity',
        component: CreateEntity
    },
    '/mergePatch/:chainingName': {
        name: 'mergePatchEntity',
        component: MergePatchEntity
    }
};