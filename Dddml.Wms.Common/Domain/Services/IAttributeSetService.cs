using System;
using System.Collections.Generic;
using System.Text;

namespace Dddml.Wms.Domain.Services
{
    /// <summary>
    /// 关于属性集的内部服务。
    /// </summary>
    public interface IAttributeSetService
    {
        IDictionary<string, string> GetPropertyExtensionFieldDictionary(string attributeSetId);

    }
}
