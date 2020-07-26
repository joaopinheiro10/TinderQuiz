package org.academiadecodigo.felinux.utilits;

import com.indvd00m.ascii.render.Render;
import com.indvd00m.ascii.render.api.ICanvas;
import com.indvd00m.ascii.render.api.IContextBuilder;
import com.indvd00m.ascii.render.api.IRender;
import com.indvd00m.ascii.render.elements.PseudoText;

public class PseudoTex {

    public static String printText(String text, int width, int height){
        IRender render = new Render();
        IContextBuilder builder = render.newBuilder();
        builder.width(width).height(height);
        builder.element(new PseudoText(text));
        ICanvas canvas = render.render(builder.build());
        String s = canvas.getText();
        System.out.println(s);
        return s;
    }
}
