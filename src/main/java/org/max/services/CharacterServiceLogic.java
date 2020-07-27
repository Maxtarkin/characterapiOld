package org.max.services;

import org.max.models.dto.CharacterModelDto;
import org.max.models.dto.CharacterModelUpdateAndSaveDto;

import java.util.List;

public interface CharacterServiceLogic {

    /**
     * Save the record
     * @param modelUpdateAndSaveDto - the model you want to save to the dataBase
     * @return id of the saved model
     */
    long save(CharacterModelUpdateAndSaveDto modelUpdateAndSaveDto);

    /**
     * Get a single record
     * @param id - id of the model you want to get from the dataBase
     * @return CharacterModelDto object related to the id
     */
    CharacterModelDto get(long id);

    /** Get all records
     * @return a list of CharacterObjectDto objects stored in the data base
     */
    List<CharacterModelDto> list();

    /**
     * Update the record
     * @param id - id of the model you want to update in the dataBase
     * @param modelUpdateAndSaveDto - the model you want to update in the dataBase     *
     * @return
     */
    String update(long id, CharacterModelUpdateAndSaveDto modelUpdateAndSaveDto);

    /**
     * Delete a record
     * @param id - id of the model you want to delete from the dataBase
     * @return
     */
    String delete(long id);

    /**
     * get a list of CharacterModelDtp objects sorted by chosen parameter
     * @see CharacterModelDto
     * @param param - id of the model you want to delete from the dataBase
     */
    List<CharacterModelDto> listSortedByParam(String param);
}
