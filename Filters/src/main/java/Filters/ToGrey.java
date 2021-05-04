package Filters;

public class ToGrey extends Filter{

    @Override
    public void workWithFilter(byte[] image, int height, int width) {
        for (int i = 0; i < height * width; i++){
            byte res = (byte)(image[i * 3] * 0.2126 + image[i * 3 + 1] * 0.7152 + image[i * 3 + 2] * 0.0722);
            image[i * 3] = res;
            image[i * 3 + 1] = res;
            image[i * 3 + 2] = res;
        }
    }
}