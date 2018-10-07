package org.dddml.wms.domain.inventoryitem;

/**
 * Created by yangjiefeng on 2018/1/31.
 */
public class InventoryItemUtils {

    public static void createOrUpdateInventoryItems(InventoryItemApplicationService invItemApplicationService, java.util.List<InventoryItemEntryCommand.CreateInventoryItemEntry> inventoryItemEntries) {
        for (InventoryItemEntryCommand.CreateInventoryItemEntry e : inventoryItemEntries) {
            InventoryItemState iitem = invItemApplicationService.get(e.getInventoryItemId());
            if (iitem == null) {
                InventoryItemCommand.CreateInventoryItem createInventoryItem = new AbstractInventoryItemCommand.SimpleCreateInventoryItem();
                createInventoryItem.setInventoryItemId(e.getInventoryItemId());
                createInventoryItem.getCreateInventoryItemEntryCommands().add(e);
                invItemApplicationService.when(createInventoryItem);
            } else {
                InventoryItemCommand.MergePatchInventoryItem updateInventoryItem = new AbstractInventoryItemCommand.SimpleMergePatchInventoryItem();
                updateInventoryItem.setInventoryItemId(e.getInventoryItemId());
                updateInventoryItem.setVersion(iitem.getVersion()); // /////////////////
                updateInventoryItem.getInventoryItemEntryCommands().add(e);
                invItemApplicationService.when(updateInventoryItem);
            }
        }
    }

}
