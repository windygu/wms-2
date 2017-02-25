using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;


namespace Dddml.Wms.Specialization
{

    public class GuidStringIdGenerator<TCommand, TState> : IIdGenerator<string, TCommand, TState>
    {

        public string GenerateId(TCommand command)
        {
            return GetNextId();
        }

        public string GetNextId()
        {
            return Guid.NewGuid().ToString();
        }

        public virtual bool Equals(TCommand command, TState state)
        {
            throw new NotSupportedException();
        }

        public bool IsSurrogateIdEnabled()
        {
            return true;
        }

    }


}
