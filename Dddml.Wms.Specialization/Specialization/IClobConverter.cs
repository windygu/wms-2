using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace Dddml.Wms.Specialization
{
    public interface IClobConverter
    {
        string ToString(IDictionary<string, object> lobProperties);

        IDictionary<string, object> ParseLobProperties(string text);
    }
}
