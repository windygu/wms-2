package org.dddml.wms.specialization;


public interface AggregateEventListener<TA, TS> {

    void eventAppended(AggregateEvent<TA, TS> e);

}
