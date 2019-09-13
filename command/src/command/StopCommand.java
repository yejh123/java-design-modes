package command;

import receiver.Player;

import java.util.Objects;

/**
 * @author yejh
 * @create 2019-07_28 23:15
 */
public class StopCommand implements Command {
    Player player;

    public StopCommand(Player player) {
        this.player = player;
    }

    @Override
    public void execute() {
        this.player.stop();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StopCommand that = (StopCommand) o;
        return Objects.equals(player, that.player);
    }

    @Override
    public int hashCode() {
        return Objects.hash(player);
    }
}
