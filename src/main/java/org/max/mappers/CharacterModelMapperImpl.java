package org.max.mappers;

import org.max.models.dto.CharacterModelDto;
import org.max.models.dto.CharacterModelUpdateAndSaveDto;
import org.max.models.entities.CharacterModel;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CharacterModelMapperImpl implements CharacterModelMapper {

    @Override
    public void mapToEntity(CharacterModelUpdateAndSaveDto modelUpdateAndSaveDto, CharacterModel model) {
        model.setName(modelUpdateAndSaveDto.getName());
        model.setLevel(modelUpdateAndSaveDto.getLevel());
        model.setCombatClass(modelUpdateAndSaveDto.getCombatClass());
        model.setRace(modelUpdateAndSaveDto.getRace());
        model.setWeapon(modelUpdateAndSaveDto.getWeapon());
    }

    @Override
    public void mapToDto(CharacterModel model, CharacterModelDto modelDto) {
        modelDto.setId(model.getId());
        modelDto.setName(model.getName());
        modelDto.setRace(model.getRace());
        modelDto.setLevel(model.getLevel());
        modelDto.setCombatClass(model.getCombatClass());
        modelDto.setWeapon(model.getWeapon());
    }

    @Override
    public void mapToDto(List<CharacterModel> models, List<CharacterModelDto> modelsDto) {
        for (CharacterModel model : models) {
            CharacterModelDto modelDto = new CharacterModelDto();
            mapToDto(model, modelDto);
            modelsDto.add(modelDto);
        }
    }
}
