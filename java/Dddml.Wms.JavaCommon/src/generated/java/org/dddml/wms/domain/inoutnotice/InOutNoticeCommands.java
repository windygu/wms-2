package org.dddml.wms.domain.inoutnotice;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;

public class InOutNoticeCommands
{
    private InOutNoticeCommands() {
    }

    public static class InOutNoticeAction extends org.dddml.wms.domain.AbstractCommand implements InOutNoticeCommand {

        public String getCommandType() {
            return "InOutNoticeAction";
        }

        public void setCommandType(String commandType) {
            //do nothing
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

    }

}

