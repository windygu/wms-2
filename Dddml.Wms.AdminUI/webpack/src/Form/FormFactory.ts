import Application from "../Application";
import config from "../../config/view/tables";
import EntityForm from "./EntityForm";

export default class FormFactory {
    static application: Application;

    static createEntityForm(metadata: EntityMetadataInterface, data = {}) {
        return new EntityForm(
            metadata,
            config[metadata.name],
            data
        )
    }
}