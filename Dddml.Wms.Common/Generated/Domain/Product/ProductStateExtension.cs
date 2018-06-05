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

	public static partial class ProductStateExtension
	{

        public static IProductCommand ToCreateOrMergePatchProduct(this ProductState state)
        {
            return state.ToCreateOrMergePatchProduct<CreateProduct, MergePatchProduct, CreateGoodIdentification, MergePatchGoodIdentification>();
        }

        public static DeleteProduct ToDeleteProduct(this ProductState state)
        {
            return state.ToDeleteProduct<DeleteProduct>();
        }

        public static MergePatchProduct ToMergePatchProduct(this ProductState state)
        {
            return state.ToMergePatchProduct<MergePatchProduct, CreateGoodIdentification, MergePatchGoodIdentification>();
        }

        public static CreateProduct ToCreateProduct(this ProductState state)
        {
            return state.ToCreateProduct<CreateProduct, CreateGoodIdentification>();
        }
		

	}

}

