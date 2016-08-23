namespace Dddml.Wms.Domain {

	export class Contact {

		private personalName: PersonalName;

		getPersonalName(): PersonalName {
			if(!this.personalName) {
				this.personalName = new PersonalName(); 
			}
			return this.personalName;
		}

		setPersonalName(personalName: PersonalName) {
			this.personalName = personalName;
		}

		private phoneNumber: string;

		getPhoneNumber(): string {
			return this.phoneNumber;
		}

		setPhoneNumber(phoneNumber: string) {
			this.phoneNumber = phoneNumber;
		}

		private address: string;

		getAddress(): string {
			return this.address;
		}

		setAddress(address: string) {
			this.address = address;
		}

	}
}

