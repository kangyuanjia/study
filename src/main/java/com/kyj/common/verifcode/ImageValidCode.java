package com.kyj.common.verifcode;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.Random;

public class ImageValidCode
{
  private static Random random = new Random();

  private static float IMAGEWIDTH = 18.5F;

  private static int IMAGEHEIGHT = 24;

  private static int CODE_LENGTH = 4;

  private static int FONTSIZE = random.nextInt(4) + 18;

  public static BufferedImage getImage(String verifyCode)
  {
    BufferedImage image = new BufferedImage((int)IMAGEWIDTH * CODE_LENGTH, IMAGEHEIGHT, 1);

    Graphics graphics = image.getGraphics();

    graphics.setColor(Color.white);
    graphics.fillRect(0, 0, (int)IMAGEWIDTH * 4, IMAGEHEIGHT);

    graphics.setColor(Color.white);
    for (int i = 0; i < 2; ++i) {
      graphics.drawRect(i, i, (int)(IMAGEWIDTH * CODE_LENGTH - (i * 2) - 1.0F), IMAGEHEIGHT - (i * 2) - 1);
    }

    graphics.setColor(Color.white);
    for (int i = 0; i < 50; ++i) {
      int x1 = random.nextInt((int)(IMAGEWIDTH * CODE_LENGTH - 4.0F)) + 2;
      int y1 = random.nextInt(IMAGEHEIGHT - 4) + 2;
      int x2 = random.nextInt((int)(IMAGEWIDTH * CODE_LENGTH - 2.0F - x1)) + x1;
      int y2 = y1;
      graphics.drawLine(x1, y1, x2, y2);
    }

    for (int i = 0; i < CODE_LENGTH; ++i) {
      graphics.setFont(new Font("TimesRoman", 1, FONTSIZE));
    }

    for (int i = 0; i < CODE_LENGTH; ++i) {
      String temp = verifyCode.substring(i, i + 1);
      graphics.setColor(Color.black);
      if (i % 2 != 0)
        graphics.drawString(temp, 17 * i + 4, 16);
      else {
        graphics.drawString(temp, 17 * i + 4, 16);
      }
    }
    graphics.dispose();
    return image;
  }
}