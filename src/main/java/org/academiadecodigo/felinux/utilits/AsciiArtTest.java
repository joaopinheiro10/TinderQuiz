package org.academiadecodigo.felinux.utilits;

import com.indvd00m.ascii.render.Render;
import com.indvd00m.ascii.render.api.ICanvas;
import com.indvd00m.ascii.render.api.IContextBuilder;
import com.indvd00m.ascii.render.api.IRender;
import com.indvd00m.ascii.render.elements.PseudoText;
import org.academiadecodigo.felinux.view.Messages;


public class AsciiArtTest {


    public static void main(String[] args) {

        System.out.println();
        String result = ASCIIArtGenerator.printTextArt(Messages.STARTGAME, 10);
        System.out.println();

        System.out.println();
        //artGen.printTextArt("Love is life!", ASCIIArtGenerator.ART_SIZE_SMALL, ASCIIArtGenerator.ASCIIArtFont.ART_FONT_MONO,"@");
        System.out.println("result again: \n" + result);

        String txt = "Lorem Ipsum is simply dummy text";
        IRender render = new Render();
        IContextBuilder builder = render.newBuilder();
        builder.width(txt.length()).height(15);
        builder.element(new PseudoText(txt,1,3, 10,false));
        ICanvas canvas = render.render(builder.build());
        String s = canvas.getText();
        System.out.println(s);

    }
}