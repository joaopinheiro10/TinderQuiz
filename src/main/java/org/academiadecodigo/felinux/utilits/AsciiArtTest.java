package org.academiadecodigo.felinux.utilits;


import org.academiadecodigo.felinux.view.Messages;

public class AsciiArtTest {


    public static void main(String[] args) throws Exception {

        System.out.println();
        String result = ASCIIArtGenerator.printTextArt(Messages.STARTGAME, 10);
        System.out.println();

        System.out.println();
        //artGen.printTextArt("Love is life!", ASCIIArtGenerator.ART_SIZE_SMALL, ASCIIArtGenerator.ASCIIArtFont.ART_FONT_MONO,"@");
        System.out.println("result again: \n" + result);
    }
}
