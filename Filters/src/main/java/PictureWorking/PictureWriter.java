package PictureWorking;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public class PictureWriter {
    public PictureWriter(File outFile) {
        try {
            DataOutputStream fin = new DataOutputStream(new FileOutputStream(outFile));
            ByteBuffer buffer = ByteBuffer.allocate(PictureStruct.sizeFile);
            buffer.order(ByteOrder.LITTLE_ENDIAN);

            buffer.putShort(PictureStruct.type);
            buffer.putInt(PictureStruct.sizeFile);
            buffer.putShort(PictureStruct.reserved1);
            buffer.putShort(PictureStruct.reserved2);
            buffer.putInt(PictureStruct.offSetBits);

            buffer.putInt(PictureStruct.size);
            buffer.putInt(PictureStruct.width);
            buffer.putInt(PictureStruct.height);
            buffer.putShort(PictureStruct.planes);
            buffer.putShort(PictureStruct.bitCount);
            buffer.putInt(PictureStruct.compression);
            buffer.putInt(PictureStruct.sizeImage);
            buffer.putInt(PictureStruct.xPelsPerMeter);
            buffer.putInt(PictureStruct.yPelsPerMeter);
            buffer.putInt(PictureStruct.colorsUsed);
            buffer.putInt(PictureStruct.colorsImportant);

            for(int i = 0; i < PictureStruct.sizeImage; i++){
                buffer.put(PictureStruct.image[i]);
            }
            fin.write(buffer.array());
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
