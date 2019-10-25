//parse argument and option, provide a common utility
public class utility {


    // opt arg
    private static int limit = 65000; // standar limit queue
    private static int type_msg = 0; // 0 = message passing local struct, 1 = shared memory
    private static boolean join = true; //false = no pthread_join
    private static boolean compile = true; // true = auto compile
    private static boolean auto_run = false; // true = no auto run
    // for not repeat option, es: set memory before msg and after share, opt -jms is not valid
    boolean set_type_msg = false;
    boolean set_no_join = false;
    boolean set_no_compile = false;
    boolean set_auto_run = false;
    // indent var
    private static int indent = 0;
    // thread Argument
    private static boolean threadArg = false;

    public void getArg(String[] args){
        //if call only help man
        if(args[0].compareTo("-h") == 0 || args[0].compareTo("--help") == 0){
            JanusHelp jh = new JanusHelp();
            jh.printHelp();
            System.exit(0);
        }

        //parsing arguments
        if (args.length > 1) {
            for (int i = 1; i < args.length; i++) {
                if (args[i].charAt(0) == '-') {
                    for (int j = 1; j < args[i].length(); j++) {//only args[i]
                        if (args[i].charAt(j) == 'm') {
                            if (!set_type_msg) {
                                type_msg = 0;
                                set_type_msg = true;
                            } else {
                                System.out.println("Incorrect option\n");
                                System.exit(1);
                            }
                        } else if (args[i].charAt(j) == 's') {
                            if (!set_type_msg) {
                                type_msg = 1;
                                set_type_msg = true;
                            } else {
                                System.out.println("Incorrect option\n");
                                System.exit(1);
                            }
                        } else if (args[i].charAt(j) == 'j') {
                            if (!set_no_join) {
                                join = false;
                                set_no_join = true;
                            } else {
                                System.out.println("Incorrect option\n");
                                System.exit(1);
                            }
                        } else if (args[i].charAt(j) == 'n') {
                            if (!set_no_compile && !set_auto_run) {
                                compile = false;
                                set_no_compile = true;
                                set_auto_run = true;
                            } else {
                                System.out.println("Incorrect option\n");
                                System.exit(1);
                            }
                        }
                        else if (args[i].charAt(j) == 'r'){
                            if(!set_no_compile && !set_auto_run){
                                auto_run = true;
                                set_no_compile = true;
                                set_auto_run = true;
                            }
                            else {
                                System.out.println("Incorrect option\n");
                                System.exit(1);
                            }
                        }
                        else if (args[i].charAt(j) == 'h'){
                            // only help option is allow
                            if (!set_type_msg && !set_no_join && !set_no_compile && !set_auto_run){
                                JanusHelp jh = new JanusHelp();
                                jh.printHelp();
                                System.exit(0);
                            }
                            else {
                                System.out.println("Incorrect option\n");
                                System.exit(1);
                            }
                        }
                        else{
                            System.out.println("Incorrect option\n");
                            System.exit(1);
                        }
                    }
                }
                else if(args[i].charAt(0) == 'l'){ // define limit queue
                    StringBuilder lim = new StringBuilder();
                    int j = 0;
                    while(args[i].charAt(j) != '='){
                        lim.append(args[i].charAt(j));
                        j++;
                    }
                    StringBuilder limit_value = new StringBuilder();
                    if(lim.toString().compareTo("limit") == 0){
                        for(j = j+1; j < args[i].length();j++){
                            limit_value.append(args[i].charAt(j));
                        }
                    }
                    else{
                        System.out.println("Incorrect option\n");
                        System.exit(1);
                    }
                    //copy limit value
                    if(Integer.parseInt(limit_value.toString()) < limit) {
                        limit = Integer.parseInt(limit_value.toString());
                    }
                }
                else {
                    System.out.println("Incorrect option\n");
                    System.exit(1);
                }
            }
        }
    }

    public int getTypeMsg(){
        return this.type_msg;
    }

    public int getLimit(){
        return this.limit;
    }

    public boolean getJoin(){
        return this.join;
    }

    public boolean getCompile(){
        return this.compile;
    }

    public boolean getAutoRun(){
        return this.auto_run;
    }

    public void decIndent(){
        indent --;
    }

    public void incIndent(){
        indent ++;
    }

    public int getIndent(){
        return this.indent;
    }

    public void resetIndent(){
        this.indent = 0;
    }


    public void setThreadArg(boolean val){
        this.threadArg = val;
    }

    public boolean getThreadArg(){
        return this.threadArg;
    }


}
