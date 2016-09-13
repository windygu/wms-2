package org.dddml.wms.domain;


public class RemoveYearPlanDto extends CreateOrMergePatchYearPlanDto
{

    @Override
    public String getCommandType() {
        return COMMAND_TYPE_REMOVE;
    }

    public YearPlanCommand.RemoveYearPlan toRemoveYearPlan()
    {
        AbstractYearPlanCommand.SimpleRemoveYearPlan command = new AbstractYearPlanCommand.SimpleRemoveYearPlan();
        ((AbstractYearPlanCommandDto)this).copyTo(command);
        return command;
    }
}

