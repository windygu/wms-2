namespace Dddml.Wms.Domain {

	export class InOutLineId {

		private inOutDocumentNumber: string;

		getInOutDocumentNumber(): string {
			return this.inOutDocumentNumber;
		}

		setInOutDocumentNumber(inOutDocumentNumber: string) {
			this.inOutDocumentNumber = inOutDocumentNumber;
		}

		private lineNumber: string;

		getLineNumber(): string {
			return this.lineNumber;
		}

		setLineNumber(lineNumber: string) {
			this.lineNumber = lineNumber;
		}

	}
}

