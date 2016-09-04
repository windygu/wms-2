package org.dddml.wms.domain;


public class RemoveDayPlanDto extends CreateOrMergePatchDayPlanDto
{

    @Override
    public String getCommandType() {
        return COMMAND_TYPE_REMOVE;
    }

    public DayPlanCommand.RemoveDayPlan toRemoveDayPlan()
    {
        AbstractDayPlanCommand.SimpleRemoveDayPlan command = new AbstractDayPlanCommand.SimpleRemoveDayPlan();
        ((AbstractDayPlanCommandDto)this).copyTo(command);
        return command;
    }

}

