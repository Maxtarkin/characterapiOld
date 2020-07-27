package org.max.services;

import org.max.dao.CharacterDaoLogic;
import org.max.models.dto.CharacterModelDto;
import org.max.models.dto.CharacterModelUpdateAndSaveDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CharacterService implements CharacterServiceLogic {

    private final CharacterDaoLogic characterDao;

    @Autowired
    CharacterService(CharacterDaoLogic characterDao) {
        this.characterDao = characterDao;
    }

    @Override
    @Transactional
    public long save(CharacterModelUpdateAndSaveDto modelUpdateAndSaveDto) {
        return characterDao.save(modelUpdateAndSaveDto);
    }

    @Override
    @Transactional
    public CharacterModelDto get(long id) {
        return characterDao.get(id);
    }

    @Override
    @Transactional
    public List<CharacterModelDto> list() {
        return characterDao.list();
    }

    @Override
    @Transactional
    public String update(long id, CharacterModelUpdateAndSaveDto modelUpdateAndSaveDto) {
        if(characterDao.update(id, modelUpdateAndSaveDto)) {
            return "Character with id " + id + " was successfully updated";
        } else {
            return "Character with id " + id + " was not updated";
        }
    }

    @Override
    @Transactional
    public String delete(long id) {
        if(characterDao.delete(id)) {
            return "Character with id " + id + " was successfully deleted";
        } else {
            return "Character with id " + id + " was not deleted";
        }
    }

    @Override
    public List<CharacterModelDto> listSortedByParam(String param) {
        if (param == null) {
            return characterDao.listSortedByParam("id");
        } else {
            return characterDao.listSortedByParam(param);
        }
    }
}
