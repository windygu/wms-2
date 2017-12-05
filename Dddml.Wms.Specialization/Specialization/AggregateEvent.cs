using System;
using System.Collections.Generic;

namespace Dddml.Wms.Specialization
{

    public class AggregateEvent<TA, TS>
    {

        private TA _aggregate;

        public virtual TA Aggregate 
        {
            get { return _aggregate; }
            set { _aggregate = value; }
        }

        private TS _state;

        public virtual TS State
        {
            get { return _state; }
            set { _state = value; }
        }

        private IList<IEvent> _events;

        public virtual IList<IEvent> Events
        {
            get
            {
                if (_events == null && _event != null)
                {
                    return new IEvent[] { _event };
                }
                return _events;
            }
            set
            {
                _events = value;
            }
        }

        private IEvent _event;

        public virtual IEvent Event
        {
            get
            {
                if (_event == null && _events != null && _events.Count == 1)
                {
                    return _events[0];
                }
                return _event;
            }
            set
            {
                _event = value;
            }
        }

        public AggregateEvent()
        {
        }

        public AggregateEvent(TA aggregate, TS state, IList<IEvent> events)
        {
            this._aggregate = aggregate;
            this._state = state;
            this._events = events;
        }

        public AggregateEvent(TA aggregate, TS state, IEvent e)
        {
            this._aggregate = aggregate;
            this._state = state;
            this._event = e;
        }



    }
}
