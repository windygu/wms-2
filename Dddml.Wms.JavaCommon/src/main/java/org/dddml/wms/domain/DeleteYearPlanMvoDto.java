package org.dddml.wms.domain;


public class DeleteYearPlanMvoDto extends AbstractYearPlanMvoCommandDto
{

    @Override
    public String getCommandType() {
        return COMMAND_TYPE_DELETE;
    }

    public YearPlanMvoCommand.DeleteYearPlanMvo toDeleteYearPlanMvo()
    {
        AbstractYearPlanMvoCommand.SimpleDeleteYearPlanMvo command = new AbstractYearPlanMvoCommand.SimpleDeleteYearPlanMvo();
        ((AbstractYearPlanMvoCommandDto)this).copyTo(command);
        return command;
    }
}

