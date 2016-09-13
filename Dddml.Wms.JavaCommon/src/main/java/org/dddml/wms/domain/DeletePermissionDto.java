package org.dddml.wms.domain;


public class DeletePermissionDto extends AbstractPermissionCommandDto
{

    @Override
    public String getCommandType() {
        return COMMAND_TYPE_DELETE;
    }

    public PermissionCommand.DeletePermission toDeletePermission()
    {
        AbstractPermissionCommand.SimpleDeletePermission command = new AbstractPermissionCommand.SimpleDeletePermission();
        ((AbstractPermissionCommandDto)this).copyTo(command);
        return command;
    }
}

