package org.max.mappers;

import org.max.models.dto.CharacterModelDto;
import org.max.models.dto.CharacterModelUpdateAndSaveDto;
import org.max.models.entities.CharacterModel;

import java.util.List;

public interface CharacterModelMapper {

    /**
     * map CharacterModelUpdateAndSaveDto to CharacterModel
     * @param modelUpdateAndSaveDto - the model you want to save or update
     * @see CharacterModelUpdateAndSaveDto
     * @param model - CharacterModel object
     * @see CharacterModel
     */
    void mapToEntity(CharacterModelUpdateAndSaveDto modelUpdateAndSaveDto, CharacterModel model);

    /**
     * map CharacterModel to CharacterModelDto
     * @param model - the model from database
     * @see CharacterModel
     * @param modelDto - the modelDto that you want to show to user
     * @see CharacterModelDto
     */
    void mapToDto(CharacterModel model, CharacterModelDto modelDto);

    /**
     * map List of CharacterModel to List of CharacterModelDto
     * @param models - the model from database
     * @param modelsDto - the modelDto that you want to show to user
     * @see CharacterModel
     * @return object type CharacterModelDto
     * @see CharacterModelDto
     */
    void mapToDto(List<CharacterModel> models, List<CharacterModelDto> modelsDto);
}
