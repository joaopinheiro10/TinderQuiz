package org.academiadecodigo.felinux.utilits;

import com.indvd00m.ascii.render.Render;
import com.indvd00m.ascii.render.api.ICanvas;
import com.indvd00m.ascii.render.api.IContextBuilder;
import com.indvd00m.ascii.render.api.IRender;
import com.indvd00m.ascii.render.elements.PseudoText;
import org.academiadecodigo.felinux.view.Colors;

public class PseudoTex {

    public static String printText(String txt, int height){
        IRender render = new Render();
        IContextBuilder builder = render.newBuilder();
        builder.width(120).height(15);
        builder.element(new PseudoText(txt,1,3, height, false));
        ICanvas canvas = render.render(builder.build());
        return canvas.getText();

    }
}
