﻿// <autogenerated>
//   This file was generated by T4 code generator GenerateFacilityDomain.tt.
//   Any changes made to this file manually will be lost next time the file is regenerated.
// </autogenerated>

using System;
using System.Linq;
using System.Collections.Generic;
using Dddml.Wms.Specialization;
using Dddml.Wms.Domain;
using Dddml.Wms.Domain.Facility;

namespace Dddml.Wms.Domain.Facility
{

	public abstract class FacilityCommandDtoBase : ICommandDto, ICreateFacility, IMergePatchFacility, IDeleteFacility
	{

		string IAggregateCommand<string, long>.AggregateId
		{
			get
			{
				return ((ICreateOrMergePatchOrDeleteFacility)this).FacilityId;
			}
		}


		long IAggregateCommand<string, long>.AggregateVersion
		{
			get
			{
				return this.Version != null ? this.Version.Value : default(long);
			}
		}

        long IFacilityCommand.Version
        {
            get { return this.Version != null ? this.Version.Value : default(long); }
            set { this.Version = value; }
        }

		public virtual long? Version { get; set; }

		public virtual string RequesterId { get; set; }

		public virtual string CommandId { get; set; }

        object ICommand.RequesterId
        {
            get { return this.RequesterId; }
            set { this.RequesterId = (string)value; }
        }

        string ICommand.CommandId
        {
            get { return this.CommandId; }
            set { this.CommandId = value; }
        }

		public virtual string FacilityId { get; set; }

		public virtual string FacilityTypeId { get; set; }

		public virtual string ParentFacilityId { get; set; }

		public virtual string OwnerPartyId { get; set; }

		public virtual string DefaultInventoryItemTypeId { get; set; }

		public virtual string FacilityName { get; set; }

		public virtual string PrimaryFacilityGroupId { get; set; }

		public virtual long? OldSquareFootage { get; set; }

		public virtual decimal? FacilitySize { get; set; }

		public virtual string FacilitySizeUomId { get; set; }

		public virtual string ProductStoreId { get; set; }

		public virtual long? DefaultDaysToShip { get; set; }

		public virtual DateTime? OpenedDate { get; set; }

		public virtual DateTime? ClosedDate { get; set; }

		public virtual string Description { get; set; }

		public virtual string DefaultDimensionUomId { get; set; }

		public virtual string DefaultWeightUomId { get; set; }

		public virtual string GeoPointId { get; set; }

		public virtual bool? Active { get; set; }

		public virtual bool? IsPropertyFacilityTypeIdRemoved { get; set; }

        bool IMergePatchFacility.IsPropertyFacilityTypeIdRemoved
        {
            get
            {
                var b = this.IsPropertyFacilityTypeIdRemoved;
                if (b != null && b.HasValue)
                {
                    return b.Value;
                }
                return false;
            }
            set
            {
                this.IsPropertyFacilityTypeIdRemoved = value;
            }
        }

		public virtual bool? IsPropertyParentFacilityIdRemoved { get; set; }

        bool IMergePatchFacility.IsPropertyParentFacilityIdRemoved
        {
            get
            {
                var b = this.IsPropertyParentFacilityIdRemoved;
                if (b != null && b.HasValue)
                {
                    return b.Value;
                }
                return false;
            }
            set
            {
                this.IsPropertyParentFacilityIdRemoved = value;
            }
        }

		public virtual bool? IsPropertyOwnerPartyIdRemoved { get; set; }

        bool IMergePatchFacility.IsPropertyOwnerPartyIdRemoved
        {
            get
            {
                var b = this.IsPropertyOwnerPartyIdRemoved;
                if (b != null && b.HasValue)
                {
                    return b.Value;
                }
                return false;
            }
            set
            {
                this.IsPropertyOwnerPartyIdRemoved = value;
            }
        }

		public virtual bool? IsPropertyDefaultInventoryItemTypeIdRemoved { get; set; }

        bool IMergePatchFacility.IsPropertyDefaultInventoryItemTypeIdRemoved
        {
            get
            {
                var b = this.IsPropertyDefaultInventoryItemTypeIdRemoved;
                if (b != null && b.HasValue)
                {
                    return b.Value;
                }
                return false;
            }
            set
            {
                this.IsPropertyDefaultInventoryItemTypeIdRemoved = value;
            }
        }

		public virtual bool? IsPropertyFacilityNameRemoved { get; set; }

        bool IMergePatchFacility.IsPropertyFacilityNameRemoved
        {
            get
            {
                var b = this.IsPropertyFacilityNameRemoved;
                if (b != null && b.HasValue)
                {
                    return b.Value;
                }
                return false;
            }
            set
            {
                this.IsPropertyFacilityNameRemoved = value;
            }
        }

		public virtual bool? IsPropertyPrimaryFacilityGroupIdRemoved { get; set; }

        bool IMergePatchFacility.IsPropertyPrimaryFacilityGroupIdRemoved
        {
            get
            {
                var b = this.IsPropertyPrimaryFacilityGroupIdRemoved;
                if (b != null && b.HasValue)
                {
                    return b.Value;
                }
                return false;
            }
            set
            {
                this.IsPropertyPrimaryFacilityGroupIdRemoved = value;
            }
        }

		public virtual bool? IsPropertyOldSquareFootageRemoved { get; set; }

        bool IMergePatchFacility.IsPropertyOldSquareFootageRemoved
        {
            get
            {
                var b = this.IsPropertyOldSquareFootageRemoved;
                if (b != null && b.HasValue)
                {
                    return b.Value;
                }
                return false;
            }
            set
            {
                this.IsPropertyOldSquareFootageRemoved = value;
            }
        }

		public virtual bool? IsPropertyFacilitySizeRemoved { get; set; }

        bool IMergePatchFacility.IsPropertyFacilitySizeRemoved
        {
            get
            {
                var b = this.IsPropertyFacilitySizeRemoved;
                if (b != null && b.HasValue)
                {
                    return b.Value;
                }
                return false;
            }
            set
            {
                this.IsPropertyFacilitySizeRemoved = value;
            }
        }

		public virtual bool? IsPropertyFacilitySizeUomIdRemoved { get; set; }

        bool IMergePatchFacility.IsPropertyFacilitySizeUomIdRemoved
        {
            get
            {
                var b = this.IsPropertyFacilitySizeUomIdRemoved;
                if (b != null && b.HasValue)
                {
                    return b.Value;
                }
                return false;
            }
            set
            {
                this.IsPropertyFacilitySizeUomIdRemoved = value;
            }
        }

		public virtual bool? IsPropertyProductStoreIdRemoved { get; set; }

        bool IMergePatchFacility.IsPropertyProductStoreIdRemoved
        {
            get
            {
                var b = this.IsPropertyProductStoreIdRemoved;
                if (b != null && b.HasValue)
                {
                    return b.Value;
                }
                return false;
            }
            set
            {
                this.IsPropertyProductStoreIdRemoved = value;
            }
        }

		public virtual bool? IsPropertyDefaultDaysToShipRemoved { get; set; }

        bool IMergePatchFacility.IsPropertyDefaultDaysToShipRemoved
        {
            get
            {
                var b = this.IsPropertyDefaultDaysToShipRemoved;
                if (b != null && b.HasValue)
                {
                    return b.Value;
                }
                return false;
            }
            set
            {
                this.IsPropertyDefaultDaysToShipRemoved = value;
            }
        }

		public virtual bool? IsPropertyOpenedDateRemoved { get; set; }

        bool IMergePatchFacility.IsPropertyOpenedDateRemoved
        {
            get
            {
                var b = this.IsPropertyOpenedDateRemoved;
                if (b != null && b.HasValue)
                {
                    return b.Value;
                }
                return false;
            }
            set
            {
                this.IsPropertyOpenedDateRemoved = value;
            }
        }

		public virtual bool? IsPropertyClosedDateRemoved { get; set; }

        bool IMergePatchFacility.IsPropertyClosedDateRemoved
        {
            get
            {
                var b = this.IsPropertyClosedDateRemoved;
                if (b != null && b.HasValue)
                {
                    return b.Value;
                }
                return false;
            }
            set
            {
                this.IsPropertyClosedDateRemoved = value;
            }
        }

		public virtual bool? IsPropertyDescriptionRemoved { get; set; }

        bool IMergePatchFacility.IsPropertyDescriptionRemoved
        {
            get
            {
                var b = this.IsPropertyDescriptionRemoved;
                if (b != null && b.HasValue)
                {
                    return b.Value;
                }
                return false;
            }
            set
            {
                this.IsPropertyDescriptionRemoved = value;
            }
        }

		public virtual bool? IsPropertyDefaultDimensionUomIdRemoved { get; set; }

        bool IMergePatchFacility.IsPropertyDefaultDimensionUomIdRemoved
        {
            get
            {
                var b = this.IsPropertyDefaultDimensionUomIdRemoved;
                if (b != null && b.HasValue)
                {
                    return b.Value;
                }
                return false;
            }
            set
            {
                this.IsPropertyDefaultDimensionUomIdRemoved = value;
            }
        }

		public virtual bool? IsPropertyDefaultWeightUomIdRemoved { get; set; }

        bool IMergePatchFacility.IsPropertyDefaultWeightUomIdRemoved
        {
            get
            {
                var b = this.IsPropertyDefaultWeightUomIdRemoved;
                if (b != null && b.HasValue)
                {
                    return b.Value;
                }
                return false;
            }
            set
            {
                this.IsPropertyDefaultWeightUomIdRemoved = value;
            }
        }

		public virtual bool? IsPropertyGeoPointIdRemoved { get; set; }

        bool IMergePatchFacility.IsPropertyGeoPointIdRemoved
        {
            get
            {
                var b = this.IsPropertyGeoPointIdRemoved;
                if (b != null && b.HasValue)
                {
                    return b.Value;
                }
                return false;
            }
            set
            {
                this.IsPropertyGeoPointIdRemoved = value;
            }
        }

		public virtual bool? IsPropertyActiveRemoved { get; set; }

        bool IMergePatchFacility.IsPropertyActiveRemoved
        {
            get
            {
                var b = this.IsPropertyActiveRemoved;
                if (b != null && b.HasValue)
                {
                    return b.Value;
                }
                return false;
            }
            set
            {
                this.IsPropertyActiveRemoved = value;
            }
        }


        string ICommandDto.CommandType 
        {
            get { return this.GetCommandType(); }
        }

        protected abstract string GetCommandType();

	}


    public class CreateOrMergePatchOrDeleteFacilityDto : FacilityCommandDtoBase
    {
        private string _commandType;

        public virtual string CommandType
        {
            get { return _commandType; }
            set { _commandType = value; }
        }

        protected override string GetCommandType()
        {
            return this._commandType;
        }

    }



	public class CreateFacilityDto : CreateOrMergePatchOrDeleteFacilityDto
	{

        public override string CommandType
        {
            get { return this.GetCommandType(); }
            set { 
				// do nothing
            }
        }

        protected override string GetCommandType()
        {
            return Dddml.Wms.Specialization.CommandType.Create;
        }

	}


	public class MergePatchFacilityDto : CreateOrMergePatchOrDeleteFacilityDto
	{

        public override string CommandType
        {
            get { return this.GetCommandType(); }
            set { 
				// do nothing
            }
        }

        protected override string GetCommandType()
        {
            return Dddml.Wms.Specialization.CommandType.MergePatch;
        }

	}

	public class DeleteFacilityDto : CreateOrMergePatchOrDeleteFacilityDto
	{
        protected override string GetCommandType()
        {
            return Dddml.Wms.Specialization.CommandType.Delete;
        }


        public override string CommandType
        {
            get { return this.GetCommandType(); }
            set { 
				// do nothing
            }
        }

	}

    public static partial class FacilityCommandDtos
    {

    }

}

