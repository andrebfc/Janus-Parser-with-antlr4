// print option arguments
public class JanusHelp {


    public void printHelp(){
        System.out.println();
        System.out.println("List of option for Janus parser");
        System.out.println();
        System.out.println("-m  :   Message Passing memory, the threads don't share memory for data struct. " +
                "This options is set to default");
        System.out.println();
        System.out.println("-s  :   Shared memory, the threads share data struct with a pointer");
        System.out.println();
        System.out.println("-j  :   remove pthread_join");
        System.out.println();
        System.out.println("-n  :   No auto compile, for manually compile you must going into out folder and exec Makefile with " +
                "name file as argument. For Example: make FILENAME=fibonacci ");
        System.out.println();
        System.out.println("-r  :   Auto run program after parsing");
        System.out.println();
        System.out.println("-h or --help    :   To print this manual");
        System.out.println();
        System.out.println();
    }

}
