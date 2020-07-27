package org.max.dao;

import org.hibernate.SessionFactory;
import org.hibernate.Session;
import org.max.mappers.CharacterModelMapper;
import org.max.models.dto.CharacterModelDto;
import org.max.models.dto.CharacterModelUpdateAndSaveDto;
import org.max.models.entities.CharacterModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
@Transactional
public class CharacterDao implements CharacterDaoLogic{

    private final SessionFactory sessionFactory;
    private final CharacterModelMapper mapper;

    @Autowired
    CharacterDao(SessionFactory sessionFactory, CharacterModelMapper mapper) {
        this.sessionFactory = sessionFactory;
        this.mapper = mapper;
    }

    @Override
    public long save(CharacterModelUpdateAndSaveDto modelUpdateAndSaveDto) {
        CharacterModel model = new CharacterModel();
        mapper.mapToEntity(modelUpdateAndSaveDto, model);
        sessionFactory.getCurrentSession().save(model);
        return model.getId();
    }

    @Override
    public CharacterModelDto get(long id) {
        CharacterModelDto modelDto = new CharacterModelDto();
        Optional<CharacterModel> optionalModel = sessionFactory.getCurrentSession().byId(CharacterModel.class).loadOptional(id);

        if(optionalModel.isPresent()) {
            mapper.mapToDto(optionalModel.get(), modelDto);
        }

        return modelDto;
    }

    @Override
    public List<CharacterModelDto> list() {
        List<CharacterModel> listOfModels = sessionFactory.getCurrentSession().createQuery("from character_model").list();
        List<CharacterModelDto> listOfModelsDto = new ArrayList<>();
        mapper.mapToDto(listOfModels, listOfModelsDto);
        return listOfModelsDto;
    }

    @Override
    public boolean update(long id, CharacterModelUpdateAndSaveDto modelUpdateAndSaveDto) {
        Session session = sessionFactory.getCurrentSession();
        Optional<CharacterModel> optionalOldModel = sessionFactory.getCurrentSession().byId(CharacterModel.class).loadOptional(id);

        if(optionalOldModel.isPresent()) {
            CharacterModel oldModel = optionalOldModel.get();
            oldModel.setCombatClass(modelUpdateAndSaveDto.getCombatClass());
            oldModel.setName(modelUpdateAndSaveDto.getName());
            oldModel.setRace(modelUpdateAndSaveDto.getRace());
            oldModel.setLevel(modelUpdateAndSaveDto.getLevel());
            oldModel.setWeapon(modelUpdateAndSaveDto.getWeapon());
            session.flush();
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean delete(long id) {
        Session session = sessionFactory.getCurrentSession();
        Optional<CharacterModel> optionalOldModel = sessionFactory.getCurrentSession().byId(CharacterModel.class).loadOptional(id);
        if(optionalOldModel.isPresent()) {
            CharacterModel model = session.byId(CharacterModel.class).load(id);
            session.delete(model);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public List<CharacterModelDto> listSortedByParam(String param) {
        List<CharacterModel> listOfModels = sessionFactory.getCurrentSession().createQuery("from character_model order by " + param).list();
        List<CharacterModelDto> listOfModelsDto = new ArrayList<>();
        mapper.mapToDto(listOfModels, listOfModelsDto);
        return listOfModelsDto;
    }
}
