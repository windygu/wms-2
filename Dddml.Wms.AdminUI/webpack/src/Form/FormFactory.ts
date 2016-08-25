import Application from "../Application";
import config from "../../config/view/tables";
import AggregateForm from "./AggregateForm";

export default class FormFactory {
    static application: Application;

    static createAggregateForm(metadata: AggregateMetadataInterface, data = {}) {
        return new AggregateForm(
            metadata,
            config[metadata.name],
            data
        )
    }
}