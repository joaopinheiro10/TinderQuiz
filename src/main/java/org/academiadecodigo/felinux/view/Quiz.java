package org.academiadecodigo.felinux.view;

public enum Quiz {

    QUESTION_0(0,"quem é o maior ?\n", "benfica"),
    QUESTION_1(1, "What does Au stand for in the periodic table?\n", "gold"),
    QUESTION_2(2, "Which popular video game franchise has released games with the subtitled Modern Warfare and Black Ops?\n", "call of duty"),
    QUESTION_3(3, "Who's the best singer with fireworks?\n", "jorge martinez"),
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
    QUESTION_36(36, "Where were Norse gods said to live?\n", "asgard"),
    QUESTION_37(37, "Gisaengchung is the original title of this South Korean film which collected four Oscars in 2020. What is the English title?\n", "parasite"),
    QUESTION_38(38, "In which US city did George Floyd die after being subdued by police officers?\n", "minneapolis"),
    QUESTION_39(39, "Who portrayed Edward Scissorhands?\n", "johnny depp"),
    QUESTION_40(40, "H2O is the chemical formula for what?\n", "water"),
    QUESTION_41(41, "What was Brooks' pet bird's name in the movie \"The Shawshank Redemption\"?\n", "jake"),
    QUESTION_42(42, "What ingredient in bread causes it to rise?\n", "tequila"),
    QUESTION_43(43, "Which liquor is made from the blue agave plant?\n", "jake"),
    QUESTION_44(44, "Which country once knighted a penguin?\n", "norway"),
    QUESTION_45(45, "She was only 14 when she married future Louis XVI in 1770, who is she?\n", "marie antoinette"),
    QUESTION_46(46, "In what year was the iPhone first released?\n", "2007"),
    QUESTION_47(47, "In which country did the Olympic Games originate?\n", "greece"),
    QUESTION_48(48, "What is the name of Harry Potter's owl?\n", "hedwig"),
    QUESTION_49(49, "What is the chemical formula for ozone?\n", "o3"),
    QUESTION_50(50, "Which Spanish festival is featured in Ernest Hemingway's The Sun Also Rises?\n", "san fermin"),
    QUESTION_51(51, "In what river did John the Baptist conduct his baptisms?\n", "jordan"),
    QUESTION_52(52, "What is the longest river in the world?\n", "amazon"),
    QUESTION_53(53, "How much money (dollars) does the average player spend on \"Fortnite\"?\n", "60"),
    QUESTION_54(54, "What was Mickey Mouse's original name?\n", "mortimer"),
    QUESTION_55(55, "In what year was \"Se7en\" released?\n", "1995"),
    QUESTION_56(56, "What are the first three words written in the Bible?\n", "in the beginning"),
    QUESTION_57(57, "In 2008, which artist broke the record for the youngest ever to win a Grammy for Album of the Year?\n", "taylor swift"),
    QUESTION_58(58, "The outermost layer of the Earth is called the what?\n", "crust"),
    QUESTION_59(59, "Which is the largest food and drink company in the world?\n", "nestlé"),
    QUESTION_60(60, "Bootylicious has become an accepted word in the Oxford Dictionary thanks to a track of the same name by which artist(s)?\n", "destiny's child");

    private final String question;
    private final String correctAnswer;
    private final int questionNumber;

    Quiz(int questionNumber, String question, String correctAnswer) {
        this.questionNumber = questionNumber;
        this.question = question;
        this.correctAnswer = correctAnswer;
    }

    public String getQuestion() {
        return Colors.YELLOW + question + Colors.NOCOLOR;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }
}
