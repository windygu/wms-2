import Index from './components/Index';
import AggregateRoot from './components/AggregateRoot';
import Entity from './components/Entity';
import CreateEntity from './components/CreateEntity';

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
    // '/:name/:id/:embedEntities': {
    //     name: 'embedEntities',
    //     component: Entity
    // },
    // '/:name/:id/:embed/:eid': {
    //     name: 'embedEntity',
    //     component: Entity
    // },
    '/create/:name/': {
        name: 'createEntity',
        component: CreateEntity
    }
};