using System;
using System.Collections.Generic;


namespace Dddml.Wms.Specialization
{
    public interface IStateDtoWrapper
    {
        string ReturnedFieldsString { set; }

        bool ReturnedFieldsContains(string fieldName);

        bool AllFieldsReturned { get; set; }

    }
}
