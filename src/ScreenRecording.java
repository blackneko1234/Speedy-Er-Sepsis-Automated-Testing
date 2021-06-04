import org.monte.media.Format;
import org.monte.media.math.Rational;
import org.monte.screenrecorder.ScreenRecorder;

import java.awt.*;
import java.io.File;
import java.io.IOException;

import static org.monte.media.FormatKeys.*;
import static org.monte.media.FormatKeys.FrameRateKey;
import static org.monte.media.VideoFormatKeys.*;
import static org.monte.media.VideoFormatKeys.QualityKey;

public class ScreenRecording {
    private static ScreenRecorder screenRecorder;

    public static void StartRecord() {
        try {
            System.out.println("Screen record started");
            GraphicsConfiguration config = GraphicsEnvironment
                    .getLocalGraphicsEnvironment()
                    .getDefaultScreenDevice()
                    .getDefaultConfiguration();

            screenRecorder = new ScreenRecorder(config,
                    config.getBounds(),
                    new Format(MediaTypeKey, MediaType.FILE, MimeTypeKey, MIME_AVI),
                    new Format(MediaTypeKey, MediaType.VIDEO, EncodingKey,
                            ENCODING_AVI_TECHSMITH_SCREEN_CAPTURE,
                            CompressorNameKey, ENCODING_AVI_TECHSMITH_SCREEN_CAPTURE,
                            DepthKey, 24, FrameRateKey, Rational.valueOf(15),
                            QualityKey, 1.0f, KeyFrameIntervalKey, 15 * 60),
                    new Format(MediaTypeKey, MediaType.VIDEO,
                            EncodingKey, "black", FrameRateKey, Rational.valueOf(30)),
                    null,
                    new File(".\\ScreenRecorder"));

            screenRecorder.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void StopRecord() throws IOException {
        screenRecorder.stop();
        System.out.println("Screen record ended");
    }
}
