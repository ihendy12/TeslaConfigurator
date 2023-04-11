package org.example.ControllersAndView;

import org.example.Dao.ModelDao;
import org.example.models.Model;

import java.util.List;

public class adminController {

    // The view manages all the user interaction, inputs and outputs.
    private final adminView view;

    // The controller expects these DAO's to be "injected" into via its constructor
    private ModelDao modelDao;


    public adminController(BasicConsole console, ModelDao modelDao) {
        view = new adminView(console);
        this.modelDao = modelDao;
    }

    private void displayModel() {
        // Make sure we have the appropriate DAOs
        if (modelDao == null) {
            view.printErrorMessage("You must implement CustomerDao and pass it into the controller for this option to work.");
            return;
        }
        // Get the list of customers so the user can choose one
        List<Model> models = modelDao.getModels();

        // Display the list of customers and ask for selection
        Model model = view.selectModels(models);
        if (model == null) {
            // User cancelled
            return;
        }
        // Show details to the user
        view.printModelDetails(model);
    }

}
