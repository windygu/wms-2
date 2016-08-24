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
            for (let type of PropertyMetadata.types) {
                if (this.metadata.type == type) {
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

        for (let metadata of valueObjectsMetadata) {
            if (this.metadata.type == metadata.name) {
                return metadata;
            }
        }

        return null;
    }
}