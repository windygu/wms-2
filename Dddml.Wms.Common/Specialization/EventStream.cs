using System;
using System.Collections.Generic;

namespace Dddml.Wms.Specialization
{
    public class EventStream
    {
        public EventStream()
        {
        }

        public long SteamVersion { get; set; }

        private IList<IEvent> _events = new List<IEvent>();

        public IList<IEvent> Events
        {
            get { return _events; }
            set { _events = value; }
        }

    }
}

