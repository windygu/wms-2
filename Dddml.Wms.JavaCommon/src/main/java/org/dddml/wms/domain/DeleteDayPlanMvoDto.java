package org.dddml.wms.domain;


public class DeleteDayPlanMvoDto extends AbstractDayPlanMvoCommandDto
{

    @Override
    public String getCommandType() {
        return COMMAND_TYPE_DELETE;
    }

    public DayPlanMvoCommand.DeleteDayPlanMvo toDeleteDayPlanMvo()
    {
        AbstractDayPlanMvoCommand.SimpleDeleteDayPlanMvo command = new AbstractDayPlanMvoCommand.SimpleDeleteDayPlanMvo();
        ((AbstractDayPlanMvoCommandDto)this).copyTo(command);
        return command;
    }

}

