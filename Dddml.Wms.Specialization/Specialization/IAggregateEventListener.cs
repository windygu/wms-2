using System;
using System.Collections.Generic;

namespace Dddml.Wms.Specialization
{
    public interface IAggregateEventListener<TA, TS>
    {

        void EventAppended(AggregateEvent<TA, TS> e);

    }
}