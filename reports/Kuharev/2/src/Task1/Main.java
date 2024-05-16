public class Main {
    public enum WordType {
        NOUN,
        ADJECTIVE,
        VERB,
        PREPOSITION
    }

    public static void main(String[] args) {
        WordType[] types = {WordType.NOUN, WordType.ADJECTIVE, WordType.VERB, WordType.PREPOSITION};
        String formated_string = Const.CLEAR, output = Const.CLEAR;
        StringDynamicArray[] type_array_navp = new StringDynamicArray[types.length];
        IFile workWith_txt = new IFile();

        try {
            output = args[Const.first_element];
        } catch (Exception ex) {
            System.out.println("Arguments are empty, using default output file");
            output = "output";
        }

        workWith_txt.ClearFile(output);

        for (int i = 0; i < types.length; ++i) {
            type_array_navp[i] = workWith_txt.ReadStrings(types[i].name().toLowerCase());
        }

        for (int i = 0; i < Const.sentences_amount; ++i) {
            formated_string = String.join(" ", type_array_navp[WordType.NOUN.ordinal()].getRandom(),
                    type_array_navp[WordType.VERB.ordinal()].getRandom(),
                    type_array_navp[WordType.PREPOSITION.ordinal()].getRandom(),
                    type_array_navp[WordType.ADJECTIVE.ordinal()].getRandom(),
                    type_array_navp[WordType.NOUN.ordinal()].getRandom()) + ".\n";

            formated_string = Character.toUpperCase(formated_string.charAt(Const.first_element))
                    + formated_string.substring(Const.lower_case_start);

            workWith_txt.WriteString(formated_string, output);
            formated_string = Const.CLEAR;
        }
    }
}