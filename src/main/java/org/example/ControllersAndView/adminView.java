package org.example.ControllersAndView;

import org.example.models.Model;

import java.util.List;

public class adminView {
    private final BasicConsole console;

    // Constructor expect a console object to print to.
    public adminView(BasicConsole console) {
        this.console = console;
    }

    public void printErrorMessage(String s) {
        System.out.println(s);
    }

    public Model selectModels(List<Model> models) {
            while (true) {

                Integer modelId = console.promptForInteger("Enter customer id [0 to cancel]: ");
                if (modelId == null || modelId == 0) {
                    return null;
                }
                Model selectedModel = findModelById(models, modelId);
                if (selectedModel != null) {
                    return selectedModel;
                }
                printErrorMessage("That's not a valid id, please try again.");
            }
        }

    private Model findModelById(List<Model> models, int modelId) {
        for (Model model : models) {
            if (model.getModelId() == modelId) {
                return model;
            }
        }
        return null;
    }

    public void printModelDetails(Model model) {
        model.getModelId();
        console.pauseOutput();
    }

}
