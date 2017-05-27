package dietbisabesok.com.bukanitip.helper;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.Image;
import android.util.Base64;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author hoangnh
 * @since 9/21/16.
 */
public class ImageHelper {

    public static byte[] bitmap2bytes(Bitmap bitmap) {
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, stream);
        return stream.toByteArray();
    }

    public static String encodeImage(Bitmap image){
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        image.compress(Bitmap.CompressFormat.JPEG, 50, byteArrayOutputStream);
        byte[] byteArray = byteArrayOutputStream .toByteArray();

        return Base64.encodeToString(byteArray, Base64.DEFAULT);
    }
    public static Bitmap decodeImageString(String image){
        ByteArrayInputStream imageStream = null;
        String imageFiltered = image.replace("data:image/jpeg;base64,","");
        byte[] imageAsBytes = Base64.decode(imageFiltered, 0);
        if(imageAsBytes != null){
            imageStream = new ByteArrayInputStream(imageAsBytes);
        }
        System.out.println(imageStream);
        return BitmapFactory.decodeStream(imageStream);
    }


    public static Bitmap bytes2Bitmap(byte[] byteArray) {
        return BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length);
    }

    public static boolean saveBitmapIntoFile(Bitmap image, String path) throws IOException {
        File imageFile = new File(path);
        if (!imageFile.exists() && imageFile.createNewFile()) {
            FileOutputStream outputStream = new FileOutputStream(imageFile);
            image.compress(Bitmap.CompressFormat.PNG, 100, outputStream);
            outputStream.flush();
            outputStream.close();
            return true;
        }
        return false;
    }

   /* public static Bitmap compressImage(Bitmap image) {
        int actualHeight = image.getHeight();
        int actualWidth = image.getWidth();
        int maxHeight = 600;
        int maxWidth = 800;
        int imgRatio = actualWidth / actualHeight;
        int maxRatio = maxWidth / maxHeight;
        Bitmap img = null;
        try {
            if (actualHeight > maxHeight || actualWidth > maxWidth) {
                if (imgRatio < maxRatio) {
                    //adjust width according to maxHeight
                    imgRatio = maxHeight / actualHeight;
                    actualWidth = imgRatio * actualWidth;
                    actualHeight = maxHeight;
                } else if (imgRatio > maxRatio) {
                    //adjust height according to maxWidth
                    imgRatio = maxWidth / actualWidth;
                    actualHeight = imgRatio * actualHeight;
                    actualWidth = maxWidth;
                } else {
                    actualHeight = maxHeight;
                    actualWidth = maxWidth;
                }
            }

            img = Bitmap.createBitmap(image, 0, 0, actualWidth, actualHeight);
        } catch (Exception e) {

        }
        return img;
    }*/
}