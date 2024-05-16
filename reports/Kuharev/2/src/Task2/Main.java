import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        GetCommand(args);
    }
    private static void GetCommand(String[] args){
        boolean isValide = false;
        try{
            if(args[Const.FIRST].equals("help")){
                ShowHelp();
            }else if(!args[Const.command].equals("join")){
                throw new IllegalArgumentException("Command '" + args[Const.command] +"' doesn't exist\nUse 'help' to get more info");
            }else{
                isValide = true;
            }
        }catch (IllegalArgumentException ce){
            System.out.println(ce.getMessage());
        }
        catch (Exception ex){
            System.out.println("Parameters can't be empty\nUse 'help' to get more info");
        } finally {
            if(isValide){
                ParseArgs(args);
            }else{
                System.exit(Const.ALL_PROCESSED);
            }
        }
    }
    private static void ShowHelp(){
        System.out.println("Format: join [-1 field_number] [-2 field_number] file1 file2 [file3]\n" +
                "Parameters:\n\t- 1 fiedl_num Specifies the field number in the line for the first file on which the execution will be performed;\n" +
                "\t- 2 field_num Specifies the field number in the line for the second file on which the execution will be performed;\n" +
                "Arguments:\n\t- file1, file2 – input files\n\t- file3 – output file where the result of the program is written.\n\n" +
                "'exit' to quit the program.");
    }
    private static void ParseArgs(String[] args){
        IntDynamicArray Parameters = new IntDynamicArray();
        StringDynamicArray Arguments = new StringDynamicArray();
        StringDynamicArray[] input_files = new StringDynamicArray[Const.files_amount];
        StringDynamicArray[] columns = new StringDynamicArray[Const.columns_amount];
        DoubleString[] tmp;

        for(int i = Const.INITIALIZE_INT; i < Const.columns_amount; ++i){
            columns[i] = new StringDynamicArray();
        }
        int input_num = Const.NO_RES, column_num = Const.INITIALIZE_INT;
        boolean isRead = false;

        for(int i = Const.parse_position; i < args.length; ++i){
            try{
                if(i < Const.params_amount + Const.next_num){
                    Parameters.add(Integer.parseInt(args[i]));
                }else{
                    throw new NumberFormatException();
                }
            }catch(NumberFormatException nex){
                Arguments.add(args[i]);
            }
        }
        Parameters = toNormalForm(Parameters);
        try{
            CheckParams(Parameters);
        }catch(IllegalArgumentException ex){
            System.out.println(ex.getMessage());
            System.exit(Const.ALL_PROCESSED);
        }
        try{
            if(Arguments.size() > Const.args_amount){
                throw new IllegalArgumentException("Too much arguments");
            }
        }catch(IllegalArgumentException ex){
            System.out.println(ex.getMessage());
            System.exit(Const.ALL_PROCESSED);
        }

        input_num = Arguments.find(Const.HYPHEN);
        isRead = (input_num != Const.NO_RES);

        for(int i = Const.INITIALIZE_INT; i < Const.files_amount; ++i){
            if(isRead && i == input_num){
                input_files[input_num] = ReadInput();
            }else{
                input_files[i] = ReadFile(Arguments.get(i));
            }
        }
        for(int i = Const.cycle_null; i < Const.files_amount; ++i){
            tmp = new DoubleString[input_files[i].size()];
            tmp = SplitFile(input_files[i]);
            for(int j = Const.INITIALIZE_INT; j < input_files[i].size(); ++j){
                columns[column_num].add(tmp[j].getFirst());
                columns[column_num+Const.next_num].add(tmp[j].getSecond());
            }
            column_num+=Const.columns_in_file;
        }
        MakeOutputFile(Parameters, Arguments, columns);
    }
    private static DoubleString[] SplitFile(StringDynamicArray initial){
        DoubleString[] tmp = new DoubleString[initial.size()];
        for(int i = Const.cycle_null; i < initial.size(); ++i){
            tmp[i] = DivideString(initial.get(i));
        }
        return tmp;
    }
    private static DoubleString DivideString(String str){
        DoubleString parsed = new DoubleString();
        boolean isFirst = true;
        char symb;
        for(int i = Const.cycle_null; i < str.length(); ++i){
            symb = str.charAt(i);
            if(symb != Const.SPACE){
                if(isFirst){
                    parsed.setFirst(parsed.getFirst() + symb);
                }else{
                    parsed.setSecond(parsed.getSecond() + symb);
                }
            }else{
                isFirst = !isFirst;
            }
        }
        return parsed;
    }
    private static StringDynamicArray ReadFile(String file_name){
        if(!findType(file_name)){
            file_name += Const.default_file_type;
        }
        return IFile.ReadStrings(file_name);
    }
    private static void MakeOutputFile(IntDynamicArray params, StringDynamicArray args, StringDynamicArray[] columns){
        String output_file_name, output_string = Const.CLEAR;
        int max_col_size = Const.INITIALIZE_INT;
        int[] col_fields = new int[params.size()];
        int second_file_col_pos = Const.INITIALIZE_INT;
        col_fields = SetColumnsNums(params);

        for(int i = Const.cycle_null; i < columns.length; ++i){
            max_col_size = columns[i].size();
            if(columns[i].size() > max_col_size){
                max_col_size = columns[i].size();
            }
        }
        if(args.size() < Const.args_amount){
            output_file_name = Const.default_file_name;
        }else{
            output_file_name = args.get(Const.args_amount+Const.sizeToPos);
        }
        if(!findType(output_file_name)){
            output_file_name += Const.default_file_type;
        }
        IFile.ClearFile(output_file_name);

        for(int i = Const.cycle_null; i < max_col_size; ++i){
            second_file_col_pos = columns[col_fields[Const.cmp_field2]].find(columns[col_fields[Const.cmp_field1]].get(i));
            if(second_file_col_pos > Const.ISNEG){
                output_string = columns[col_fields[Const.cmp_field1]].get(i) + Const.SPACE
                        + columns[col_fields[Const.field_toWr1]].get(i) + Const.SPACE
                        + columns[col_fields[Const.field_toWr2]].get(second_file_col_pos) + Const.endl;
                IFile.WriteFile(output_string, output_file_name);
            }
        }
    }
    private static IntDynamicArray toNormalForm(IntDynamicArray params){
        IntDynamicArray normal_params = new IntDynamicArray();
        int rep_tmp = Const.INITIALIZE_INT;
        normal_params.add(Const.nparam1);
        normal_params.add(Const.nparam2);
        normal_params.add(Const.nparam3);
        normal_params.add(Const.nparam4);
        if(params.size() == Const.params_amount){
            normal_params = params;
        }
        if(params.size() == Const.ONEARG){
            if(params.get(Const.FIRST) == Const.nparam1){
                normal_params.replace(params.get(Const.FIRST), Const.FIRST);
            }else{
                normal_params.replace(params.get(Const.FIRST), Const.THIRD);
            }
        } else if(params.size() == Const.TWOARGS){
            if(params.get(Const.FIRST) < Const.ISNEG && params.get(Const.SECOND) < Const.ISNEG){
                normal_params.replace(params.get(Const.FIRST), Const.FIRST);
                normal_params.replace(params.get(Const.SECOND), Const.THIRD);
            }else{
                if(params.get(Const.FIRST) == Const.nparam1){
                    normal_params.replace(params.get(Const.FIRST), Const.FIRST);
                    normal_params.replace(params.get(Const.SECOND), Const.SECOND);
                }else{
                    normal_params.replace(params.get(Const.FIRST), Const.THIRD);
                    normal_params.replace(params.get(Const.SECOND), Const.FOURTH);
                }
            }
        }else if(params.size() == Const.THREEARGS){
            if(params.get(Const.SECOND) < Const.ISNEG){
                normal_params.replace(params.get(Const.FIRST), Const.FIRST);
                normal_params.replace(params.get(Const.SECOND), Const.THIRD);
                normal_params.replace(params.get(Const.THIRD), Const.FOURTH);
            }else{
                normal_params.replace(params.get(Const.FIRST), Const.FIRST);
                normal_params.replace(params.get(Const.SECOND), Const.SECOND);
                normal_params.replace(params.get(Const.THIRD), Const.THIRD);
            }
        }
        if(normal_params.get(Const.FIRST) == Const.nparam3){
            rep_tmp = params.get(Const.THIRD);
            normal_params.replace(params.get(Const.FIRST), Const.THIRD);
            normal_params.replace(rep_tmp, Const.FIRST);

            rep_tmp = params.get(Const.FOURTH);
            normal_params.replace(params.get(Const.SECOND), Const.FOURTH);
            normal_params.replace(rep_tmp, Const.SECOND);
        }
        return normal_params;
    }
    private static StringDynamicArray ReadInput(){
        StringDynamicArray console_stream = new StringDynamicArray();
        console_stream.add(Const.CLEAR);
        Scanner in = new Scanner(System.in);
        System.out.println("Welcome to the 'Input Reader'\nWrite lines in the next format '[str1] [str2]'\n" +
                "Space is required, line without space will end the input\nEnter:");
        String str = Const.CLEAR;
        do{
            str = in.nextLine();
            if(hasSpace(str)){
                console_stream.add(str);
            }
        }while(hasSpace(str));
        return console_stream;
    }
    private static boolean hasSpace(String str){
        for(int i = Const.INITIALIZE_INT; i < str.length(); ++i){
            if(str.charAt(i) == ' '){
                return true;
            }
        }
        return false;
    }
    private static int[] SetColumnsNums(IntDynamicArray params){
        int[] result = new int[params.size()];
        if(params.get(Const.firstLineNum) == Const.nparam2){
            result[Const.cmp_field1] = Const.FIRST;
            result[Const.field_toWr1] = Const.SECOND;
        }else{
            result[Const.cmp_field1] = Const.SECOND;
            result[Const.field_toWr1] = Const.FIRST;
        }
        if(params.get(Const.secondLineNum) == Const.nparam2){
            result[Const.cmp_field2] = Const.THIRD;
            result[Const.field_toWr2] = Const.FOURTH;
        }else{
            result[Const.cmp_field2] = Const.FOURTH;
            result[Const.field_toWr2] = Const.THIRD;
        }

        return result;
    }
    private static boolean findType(String str){
        for(int i = Const.INITIALIZE_INT; i < str.length(); ++i){
            if(str.charAt(i) == '.'){
                return true;
            }
        }
        return false;
    }
    private static void CheckParams(IntDynamicArray params){
        if(params.get(Const.FIRST) == params.get(Const.THIRD)){
            throw new IllegalArgumentException("Can't compare same file");
        }else if(params.get(Const.FIRST) > Const.nparam1 || params.get(Const.FIRST) < Const.nparam3 ||
                params.get(Const.THIRD) > Const.nparam1 || params.get(Const.THIRD) < Const.nparam3){
            throw new IllegalArgumentException("Wrong field number");
        } else if(params.get(Const.SECOND) > Const.max_param || params.get(Const.SECOND) < Const.min_param ||
                params.get(Const.FOURTH) > Const.max_param || params.get(Const.FOURTH) < Const.min_param){
            throw new IllegalArgumentException("Wrong field number");
        }
    }
}