﻿// <autogenerated>
//   This file was generated by T4 code generator GenerateUomConversionDomain.tt.
//   Any changes made to this file manually will be lost next time the file is regenerated.
// </autogenerated>

using System;
using System.Collections.Generic;
using Dddml.Wms.Specialization;
using Dddml.Wms.Domain;
using Dddml.Wms.Domain.UomConversion;

namespace Dddml.Wms.Domain.UomConversion
{
	public interface IUomConversionCommand : IAggregateCommand<UomConversionId, long>, ICommandDto
	{
		long Version { get; set; }

		UomConversionId UomConversionId { get; set; }

	}


	public interface ICreateOrMergePatchOrDeleteUomConversion : IUomConversionCommand
	{

		double? ConversionFactor { get; set; }

		string CustomMethodId { get; set; }

		long? DecimalScale { get; set; }

		string RoundingMode { get; set; }

		bool? Active { get; set; }


	}

	public interface ICreateUomConversion : ICreateOrMergePatchOrDeleteUomConversion
	{
	}

	public interface IMergePatchUomConversion : ICreateOrMergePatchOrDeleteUomConversion
	{

		bool IsPropertyConversionFactorRemoved { get; set; }

		bool IsPropertyCustomMethodIdRemoved { get; set; }

		bool IsPropertyDecimalScaleRemoved { get; set; }

		bool IsPropertyRoundingModeRemoved { get; set; }

		bool IsPropertyActiveRemoved { get; set; }


	}

	public interface IDeleteUomConversion : ICreateOrMergePatchOrDeleteUomConversion
	{
	}


}

