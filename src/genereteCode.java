// this class is tools to write a c++ code in a file
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import static java.lang.System.exit;

public class genereteCode {


    File file;

    int forkandjoinvar = 0;
    boolean libinclude = false;

    utility ut = new utility();

    //create c/c++ file
    public void initFile(String fileName) throws IOException {
        file = new File("./src/out/" + fileName + ".cpp");

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

    //check correct extension for janus
    public void checkExtension(String s){
        String[] tokens = s.split("/");
        String[] name = tokens[tokens.length - 1].split("\\.");
        if(name[name.length-1].compareTo("jan") != 0){
            System.err.println("Errorr input file extension");
            exit(1);
        }
    }

    public void setlibinclude(boolean b){
        this.libinclude = b;
    }

    public boolean getlibinclude(){
        return this.libinclude;
    }

    //standard include
    public void setStInclude(){
        this.appendStrToFile("#include <stdio.h>\n");
        this.appendStrToFile("#include <assert.h>\n");
        this.appendStrToFile("#include <math.h>\n");
        this.appendStrToFile("#include <stdlib.h>\n");
    }

    // include for threads
    public void setInclude4threads(int limit) {

        this.appendStrToFile("#include <semaphore.h>\n");
        this.appendStrToFile("#include <string.h>\n");
        this.appendStrToFile("#include \"../concurrency/queue.h\"\n\n");
        this.appendStrToFile("#define limit " + limit + "\n\n");

        ut.setIncludeTrhread(); //this for not include this library more times


    }

    public void declareFunction(String funName, int flag){

        if(flag == 0) { // forward
            this.appendStrToFile("void " + funName+"_forward" + "(");
        }
        else if(flag == 1) { // reverse
            this.appendStrToFile("void " + funName+"_reverse" + "(");
        }
        else if (flag == 2){ // main
            this.appendStrToFile("int " + funName + "(){\n");
        }
    }

    // argument function set
    public void setParamsDeclFunc(List<String> type, List<String> name,int flag){ // flag = 0 => '&' , flag = 1 => '*'

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

    //variable declaration
    public void setParamDeclare(String type, String name, String value, int array){
        this.setTab(ut.getIndent());

        this.appendStrToFile(type + " " + name);

        if(array == 1){
            this.appendStrToFile("[" + value + "] = {0};\n");
        }
        else {
            this.appendStrToFile(" = " + value + ";\n");
        }
    }

    //array declaration
    public void setArray(String type, String name, String size, String value){
        this.setTab(ut.getIndent());
        this.appendStrToFile(type + " " + name + "[" + size + "] = {" + value + "};\n");
    }

    //set condition
    public void setAssertCondition(String lvalue, String op, String rvalue, int flag){ //flag: 1 = neg !
        this.setTab(ut.getIndent());
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
    public void setElse(){
        this.setTab(ut.getIndent());
        this.appendStrToFile("}\n");
        this.setTab(ut.getIndent());
        this.appendStrToFile("else {\n");

    }

    //set Assignment Expression
    public void setAssignmentExpression(String lvalue, String op, String rvalue,int flag){ // flag: 0 = forward, 1 = reverse
        this.setTab(ut.getIndent());
        //assert for =
        if(op.compareTo("=") == 0) {
            this.appendStrToFile("assert(" + lvalue + " == 0);\n");
            this.setTab(ut.getIndent());
        }
        //this.setTab(indent);
        this.appendStrToFile(lvalue + " ");
        if(op.compareTo("<=>") == 0){
            this.appendStrToFile("^= "+rvalue+";\n");
            this.setTab(ut.getIndent());
            this.appendStrToFile(rvalue +" ^= " + lvalue + ";\n");
            this.setTab(ut.getIndent());
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
    public void setExitFunction(){
        this.setTab(ut.getIndent());
        this.appendStrToFile("}\n");
    }

    //functionCall
    public void setFunctionCall(String name, int flag){ //flag: 0 = forward, 1 = reverse
        this.setTab(ut.getIndent());
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

    //open if
    public void openIfDec(){
        this.setTab(ut.getIndent());
        this.appendStrToFile("if( ");
    }

    //close if
    public void closeIfDec(){
        this.appendStrToFile("){\n");
    }

    //open while
    public void openWhileDec(){
        this.setTab(ut.getIndent());
        this.appendStrToFile("while(!( ");
    }

    //close while
    public void closeWhileDec(){
        this.appendStrToFile(" )){\n");
    }

    //open assert condition
    public void openAssertCondition(int flag){
        this.setTab(ut.getIndent());
        if(flag != 1) {
            this.appendStrToFile("assert(");
        }
        else {
            this.appendStrToFile("assert(!(");
        }
    }

    //close assert condition
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


    // set print function
    public void setPrint(String s){
        this.setTab(ut.getIndent());
        this.appendStrToFile("printf(\"%d\\n\"," + s + ");\n");
    }

    // set pthread declaration
    public void setPthreadDeclare(int n){
        this.appendStrToFile("pthread_t p" + (n-1) +",p" + n + ";\n");
    }

    //set pthread create for fork and join
    public void setforkandjoin(String arg, int n, int flag){ // flag = 0 forward, flag = 1 reverse
        String type;
        if(flag == 0){
            type = "_forward";
        }
        else
            type = "_reverse";

        this.setBlankLine();
        this.setTab(ut.getIndent());

        this.appendStrToFile("pthread_create(&p"+ (n-1) + ",NULL,program_"+ (n-1) + type +"," + "(void *)" +arg +");\n");
        this.setTab(ut.getIndent());

        this.appendStrToFile("pthread_create(&p" + n + ",NULL,program_" + n + type + ","+ "(void *)" +arg + ");\n\n");
        this.setTab(ut.getIndent());

        this.appendStrToFile("pthread_join(p"+ (n-1) + ",NULL);\n");
        this.setTab(ut.getIndent());

        this.appendStrToFile("pthread_join(p" + n + ",NULL);\n\n");
    }

    // pthread functions
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

    //open pthread function
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

    //function for message passing
    public void setMsgpass(String type, String name, String port){
        this.setTab(ut.getIndent());
        if(type.compareTo("asend") == 0 ){
            this.appendStrToFile(type + '(' + name + ",pN_" + port + ",pQ_" + port + ",&mutex_" + port + ",&write_" + port + ",&read_" + port + ");\n");
            this.setTab(ut.getIndent());
            this.appendStrToFile(name + " = 0;\n");
        }
        else if (type.compareTo("arcv") == 0){
            this.appendStrToFile("assert("+name+" == 0);\n");
            this.setTab(ut.getIndent());
            this.appendStrToFile(name + " = " + type + '(' + "pN_" + port + ",pQ_" + port + ",&mutex_" + port + ",&write_" + port + ",&read_" + port + ");\n");
        }
        else if (type.compareTo("ssend") == 0){// sync type
            this.appendStrToFile(type + '(' + name + ",pN_" + port + ",pQ_" + port + ",&mutex_" + port + ",&write_" + port + ",&read_" + port + ",&sync_" + port + ");\n");
            this.setTab(ut.getIndent());
            this.appendStrToFile(name + " = 0;\n");
        }
        else if(type.compareTo("srcv") == 0){
            this.appendStrToFile("assert("+name+" == 0);\n");
            this.setTab(ut.getIndent());
            this.appendStrToFile(name + " = " + type + '(' + "pN_" + port + ",pQ_" + port + ",&mutex_" + port + ",&write_" + port + ",&read_" + port + ",&sync_" + port + ");\n");
        }
    }

    // set queue and semaphore
    public void setPort(String name){
        this.appendStrToFile("Queue *pQ_" + name + ";\n");
        this.appendStrToFile("NODE *pN_" + name + ";\n");
        this.appendStrToFile("sem_t mutex_" + name + ";\n");
        this.appendStrToFile("sem_t write_" + name + ";\n");
        this.appendStrToFile("sem_t read_" + name + ";\n");
        this.appendStrToFile("sem_t sync_" + name + ";\n\n");
    }
    // inizialize semaphore and queue
    public void setInitPort(String name){
        this.setTab(ut.getIndent());

        this.appendStrToFile("sem_init (&mutex_" + name + ",0,1);\n");
        this.setTab(ut.getIndent());

        this.appendStrToFile("sem_init (&write_" + name + ",0,0);\n");
        this.setTab(ut.getIndent());

        this.appendStrToFile("sem_init (&read_" + name + ",0,limit);\n");
        this.setTab(ut.getIndent());

        this.appendStrToFile("sem_init (&sync_" + name + ",0,0);\n");
        this.setTab(ut.getIndent());

        this.appendStrToFile("pQ_" + name + " = ConstructQueue(limit);\n\n");
    }

    // open struct
    public void setStruct(String name){
        this.appendStrToFile("struct " + name + "{\n");
    }

    // close struct
    public void closeStruct(){
        this.appendStrToFile("};\n\n");
    }

    // set struct param
    public void setStructParam(String type,String name,int array){
        this.setTab(ut.getIndent());
        if (array == 0) {
            this.appendStrToFile(type + " " + name + ";\n");
        }
        if(array == 1){
            this.appendStrToFile(type + " " + name + "[];");
        }
    }

    //inizialize struct
    public void initStruct(String typeName, String structName){
        this.setTab(ut.getIndent());
        this.appendStrToFile("struct " + typeName + " *" + structName + "=(struct "+typeName+"*)malloc(sizeof(struct "+typeName+"));\n\n");
    }

    // set struct
    public void setLocalStruct(String struct_name, String localStrucName){
        this.setTab(ut.getIndent());
        this.appendStrToFile("struct " + struct_name + " " + localStrucName + ";\n");
    }

    //copy struct with memcpy
    public void setCpyStruct(String struct_name, String localStrucName){
        this.setTab(ut.getIndent());
        this.appendStrToFile("memcpy(&" + localStrucName + ",(struct " + struct_name + "*)arg,sizeof(" + struct_name + "));\n");
    }


    // write on file
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
