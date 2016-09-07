package org.dddml.wms.domain;


public class RemoveMonthPlanDto extends CreateOrMergePatchMonthPlanDto
{

    @Override
    public String getCommandType() {
        return COMMAND_TYPE_REMOVE;
    }

    public MonthPlanCommand.RemoveMonthPlan toRemoveMonthPlan()
    {
        AbstractMonthPlanCommand.SimpleRemoveMonthPlan command = new AbstractMonthPlanCommand.SimpleRemoveMonthPlan();
        ((AbstractMonthPlanCommandDto)this).copyTo(command);
        return command;
    }

}

