﻿// <autogenerated>
//   This file was generated by T4 code generator GenerateProductDomain.tt.
//   Any changes made to this file manually will be lost next time the file is regenerated.
// </autogenerated>

using System;
using System.Collections.Generic;
using Dddml.Wms.Specialization;
using Dddml.Wms.Domain;
using Dddml.Wms.Domain.Product;

namespace Dddml.Wms.Domain.Product
{

	public static partial class ProductStateDtoExtension
	{

        public static IProductCommand ToCreateOrMergePatchProduct(this ProductStateDtoWrapper state)
        {
            return state.ToCreateOrMergePatchProduct<CreateProductDto, MergePatchProductDto, CreateGoodIdentificationDto, MergePatchGoodIdentificationDto>();
        }

        public static DeleteProductDto ToDeleteProduct(this ProductStateDtoWrapper state)
        {
            return state.ToDeleteProduct<DeleteProductDto>();
        }

        public static MergePatchProductDto ToMergePatchProduct(this ProductStateDtoWrapper state)
        {
            return state.ToMergePatchProduct<MergePatchProductDto, CreateGoodIdentificationDto, MergePatchGoodIdentificationDto>();
        }

        public static CreateProductDto ToCreateProduct(this ProductStateDtoWrapper state)
        {
            return state.ToCreateProduct<CreateProductDto, CreateGoodIdentificationDto>();
        }
		

	}

}

