import valueObjectsMetadata from '../../metadata/valueObjects';

export default class PropertyMetadata {
    public metadata;

    public static types = [
        'bool',
        'DateTime',
        'decimal',
        'int',
        'long',
        'string'
    ];

    constructor(metadata) {
        this.metadata = metadata;
    }

    isNormalType() {
        if (this.metadata.type) {
            for (let i = 0; i < PropertyMetadata.types.length; i++) {
                if (this.metadata.type == PropertyMetadata.types[i]) {
                    return true;
                }
            }

            return false;
        }

        return false;
    }

    isSet() {
        return this.metadata.itemType;
    }

    isValueObject() {
        return !this.isNormalType() && !this.isSet();
    }

    getValueObjectMetadata() {
        if (!this.isValueObject()) {
            return null;
        }

        for (let i = 0; i < valueObjectsMetadata.length; i++) {
            if (this.metadata.type == valueObjectsMetadata[i].name) {
                return valueObjectsMetadata[i];
            }
        }

        return null;
    }
}