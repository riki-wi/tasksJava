package PictureWorking;

import java.awt.image.BufferedImage;
import java.io.*;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;

public class PictureReader {
    public PictureReader(File fileIn){
        try {
            DataInputStream fin = new DataInputStream(new FileInputStream(fileIn));
            ByteBuffer buffer = ByteBuffer.wrap(fin.readAllBytes());
            buffer.order(ByteOrder.LITTLE_ENDIAN);

            PictureStruct.type = buffer.getShort();
            PictureStruct.sizeFile = buffer.getInt();
            PictureStruct.reserved1 = buffer.getShort();
            PictureStruct.reserved2 = buffer.getShort();
            PictureStruct.offSetBits = buffer.getInt();

            PictureStruct.size = buffer.getInt();
            PictureStruct.width = buffer.getInt();
            PictureStruct.height = buffer.getInt();
            PictureStruct.planes = buffer.getShort();
            PictureStruct.bitCount = buffer.getShort();
            PictureStruct.compression = buffer.getInt();
            PictureStruct.sizeImage = buffer.getInt();
            PictureStruct.xPelsPerMeter = buffer.getInt();
            PictureStruct.yPelsPerMeter = buffer.getInt();
            PictureStruct.colorsUsed = buffer.getInt();
            PictureStruct.colorsImportant = buffer.getInt();

            PictureStruct.image = new byte[PictureStruct.sizeImage];
            for(int i = 0; i < PictureStruct.sizeImage; i++){
                PictureStruct.image[i] = buffer.get();
            }






        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
