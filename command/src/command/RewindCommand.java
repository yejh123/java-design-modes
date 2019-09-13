package command;

import receiver.Player;

import java.util.Objects;

/**
 * @author yejh
 * @create 2019-07_28 23:15
 */
public class RewindCommand implements Command {
    Player player;

    public RewindCommand(Player player) {
        this.player = player;
    }

    @Override
    public void execute() {
        this.player.rewind();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RewindCommand that = (RewindCommand) o;
        return Objects.equals(player, that.player);
    }

    @Override
    public int hashCode() {
        return Objects.hash(player);
    }
}
