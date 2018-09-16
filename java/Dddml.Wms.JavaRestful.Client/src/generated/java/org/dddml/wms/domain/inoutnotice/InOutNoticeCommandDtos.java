package org.dddml.wms.domain.inoutnotice;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;

public class InOutNoticeCommandDtos
{
    private InOutNoticeCommandDtos() {
    }

    public static class InOutNoticeActionRequestContent {

        public String getCommandType() {
            return "InOutNoticeAction";
        }

        /**
         * Value
         */
        private String value;

        public String getValue() {
            return this.value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        /**
         * In Out Notice Id
         */
        private String inOutNoticeId;

        public String getInOutNoticeId() {
            return this.inOutNoticeId;
        }

        public void setInOutNoticeId(String inOutNoticeId) {
            this.inOutNoticeId = inOutNoticeId;
        }

        /**
         * Version
         */
        private Long version;

        public Long getVersion() {
            return this.version;
        }

        public void setVersion(Long version) {
            this.version = version;
        }

        /**
         * Command Id
         */
        private String commandId;

        public String getCommandId() {
            return this.commandId;
        }

        public void setCommandId(String commandId) {
            this.commandId = commandId;
        }

        /**
         * Requester Id
         */
        private String requesterId;

        public String getRequesterId() {
            return this.requesterId;
        }

        public void setRequesterId(String requesterId) {
            this.requesterId = requesterId;
        }

    }

}
