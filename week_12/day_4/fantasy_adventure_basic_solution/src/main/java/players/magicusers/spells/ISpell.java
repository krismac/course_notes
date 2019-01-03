package players.magicusers.spells;

import enemies.Enemy;
import players.Player;

public interface ISpell {

     void cast(Enemy Enemy);

     int getDamageValue();
}
