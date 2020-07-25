package org.academiadecodigo.felinux.view;

public enum Quiz {

    QUESTION_0(0,"quem é o maior ?\n", "benfica"),
    QUESTION_1(1, "What does Au stand for in the periodic table?\n", "gold"),
    QUESTION_2(2, "Which popular video game franchise has released games with the subtitled Modern Warfare and Black Ops?\n", "call of duty"),
    QUESTION_3(3, "Who's the best singer with fireworks?\n", "jorge martínez"),
    QUESTION_4(4, "Name the composer behind the soundtracks of The Lion King, Inception and Pirates of the Caribbean.\n", "hanz zimmer"),
    QUESTION_5(5, "Which 2014 Seth Rogan film caused the North Korean government to threaten action against the United States?\n", "the interview"),
    QUESTION_6(6, "What is the capital city of Australia?\n", "canberra"),
    QUESTION_7(7, "What is the capital of Finland?\n", "edinburgh"),
    QUESTION_8(8, "What’s the name of the talking snowman in Disney’s Frozen?\n", "olaf"),
    QUESTION_9(9, "Gordon Sumner is the real name of what famous British musician?\n", "sting"),
    QUESTION_10(10, "Which Stephen King novel takes place mostly in the fictional Overlook Hotel?\n", "the shinning"),
    QUESTION_11(11, "Which planet has the most moons?\n", "jupiter"),
    QUESTION_12(12, "Elon Musk is the CEO of which global brand.\n", "tesla"),
    QUESTION_13(13, "In which year was the Nintendo 64 released in Europe?\n", "1997"),
    QUESTION_14(14, "Who is the former drummer of Nirvana who fronts the Foo Fighters?\n", "dave grohl"),
    QUESTION_15(15, "What is the longest Harry Potter film? (Non-extended versions)\n", "chamber of secrets"),
    QUESTION_16(16, "Who discovered penicillin?\n", "alexander fleming"),
    QUESTION_17(17, "What instrument does Lisa Simpson play?\n", "saxophone"),
    QUESTION_18(18, "Where was Frida Kahlo born?\n", "mexico"),
    QUESTION_19(19, "What is the capital of Canada?\n", "ottawa"),
    QUESTION_20(20, "In 1952 Albert Einstein was offered the Presidency of which country?\n", "israel"),
    QUESTION_21(21, "Who is the president of the United States?\n", "donald trump"),
    QUESTION_22(22, "In which country would you find the original Legoland?\n", "denmark"),
    QUESTION_23(23, "Botany is the study of what life form?\n", "plants"),
    QUESTION_24(24, "What US premium cable network made Game of Thrones?\n", "hbo"),
    QUESTION_25(25, "Which specific form of cancer is Walt (from Breaking Bad) diagnosed with?\n", "lung cancer"),
    QUESTION_26(26, "What does the slang term ‘Tokyo’ refer to in Peaky Blinders?\n", "cocaine"),
    QUESTION_27(27, "How many bones are there in the average adult human body?\n", "206"),
    QUESTION_28(28, "When Michael Jordan played for the Chicago Bulls, how many NBA Championships did he win?\n", "6"),
    QUESTION_29(29, "What does “HTTP” stand for?\n", "hypertext transfer protocol"),
    QUESTION_30(30, "What is the name of the man who launched eBay back in 1995?\n", "pierre omidyar"),
    QUESTION_31(31, "What was the name of the rock band formed by Jimmy Page?\n", "led zeppelin"),
    QUESTION_32(32, "Which singer was known amongst other things as 'The King of Pop'?\n", "michael jackson"),
    QUESTION_33(33, "Who scored the first Premier League hat-trick?\n", "eric cantona"),
    QUESTION_34(34, "In Spain what is the word for an afternoon nap?\n", "siesta"),
    QUESTION_35(35, "In which town do the Flintstones live?\n", "bedrock"),
    QUESTION_36(36, "Where were Norse gods said to live?", "asgard"),
    QUESTION_37(37, "Gisaengchung is the original title of this South Korean film which collected four Oscars in 2020. What is the English title?\n", "parasite"),
    QUESTION_38(38, "In which US city did George Floyd die after being subdued by police officers?\n", "minneapolis"),
    QUESTION_39(39, "Who portrayed Edward Scissorhands?\n", "johnny depp"),
    QUESTION_40(40, "H2O is the chemical formula for what?\n", "water");


    private final String question;
    private final String correctAnswer;
    private final int questionNumber;

    Quiz(int questionNumber, String question, String correctAnswer) {
        this.questionNumber = questionNumber;
        this.question = question;
        this.correctAnswer = correctAnswer;
    }

    public String getQuestion() {
        return question;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }
}
