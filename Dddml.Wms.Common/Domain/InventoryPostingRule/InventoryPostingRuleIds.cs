using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace Dddml.Wms.Domain.InventoryPostingRule
{
    public static class InventoryPostingRuleIds
    {
        public const string QuantityOnHandUpdateProductSellableTotal = "OH->PrdSellableTotal";
        public const string QuantityOccupiedUpdateProductSellableTotal = "Oc->PrdSellableTotal";
        public const string QuantityReservedUpdateProductSellableTotal = "R->PrdSellableTotal";
        public const string QuantityVirtualUpdateProductSellableTotal = "V->PrdSellableTotal";
        public const string QuantityInTransitUpdateProductSellableTotal = "IT->PrdSellableTotal";

        // 需求数量 = 订单占用数量（Oc） - 在库数量（OH） + 保留数量（R） - 在途数量（IT）
        public const string QuantityOnHandUpdateProductRequiredTotal = "OH->PrdRequiredTotal";
        public const string QuantityOccupiedUpdateProductRequiredTotal = "Oc->PrdRequiredTotal";
        public const string QuantityReservedUpdateProductRequiredTotal = "R->PrdRequiredTotal";
        public const string QuantityInTransitUpdateProductRequiredTotal = "IT->PrdRequiredTotal";

        public const string OutputAccountNameSellableQuantity = "SellableQuantity";
        public const string OutputAccountNameRequiredQuantity = "RequiredQuantity";

    }
}
