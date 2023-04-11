package org.example.Dao;

import org.example.models.Model;

import java.util.List;

public interface ModelDao {

   Model getModel(int ModelId);

   List<Model> getModels();

   Model createModel(Model newModel);

   void updateModel(Model updatedModel);

}
