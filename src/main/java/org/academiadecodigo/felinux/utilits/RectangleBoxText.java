package org.academiadecodigo.felinux.utilits;

import com.indvd00m.ascii.render.Render;
import com.indvd00m.ascii.render.api.ICanvas;
import com.indvd00m.ascii.render.api.IContextBuilder;
import com.indvd00m.ascii.render.api.IRender;
import com.indvd00m.ascii.render.elements.Rectangle;
import com.indvd00m.ascii.render.elements.Text;

public class RectangleBoxText {

    public static String printText(String text, int width , int height){

        IRender render = new Render();
        IContextBuilder builder = render.newBuilder();
        builder.width(width).height(height);
        builder.element(new Rectangle());
        builder.element(new Text(text, 1, 3, 100, 10));
        ICanvas canvas = render.render(builder.build());
        return canvas.getText();
    }
}
