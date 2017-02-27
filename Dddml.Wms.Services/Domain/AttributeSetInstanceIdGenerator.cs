using Dddml.Wms.Support;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;


namespace Dddml.Wms.Domain
{
   
    public class AttributeSetInstanceIdGenerator : AttributeSetInstanceIdGeneratorBase
    {
        public override string GenerateId(ICreateAttributeSetInstance command)
        {
            string hash = AttributeSetInstancePropertyUtils.GetHash(command);
            return hash;
        }

        public override bool Equals(ICreateAttributeSetInstance command, IAttributeSetInstanceState state)
        {
            return AttributeSetInstancePropertyUtils.Equals(command, state);
        }

        public override string GetNextId()
        {
            return Guid.NewGuid().ToString();
        }

        public override bool IsSurrogateIdEnabled()
        {
            return true;
        }
    }
}
