package org.max.models.entities;

import lombok.Getter;
import lombok.Setter;
import org.max.models.enums.CombatClassEnum;
import org.max.models.enums.RaceEnum;

import javax.persistence.*;

@Entity(name = "character_model")
@Getter
@Setter
public class CharacterModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private int level;

    @Enumerated(EnumType.STRING)
    private RaceEnum race;

    @Enumerated(EnumType.STRING)
    private CombatClassEnum combatClass;

    private String weapon;
}
