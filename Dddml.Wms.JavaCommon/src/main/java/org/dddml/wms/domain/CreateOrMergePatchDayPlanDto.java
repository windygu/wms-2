package org.dddml.wms.domain;

import java.util.Date;

public class CreateOrMergePatchDayPlanDto extends AbstractDayPlanCommandDto
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

    private Boolean active;

    public Boolean getActive()
    {
        return this.active;
    }

    public void setActive(Boolean active)
    {
        this.active = active;
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

    private Boolean isPropertyActiveRemoved;

    public Boolean getIsPropertyActiveRemoved()
    {
        return this.isPropertyActiveRemoved;
    }

    public void setIsPropertyActiveRemoved(Boolean removed)
    {
        this.isPropertyActiveRemoved = removed;
    }

    public void copyTo(AbstractDayPlanCommand.AbstractCreateOrMergePatchDayPlan command)
    {
        ((AbstractDayPlanCommandDto) this).copyTo(command);
        command.setDescription(this.getDescription());
        command.setActive(this.getActive());
    }

    public DayPlanCommand toCommand()
    {
        if (COMMAND_TYPE_CREATE.equals(getCommandType())) {
            AbstractDayPlanCommand.SimpleCreateDayPlan command = new AbstractDayPlanCommand.SimpleCreateDayPlan();
            copyTo((AbstractDayPlanCommand.AbstractCreateDayPlan) command);
            return command;
        } else if (COMMAND_TYPE_MERGE_PATCH.equals(getCommandType())) {
            AbstractDayPlanCommand.SimpleMergePatchDayPlan command = new AbstractDayPlanCommand.SimpleMergePatchDayPlan();
            copyTo((AbstractDayPlanCommand.SimpleMergePatchDayPlan) command);
            return command;
        } 
        else if (COMMAND_TYPE_REMOVE.equals(getCommandType())) {
            AbstractDayPlanCommand.SimpleRemoveDayPlan command = new AbstractDayPlanCommand.SimpleRemoveDayPlan();
            ((AbstractDayPlanCommandDto) this).copyTo(command);
            return command;
        }
        throw new IllegalStateException("Unknown command type:" + getCommandType());
    }

    public void copyTo(AbstractDayPlanCommand.AbstractCreateDayPlan command)
    {
        copyTo((AbstractDayPlanCommand.AbstractCreateOrMergePatchDayPlan) command);
    }

    public void copyTo(AbstractDayPlanCommand.AbstractMergePatchDayPlan command)
    {
        copyTo((AbstractDayPlanCommand.AbstractCreateOrMergePatchDayPlan) command);
        command.setIsPropertyDescriptionRemoved(this.getIsPropertyDescriptionRemoved());
        command.setIsPropertyActiveRemoved(this.getIsPropertyActiveRemoved());
    }

    public static class CreateDayPlanDto extends CreateOrMergePatchDayPlanDto
    {
        @Override
        public String getCommandType() {
            return COMMAND_TYPE_CREATE;
        }
        public DayPlanCommand.CreateDayPlan toCreateDayPlan()
        {
            return (DayPlanCommand.CreateDayPlan) toCommand();
        }

    }

    public static class MergePatchDayPlanDto extends CreateOrMergePatchDayPlanDto
    {
        @Override
        public String getCommandType() {
            return COMMAND_TYPE_MERGE_PATCH;
        }
        public DayPlanCommand.MergePatchDayPlan toMergePatchDayPlan()
        {
            return (DayPlanCommand.MergePatchDayPlan) toCommand();
        }

    }

}

