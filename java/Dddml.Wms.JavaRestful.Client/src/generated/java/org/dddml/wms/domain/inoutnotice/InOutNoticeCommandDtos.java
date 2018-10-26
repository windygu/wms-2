package org.dddml.wms.domain.inoutnotice;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;

public class InOutNoticeCommandDtos
{
    private InOutNoticeCommandDtos() {
    }

    public static class InOutNoticeActionRequestContent extends org.dddml.wms.domain.AbstractCommand {

        public String getCommandType() {
            return "InOutNoticeAction";
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

