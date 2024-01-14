package prophetsama.testing.mixin;

import net.minecraft.core.net.command.Command;
import net.minecraft.core.net.command.CommandHandler;
import net.minecraft.core.net.command.Commands;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import prophetsama.testing.commands.*;

import java.util.List;

@Mixin(value = Commands.class, remap = false)
public abstract class CommandsMixin {

	@Shadow public static List<Command> commands;

	@Inject(method = "initCommands", at = @At("TAIL"))
	private static void melon_initCommands(CallbackInfo ci) {
		commands.add(new Compass());
		commands.add(new WhereAmI());
		commands.add(new StarterKit());
	}

}
