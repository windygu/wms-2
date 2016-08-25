import Index from './components/Index';
import AggregateRoot from './components/AggregateRoot';
import Aggregate from './components/Aggregate';
import CreateAggregate from './components/CreateAggregate';

export default {
    '/': {
        name: 'index',
        component: Index
    },
    '/get/:name/': {
        name: 'aggregates',
        component: AggregateRoot
    },
    '/get/:name/:id/': {
        name: 'aggregate',
        component: Aggregate
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
        name: 'createAggregate',
        component: CreateAggregate
    }
};