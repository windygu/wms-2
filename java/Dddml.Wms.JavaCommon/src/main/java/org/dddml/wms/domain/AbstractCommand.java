package org.dddml.wms.domain;

public abstract class AbstractCommand implements Command {

    private String commandType;
    private String commandId;
    private String requesterId;

    public String getCommandType() {
        return this.commandType;
    }

    public void setCommandType(String commandType) {
        this.commandType = commandType;
    }

    public String getCommandId() {
        return this.commandId;
    }

    public void setCommandId(String commandId) {
        this.commandId = commandId;
    }

    public String getRequesterId() {
        return this.requesterId;
    }

    public void setRequesterId(String requesterId) {
        this.requesterId = requesterId;
    }

}


