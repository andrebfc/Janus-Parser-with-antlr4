import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import static java.lang.System.exit;

public class genereteCode {


    File file;
    int forkandjoinvar = 0;

    genereteCode() throws IOException {

        file = new File("./out/out.cpp");

        if(!file.exists()) {
            file.createNewFile();
        }
        else{
            file.delete();
            file.createNewFile();
        }
        file.setWritable(true);
        file.setReadable(true);
        file.setExecutable(true);

    }

    genereteCode(String fileName) throws IOException {




        file = new File(fileName);

        if(!file.exists()) {
            file.createNewFile();
        }

    }

    public void checkExtension(String s){
        String[] tokens = s.split("/");
        String[] name = tokens[tokens.length - 1].split("\\.");
        if(name[name.length-1].compareTo("jan") != 0){
            System.err.println("Errorr input file extension");
            exit(1);
        }
    }

    public void setInclude(String include) throws IOException {

        this.appendStrToFile(include);

    }

    public void declareFunction(String funName, int flag){

        if(flag == 0) { // forward
            this.appendStrToFile("void " + funName+"_forward" + "(");
        }
        else if(flag == 1) { // reverse
            this.appendStrToFile("void " + funName+"_reverse" + "(");
        }
        else if (flag == 2){ // main
            this.appendStrToFile("int " + funName + "(");
        }
    }

    public void setParamsDeclFunc(List<String> type, List<String> name,int flag){ // flag = 0 => '&' , flag = 1 => '*'

        //this.appendStrToFile(type + " &"+name+", ");
        for(int i = 0; i < type.size(); i++){
            this.appendStrToFile(type.get(i));
            if(flag == 0) {
                this.appendStrToFile(" &");
            }
            else { // flag == 1
                this.appendStrToFile(" *");
            }
            this.appendStrToFile(name.get(i));
            if(i < (type.size()-1)){
                this.appendStrToFile(", ");
            }
        }
    }

    public void setBlankLine(){
        this.appendStrToFile("\n");
    }

    public void setParamDeclare(String type, String name, String value,int indent, int array){
        this.setTab(indent);

        this.appendStrToFile(type + " " + name + " = ");
        if(array == 1){
               this.appendStrToFile( "{"+ value + "};\n");
        }
        else {
            this.appendStrToFile(value + ";\n");
        }
    }


    //set condition
    public void setAssertCondition(String lvalue, String op, String rvalue, int flag, int indent){ //flag: 1 = neg !
        this.setTab(indent);
        if(flag != 1) {
            this.appendStrToFile("assert(");
        }
        else {
            this.appendStrToFile("assert(!(");
        }

        this.appendStrToFile(lvalue + " ");

        if(op.compareTo("=") == 0){
            this.appendStrToFile("==");
        }
        else {
            this.appendStrToFile(op);
        }

        this.appendStrToFile(" " + rvalue);

        if(flag != 1) {
            this.appendStrToFile(");\n");
        }
        else{
            this.appendStrToFile("));\n");
        }
    }

    //set else
    public void setElse(int indent){
        this.setTab(indent);
        this.appendStrToFile("}\n");
        this.setTab(indent);
        this.appendStrToFile("else {\n");

    }

    //set Assignment Expression
    public void setAssignmentExpression(String lvalue, String op, String rvalue,int flag, int indent){ // flag: 0 = forward, 1 = reverse
        this.setTab(indent);
        this.appendStrToFile(lvalue + " ");
        if(op.compareTo("<=>") == 0){
            this.appendStrToFile("^= "+rvalue+";\n");
            this.setTab(indent);
            this.appendStrToFile(rvalue +" ^= " + lvalue + ";\n");
            this.setTab(indent);
            this.appendStrToFile(lvalue + " ^= " + rvalue + ";\n");
        }
        else if (op.compareTo("+=") == 0 && flag == 1){ //reverse += in -=
            this.appendStrToFile("-= " + rvalue + ";\n");
        }
        else if (op.compareTo("-=") == 0 && flag == 1){ //reverse -= in +=
            this.appendStrToFile("+= " + rvalue + ";\n");
        }
        else {
            this.appendStrToFile(op + " " + rvalue + ";\n");
        }
    }

    //close declaration and open function
    public void setExitFunctionDeclaration(){
        this.appendStrToFile("){\n");
    }

    //close function
    public void setExitFunction(int indent){
        this.setTab(indent);
        this.appendStrToFile("}\n");
    }

    //functionCall
    public void setFunctionCall(String name, int flag,int indent){ //flag: 0 = forward, 1 = reverse
        this.setTab(indent);
        if(flag == 0) {
            this.appendStrToFile(name + "_forward(");
        }
        else{
            this.appendStrToFile(name + "_reverse(");
        }
    }

    //Arguments function
    public void setArgumentsFunction(List<String> name){
        for(int i = 0; i < name.size(); i++){
            //this.appendStrToFile('&' + name.get(i));
            this.appendStrToFile(name.get(i));
            if(i < (name.size()-1)){
                this.appendStrToFile(", ");
            }
        }

        this.appendStrToFile(");\n");
    }

    //set tab
    private void setTab(int indent){
        while(indent > 0){
            this.appendStrToFile("\t");
            indent--;
        }
    }


    public void openIfDec(int indent){
        this.setTab(indent);
        this.appendStrToFile("if( ");
    }

    public void closeIfDec(){
        this.appendStrToFile("){\n");
    }

    public void openWhileDec(int indent){
        this.setTab(indent);
        this.appendStrToFile("while(!( ");
    }

    public void closeWhileDec(){
        this.appendStrToFile(" )){\n");
    }

    public void openAssertCondition(int flag, int indent){
        this.setTab(indent);
        if(flag != 1) {
            this.appendStrToFile("assert(");
        }
        else {
            this.appendStrToFile("assert(!(");
        }
    }

    public void closeAssertCondition(int flag){
        if(flag != 1) {
            this.appendStrToFile(");\n");
        }
        else{
            this.appendStrToFile("));\n");
        }
    }

    //set general condition
    public void setGeneralCondition(String lvalue, String op, String rvalue){
        this.appendStrToFile(lvalue);
        if(op.compareTo("=") == 0){
            this.appendStrToFile(" == ");
        }
        else{
            this.appendStrToFile(" " + op +" ");
        }
        this.appendStrToFile(rvalue);
    }


    public void setPrint(String s, int indent){
        this.setTab(indent);
        this.appendStrToFile("printf(\"%d\\n\"," + s + ");\n");
    }

    public void setPthreadDeclare(int n){
        this.appendStrToFile("pthread_t p" + (n-1) +",p" + n + ";\n");
    }

    public void setforkandjoin(String arg, int indent,int n, int flag){ // flag = 0 forward, flag = 1 reverse
        String type;
        if(flag == 0){
            type = "_forward";
        }
        else
            type = "_reverse";

        this.setBlankLine();
        this.setTab(indent);
        //this.appendStrToFile("pthread_create(&p"+ (n-1) + ",NULL,program_"+ (n-1) + type +",NULL);\n");
        this.appendStrToFile("pthread_create(&p"+ (n-1) + ",NULL,program_"+ (n-1) + type +"," + "(void *)" +arg +");\n");
        this.setTab(indent);
        //this.appendStrToFile("pthread_create(&p" + n + ",NULL,program_" + n + type + ",NULL);\n\n");
        this.appendStrToFile("pthread_create(&p" + n + ",NULL,program_" + n + type + ","+ "(void *)" +arg + ");\n\n");
        //this.setTab(indent);
        //this.appendStrToFile("pthread_join(p"+ (n-1) + ",NULL);\n");
        //this.setTab(indent);
        //this.appendStrToFile("pthread_join(p" + n + ",NULL);\n\n");
    }

    public void setJoinThread(int indent,int n){
        this.setTab(indent);
        this.appendStrToFile("pthread_join(p"+ (n-1) + ",NULL);\n");
        this.setTab(indent);
        this.appendStrToFile("pthread_join(p" + n + ",NULL);\n\n");
    }

    public void setforkandjoinDeclare(int n,int flag){ // 0 = forward, 1 = reverse
        this.forkandjoinvar = n;
        if(flag == 0) {
            this.appendStrToFile("void *program_" + (n - 1) + "_forward" + "(void *arg);\n");
            this.appendStrToFile("void *program_" + n + "_forward" + "(void *arg);\n");
        }
        else{//reverse case
            this.appendStrToFile("void *program_" + (n - 1) + "_reverse" + "(void *arg);\n");
            this.appendStrToFile("void *program_" + n + "_reverse" + "(void *arg);\n");
        }
    }

    public void setSingleFork(int n, int flag){ // 0 = forward, 1 = reverse
        if(flag == 0) {
            this.appendStrToFile("void *program_" + n + "_forward" + "(void *arg){\n");
        }
        else{//reverse case
            this.appendStrToFile("void *program_" + n + "_reverse" + "(void *arg){\n");
        }
    }

    public int getForkandjoinvar(){
        return this.forkandjoinvar;
    }

    public void setForkandjoinvar(int dec){
        this.forkandjoinvar = this.forkandjoinvar - dec;
    }

    public void setMsgpass(String type, String name, String port, int indent){
        this.setTab(indent);
        if(type.compareTo("asend") == 0 ){
            this.appendStrToFile(type + '(' + name + ",pN_" + port + ",pQ_" + port + ",&mutex_" + port + ",&write_" + port + ",&read_" + port + ");\n");
            this.setTab(indent);
            this.appendStrToFile(name + " = 0;\n");
        }
        else if (type.compareTo("arcv") == 0){
            this.appendStrToFile("assert("+name+" == 0);\n");
            this.setTab(indent);
            this.appendStrToFile(name + " = " + type + '(' + "pN_" + port + ",pQ_" + port + ",&mutex_" + port + ",&write_" + port + ",&read_" + port + ");\n");
        }
        else if (type.compareTo("ssend") == 0){// sync type
            this.appendStrToFile(type + '(' + name + ",pN_" + port + ",pQ_" + port + ",&mutex_" + port + ",&write_" + port + ",&read_" + port + ",&sync_" + port + ");\n");
            this.setTab(indent);
            this.appendStrToFile(name + " = 0;\n");
        }
        else if(type.compareTo("srcv") == 0){
            this.appendStrToFile("assert("+name+" == 0);\n");
            this.setTab(indent);
            this.appendStrToFile(name + " = " + type + '(' + "pN_" + port + ",pQ_" + port + ",&mutex_" + port + ",&write_" + port + ",&read_" + port + ",&sync_" + port + ");\n");
        }
    }

    public void setPort(String name){
        this.appendStrToFile("Queue *pQ_" + name + ";\n");
        this.appendStrToFile("NODE *pN_" + name + ";\n");
        this.appendStrToFile("sem_t mutex_" + name + ";\n");
        this.appendStrToFile("sem_t write_" + name + ";\n");
        this.appendStrToFile("sem_t read_" + name + ";\n");
        this.appendStrToFile("sem_t sync_" + name + ";\n\n");
    }

    public void setInitPort(String name,int indent){
        this.setTab(indent);
        //inizializzo semafori
        this.appendStrToFile("sem_init (&mutex_" + name + ",0,1);\n");
        this.setTab(indent);
        this.appendStrToFile("sem_init (&write_" + name + ",0,0);\n");
        this.setTab(indent);
        this.appendStrToFile("sem_init (&read_" + name + ",0,limit);\n");
        this.setTab(indent);
        this.appendStrToFile("sem_init (&sync_" + name + ",0,0);\n");
        this.setTab(indent);
        //inizializzo coda
        this.appendStrToFile("pQ_" + name + " = ConstructQueue(limit);\n\n");
    }

    public void setStruct(String name){
        //this.setTab(indent);
        this.appendStrToFile("struct " + name + "{\n");
    }

    public void closeStruct(){
        //this.setTab(indent);
        this.appendStrToFile("};\n\n");
    }

    public void setStructParam(String type,String name,int indent,int array){
        this.setTab(indent);
        if (array == 0) {
            this.appendStrToFile(type + " " + name + ";\n");
        }
        if(array == 1){
            this.appendStrToFile(type + " " + name + "[];");
        }
    }

    public void initStruct(String name,int indent){
        this.setTab(indent);
        this.appendStrToFile("struct " + name + " *" + name + "=(struct "+name+"*)malloc(sizeof(struct "+name+"));\n\n");
    }

    public void appendStrToFile(String str) {

        try {

            // Open given file in append mode.
            BufferedWriter out = new BufferedWriter(new FileWriter(file, true));
            out.write(str);
            out.close();
        }
        catch (IOException e) {
            System.out.println("exception: " + e);
        }
    }



}
