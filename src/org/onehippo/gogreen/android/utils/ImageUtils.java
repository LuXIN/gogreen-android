package org.onehippo.gogreen.android.utils;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;

/**
 * Utility class for images
 * @author Jeroen Reijn
 */
public class ImageUtils {

    /**
     * Fetches an external image and decodes the stream as a {@link Bitmap}
     * @param urlstr the url of the external image
     * @return {@link Bitmap} containing the external image
     */
    public static Bitmap fetchImage(String urlstr )
    {
        try
        {
            URL url;
            url = new URL( urlstr );

            HttpURLConnection c = ( HttpURLConnection ) url.openConnection();
            c.setDoInput( true );
            c.connect();
            InputStream is = c.getInputStream();
            Bitmap img;
            img = BitmapFactory.decodeStream(is);
            return img;
        }
        catch ( MalformedURLException e )
        {
            Log.d("RemoteImageHandler", "fetchImage passed invalid URL: " + urlstr);
        }
        catch ( IOException e )
        {
            Log.d( "RemoteImageHandler", "fetchImage IO exception: " + e );
        }
        return null;
    }
}
