using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Dddml.Wms.Domain.InventoryItem
{
    public static partial class InventoryItemUtils
    {

        public static void CreateOrUpdateInventoryItems(IInventoryItemApplicationService invItemApplicationService, IList<ICreateInventoryItemEntry> inventoryItemEntries)
        {
            foreach (var e in inventoryItemEntries)
            {
                var iitem = invItemApplicationService.Get(e.InventoryItemId);
                if (iitem == null)
                {
                    var createInventoryItem = new CreateInventoryItem();
                    createInventoryItem.InventoryItemId = e.InventoryItemId;
                    createInventoryItem.Entries.Add(e);
                    invItemApplicationService.When(createInventoryItem);
                }
                else
                {
                    var updateInventoryItem = new MergePatchInventoryItem();
                    updateInventoryItem.InventoryItemId = e.InventoryItemId;
                    updateInventoryItem.Version = iitem.Version; // /////////////////
                    updateInventoryItem.InventoryItemEntryCommands.Add(e);
                    invItemApplicationService.When(updateInventoryItem);
                }
            }
        }

    }
}
