package app.types.commands;

import app.controllers.ExecutionController;
import app.models.system.SportManagementSystem;
import app.types.Error;

import java.util.HashMap;
import java.util.Map;

public class CommandManager {
    private final Map<String, Command> commands;

    public CommandManager(SportManagementSystem sportManagementSystem) {
        ExecutionController controller = new ExecutionController(sportManagementSystem);
        this.commands = new HashMap<>();

        this.commands.put("player_create",new Command() {
            private static final int NECESSARY_ARGUMENTS = 5;
            public Error execute(String[] arguments){
                Error error;
                if(arguments.length < NECESSARY_ARGUMENTS){
                    error = Error.NOT_ENOUGH_ARGUMENTS;
                } else {
                    error = controller.createPlayer(arguments);
                }
                return error;
            }
        });
        this.commands.put("team_create",new Command() {
            private static final int NECESSARY_ARGUMENTS = 3;

            public Error execute(String[] arguments){
                Error error;
                if(arguments.length < NECESSARY_ARGUMENTS){
                    error = Error.NOT_ENOUGH_ARGUMENTS;
                } else {
                    error = controller.createTeam(arguments);
                }
                return error;
            }
        });
        this.commands.put("player_delete",new Command() {
            private static final int NECESSARY_ARGUMENTS = 1;

            public Error execute(String[] arguments){
                Error error;
                if(arguments.length < NECESSARY_ARGUMENTS){
                    error = Error.NOT_ENOUGH_ARGUMENTS;
                } else {
                    error = controller.deletePlayer(arguments);
                }
                return error;
            }
        });
        this.commands.put("team_delete",new Command() {
            private static final int NECESSARY_ARGUMENTS = 1;

            public Error execute(String[] arguments){
                Error error;
                if(arguments.length < NECESSARY_ARGUMENTS){
                    error = Error.NOT_ENOUGH_ARGUMENTS;
                } else {
                    error = controller.deleteTeam(arguments);
                }
                return error;
            }
        });
        this.commands.put("team_add",new Command() {
            private static final int NECESSARY_ARGUMENTS = 2;

            public Error execute(String[] arguments){
                Error error;
                if(arguments.length < NECESSARY_ARGUMENTS){
                    error = Error.NOT_ENOUGH_ARGUMENTS;
                } else {
                    error = controller.teamAdd(arguments);
                }
                return error;
            }
        });
        this.commands.put("team_remove",new Command() {
            private static final int NECESSARY_ARGUMENTS = 2;

            public Error execute(String[] arguments){
                Error error;
                if(arguments.length < NECESSARY_ARGUMENTS){
                    error = Error.NOT_ENOUGH_ARGUMENTS;
                } else {
                    error = controller.teamRemove(arguments);
                }
                return error;
            }
        });
        this.commands.put("tournament_create",new Command() {
            private static final int NECESSARY_ARGUMENTS = 6;

            public Error execute(String[] arguments){
                Error error;
                if(arguments.length < NECESSARY_ARGUMENTS){
                    error = Error.NOT_ENOUGH_ARGUMENTS;
                } else {
                    error = controller.createTournament(arguments);
                }
                return error;
            }
        });
        this.commands.put("tournament_delete",new Command() {
            private static final int NECESSARY_ARGUMENTS = 1;

            public Error execute(String[] arguments){
                Error error;
                if(arguments.length < NECESSARY_ARGUMENTS){
                    error = Error.NOT_ENOUGH_ARGUMENTS;
                } else {
                    error = controller.deleteTournament(arguments);
                }
                return error;
            }
        });
        this.commands.put("tournament_matchmaking",new Command() {
            private static final int DIFFERENTIATOR = 1;

            public Error execute(String[] arguments){
                Error error;
                final int NECESSARY_ARGUMENTS;

                if(arguments[DIFFERENTIATOR].equals("-m")){
                    NECESSARY_ARGUMENTS = 4;
                } else {
                    NECESSARY_ARGUMENTS = 2;
                }

                if(arguments.length < NECESSARY_ARGUMENTS){
                    error = Error.NOT_ENOUGH_ARGUMENTS;
                } else {
                    error = controller.tournamentMatchmaking(arguments);
                }
                return error;
            }
        });
        this.commands.put("login", new Command() {
            private static final int NECESSARY_ARGUMENTS = 2;

            public Error execute(String[] arguments) {
                Error error;
                if(arguments.length < NECESSARY_ARGUMENTS){
                    error = Error.NOT_ENOUGH_ARGUMENTS;
                } else {
                    error = controller.login(arguments);
                }
                return error;
            }
        });
        this.commands.put("logout", arguments -> controller.logout());
        this.commands.put("statistics_show",new Command() {
            private static final int NECESSARY_ARGUMENTS = 1;

            public Error execute(String[] arguments){
                if(arguments.length < NECESSARY_ARGUMENTS){
                    return Error.NOT_ENOUGH_ARGUMENTS;
                } else {
                    return controller.showStatistics(arguments);
                }
            }
        });
        this.commands.put("tournament_add",new Command() {
            private final static int NECESSARY_ARGUMENTS = 1;

            public Error execute(String[] arguments){
                Error error;
                if(arguments.length < NECESSARY_ARGUMENTS){
                    error = Error.NOT_ENOUGH_ARGUMENTS;
                } else {
                    if(arguments.length == 1){
                        error = controller.tournamentAddPlayer(arguments);
                    } else {
                        error = controller.tournamentAddTeam(arguments);
                    }
                }
                return error;
            }
        });
        this.commands.put("tournament_remove",new Command() {
            private final static int NECESSARY_ARGUMENTS = 1;

            public Error execute(String[] arguments){
                Error error;
                if(arguments.length < NECESSARY_ARGUMENTS){
                    error = Error.NOT_ENOUGH_ARGUMENTS;
                } else {
                    if(arguments.length == 1){
                        error = controller.tournamentRemovePlayer(arguments);
                    } else {
                        error = controller.tournamentRemoveTeam(arguments);
                    }
                }
                return error;
            }
        });
        this.commands.put("tournament_list", arguments -> {
            controller.tournamentList();
            return Error.NULL;
        });
        this.commands.put("save", arguments -> controller.saveSession());
        this.commands.put("recover", arguments -> controller.recoverSession());
    }

    public Command getCommand(String input) {
        return this.commands.get(input);
    }

    public Error getCommandError(Command command){
        if(command == null){
            return Error.INVALID_COMMAND;
        } else {
            return Error.NULL;
        }
    }


}
