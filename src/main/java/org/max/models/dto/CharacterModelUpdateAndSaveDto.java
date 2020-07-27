package org.max.models.dto;

import lombok.Getter;
import lombok.Setter;
import org.max.models.enums.CombatClassEnum;
import org.max.models.enums.RaceEnum;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Getter
@Setter
public class CharacterModelUpdateAndSaveDto {

    private String name;

    private int level;

    @Enumerated(EnumType.STRING)
    private RaceEnum race;

    @Enumerated(EnumType.STRING)
    private CombatClassEnum combatClass;

    private String weapon;
}
