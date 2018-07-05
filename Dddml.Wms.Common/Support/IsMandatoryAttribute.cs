using System;
using System.Text;

namespace Dddml.Wms.Support
{

    [AttributeUsage(AttributeTargets.Field | AttributeTargets.Property, AllowMultiple = false, Inherited = true)]
    public class IsMandatoryAttribute : Attribute
    {
        private bool isMandatory = true;

        public bool IsMandatory
        {
            get { return isMandatory; }
            set { isMandatory = value; }
        }

        public IsMandatoryAttribute()
        { }

        public IsMandatoryAttribute(bool isMandatory)
        {
            this.isMandatory = isMandatory;
        }

    }
}
