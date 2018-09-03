package org.dddml.wms;

import org.dddml.wms.domain.attributesetinstanceextensionfield.*;
import org.dddml.wms.domain.attributesetinstanceextensionfieldgroup.*;
import org.dddml.wms.specialization.ApplicationContext;
import org.dddml.wms.support.AttributeSetInstanceExtensionFieldUtils;

/**
 * Created by yangjiefeng on 2018/1/30.
 */
public class InitAttributeSetInstanceExtensionFields {

    public static void createAttributeSetInstanceExtensionFieldsAndGroups() {
        AttributeSetInstanceExtensionFieldApplicationService attributeSetInstanceExtensionFieldApplicationService = (AttributeSetInstanceExtensionFieldApplicationService) ApplicationContext.current.get("attributeSetInstanceExtensionFieldApplicationService");
        AttributeSetInstanceExtensionFieldGroupApplicationService attributeSetInstanceExtensionFieldGroupApplicationService = (AttributeSetInstanceExtensionFieldGroupApplicationService) ApplicationContext.current.get("attributeSetInstanceExtensionFieldGroupApplicationService");

        for (AttributeSetInstanceExtensionFieldCommand.CreateAttributeSetInstanceExtensionField f : AttributeSetInstanceExtensionFieldUtils.CreateAttributeSetInstanceExtensionFields()) {
            f.setCommandId(f.getName());
            attributeSetInstanceExtensionFieldApplicationService.when(f);
        }

        for (AttributeSetInstanceExtensionFieldGroupCommand.CreateAttributeSetInstanceExtensionFieldGroup fg : AttributeSetInstanceExtensionFieldUtils.CreateAttributeSetInstanceExtensionFieldGroups()) {
            fg.setCommandId(fg.getId());
            attributeSetInstanceExtensionFieldGroupApplicationService.when(fg);
        }
    }


}
