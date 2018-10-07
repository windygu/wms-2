package org.dddml.wms.domain.picklist;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.partyrole.*;
import org.dddml.wms.domain.*;
import org.dddml.wms.domain.AbstractCommand;

public abstract class AbstractPicklistCommand extends AbstractCommand implements PicklistCommand
{
    private String picklistId;

    public String getPicklistId()
    {
        return this.picklistId;
    }

    public void setPicklistId(String picklistId)
    {
        this.picklistId = picklistId;
    }

    private Long version;

    public Long getVersion()
    {
        return this.version;
    }

    public void setVersion(Long version)
    {
        this.version = version;
    }


    public static abstract class AbstractCreateOrMergePatchPicklist extends AbstractPicklistCommand implements CreateOrMergePatchPicklist
    {
        private String description;

        public String getDescription()
        {
            return this.description;
        }

        public void setDescription(String description)
        {
            this.description = description;
        }

        private String facilityId;

        public String getFacilityId()
        {
            return this.facilityId;
        }

        public void setFacilityId(String facilityId)
        {
            this.facilityId = facilityId;
        }

        private String shipmentMethodTypeId;

        public String getShipmentMethodTypeId()
        {
            return this.shipmentMethodTypeId;
        }

        public void setShipmentMethodTypeId(String shipmentMethodTypeId)
        {
            this.shipmentMethodTypeId = shipmentMethodTypeId;
        }

        private String statusId;

        public String getStatusId()
        {
            return this.statusId;
        }

        public void setStatusId(String statusId)
        {
            this.statusId = statusId;
        }

        private java.sql.Timestamp picklistDate;

        public java.sql.Timestamp getPicklistDate()
        {
            return this.picklistDate;
        }

        public void setPicklistDate(java.sql.Timestamp picklistDate)
        {
            this.picklistDate = picklistDate;
        }

        private Long pickwaveId;

        public Long getPickwaveId()
        {
            return this.pickwaveId;
        }

        public void setPickwaveId(Long pickwaveId)
        {
            this.pickwaveId = pickwaveId;
        }

        private Boolean active;

        public Boolean getActive()
        {
            return this.active;
        }

        public void setActive(Boolean active)
        {
            this.active = active;
        }

        public PicklistRoleCommand.CreatePicklistRole newCreatePicklistRole()
        {
            AbstractPicklistRoleCommand.SimpleCreatePicklistRole c = new AbstractPicklistRoleCommand.SimpleCreatePicklistRole();
            c.setPicklistId(this.getPicklistId());

            return c;
        }

        public PicklistRoleCommand.MergePatchPicklistRole newMergePatchPicklistRole()
        {
            AbstractPicklistRoleCommand.SimpleMergePatchPicklistRole c = new AbstractPicklistRoleCommand.SimpleMergePatchPicklistRole();
            c.setPicklistId(this.getPicklistId());

            return c;
        }

        public PicklistRoleCommand.RemovePicklistRole newRemovePicklistRole()
        {
            AbstractPicklistRoleCommand.SimpleRemovePicklistRole c = new AbstractPicklistRoleCommand.SimpleRemovePicklistRole();
            c.setPicklistId(this.getPicklistId());

            return c;
        }

    }

    public static abstract class AbstractCreatePicklist extends AbstractCreateOrMergePatchPicklist implements CreatePicklist
    {
        @Override
        public String getCommandType() {
            return COMMAND_TYPE_CREATE;
        }

        private CreatePicklistRoleCommandCollection picklistRoles = new SimpleCreatePicklistRoleCommandCollection();

        public CreatePicklistRoleCommandCollection getPicklistRoles()
        {
            return this.picklistRoles;
        }

    }

    public static abstract class AbstractMergePatchPicklist extends AbstractCreateOrMergePatchPicklist implements MergePatchPicklist
    {
        @Override
        public String getCommandType() {
            return COMMAND_TYPE_MERGE_PATCH;
        }

        private Boolean isPropertyDescriptionRemoved;

        public Boolean getIsPropertyDescriptionRemoved()
        {
            return this.isPropertyDescriptionRemoved;
        }

        public void setIsPropertyDescriptionRemoved(Boolean removed)
        {
            this.isPropertyDescriptionRemoved = removed;
        }

        private Boolean isPropertyFacilityIdRemoved;

        public Boolean getIsPropertyFacilityIdRemoved()
        {
            return this.isPropertyFacilityIdRemoved;
        }

        public void setIsPropertyFacilityIdRemoved(Boolean removed)
        {
            this.isPropertyFacilityIdRemoved = removed;
        }

        private Boolean isPropertyShipmentMethodTypeIdRemoved;

        public Boolean getIsPropertyShipmentMethodTypeIdRemoved()
        {
            return this.isPropertyShipmentMethodTypeIdRemoved;
        }

        public void setIsPropertyShipmentMethodTypeIdRemoved(Boolean removed)
        {
            this.isPropertyShipmentMethodTypeIdRemoved = removed;
        }

        private Boolean isPropertyStatusIdRemoved;

        public Boolean getIsPropertyStatusIdRemoved()
        {
            return this.isPropertyStatusIdRemoved;
        }

        public void setIsPropertyStatusIdRemoved(Boolean removed)
        {
            this.isPropertyStatusIdRemoved = removed;
        }

        private Boolean isPropertyPicklistDateRemoved;

        public Boolean getIsPropertyPicklistDateRemoved()
        {
            return this.isPropertyPicklistDateRemoved;
        }

        public void setIsPropertyPicklistDateRemoved(Boolean removed)
        {
            this.isPropertyPicklistDateRemoved = removed;
        }

        private Boolean isPropertyPickwaveIdRemoved;

        public Boolean getIsPropertyPickwaveIdRemoved()
        {
            return this.isPropertyPickwaveIdRemoved;
        }

        public void setIsPropertyPickwaveIdRemoved(Boolean removed)
        {
            this.isPropertyPickwaveIdRemoved = removed;
        }

        private Boolean isPropertyActiveRemoved;

        public Boolean getIsPropertyActiveRemoved()
        {
            return this.isPropertyActiveRemoved;
        }

        public void setIsPropertyActiveRemoved(Boolean removed)
        {
            this.isPropertyActiveRemoved = removed;
        }

        private PicklistRoleCommandCollection picklistRoleCommands = new SimplePicklistRoleCommandCollection();

        public PicklistRoleCommandCollection getPicklistRoleCommands()
        {
            return this.picklistRoleCommands;
        }

    }

    public static class SimpleCreatePicklist extends AbstractCreatePicklist
    {
    }

    
    public static class SimpleMergePatchPicklist extends AbstractMergePatchPicklist
    {
    }

    
	public static class SimpleDeletePicklist extends AbstractPicklistCommand implements DeletePicklist
	{
        @Override
        public String getCommandType() {
            return COMMAND_TYPE_DELETE;
        }
	}

    
    public static class SimpleCreatePicklistRoleCommandCollection implements CreatePicklistRoleCommandCollection {
        private List<PicklistRoleCommand.CreatePicklistRole> innerCommands = new ArrayList<PicklistRoleCommand.CreatePicklistRole>();

        public void add(PicklistRoleCommand.CreatePicklistRole c) {
            innerCommands.add(c);
        }

        public void remove(PicklistRoleCommand.CreatePicklistRole c) {
            innerCommands.remove(c);
        }

        public void clear() {
            innerCommands.clear();
        }

        @Override
        public Iterator<PicklistRoleCommand.CreatePicklistRole> iterator() {
            return innerCommands.iterator();
        }
    }

    public static class SimplePicklistRoleCommandCollection implements PicklistRoleCommandCollection {
        private List<PicklistRoleCommand> innerCommands = new ArrayList<PicklistRoleCommand>();

        public void add(PicklistRoleCommand c) {
            innerCommands.add(c);
        }

        public void remove(PicklistRoleCommand c) {
            innerCommands.remove(c);
        }

        public void clear() {
            innerCommands.clear();
        }

        @Override
        public Iterator<PicklistRoleCommand> iterator() {
            return innerCommands.iterator();
        }
    }


}

