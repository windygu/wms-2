using Newtonsoft.Json;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace Dddml.Wms.Specialization.Json
{
    public class JsonClobConverter : IClobConverter
    {
        private static JsonSerializerSettings _jsonSerializerSettings = GetJsonSerializerSettings();

        public string ToString(IDictionary<string, object> lobProperties)
        {
            return JsonConvert.SerializeObject(lobProperties, _jsonSerializerSettings);
        }

        public IDictionary<string, object> ParseLobProperties(string text)
        {
            return JsonConvert.DeserializeObject<IDictionary<string, object>>(text, _jsonSerializerSettings);
        }

        private static JsonSerializerSettings GetJsonSerializerSettings(bool isCamelCase = false)
        {
            var jsonSerializerSettings = new JsonSerializerSettings();
            jsonSerializerSettings.NullValueHandling = NullValueHandling.Ignore;
            jsonSerializerSettings.DateFormatHandling = DateFormatHandling.IsoDateFormat;
            if (isCamelCase)
            {
                jsonSerializerSettings.ContractResolver = new Newtonsoft.Json.Serialization.CamelCasePropertyNamesContractResolver();
            }
            jsonSerializerSettings.Formatting = Formatting.None;

            return jsonSerializerSettings;
        }
    }

}
