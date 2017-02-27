using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace Dddml.Wms.Specialization
{
    public class PropertyMetadataDto
    {

        public PropertyMetadataDto()
        { }

        public PropertyMetadataDto(string name, string typeName, bool isFilteringProperty)
            : this(name, typeName, isFilteringProperty, null)
        {
        }

        public PropertyMetadataDto(string name, string typeName, bool isFilteringProperty, string targetPropertyName)
        {
            this.Name = name;
            this.TypeName = typeName;
            this.IsFilteringProperty = IsFilteringProperty;
            this.TargetPropertyName = targetPropertyName;
        }

        public string Name { get; set; }

        public string TypeName { get; set; }

        public string TargetPropertyName { get; set; }

        public bool? IsBasicType { get; set; }

        public string DeclaringObjectName { get; set; }

        public string DisplayName { get; set; }

        public string Description { get; set; }

        public int? Length { get; set; }

        public string GenericTypeName { get; set; }

        public string ReferenceTypeName { get; set; }

        public string ReferenceName { get; set; }

        public string ItemTypeName { get; set; }

        public string InverseOf { get; set; }

        public bool? IsDerived { get; set; }

        public bool? IsTransient { get; set; }

        public bool? IsHoisted { get; set; }

        public bool? IsReallyFlattened { get; set; }

        public string SourceChainingName { get; set; }

        public string OriginPropertyName { get; set; }

        public bool? IsNullableType { get; set; }

        public bool? IsDiscriminator { get; set; }

        public bool? IsReservedProperty { get; set; }

        public bool? IsReservedPropertyVersion { get; set; }

        public bool? IsReservedPropertyDeleted { get; set; }

        public bool? IsReservedPropertyActive { get; set; }

        public bool? IsReservedPropertyCreatedBy { get; set; }

        public bool? IsReservedPropertyCreatedAt { get; set; }

        public bool? IsReservedPropertyUpdatedBy { get; set; }

        public bool? IsReservedPropertyUpdatedAt { get; set; }

        public bool? IsId { get; set; }

        public bool? IsGlobalId { get; set; }

        public bool? IsOuterId { get; set; }

        public string DerivedFrom { get; set; }

        public bool? IsFilteringProperty { get; set; }

        public virtual bool IsCollectionProperty
        {
            get { return !String.IsNullOrWhiteSpace(ItemTypeName); }
        }

        public virtual bool IsReferenceIdProperty
        {
            get { return !String.IsNullOrWhiteSpace(ReferenceTypeName); }
        }


    }
}
